/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

import Utilities.Archivo;
import com.mycompany.proyecto1p.services.*;

/**
 * Clase que representa un conductor que es creado a partir de conductores.txt
 * Clase conductor que tiene 4 atributos aparte de los de usuario, 
 * el codigoUsuario, la licencia, el estado y el codigovehiculo
 * @author Davca
 */
public class Conductor extends Usuario{
    //Campos de la clase
    private String codigoUsuario;
    private String licencia;
    private String estado;
    private String codigoVehiculo;
    private ServicioTaxi servicioT = new ServicioTaxi();
    private ServicioEncomiendas servicioEnco = new ServicioEncomiendas();
    private ServicioComida servicioCom = new ServicioComida();
    
    /**
    * Constructor sin parametros
    */
    public Conductor(){
    }//Cierre del Constructor
    
    /**
    * Constructor de la clase Conductor que hereda de la clase Usuario
    * @param cedula recibe la cedula del usuario
    * @param nombre recibe el nombre del usuario
    * @param apellido recibe el apellido del usuario
    * @param user recibe el nombre de usuario del usuario
    * @param password recibe la contraseña del usuario
    * @param celular recibe el celular del usuario
    * @param tipoUsuario recibe el tipo de Usuario en este caso R
    * @param codigoUsuario recibe el codigo de Usuario
    * @param licencia recibe la licencia del usuario 
    * @param estado recibe si esta disponible D u ocupado O
    * @param codigoVehiculo recibe el codigo del Vehiculo del usuario
    * cabe recalcar que el codigo Usuario fue reemplazado por la cedula. 
    */
    public Conductor(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario,String codigoUsuario,String licencia, String estado, String codigoVehiculo) {
        super(cedula, nombre, apellido, user, password, celular, tipoUsuario);
        this.codigoUsuario = codigoUsuario;
        this.licencia = licencia;
        this.estado = estado;
        this.codigoVehiculo = codigoVehiculo;

    }//Cierre del constructor

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
   
    /**
     * Metodo que busca entre los archivos delivery, encomiendas, y viajes segun 
     * el numero de servicio unico para asignarlo a un conductor
     * @param conductores es el conductores.txt
     * @param encomiendas es el archivo encomiendas.txt
     * @param viajes es el archivo viajes.txt
     * @param delivery es el archivo delivery.txt
     * @param restaurantes es el archivo restaurantes.txt
     * @param pedidos es el archivo pedidos.txt
     * @return retorna la linea que coincida con el numero de servicio unico en cualquiera de los archivos 
     */
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
        }//Cierre del metodo
    @Override
    /**
     * Metodo que imprime en pantalla el servicio asignado segun el formato PDF
     * @param s1 recibe un objeto de la clase Sistema 2 ya que ahi se abrieron todos los archivos txt
     */
    public void consultarServicios(Sistema2 s1){
        System.out.println(saberQueServicioMeToco(s1.getConductoreFile(), s1.getEncomiendasFile(), s1.getViajesFile(), s1.getDeliveryFile(), s1.getRestaurantesFile(), s1.getPedidosFile()));
                
            
        }//Cierre del metodo
    }
    
