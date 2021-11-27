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
    private ArrayList<Menu> Platos;
    private String numeroPedido;

    public Pedido() {
    }

    public Pedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    
    public ArrayList<Menu> getPlatos() {
        return Platos;
    }

    public void setPlatos(ArrayList<Menu> nombrePlatos) {
        this.Platos = nombrePlatos;
    }

    
 
    

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }  
}
