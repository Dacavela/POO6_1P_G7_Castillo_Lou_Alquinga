/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import static Utilities.Validacion.*;
import Utilities.Archivo;
import java.io.IOException;

/**
 *
 * @author Davca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        Archivo v2 = new Archivo("conductores.txt");
//        Archivo v = new Archivo("vehículos.txt");
//        
//        String co = v2.accederLinea(v2.buscar("D", 3)).split(",")[3];
//        String cod = v.accederLinea(v.buscar(co, 1));
//        System.out.println(cod);
          

// Clase main para ejecutar todo el programa
        SistemaUI2 sysui = new SistemaUI2();
        sysui.SistemaUI();
        
    }
    
}
