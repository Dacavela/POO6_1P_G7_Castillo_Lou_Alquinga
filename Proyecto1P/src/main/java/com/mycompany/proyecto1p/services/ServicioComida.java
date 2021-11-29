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
 *Clase servicio, utilizada para crear servicios de delivery
 * @author David Castillo
 * @version 1
 */
public class ServicioComida extends Servicio{
    private Pedido pedido = new Pedido();
    private final Archivo restaFile = new Archivo("restaurantes.txt");
    private final Archivo menuFile = new Archivo("menu.txt");
    private ArrayList<String> listaRestaurante;
    private ArrayList<String> listaMenu;
    private Restaurante r1 = new Restaurante();
    //private Restaurante local = new Restaurante();
    
    //C
    /**
    * Constructor de Servicio 
    * Constructor ServicioComida que hereda de la clase Servicio
     * @param rDesde ruta desde la que se va
     * @param rHacia la que se dirige
     * @param date fecha
     * @param hour hora
     * @param c conductor asignado para el servicio
     * @param vPagar valor a pagar
     * @param p pedido creado para la clase
    */
    public ServicioComida(String rDesde, String rHacia, String date, String hour, Conductor c, Double vPagar, Pedido p){
        super(rDesde, rHacia, date, hour, c, vPagar);
         pedido = p;
    }
    /**
     * Constructor sin parametros
     */
    public ServicioComida(){
    }
    
    /**
     * Getters y Setters
    */
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    /**
     * metodo para mostrar en pantalla el servicio e ir pidiendo la informacion para instanciarlo
     * @param s1 el sistema para realizar acciones y metodos que son de sistema
     * @return retorna un booleano usado para ver si se cancela o no el pedido y se regresa al menu
     */
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
        r1 = seleccionarRestaurante(restaurantes);

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
        if(tipopago.equals("cancelar")){return permanecer = true;}
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
            s1.getConductoreFile().reemplazarLineaConductores(s1.getDriver().getCedula(),super.getIdUnico());
            s1.getDeliveryFile().escribir(this.toString(s1.getUser(), tipopago.toUpperCase(), s1.getDriver()));
            s1.getDriver().setServicioCom(this);
            for (Menu m: pedido.getPlatos()){
                s1.getPedidosFile().escribir(pedido.toString(m));
            }
            s1.agregaServicioLista(this);
        }
        return permanecer;
    }
    
    
    /**
     * metodo para elegir un restaurante
     * @param restaurantes recibe un array de restaurantes para buscar en ellos el seleccionado
     * @return devuelve un restaurante que se usara en el metodo de de mostrarInfoServicio para generar el pedido
     */
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
    /**
     * Metodo para seleccionar el pedido
     * @param menus es un array de platos del restaurante
     * @return retorna un array con la seleccion de platos
     */
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
    
    /**
     * metodo heredado que suma al valor de pago el costo del servicio
     * @return el valor de pago sin el cargo de tarjeta
     */
    @Override
    public double calcularPrecio(){
        vPagar += 1 + (Math.random() * 49);
        vPagar = Math.round(vPagar*100.0)/100.0;
        return vPagar;
    }
    /**
     * metodo heredado que suma al valor de pago el costo del servicio
     * @return el valor de pago con tarjeta
     */
    @Override
    public double calcularPrecio(String s){
        vPagar *= 1.10;
        vPagar = Math.round(vPagar*100.0)/100.0;

        return vPagar;
    }
    
    /**
     * metodo toString, no es una sobreescritura porque recibe parametros
     * @param cli cliente que hace el pedido
     * @param tipoPago tipo de pago del pedido
     * @param con conductor encargado del pedido
     * @return retorna un string deseado con datos del cliente, tipo de pago y conductor.
     */
    public String toString(Cliente cli, String tipoPago, Conductor con){
        
        return super.idUnico + "," + cli.getNombre() + "," +con.getNombre()
                            + "," + this.rutaDesde + "," + this.rutaHacia +"," + this.fecha 
                            + "," + this.hora + "," + pedido.getNumeroPedido() + "," + tipoPago + "," + this.vPagar;
    }
    /**
     * metodo toString, sobreescritura del metodo de java
     * @return retorna un string deseado
     */
    @Override
    public String toString(){
        String pedido1 = "reemplazar";
        for (Menu m: pedido.getPlatos()){
                pedido1 = pedido1+", "+m.getNombrePlato();
            }
        pedido1 = pedido1.replaceAll("reemplazar, ", "");
        return "Tipo: Delivery\n"+"Restaurante: "+r1.getNombre()+"\nPedido: "+pedido1+
                "\nFecha: "+this.fecha+"\nHora: "+this.hora+"\nDesde: "+this.rutaDesde+"\nHasta: "+this.rutaHacia;
    }
}
