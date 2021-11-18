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
    
    public String presentarLogIn(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("             BIENVENIDO AL SISTEMA");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");        
        System.out.println("Usuario: ");
        String user = sc.nextLine();
        System.out.println("Contraseña: ");
        String password = sc.nextLine();
        return (user +"," + password);
    }

    
    public void iniciar(){
        String log = presentarLogIn();
        String user = log.split(",")[0];
        String password = log.split(",")[1];
        System.out.println(user);
        System.out.println(password);
        
        if(sistema.buscarUsuario(user, password) == null){
            
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
            Cliente c = new Cliente(cedula,  nombre,  apellido,  user, password,  celular,  "C", tarjetaCred, edad);
            sistema.agregarCliente(c);
            System.out.println(sistema.getUsuarios());
            
        }
        
    }
    
}
