/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import Restaurante.Pedido;
import static Utilities.Validacion.validarFecha;
import static Utilities.Validacion.validarHora;
import static Utilities.Validacion.validarRuta;
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
    public ServicioComida(){
    
    }
    //Getters y Setters
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Override
    public void mostrarInfoServicio(){
        System.out.println("Ingresa el origen de tu encomienda: ");
        super.rutaDesde = validarRuta(sc);

        System.out.println("Ingresa el destino de tu encomienda: ");
        super.rutaHacia = validarRuta(sc);

        System.out.println("Ingresa la fecha dd/mm/yyyy: ");
        super.fecha = validarFecha(sc);

        System.out.println("Ingresa la Hora de la encomienda 24Hrs (hh:mm): ");
        super.hora = validarHora(sc);
    
        
        
    }
}
