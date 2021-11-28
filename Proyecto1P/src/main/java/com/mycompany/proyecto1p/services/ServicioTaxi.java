/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;
import static Utilities.Validacion.*;
import com.mycompany.proyecto1p.Cliente;
import com.mycompany.proyecto1p.Conductor;
import com.mycompany.proyecto1p.Sistema2;
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
    
    //@Override
    public boolean mostrarInfoServicio(Sistema2 s1){
        String cancelar = null;
        boolean permanecer = false;
        
        System.out.println("Ingresa el origen del viaje: ");
        cancelar = validarRuta(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.rutaDesde = cancelar;
        

        System.out.println("Ingresa tu destino: ");
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
        
        System.out.println("¿Cuántas personas viajarán?: ");
        cancelar = validarPasajeros(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        this.personasQueViajan = cancelar;
        String tipopago = tipoPago();
        System.out.println("¿Desea confirmar su viaje? S/N");                                
        //cancelar
        cancelar = validarConfirmacion(sc);
        
        if(cancelar.equals("cancelar")){
            return permanecer = true;
        
        }
        if(s1.getUser().confirmarServicio(cancelar)){
            Servicio.setIdUnico(this.getIdUnico()+1);
            String[] lineaConductor = s1.getConductoreFile().buscarDriver("D","A");
            s1.setearConductor(lineaConductor,s1.getUserFile().accederLinea(s1.getUserFile().buscar(lineaConductor[0], 1)));
            s1.getConductoreFile().reemplazarLineaConductores(s1.getDriver().getCedula());

            s1.getViajesFile().escribir(this.toString(s1.getUser(), tipopago.toUpperCase(), s1.getDriver()));
            s1.agregaServicioLista(this);
        }
        return permanecer =true;
    }
    
    
    public String toString(Cliente cli, String tipoPago, Conductor con){
        
        return super.idUnico + "," + cli.getNombre() + "," +con.getNombre()
                            + "," + this.rutaDesde + "," + this.rutaHacia +"," + this.fecha 
                            + "," + this.hora + "," + this.personasQueViajan + "," + tipoPago + "," + this.vPagar;
    }
    
}