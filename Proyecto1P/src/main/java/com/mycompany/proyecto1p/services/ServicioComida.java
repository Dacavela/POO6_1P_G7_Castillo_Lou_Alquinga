/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p.services;

import Restaurante.*;
import java.util.*;
import static Utilities.Validacion.*;
import Utilities.Archivo;
import com.mycompany.proyecto1p.Conductor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davca
 */
public class ServicioComida extends Servicio{
    private Pedido pedido;
    private ArrayList<Restaurante>restaurantes = new ArrayList<Restaurante>();
    private ArrayList<Menu>menus = new ArrayList<>();
 
    private Archivo restaFile = new Archivo("restaurantes.txt");
    private Archivo menuFile = new Archivo("menu.txt");
    private ArrayList<String> listaRestaurante;
    private ArrayList<String> listaMenu;
    //private Restaurante local = new Restaurante();
    
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
    
//    public void mostrarMenu(Restaurante r1){
//        for(Restaurante r : restaurantes){
//            if(!resCho.equals(r.getNombre().toLowerCase())){
//                System.out.println("Ingrese Restaurante en la Lista:");
//                resCho = validarRestaurante(sc).toLowerCase();
//            }
//        }
//    
//    
//    
//    }
    public Restaurante mostrarInfoServicio(){
        System.out.println("Ingresa el origen de tu encomienda: ");
        super.rutaDesde = validarRuta(sc);

        System.out.println("Ingresa el destino de tu encomienda: ");
        super.rutaHacia = validarRuta(sc);

        System.out.println("Ingresa la fecha dd/mm/yyyy: ");
        super.fecha = validarFecha(sc);

        System.out.println("Ingresa la Hora de la encomienda 24Hrs (hh:mm): ");
        super.hora = validarHora(sc);
        System.out.println("----Lista de Restaurantes---");
        
        try
        {
            listaRestaurante = restaFile.leerFichero("retaurantes.txt");
        } catch (IOException ex)
        {
            Logger.getLogger(ServicioComida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String l1: listaRestaurante){
            restaurantes.add(new Restaurante(l1.split(",")[0], l1.split(",")[1]));
        }
        
        for(Restaurante r : restaurantes){
            System.out.println("-. "+r.getNombre());
        }
        Restaurante r1 = seleccionarRestaurante();
        
        try
        {
            listaMenu = menuFile.leerFichero("menus.txt");
        } catch (IOException ex)
        {
            Logger.getLogger(ServicioComida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String l1: listaMenu){
            if (r1.getCodigo().equals(l1.split(",")[0]))
                menus.add(new Menu(r1.getCodigo(),r1.getNombre(),l1.split(",")[1], Double.valueOf(l1.split(",")[2])));
        }
        ArrayList<Menu> platosElegidos = seleccionarMenu();
        
        
        
        
        return null;   
    }
    
    public Restaurante seleccionarRestaurante(){
        System.out.println("Elija un restaurante:");
        String resCho = validarRestaurante(sc);
        boolean tr = true;
        while (tr) {

            for (Restaurante r : restaurantes) {
                System.out.println(r.getNombre().toLowerCase());
                if (resCho.equals(r.getNombre().toLowerCase())) {
                    return r;
                }
            }
            System.out.println("Ingrese Restaurante en la Lista:");
            resCho = validarRestaurante(sc);
        }
        return null;
    }
    
    public ArrayList seleccionarMenu(){
        String eleccion = "";
        while (!eleccion.equals("N")){
            for(Menu m : menus){
                System.out.println("-. " + m.getNombrePlato() + ": $" + m.getPrecio());
            }
            System.out.println("Elija un Plato(Escriba N si no quiere agregar mas platos):");
            eleccion = sc.nextLine();
            Menu platoElegido = null;
            if (!eleccion.equals("N"))
                platoElegido = menus.get(Integer.parseInt(eleccion));
                pedido.getPlatos().add(platoElegido);
                vPagar += platoElegido.getPrecio();    
        }
        return pedido.getPlatos();
    }
    
    @Override
    public double calcularPrecio(){
        vPagar += 1 + (Math.random() * 49);
        vPagar = Math.round(vPagar*100.0)/100.0;
        return vPagar;
    }
    @Override
    public double calcularPrecio(String s){
        vPagar *= 1.10;
        vPagar = Math.round(vPagar*100.0)/100.0;

        return vPagar;
    }
    
}
