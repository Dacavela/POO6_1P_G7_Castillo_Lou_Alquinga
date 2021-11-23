/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto1p;

import Utilities.Archivo;
import static Utilities.Validacion.*;
import java.util.Scanner;


/**
 *
 * @author DhuDu
 */
public class Sistema2 {
    public Archivo userFile = new Archivo("usuarios.txt");
    public Archivo clientesFile = new Archivo("clientes.txt");
    public Archivo viajesFile = new Archivo("viajes.txt");
    
    public Cliente user = new Cliente();
    
    public Scanner sc = new Scanner(System.in);
    
    
    
    public String mostrarInicio(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("             BIENVENIDO AL SISTEMA");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");        
        System.out.println("Usuario:");
        String user1 = (validNameUser(sc));
        user.setUser(user1);
        System.out.println("Contraseña:");
        String password = (sc.nextLine());
        user.setPassword(password);
        return user1+","+password;
    }
    public String verifyLogin(){
        String verLogin = null;
        boolean esUser = userFile.buscar(user.getUser(), 4);
        String[] line = userFile.accederLinea().split(",");
        userFile.setContador(0);
        if(esUser && "C".equals(line[6])){
            if(user.getPassword().equals(line[4])){
                boolean esCliente = clientesFile.buscar(line[0], 1);
                if(esCliente){
                    verLogin = "AccesoCliente";
                    
                }
            }else{
                verLogin = "ClienteWrongPassword";
                System.out.println(verLogin);}            
            
            
        }if(esUser && "R".equals(line[6])){
            if(user.getPassword().equals(line[4])){
                verLogin = "AccesoConductor";
            }else{verLogin = "ConductorWrongPassword";System.out.println(verLogin);}
        }if(!esUser){
            verLogin = "NoExiste";
            System.out.println("---Registrando nuevo usuario---");
        }
        
        
        
        return verLogin;
    }
    public String mostrarInfoCliente(){
        String opcion;
        //Scanner opt = new Scanner(System.in);
        System.out.println("++++++++++++ MENU +++++++++++++"
                +        "\n*                              *\n"
                +          "+++++++++++++++++++++++++++++++");
        
        
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar comida a domicilio");
        System.out.println("3. Solicitar entrega encomienda");
        System.out.println("4. Consultar servicios");
        System.out.println("Escoja una opcion:");
        opcion = sc.nextLine();
        
        while( !opcion.equals("4") && !opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")){
            
            System.out.println("Ingrese Opcion Valida: ");
            opcion = sc.nextLine();
            
        }
        
        return opcion;
        
    }
    
        public void setearCliente(String linea) {
            String[] lineaSeparada = linea.split(",");
            String cedula = lineaSeparada[0];
            String nombre = lineaSeparada[1];
            String apellido = lineaSeparada[2];
            String usuario = lineaSeparada[3];
            String password = lineaSeparada[4];
            String celular = lineaSeparada[5];
            String tipoUsuario = lineaSeparada[6];
            clientesFile.buscar(cedula, 1);
            String[] lane = clientesFile.accederLinea().split(",");
            String edad = lane[1];
            String tarjeta = lane[2];
            user = new Cliente(cedula, nombre, apellido, usuario, password, celular, tipoUsuario, tarjeta, edad);    
    }
}
