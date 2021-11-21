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
public class Usuario {
    //Atributos protected ya que todos van a ser heredados por Cliente y Conductor
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String user;
    protected String password;
    protected String celular;
    protected String tipoUsuario;

    //Constructor de la clase usuario
    public  Usuario(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.password = password;
        this.celular = celular;
        this.tipoUsuario = tipoUsuario;
    }

    
    //Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellidos(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    //Fin Getters y Setters
    
    @Override
    public String toString(){
        return cedula+","+nombre+","+apellido+","+user+","+password+","+celular+","+tipoUsuario;
    }
    
    
    
}
