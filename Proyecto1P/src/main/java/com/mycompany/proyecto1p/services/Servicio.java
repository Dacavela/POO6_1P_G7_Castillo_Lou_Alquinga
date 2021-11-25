/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import com.mycompany.proyecto1p.*;
import java.util.Scanner;

/**
 *
 * @author Davca
 */

//Clase abtracta ya que como tal no es nada sin pasar a ser uno de los tres tipos de servicios que puede contratar un cliente
public abstract class Servicio {
    protected String rutaDesde;
    protected String rutaHacia;
    protected String fecha;
    protected String hora;
    protected Conductor conductor;
    protected Double vPagar;
    protected static int idUnico = 2000;
    
    
    Scanner sc = new Scanner(System.in);
    
    //Constructor de Servicio que 
    public Servicio(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar){
        rutaDesde = rDesde;
        rutaHacia = rHacia;
        fecha = date;
        hora = hour;
        conductor = c;
        this.vPagar = vPagar;
        
        
    }
    public Servicio(){
        
    }
    
    //Getters y Setters
    public String getRutaDesde() {
        return rutaDesde;
    }

    public void setRutaDesde(String rutaDesde) {
        this.rutaDesde = rutaDesde;
    }

    public String getRutaHacia() {
        return rutaHacia;
    }

    public void setRutaHacia(String rutaHacia) {
        this.rutaHacia = rutaHacia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Double getValPagar() {
        return vPagar;
    }

    public void setValPagar(Double valPagar) {
        this.vPagar = valPagar;
    }

    public int getIdUnico() {
        return idUnico;
    }

    public static void setIdUnico(int idUnico) {
        Servicio.idUnico = idUnico;
    }
    

//    public static void setIdUnico(int idUnico) {
//        Servicio.idUnico = idUnico;
//    }
    //Fin Getters y Setters
    
    public abstract void mostrarInfoServicio();
    
    public double calcularPrecio(){
        vPagar = 0.00;
        vPagar = 1 + (Math.random() * 49);
        vPagar = Math.round(vPagar*100.0)/100.0;
        return vPagar;
    }
    
    public double calcularPrecio(String s){
        
        vPagar *= 1.10;
        vPagar = Math.round(vPagar*100.0)/100.0;

        return vPagar;
    }
    
    public String tipoPago(){
       String tipoPago;
        do {
            System.out.println("Ingresa el número del método de pago que desee\n1: Efectivo: $"+calcularPrecio()
                    +"\n2: Tarjeta: $"+calcularPrecio("s"));
            tipoPago = sc.nextLine();
            switch (tipoPago) {
                case "1":
                    System.out.println("Pago en efectivo seleccionado.");

                    tipoPago = "Efectivo";
                    break;
                case "2":

                    System.out.println("Pago con tarjeta seleccionado.");
                    tipoPago = "Tarjeta";
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentarlo");
                    break;
            }
        } while (!tipoPago.equals("Efectivo") && !tipoPago.equals("Tarjeta"));
        return tipoPago;
    }
    
    
}
