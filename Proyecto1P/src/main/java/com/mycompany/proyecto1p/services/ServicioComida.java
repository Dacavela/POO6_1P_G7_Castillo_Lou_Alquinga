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
import com.mycompany.proyecto1p.Cliente;
import com.mycompany.proyecto1p.Conductor;
import com.mycompany.proyecto1p.Sistema2;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davca
 */
public class ServicioComida extends Servicio{
    private Pedido pedido = new Pedido();
    private final Archivo restaFile = new Archivo("restaurantes.txt");
    private final Archivo menuFile = new Archivo("menu.txt");
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
    
    public boolean mostrarInfoServicio(Sistema2 s1) {
        ArrayList<Restaurante>restaurantes = new ArrayList<Restaurante>();
        ArrayList<Menu>menus = new ArrayList<>();
        
        String cancelar = null;
        boolean permanecer = false;

        System.out.println("Ingresa el origen del pedido: ");
        cancelar = validarRuta(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.rutaDesde = cancelar;
        

        System.out.println("Ingresa el destino: ");
        cancelar = validarRuta(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.rutaHacia = cancelar;

        System.out.println("Ingresa la fecha dd/mm/yyyy: ");
        cancelar = validarFecha(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.fecha = cancelar;
        

        System.out.println("Ingresa la Hora del pedido 24Hrs (hh:mm): ");
        cancelar = validarHora(sc);
        if(cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        super.hora = cancelar;
        System.out.println("----Lista de Restaurantes---");

        try {
            listaRestaurante = restaFile.leerFichero("retaurantes.txt");
        } catch (IOException ex) {
            Logger.getLogger(ServicioComida.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String l1 : listaRestaurante) {
            restaurantes.add(new Restaurante(l1.split(",")[0], l1.split(",")[1]));
        }

        for (Restaurante r : restaurantes) {
            System.out.println("-. " + r.getNombre());
        }
        Restaurante r1 = seleccionarRestaurante(restaurantes);

        try {
            listaMenu = menuFile.leerFichero("menus.txt");
        } catch (IOException ex) {
            Logger.getLogger(ServicioComida.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String l1 : listaMenu) {
            if (r1.getCodigo().equals(l1.split(",")[0])) {
                menus.add(new Menu(r1.getCodigo(), r1.getNombre(), l1.split(",")[1], Double.valueOf(l1.split(",")[2])));
            }
        }
        pedido.setPlatos(seleccionarMenu(menus));
         String tipopago = tipoPago();
        System.out.println("¿Desea confirmar su viaje? S/N");                                
        //cancelar
        cancelar = validarConfirmacion(sc);
        
        if(cancelar.equals("cancelar")){
            return permanecer = true;
        
        }
        if(s1.getUser().confirmarServicio(cancelar)){
            Servicio.setIdUnico(this.getIdUnico()+1);
            pedido.setNumeroPedido(pedido.getNumeroPedido()+1);
            String[] lineaConductor = s1.getConductoreFile().buscarDriver("D","M");
            s1.setearConductor(lineaConductor,s1.getUserFile().accederLinea(s1.getUserFile().buscar(lineaConductor[0], 1)));
            s1.getConductoreFile().reemplazarLineaConductores(s1.getDriver().getCedula());
            s1.getDeliveryFile().escribir(this.toString(s1.getUser(), tipopago.toUpperCase(), s1.getDriver()));
            for (Menu m: pedido.getPlatos()){
                s1.getPedidosFile().escribir(pedido.toString(m));
            }
            s1.agregaServicioLista(this);
        }
        return permanecer;
    }
    
    
    
    public Restaurante seleccionarRestaurante(ArrayList<Restaurante> restaurantes){
        System.out.println("Elija un restaurante:");
        String resCho = validarRestaurante(sc);
        boolean tr = true;
        while (tr) {

            for (Restaurante r : restaurantes) {
                //System.out.println(r.getNombre().toLowerCase());
                if (resCho.equals(r.getNombre().toLowerCase())) {
                    return r;
                }
            }
            System.out.println("Ingrese Restaurante en la Lista:");
            resCho = validarRestaurante(sc);
        }
        return null;
    }
    
    public ArrayList seleccionarMenu(ArrayList<Menu> menus){
        int eleccion = 1999999999;
        ArrayList<Menu> platosPed = new ArrayList<>();
        vPagar =0.0;
        while (eleccion!=0){
            int con = 1;
            for(Menu m : menus){
                System.out.println("-. "+ con +" "+ m.getNombrePlato() + ": $" + m.getPrecio());
                con++;
            }
            System.out.println("Elija un Plato(Escriba 0 si no quiere agregar mas platos):");
            eleccion = sc.nextInt();
            sc.nextLine();
            Menu platoElegido = null;
            if (eleccion!=0 && eleccion<con){
                platoElegido = menus.get(eleccion-1);
                platosPed.add(platoElegido);
                vPagar += platoElegido.getPrecio();
            }  
        }
        return platosPed;
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
    
    public String toString(Cliente cli, String tipoPago, Conductor con){
        
        return super.idUnico + "," + cli.getNombre() + "," +con.getNombre()
                            + "," + this.rutaDesde + "," + this.rutaHacia +"," + this.fecha 
                            + "," + this.hora + "," + pedido.getNumeroPedido() + "," + tipoPago + "," + this.vPagar;
    }
    
}
