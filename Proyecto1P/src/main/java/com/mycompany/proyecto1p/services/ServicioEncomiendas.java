/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import Utilities.TipoEncomiendas;
import static Utilities.TipoEncomiendas.*;
import static Utilities.Validacion.validarCantidadProductos;
import static Utilities.Validacion.validarEncomienda;
import static Utilities.Validacion.validarFecha;
import static Utilities.Validacion.validarHora;
import static Utilities.Validacion.validarRuta;
import com.mycompany.proyecto1p.Cliente;
import com.mycompany.proyecto1p.Conductor;

/**
 *
 * @author Davca
 */
public class ServicioEncomiendas extends Servicio{
    public String cantidadProductos;
    public TipoEncomiendas tipoEncomienda;
    
    //Constructor ServicioEncomiendas que hereda de la clase Servicio
    public ServicioEncomiendas(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, String cProductos, TipoEncomiendas tEnc){
        super(rDesde, rHacia, date, hour, c, vPagar);
        cantidadProductos = cProductos;
    }
    public ServicioEncomiendas(){
        
    }
    
    //Getters y Setters
    public String getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(String cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public TipoEncomiendas getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(TipoEncomiendas tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }
    
    
    public void mostrarInfoServicio(){
        System.out.println("Ingresa el origen de tu encomienda: ");
        super.rutaDesde = validarRuta(sc);

        System.out.println("Ingresa el destino de tu encomienda: ");
        super.rutaHacia = validarRuta(sc);

        System.out.println("Ingresa la fecha dd/mm/yyyy: ");
        super.fecha = validarFecha(sc);

        System.out.println("Ingresa la Hora de la encomienda 24Hrs (hh:mm): ");
        super.hora = validarHora(sc);
        
        System.out.printf("Ingresa el tipo de encomienda:\n1. Medicamentos\n2. Documentos\n3. Ropa\n");
        this.tipoEncomienda = validarEncomienda(sc);
        
        System.out.printf("Ingresa la cantidad de productos de tipo %s a enviar\n",this.tipoEncomienda.toString().toLowerCase());
        this.cantidadProductos = validarCantidadProductos(sc);
    }
    
    public String toString(Cliente cli, String tipoPago, Conductor con){
        
        return super.idUnico + "," + cli.getNombre() + "," +con.getNombre()
                            + "," + this.rutaDesde + "," + this.rutaHacia +"," + this.fecha 
                            + "," + this.hora + "," + this.tipoEncomienda + "," + this.cantidadProductos + "," + tipoPago + "," + this.vPagar;
    }
        
    
}
