/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
//import static Utilities.Validacion.*;
//import Utilities.Archivo;

import java.io.IOException;
//import com.mycompany.proyecto1p.services.ServicioComida;
//import Restaurante.Restaurante;

/**
 * Clase main para correr todo el programa
 *
 * @author Davca
 */
public class Main {

    /**
     * metodo main para correr todo el programa
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        SistemaUI2 sysui = new SistemaUI2();
        sysui.SistemaUI();

    }

}
