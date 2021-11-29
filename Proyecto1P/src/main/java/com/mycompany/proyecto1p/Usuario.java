/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

/**
 *Clase abstracta creada para los usuarios cliente y Conductor
 * @author Davca
 */
public abstract class Usuario {
    //Atributos protected ya que todos van a ser heredados por Cliente y Conductor
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String user;
    protected String password;
    protected String celular;
    protected String tipoUsuario;
    
    /**
     * Constructor de la clase usuario con parametros
     * @param cedula cedula del usuario
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param user usuario
     * @param password contraseña del usuario
     * @param celular celular del usuario
     * @param tipoUsuario el tipo de usuario que es, conductor o cliente
     */
    public  Usuario(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.password = password;
        this.celular = celular;
        this.tipoUsuario = tipoUsuario;
    }
    public Usuario(){
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
    /**
     * Metodo abstracto de consultar servicios que va a ser sobreescrita en cliente y conductor
     * @param s1 sistema para realizar metodos necesarios del sistema
     */
    public abstract void consultarServicios(Sistema2 s1);
    /**
     * Override del metodo toString para devolver el ususario por sus atributos
     * @return 
     */
    @Override
    public String toString(){
        return cedula+","+nombre+","+apellido+","+user+","+password+","+celular+","+tipoUsuario;
    }
    
    
    
    
    
}
