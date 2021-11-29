/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

/**
 * Clase vehiculo donde se instancia vehiculos para cada conductor
 * @author Luis Alquinga
 */
public class Vehiculo {
    private String codV;
    private String placa;
    private String modelo;
    private String marca;
    private String tipo;

    /**
     * Constructor sin parametros
     */
    public Vehiculo() {
    }

    /**
     * Constructor con parametros
     * @param codV
     * @param placa
     * @param modelo
     * @param marca
     * @param tipo 
     */
    public Vehiculo(String codV, String placa, String modelo, String marca, String tipo) {
        this.codV = codV;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
    }
    
    public String getCodV() {
        return codV;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodV(String codV) {
        this.codV = codV;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
