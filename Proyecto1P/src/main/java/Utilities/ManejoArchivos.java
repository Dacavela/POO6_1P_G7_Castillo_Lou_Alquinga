/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import com.mycompany.proyecto1p.Cliente;
import static com.mycompany.proyecto1p.Sistema.agregaUsuarioLista;
import static com.mycompany.proyecto1p.Sistema.buscarUsuario;
import com.mycompany.proyecto1p.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Davca
 */
public class ManejoArchivos {
    
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
    
    
}
