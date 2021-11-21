/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

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

/**
 *
 * @author Davca
 */
public class Sistema {
    private static List <Usuario> usuarios;
    
    
    public Sistema(){
        usuarios = new ArrayList<>();       
        
//        usuarios.add(new Usuario("0923547362","Luis","Mancero","lmancero","qwerty","0983637223","C"));
//        usuarios.add(new Usuario("0945698598","Marco","Cárdenas","mcarden","abcde","0975342533","C"));
//        usuarios.add(new Usuario("0986353323","Juan" ,"Gómez","jgome","38373","093727266","R"));
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }

    
    public static ArrayList<String> LeeFichero(String nombrearchivo) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
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
    
    
    
    //Metodo agregarCliente que sirve cuando no exista un usuario registrado, entonces procede a registrarlo en usuarios.txt y clientes.txt
    public static boolean agregarCliente(Cliente c) {
        if (buscarUsuario(c.getUser(), c.getPassword()) == null) {

            int x = 2;
            for (int i = 0; i < x; i++) {
                FileWriter fichero = null;
                BufferedWriter bw = null;
                PrintWriter pw = null;
                if (i == 0) {

                    try {
                        fichero = new FileWriter("clientes.txt", true);
                        bw = new BufferedWriter(fichero);
                        //upcasting del usuario a cliente
                        
                        bw.write(c.getCedula() + "," + c.getEdad() + "," + c.getTarjetaCred() + "\n");

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // Nuevamente aprovechamos el finally para 
                            // asegurarnos que se cierra el fichero.
                            if (null != fichero) {
                                //fichero.close();
                                bw.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (i == 1) {
                    try {
                        fichero = new FileWriter("usuarios.txt", true);
                        bw = new BufferedWriter(fichero);
                        Usuario usuario = (Usuario)c;
                        bw.write(usuario.toString() + "\n");
                        //Agregamos el usuario a la lista luego de agregarlo al txt para poder comparar luego en la lista en vez de buscar por todo el fichero
                        agregaUsuarioLista(usuario);

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // Nuevamente aprovechamos el finally para 
                            // asegurarnos que se cierra el fichero.
                            if (null != fichero) {
                                //fichero.close();
                                bw.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
//    public boolean agregarUsuario(Usuario c) {
//        if (buscarUsuario(c.getUser(),c.getPassword()) == null) {
//            FileWriter fichero = null;
//            BufferedWriter bw = null;
//            PrintWriter pw = null;
//            
//            try {
//            fichero = new FileWriter("usuarios.txt",true);
//            bw = new BufferedWriter(fichero);
//            bw.write(c+"\n");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // Nuevamente aprovechamos el finally para 
//                // asegurarnos que se cierra el fichero.
//                if (null != fichero) {
//                    //fichero.close();
//                    bw.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//            return true;
//        }
//        return false;
//    }

}