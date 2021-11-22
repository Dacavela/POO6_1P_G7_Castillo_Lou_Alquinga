/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

import static Utilities.ManejoArchivos.LeeFichero;
import static Utilities.ManejoArchivos.agregarCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Davca
 */
public class Sistema {
    private static List <Usuario> usuarios;
    public Sistema(){
       usuarios = new ArrayList<>();
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }
    
    //Metodo estatico para agregar usuarios que hayan sido agregados a usuarios.txt a la  lista de usuarios
    public static void agregaUsuarioLista(Usuario u) throws IOException {           
            usuarios.add(new Usuario(u.getCedula(), u.getNombre(), u.getApellido(), u.getUser(), u.getPassword(), u.getCelular(), u.getTipoUsuario())); 
    }
   
    
    public static void agregaUsuarioLista(String linea) throws IOException {
            String[] lineaSeparada = linea.split(",");
            String cedula = lineaSeparada[0];
            String nombre = lineaSeparada[1];
            String apellido = lineaSeparada[2];
            String user = lineaSeparada[3];
            String password = lineaSeparada[4];
            String celular = lineaSeparada[5];
            String tipoUsuario = lineaSeparada[6];
            usuarios.add(new Usuario(cedula, nombre, apellido, user, password, celular, tipoUsuario)); 
    }
    
    //Metodo estatico para buscar usuarios en el ArrayList de usuarios
    
    public static void nuevoCliente(String user, String password) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su cedula: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su celular: ");
        String celular = sc.nextLine();
        System.out.println("Ingrese su numero de tarjeta de credito: ");
        String tarjetaCred = sc.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        //Procedemos a crear el cliente y agregarlo al sistema, es decir, los archivos usuario.txt y cliente.txt
        agregarCliente(new Cliente(cedula, nombre, apellido, user, password, celular, "C", tarjetaCred, edad));
        ////System.out.println(sistema.getUsuarios());
    }
    
    public  static Usuario buscarUsuario(String user, String password){
        for(Usuario u: usuarios){
            if(u.getUser().equals(user) && u.getPassword().equals(password))
                return u;
        }
        return null;
    }
    public static Cliente buscarCliente(String user, String password) throws IOException {
        ArrayList<String> Lista;
        Usuario u = buscarUsuario(user, password);
        Lista = LeeFichero("clientes.txt");
        for (String linea : Lista) {
            String[] client = linea.split(",");
            if (client[0].equals(u.getCedula())) {
                return new Cliente(u.getCedula(), u.getNombre(), u.getApellido(), u.getUser(), u.getPassword(), u.getCelular(), u.getTipoUsuario(), client[2], Integer.parseInt(client[1]));
            }

        }
        return null;
    }
    
    public static Conductor buscarConductor(String user, String password) throws IOException {
        ArrayList<String> Lista;
        Usuario u = buscarUsuario(user, password);
        Lista = LeeFichero("conductores.txt");
        for (String linea : Lista) {
            String[] driver = linea.split(",");
            if (driver[0].equals(u.getCedula())) {
                return new Conductor(u.getCedula(), u.getNombre(), u.getApellido(), u.getUser(), u.getPassword(), u.getCelular(), u.getTipoUsuario(), driver[0], driver[1], driver[2], Integer.parseInt(driver[3]));
            }
        }
        return null;
    }
    
}