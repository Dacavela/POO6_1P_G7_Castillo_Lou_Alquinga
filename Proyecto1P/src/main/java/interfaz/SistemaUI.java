/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import com.mycompany.proyecto1p.*;
import com.mycompany.proyecto1p.services.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Utilities.ManejoArchivos.agregarCliente;
/**
 *
 * @author Davca
 */
public class SistemaUI {
<<<<<<< HEAD
//    private Scanner sc;
//    private Sistema sistema;
//    /**
//     * @param args the command line arguments
//     */
//    
//    public SistemaUI() {
//        sc = new Scanner(System.in);
//        sistema = new Sistema();
//        // TODO code application logic here
//    }
//    
//    public String presentarLogIn(){
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("             BIENVENIDO AL SISTEMA");
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");        
//        System.out.println("Usuario: ");
//        String user = sc.nextLine().toLowerCase().replaceAll("^\\s*","");
//        System.out.println("Contraseña: ");
//        String password = sc.nextLine();
//        return (user +"," + password);
//    }
//
//    
//    public void iniciar() throws IOException {
//        /*Lineas 43 a 46 sirven para que al iniciar sesión agregue a la lista de usuarios 
//        los que ya estén registrados en el archivo usuarios.txt, así no pedirá crear el 
//        usuario cada vez que se corra el programa nuevamente ni duplicará un usuario que 
//        ya haya sido creado en otra iniciación del programa en los archivos de texto*/
//        ArrayList<String> Lista = sistema.LeeFichero("usuarios.txt");
//        for (String linea : Lista) {
//            sistema.agregaUsuarioLista(linea);
//        }
//
//        do {
//            String[] log = presentarLogIn().split(",");
//            String user = log[0];
//            String password = log[1];
//            //System.out.println(user);
//            //System.out.println(password);
//            
//            //Si el usuario no está en la lista de usuarios proporcionada por usuarios.txt pasa a registar al usuario como cliente
//            if (sistema.buscarUsuario(user, password) == null) {
//
//                System.out.println("Ingrese su cedula: ");
//                String cedula = sc.nextLine();
//                System.out.println("Ingrese su nombre: ");
//                String nombre = sc.nextLine();
//                System.out.println("Ingrese su apellido: ");
//                String apellido = sc.nextLine();
//                System.out.println("Ingrese su celular: ");
//                String celular = sc.nextLine();
//                System.out.println("Ingrese su numero de tarjeta de credito: ");
//                String tarjetaCred = sc.nextLine();
//                System.out.println("Ingrese su edad: ");
//                
//                int edad = sc.nextInt();
//                sc.nextLine();
//                //Procedemos a crear el cliente y agregarlo al sistema, es decir, los archivos usuario.txt y cliente.txt
//                Cliente c = new Cliente(cedula, nombre, apellido, user, password, celular, "C", tarjetaCred, edad);
//                sistema.agregarCliente(c);
//                System.out.println(sistema.getUsuarios());
//            
//            }
//            //Si encuentra al usuario en la lista de usuarios procede a ver si el usuario es cliente o conductor 
//            else {
//                Usuario u = sistema.buscarUsuario(user, password);
//                if (u.getTipoUsuario().equals("C")) {
//                    //Creamos un cliente con los atributos dados de la base de datos si es que el usuario es cliente
//                    Cliente c2 = sistema.buscarCliente(user, password);
//                    System.out.println("Bienvenido cliente "+ c2.getNombre());
//                    //System.out.println(c2);
//                    
//                } else if (u.getTipoUsuario().equals("R")){
//                    //Creamos un cliente con los atributos dados de la base de datos si es que el usuario es conductor
//                    Conductor r = sistema.buscarConductor(user, password);
//                    System.out.println("Bienvenido conductor " + r.getNombre());
//                    //System.out.println(r);
//                    
//                }
//            }
//        } while (1 == 1);
//    }

}
=======
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
        //Agregada verificacion
        
        return (user +"," + password);
    }

    
    public void iniciar() throws IOException {
        /*Lineas 43 a 46 sirven para que al iniciar sesión agregue a la lista de usuarios 
        los que ya estén registrados en el archivo usuarios.txt, así no pedirá crear el 
        usuario cada vez que se corra el programa nuevamente ni duplicará un usuario que 
        ya haya sido creado en otra iniciación del programa en los archivos de texto*/
        ArrayList<String> Lista = Utilities.ManejoArchivos.LeeFichero("usuarios.txt");
        for (String linea : Lista) {
            sistema.agregaUsuarioLista(linea);
        }

        do {
            String[] log = presentarLogIn().split(",");
            String user = log[0];
            String password = log[1];
            //System.out.println(user);
            //System.out.println(password);
            
            //Si el usuario no está en la lista de usuarios proporcionada por usuarios.txt pasa a registar al usuario como cliente
            if (sistema.buscarUsuario(user, password) == null) {
                sistema.nuevoCliente(user, password);
            }
            
            //Si encuentra al usuario en la lista de usuarios procede a ver si el usuario es cliente o conductor 
            else {
                Usuario u = sistema.buscarUsuario(user, password);
                if (u.getTipoUsuario().equals("C")) {
                    //Creamos un cliente con los atributos dados de la base de datos si es que el usuario es cliente
                    Cliente c2 = sistema.buscarCliente(user, password);
                    System.out.println("Bienvenido cliente "+ c2.getNombre());
                    ////System.out.println(c2);
                    
                    System.out.println("/***************MENU***************/");
                    System.out.println("/*                                */");
                    System.out.println("/**********************************/");
                    System.out.println("1. Solicitar servicio taxi");
                    System.out.println("2. Solicitar comida a domicilio");
                    System.out.println("3. Solicitar entrega encomienda");
                    System.out.println("4. Consultar servicios");
                    
                    
                    String opcion = "";
                    do{
                        System.out.println("Elija una opción: ");
                        opcion = sc.nextLine();
                        switch (opcion){
                            case "1":
                                c2.solicitarServicioTaxi();
                                break;
                            case "2":
                                //c2.solicitarComidaDomicilio();
                                break;
                            case "3":
                                //c2.solicitarEntregaEncomienda();
                                break;
                            case "4":
                                //c2.consultarServicios();
                                break;
                            default:
                                System.out.println("Ingreso incorrecto: ");
                                break;
                        
                       
                    }
                    }while (opcion!= "1" && opcion!= "2" && opcion!= "3" && opcion!= "4");
                    
                } else if (u.getTipoUsuario().equals("R")){
                    //Creamos un cliente con los atributos dados de la base de datos si es que el usuario es conductor
                    Conductor r = sistema.buscarConductor(user, password);
                    System.out.println("Bienvenido conductor " + r.getNombre());
                    ////System.out.println(r);
                    
                }
            }
        } while (1 == 1);
    }
}
>>>>>>> 9fe1ba1fbcfa0c565705244a8c2d77c367acac1a
