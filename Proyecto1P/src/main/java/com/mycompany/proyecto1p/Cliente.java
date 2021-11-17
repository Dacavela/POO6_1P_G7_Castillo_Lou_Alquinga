/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

import com.mycompany.proyecto1p.services.*;
import java.util.Scanner;

/**
 *
 * @author Davca
 */
public class Cliente {
    private String tarjetaCred;
    
    public void solicitarServicioTaxi() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el origen del viaje: ");
        String rDesde = sc.nextLine();

        System.out.println("Ingresa tu destino: ");
        String rHacia = sc.nextLine();

        System.out.println("Ingresa la fecha: ");
        String date = sc.nextLine();

        System.out.println("Ingresa la Hora del viaje: ");
        String hour = sc.nextLine();

        System.out.println("¿Cuántas personas viajarán?: ");
        int pViajan = sc.nextInt();
        sc.nextLine();

        int tipoPago = 0;
        Double vPagar = Math.random() * 50;
        do {
            System.out.printf("Ingresa el número del método de pago que desees:\n1: Efectivo %s\2:Tarjeta %s", vPagar, vPagar * 1.10);
            tipoPago = sc.nextInt();
            sc.nextLine();
            switch (tipoPago) {
                case 1:
                    System.out.println("Pago en efectivo seleccionado.");
                case 2:
                    vPagar *= 1.10;
                    System.out.println("Pago con tarjeta seleccionado.");
            }
        } while (tipoPago != 1 || tipoPago != 2);
        
        System.out.println("¿Desea confirmar su viaje? S/N");
        String confirmar = sc.nextLine();
        
        if (confirmar.equals("S")){
            
            Conductor c = new Conductor();
            ServicioTaxi st = new ServicioTaxi(rDesde, rHacia, date, hour, c, vPagar, pViajan);
        }
    }
    
    
}
