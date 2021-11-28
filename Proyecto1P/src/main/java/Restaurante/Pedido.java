/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante;

import java.util.ArrayList;

/**
 *
 * @author Davca
 */
//Esta clase extiende de Menu ya que necesita el codigo del restaurante, podria no heredar pero mejor no hacerse lios.
public class Pedido extends Menu {
    
    //El ArrayList de tipo Menu es una lista de platos que utilizaremos para guardar los platos pedidos por el servicioComida
    private ArrayList<Menu> Platos = new ArrayList<Menu>();
    //El numeroPedido es un static ya que se va a sumar uno cada vez que se instancie un pedido.
    private static int numeroPedido = (int)Math.round(Math.random()*2000.0);

    //Constructor donde se instancia un pedido
    public Pedido() {    
    }

    //Constructor que recibe parametros
    public Pedido(String codigo, String nombre, String nombrePlato, Double precio) {
        super(codigo, nombre, nombrePlato, precio);
    }

    //Getters y Setters
    public ArrayList<Menu> getPlatos() {
        return Platos;
    }

    public void setPlatos(ArrayList<Menu> nombrePlatos) {
        this.Platos = nombrePlatos;
    }
    
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    //Fin de getters y Setters
    
    //Una SobreCarga del metodo toString, no es sobreescritura ya que recibe un parametro, a diferencia del metodo toString de Java     
    public String toString(Menu m){
        return ""+numeroPedido+","+m.toString();
    }
}
