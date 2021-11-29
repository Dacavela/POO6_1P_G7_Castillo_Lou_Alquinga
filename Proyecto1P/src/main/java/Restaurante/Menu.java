/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante;

/**
 *Clase Menu que será para instanciar los platos de los pedidos de comida.
 *Extiende de restaurante porque necesitaremos el codigo de restaurante para trabajarlos en conjunto
 *Esta clase se llama Menu, sin embargo lo que se genera cada vez que generamos una de estas es un plato
 * @author Davca
 */
public class Menu extends Restaurante {
    //Campos de la clase
    private String nombrePlato;
    private Double precio;
    
   /**Constructor sin paramteros que sirve para inicializar el menu 
    *sin la necesidad de que el usuario elija un menu
    */
    public Menu() {
    }//Cierre del Constructor
    
    /**Constructor con parametros
    *@param codigo Define el codigo del restaurante
    *@param nombre Define el nombre del restaurante
    *@param nombrePlato Define el nombre del Plato que ofrece el Restaurante
    *@param precio Define el precio del plato que ofrece el restaurante
    */
    public Menu(String codigo, String nombre, String nombrePlato, Double precio) {
        super(codigo, nombre);
        this.nombrePlato = nombrePlato;
        this.precio = precio;
    }//Cierre del constructor
    
    //Getters y Setters
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
    }//fin de getters y setters
    
    /**Utilizamos el codigo del restaurante que proviene de la clase padre,el nombre plato y precio
    *@return retorna el pedido listo para ser agregado a pedidos.txt
    */
    @Override
    public String toString(){
        return ""+ super.getCodigo()+"," + nombrePlato+"," + precio;
    }
    
}
