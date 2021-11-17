/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import com.mycompany.proyecto1p.*;
import com.mycompany.proyecto1p.services.*;
import java.util.Scanner;
/**
 *
 * @author Davca
 */
public class SistemaUI {
    private Scanner sc;
    private Sistema sistema;
    /**
     * @param args the command line arguments
     */
    
    public SistemaUI() {
        sc = new Scanner(System.in);
        sistema = new Sistema();
        // TODO code application logic here
    }
    
    public void presentarLogIn(){
        System.out.println("Bienvenido ");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
    }

    public void iniciar(){
        
    }
    
}
