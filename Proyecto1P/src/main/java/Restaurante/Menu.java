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
    //Extiende de restaurante porque necesitaremos el codigo de restaurante para trabajarlos en conjunto
    //Esta clase se llama Menu, sin embargo lo que se genera cada vez que generamos una de estas es un plato
    private String nombrePlato;
    private Double precio;
    
    //Constructor sin parámetros para instanciar la clase servicioComida un pedido vacio
    public Menu() {
    }
    //Constructor con parametros ya que en servicioComida instanciaremos platos para agregarlos a una lista de platos del menu del restaurante elegido
    public Menu(String codigo, String nombre, String nombrePlato, Double precio) {
        super(codigo, nombre);
        this.nombrePlato = nombrePlato;
        this.precio = precio;
    }
    //Getters y setters
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
    //fin de getters y setters
    //Override del toString, utilizamos el codigo del restaurante que proviene de la clase padre y el nombre plato y precio
    //Realizamos este Override para llamarlo en la clase hija Pedido
    @Override
    public String toString(){
        return ""+ super.getCodigo()+"," + nombrePlato+"," + precio;
    }
    
}
