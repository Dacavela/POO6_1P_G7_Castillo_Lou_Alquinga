/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import com.mycompany.proyecto1p.Conductor;

/**
 *
 * @author Davca
 */
public class ServicioTaxi extends Servicio{
    private int personasQueViajan;
    
    public ServicioTaxi(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, int pViajan){
        super(rDesde, rHacia, date, hour, c, vPagar);
        personasQueViajan = pViajan;
    }

    public int getPersonasQueViajan() {
        return personasQueViajan;
    }

    public void setPersonasQueViajan(int personasQueViajan) {
        this.personasQueViajan = personasQueViajan;
    }
    
    
    
}
