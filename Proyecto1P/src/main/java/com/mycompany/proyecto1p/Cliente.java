/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;
import java.util.Scanner;
import Utilities.Archivo;
import static Utilities.Validacion.*;

import com.mycompany.proyecto1p.services.*;
//import java.util.Scanner;

/**
 *
 * @author Davca
 */
public class Cliente extends Usuario{
    private String tarjetaCred;
    private String edad;
    String confirmar;
    public ServicioTaxi s1 = new ServicioTaxi();
    public ServicioComida s2 = new ServicioComida();
    public ServicioEncomiendas s3 = new ServicioEncomiendas();
    public Vehiculo v1 = new Vehiculo();
    private Archivo userFile = new Archivo("usuarios.txt");
    private Archivo clientesFile = new Archivo("clientes.txt");

    public Cliente() {
        this.tipoUsuario = "C";
    }
    
    
    //Constructor de la clase Cliente que hereda de la clase Usuario
    public Cliente(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario, String tarjetaCred, String edad) {
        super(cedula, nombre, apellido, user, password, celular, tipoUsuario);
        this.tarjetaCred = tarjetaCred;
        this.edad = edad;
    }

    public String getTarjetaCred() {
        return tarjetaCred;
    }

    public void setTarjetaCred(String tarjetaCred) {
        this.tarjetaCred = tarjetaCred;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public boolean confirmarServicio(String s){
        
        return s.toUpperCase().equals("S");
    }
    
    public void solicitarServicioTaxi() {
        s1.mostrarInfoServicio();
    }
    
        public String toString(String a){
            return this.cedula+","+this.edad+","+this.tarjetaCred;
        }   
    
    public boolean crearNewUsuario(Scanner sc) {
        
        String cancelar;
        boolean permanecer = false;
        
        System.out.println("Ingrese Cedula:");
                cancelar = validarCedula(sc);
                if(cancelar.equals("cancelar")) {
                    return permanecer = true;
                }
                while (userFile.buscar(cancelar, 1)) {
                    System.out.println("----Cedula ya existente----\nIngrese Cedula:");
                    cancelar = validarCedula(sc);
                    if(cancelar.equals("cancelar")) {
                        return permanecer = true;
                    }
                }

                setCedula(cancelar);
                System.out.println("Ingrese Nombre");
                cancelar = validarNames(sc);
                if(cancelar.equals("cancelar")) {
                    return permanecer = true;
                }
                setNombre(cancelar);
                System.out.println("Ingrese Apellido");
                cancelar = validarNames(sc);
                if(cancelar.equals("cancelar")) {
                    return permanecer = true;
                }
                setApellidos(cancelar);
                System.out.println("Ingrese Celular");
                cancelar = validarCelular(sc);
                if(cancelar.equals("cancelar")) {
                    return permanecer = true;
                }
                while (userFile.buscar(cancelar, 6)) {
                    System.out.println("----Celular ya existente----\nIngrese Celular:");
                    cancelar = validarCelular(sc);
                    if(cancelar.equals("cancelar")) {
                        return permanecer = true;
                    }
                }
                setCelular(cancelar);

                System.out.println("Ingrese Edad:");
                cancelar = validarEdad(sc);
                if(cancelar.equals("cancelar")) {
                    return permanecer = true;
                }
                setEdad(cancelar);

                System.out.println("Ingrese Tarjeta de Credito:");
                cancelar = validarCC(sc);
                if(cancelar.equals("cancelar")) {
                    return permanecer = true;
                }
                setTarjetaCred(cancelar);

                System.out.println("------Establecer contraseña------\nIngrese nueva contraseña: ");
                setPassword(validPassword(sc));

                setTipoUsuario("C");
                userFile.escribir(toString());
                clientesFile.escribir(toString("a"));
        return permanecer = false; 
    }
}
