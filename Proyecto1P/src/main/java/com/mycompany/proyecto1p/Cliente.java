/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

import com.mycompany.proyecto1p.services.*;
//import java.util.Scanner;

/**
 *
 * @author Davca
 */
public class Cliente extends Usuario{
    private String tarjetaCred;
    private String edad;
    String confirmar;
    public ServicioTaxi s1 = new ServicioTaxi();
    public ServicioEncomiendas s2 = new ServicioEncomiendas();
    

    public Cliente() {
        this.tipoUsuario = "C";
    }
    
    
    //Constructor de la clase Cliente que hereda de la clase Usuario
    public Cliente(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario, String tarjetaCred, String edad) {
        super(cedula, nombre, apellido, user, password, celular, tipoUsuario);
        this.tarjetaCred = tarjetaCred;
        this.edad = edad;
    }

    public String getTarjetaCred() {
        return tarjetaCred;
    }

    public void setTarjetaCred(String tarjetaCred) {
        this.tarjetaCred = tarjetaCred;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public boolean confirmarServicio(String s){
        
        return s.toUpperCase().equals("S");
    }
    
    public void solicitarServicioTaxi() {
        s1.mostrarInfoServicio();
    }
    
        public String toString(String a){
            return this.cedula+","+this.edad+","+this.tarjetaCred;
        }   
}
