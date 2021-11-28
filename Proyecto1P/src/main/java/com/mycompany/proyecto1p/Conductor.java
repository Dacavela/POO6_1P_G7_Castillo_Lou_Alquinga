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
    //Clase conductor que tiene 4 atributos aparte de los de usuario, el codigoUsuario, la licencia, el estado y el codigovehiculo
    private String codigoUsuario;
    private String licencia;
    private String estado;
    private String codigoVehiculo;
    
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
   
    
    
    
    
}
