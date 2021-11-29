/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

import Utilities.Archivo;
import com.mycompany.proyecto1p.services.*;

/**
 *
 * @author Davca
 */
public class Conductor extends Usuario{
    //Clase conductor que tiene 4 atributos aparte de los de usuario, el codigoUsuario, la licencia, el estado y el codigovehiculo
    private String codigoUsuario;
    private String licencia;
    private String estado;
    private String codigoVehiculo;
    private ServicioTaxi servicioT = new ServicioTaxi();
    private ServicioEncomiendas servicioEnco = new ServicioEncomiendas();
    private ServicioComida servicioCom = new ServicioComida();
    
    //Constructor sin parametros
    public Conductor(){
    }
    
    //Constructor de la clase Conductor que hereda de la clase Usuario
    public Conductor(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario,String codigoUsuario,String licencia, String estado, String codigoVehiculo) {
        super(cedula, nombre, apellido, user, password, celular, tipoUsuario);
        this.codigoUsuario = codigoUsuario;
        this.licencia = licencia;
        this.estado = estado;
        this.codigoVehiculo = codigoVehiculo;

    }

    //Getters y Setters

    public ServicioTaxi getServicioT() {
        return servicioT;
    }

    public void setServicioT(ServicioTaxi servicioT) {
        this.servicioT = servicioT;
    }

    public ServicioComida getServicioCom() {
        return servicioCom;
    }

    public void setServicioCom(ServicioComida servicioCom) {
        this.servicioCom = servicioCom;
    }

    public ServicioEncomiendas getServicioEnco() {
        return servicioEnco;
    }

    public void setServicioEnco(ServicioEncomiendas servicioEnco) {
        this.servicioEnco = servicioEnco;
    }

    
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    
    
    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String vehiculo) {
        this.codigoVehiculo = vehiculo;
    }
    //Fin Getters y Setters
   
    
    public String saberQueServicioMeToco(Archivo conductores, Archivo encomiendas, Archivo viajes, Archivo delivery, Archivo restaurantes, Archivo pedidos){
        String idServicio = conductores.accederLinea(conductores.buscar(this.cedula, 1)).split(",")[4];
        String serAsignado;
        if(encomiendas.buscar(idServicio, 0)){
            String[] encom =encomiendas.accederLinea(true).split(",");
            serAsignado = "Usted tiene asignado el servicio de Encomienda\n"+"Tipo Encomienda: "+encom[7]
                    +"\nCantidad: "+encom[8]+"\nFecha: "+encom[5]+"\nHora: "+encom[6]+"\nDesde: "+encom[3]+"\nHasta: "+encom[4];
            return serAsignado ;
        }
        if(viajes.buscar(idServicio, 1)){
            String[] via =viajes.accederLinea(true).split(",");
            serAsignado = "Usted tiene asignado el servicio de Viaje\n"+"Cantidad de Pasajeros: "+via[7]
                    +"\nFecha: "+via[5]+"\nHora: "+via[6]+"\nDesde: "+via[3]+"\nHasta: "+via[4];
            return serAsignado;
        }
        if(delivery.buscar(idServicio, 1)){
            
            
            
            String[] deli =delivery.accederLinea(true).split(",");
            String codRestaurante = pedidos.accederLinea(pedidos.buscar(deli[7],1)).split(",")[1];
            String nameRes = restaurantes.accederLinea(restaurantes.buscar(codRestaurante, 1)).split(",")[1]; 
            serAsignado = "Usted tiene asignado el servicio de Delivery\n"+"Restaurante: " +nameRes
                   +"\nFecha: "+deli[5]+"\nHora: "+deli[6]+"\nDesde: "+deli[3]+"\nHasta: "+deli[4];
            return delivery.accederLinea(true);
        }
        return "No tiene Servicio Asignado";
        }
    @Override
    public void consultarServicios(Sistema2 s1){
        System.out.println(saberQueServicioMeToco(s1.getConductoreFile(), s1.getEncomiendasFile(), s1.getViajesFile(), s1.getDeliveryFile(), s1.getRestaurantesFile(), s1.getPedidosFile()));
                
            
        }
    }
    
