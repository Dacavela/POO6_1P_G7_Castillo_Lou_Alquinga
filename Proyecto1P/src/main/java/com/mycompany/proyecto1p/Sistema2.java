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
    
    
    
    public void mostrarInicio(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("             BIENVENIDO AL SISTEMA");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");        
        System.out.println("Usuario:");
        String user1 = (validNameUser(sc));
        user.setUser(user1);
        System.out.println("Contraseña:");
        String password = (sc.nextLine());
        user.setPassword(password);

    }
    public String verifyLogin(){
        String verLogin = null;
        boolean esUser = userFile.buscar(user.getUser(), 4);
        String[] line = userFile.accederLinea(esUser).split(",");
        
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
            user.setCedula(lineaSeparada[0]);
            user.setNombre(lineaSeparada[1]);
            user.setApellidos(lineaSeparada[2]);
            user.setUser(lineaSeparada[3]);
            user.setPassword(lineaSeparada[4]);
            user.setCelular(lineaSeparada[5]);
            user.setTipoUsuario(lineaSeparada[6]);
            
            String[] lane = clientesFile.accederLinea(clientesFile.buscar(user.getCedula(), 1)).split(",");
            user.setEdad(lane[1]);
            user.setTarjetaCred(lane[2]);
                
    }
}
