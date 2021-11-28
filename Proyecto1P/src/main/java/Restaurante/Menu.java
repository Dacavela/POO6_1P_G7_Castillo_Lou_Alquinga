/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante;

/**
 *
 * @author Davca
 */
public class Menu extends Restaurante {
    private String nombrePlato;
    private Double precio;

    public Menu() {
    }

    public Menu(String codigo, String nombre, String nombrePlato, Double precio) {
        super(codigo, nombre);
        this.nombrePlato = nombrePlato;
        this.precio = precio;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return ""+ super.getCodigo()+"," + nombrePlato+"," + precio;
    }
    
}
