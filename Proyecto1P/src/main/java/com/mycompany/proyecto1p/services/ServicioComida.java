/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import Utilities.Pedido;
import com.mycompany.proyecto1p.Conductor;

/**
 *
 * @author Davca
 */
public class ServicioComida extends Servicio{
    private Pedido pedido;
    
    //Constructor ServicioComida que hereda de la clase Servicio
    public ServicioComida(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, Pedido p){
        super(rDesde, rHacia, date, hour, c, vPagar);
         pedido = p;
    }
    
    //Getters y Setters
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
    
    
}
