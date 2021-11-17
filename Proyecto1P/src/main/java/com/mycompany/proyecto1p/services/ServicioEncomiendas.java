/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import Utilities.TipoEncomiendas;
import com.mycompany.proyecto1p.Conductor;

/**
 *
 * @author Davca
 */
public class ServicioEncomiendas extends Servicio{
    public int cantidadProductos;
    public TipoEncomiendas tipoEncomienda;
    
    public ServicioEncomiendas(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, int cProductos, TipoEncomiendas tEnc){
        super(rDesde, rHacia, date, hour, c, vPagar);
        cantidadProductos = cProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public TipoEncomiendas getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(TipoEncomiendas tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }
    
    
    
}
