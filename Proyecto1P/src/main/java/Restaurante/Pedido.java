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
public class Pedido extends Menu {
    private ArrayList<Menu> Platos = new ArrayList<Menu>();
    private static int numeroPedido = (int)Math.round(Math.random()*2000.0);

    public Pedido() {
        numeroPedido++;
    }

    public Pedido(String codigo, String nombre, String nombrePlato, Double precio) {
        super(codigo, nombre, nombrePlato, precio);
        numeroPedido++;
    }

    
    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    
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
    
    @Override
    public String toString(){
        return Platos.toString();
    }
    
    public String toString(Menu m){
        return ""+numeroPedido+","+m.toString();
    }
}
