/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import Utilities.TipoEncomiendas;
import static Utilities.TipoEncomiendas.*;
import static Utilities.Validacion.*;
import com.mycompany.proyecto1p.Cliente;
import com.mycompany.proyecto1p.Conductor;
import com.mycompany.proyecto1p.Sistema2;

/**
 *Clase servicio, utilizada para crear servicios de encomiendas
 * @author David Castillo
 * @version 1
 */
public class ServicioEncomiendas extends Servicio{
    public String cantidadProductos;
    public TipoEncomiendas tipoEncomienda;
    
    
    /**
     * Constructor ServicioEncomiendas que hereda de la clase Servicio
     * @param rDesde ruta desde
     * @param rHacia ruta hacia 
     * @param date fecha
     * @param hour hora
     * @param c conductor 
     * @param vPagar valor a pagar
     * @param cProductos cantidad de productos
     * @param tEnc  tipo de encomienda
     */
    public ServicioEncomiendas(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, String cProductos, TipoEncomiendas tEnc){
        super(rDesde, rHacia, date, hour, c, vPagar);
        cantidadProductos = cProductos;
    }
    /**
     * Constructor sin parametros
     */
    public ServicioEncomiendas(){
        
    }
    
    //Getters y Setters
    public String getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(String cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public TipoEncomiendas getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(TipoEncomiendas tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }
    
    /**
     * metodo para mostrar en pantalla el servicio e ir pidiendo la informacion para instanciarlo
     * @param s1 el sistema para realizar acciones y metodos que son de sistema
     * @return retorna un booleano usado para ver si se cancela o no el pedido y se regresa al menu
     */
    public boolean mostrarInfoServicio(Sistema2 s1){
        
        String cancelar = null;
        boolean permanecer = false;
        
        System.out.println("Ingresa desde dónde va la encomienda: ");
        cancelar = validarRuta(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.rutaDesde = cancelar;
        

        System.out.println("Ingresa hacia dónde se dirige: ");
        cancelar = validarRuta(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.rutaHacia = cancelar;

        System.out.println("Ingresa la fecha dd/mm/yyyy: ");
        cancelar = validarFecha(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.fecha = cancelar;
        

        System.out.println("Ingresa la Hora del viaje 24Hrs (hh:mm): ");
        cancelar = validarHora(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.hora = cancelar;
        
        System.out.printf("Ingresa el tipo de encomienda:\n1. Medicamentos\n2. Documentos\n3. Ropa\n");
        TipoEncomiendas t1 = validarEncomienda(sc); 
        cancelar = t1.toString();
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        this.tipoEncomienda = t1;
        
        System.out.printf("Ingresa la cantidad de productos de tipo %s a enviar\n",this.tipoEncomienda.toString().toLowerCase());
        cancelar = validarCantidadProductos(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        this.cantidadProductos = cancelar;
        String tipopago = tipoPago();
        if(tipopago.equals("cancelar")){return permanecer = true;}
        System.out.println("¿Desea confirmar su viaje? S/N");                                
        //cancelar
        cancelar = validarConfirmacion(sc);
        
        if(cancelar.equals("cancelar")){
            return permanecer = true;
        
        }
        if(s1.getUser().confirmarServicio(cancelar)){
            Servicio.setIdUnico(this.getIdUnico()+1);
            String[] lineaConductor = s1.getConductoreFile().buscarDriver("D","M");
            s1.setearConductor(lineaConductor,s1.getUserFile().accederLinea(s1.getUserFile().buscar(lineaConductor[0], 1)));
            s1.getConductoreFile().reemplazarLineaConductores(s1.getDriver().getCedula(),super.getIdUnico());
            s1.getDriver().setServicioEnco(this);
            s1.getEncomiendasFile().escribir(this.toString(s1.getUser(), tipopago.toUpperCase(), s1.getDriver()));
            s1.agregaServicioLista(this);
        }
        return permanecer =true;
        
    }
    
    /**
     * metodo toString, no es una sobreescritura porque recibe parametros
     * @param cli cliente que hace el pedido
     * @param tipoPago tipo de pago del pedido
     * @param con conductor encargado del pedido
     * @return retorna un string deseado con datos del cliente, tipo de pago y conductor.
     */
    public String toString(Cliente cli, String tipoPago, Conductor con){
        
        return ServicioEncomiendas.idUnico + "," + cli.getNombre() + "," +con.getNombre()
                            + "," + this.rutaDesde + "," + this.rutaHacia +"," + this.fecha 
                            + "," + this.hora + "," + this.tipoEncomienda + "," + this.cantidadProductos + "," + tipoPago + "," + this.vPagar;
    }
    
    /**
     * metodo toString, sobreescritura del metodo de java
     * @return retorna un string deseado
     */
    @Override
    public String toString(){
     return "Tipo: Encomienda\n"+"Tipo Encomiensa: "+this.getTipoEncomienda()+"\nCantidad: "
             +this.cantidadProductos+"\nFecha: "+this.fecha+"\nHora: "+this.hora+"\nDesde: "+this.rutaDesde
             +"\nHacia: " + this.rutaHacia;
    }
    
}
