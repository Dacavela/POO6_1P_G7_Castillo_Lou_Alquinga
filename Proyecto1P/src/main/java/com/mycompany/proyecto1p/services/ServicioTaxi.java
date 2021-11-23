/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import com.mycompany.proyecto1p.Cliente;
import com.mycompany.proyecto1p.Conductor;

/**
 *
 * @author Davca
 */
public class ServicioTaxi extends Servicio{
    private String personasQueViajan;
    
    
    //Constructor ServicioTaxi que hereda de la clase Servicio
    public ServicioTaxi(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, String pViajan){
        super(rDesde, rHacia, date, hour, c, vPagar);
        personasQueViajan = pViajan;
    }
    public ServicioTaxi(){
        
    }
    
    //Getters y Setters
    public String getPersonasQueViajan() {
        return personasQueViajan;
    }

    public void setPersonasQueViajan(String personasQueViajan) {
        this.personasQueViajan = personasQueViajan;
    }
    
    @Override
    public void mostrarInfoServicio(){
        
        System.out.println("Ingresa el origen del viaje: ");
        super.rutaDesde = sc.nextLine();

        System.out.println("Ingresa tu destino: ");
        super.rutaHacia = sc.nextLine();

        System.out.println("Ingresa la fecha: ");
        super.fecha = sc.nextLine();

        System.out.println("Ingresa la Hora del viaje: ");
        super.hora = sc.nextLine();
        
        System.out.println("¿Cuántas personas viajarán?: ");
        this.personasQueViajan = sc.nextLine();
     
       //Falta poner el conductor 
        
    }
    
    
    public String toString(Cliente cli, String tipoPago){
        
        return super.idUnico + "," + cli.getNombre() + "," +"Fabricio"
                            + "," + this.rutaDesde + "," + this.rutaHacia +"," + this.fecha 
                            + "," + this.hora + "," + this.personasQueViajan + "," + tipoPago + "," + this.vPagar;
    }
    
}
