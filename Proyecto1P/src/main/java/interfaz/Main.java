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
 *
 * @author Davca
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

//        Archivo v2 = new Archivo("conductores.txt");
//        Archivo v = new Archivo("vehículos.txt");
//        Restaurante r1 = new Restaurante();
//        
//        r1 = c1.mostrarInfoServicio();
//        System.out.println(r1.getNombre());
////        
//        String co = v2.accederLinea(v2.buscar("D", 3)).split(",")[3];
//        String cod = v.accederLinea(v.buscar(co, 1));
//        System.out.println(cod);
//        String [] verifi = v2.buscarDriver("O","M");
//        System.out.println(verifi[0]);
// Clase main para ejecutar todo el programa
        //v2.reemplazarLineaConductores("1750036422");

        SistemaUI2 sysui = new SistemaUI2();
        sysui.SistemaUI();
        
    }
    
}
