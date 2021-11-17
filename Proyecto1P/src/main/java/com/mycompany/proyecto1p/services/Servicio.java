/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import com.mycompany.proyecto1p.*;

/**
 *
 * @author Davca
 */
public abstract class Servicio {
    protected String rutaDesde;
    protected String rutaHacia;
    protected String fecha;
    protected String hora;
    protected Conductor conductor;
    protected Double valPagar;
    protected static int idUnico = 0;
    
    public Servicio(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar){
        rutaDesde = rDesde;
        rutaHacia = rHacia;
        fecha = date;
        hora = hour;
        conductor = c;
        valPagar = vPagar;
        idUnico +=1;
    }

    public String getRutaDesde() {
        return rutaDesde;
    }

    public void setRutaDesde(String rutaDesde) {
        this.rutaDesde = rutaDesde;
    }

    public String getRutaHacia() {
        return rutaHacia;
    }

    public void setRutaHacia(String rutaHacia) {
        this.rutaHacia = rutaHacia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Double getValPagar() {
        return valPagar;
    }

    public void setValPagar(Double valPagar) {
        this.valPagar = valPagar;
    }

    public static int getIdUnico() {
        return idUnico;
    }

    public static void setIdUnico(int idUnico) {
        Servicio.idUnico = idUnico;
    }

    
    
    
    
    
}
