/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

/**
 *
 * @author Davca
 */
public class Conductor extends Usuario{
    private String licencia;
    private char estado;
    private int vehiculo;
    private int edad; 

    public Conductor(String licencia, char estado, int vehiculo, int edad, String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario) {
        super(cedula, nombre, apellido, user, password, celular, tipoUsuario);
        this.licencia = licencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.edad = edad;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
    
    
    
    
}
