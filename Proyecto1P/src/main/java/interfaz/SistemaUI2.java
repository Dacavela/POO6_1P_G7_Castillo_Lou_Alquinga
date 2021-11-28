package interfaz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DhuDu
 */
import static Utilities.Validacion.*;
import com.mycompany.proyecto1p.Sistema2;
import java.util.Scanner;
import com.mycompany.proyecto1p.services.*;

public class SistemaUI2 {
    
    
    public void SistemaUI() {
        
        
        Scanner sc = new Scanner(System.in);
        Sistema2 s1 = new Sistema2();
        s1.listaServices();
        s1.mostrarInicio();
        String login = s1.verifyLogin();
        
        while (true) {

            boolean cancelar = false;

            if (login.equals("NoExiste")) {
                System.out.println("---Registrando nuevo usuario---");//si el usuario no existe se escribe en el archivo usuarios.txt
                cancelar = s1.getUser().crearNewUsuario(sc);
                if(cancelar == true) {
                    s1.mostrarInicio();
                    login = s1.verifyLogin();
                    
                }
            }
            
            while (login.equals("ClienteWrongPassword") || login.equals("ConductorWrongPassword")) {

                s1.mostrarInicio();
                login = s1.verifyLogin();
            }
            
            if (login.equals("AccesoCliente")) {
               
               s1.setearCliente(s1.userFile.accederLinea(s1.userFile.buscar(s1.getUser().getUser(), 4)));
               //System.out.println(s1.user.getNombre());
               String opcion;
                    do{
                        System.out.println("Elija una opción: ");
                        opcion = s1.mostrarInfoCliente();
                        switch (opcion){
                            case "1":
                                System.out.println("Solicitando servicio de taxi");
                                ServicioTaxi serv1 = s1.getUser().getS1();                                
                                cancelar = serv1.mostrarInfoServicio(s1);
                                if (cancelar)
                                    System.out.println("Regresando al menu");
                                //System.out.println(s1.getServices());
                                login = s1.verifyLogin();
                                break;
                            case "2":
                                System.out.println("Solicitando entrega de encomienda");
                                ServicioEncomiendas serv3 = s1.getUser().getS3();
                                cancelar = serv3.mostrarInfoServicio(s1);
                                if (cancelar)
                                    System.out.println("Regresando al menu");
                                login = s1.verifyLogin();
                                break;
                            case "3":
                                System.out.println("Solicitando comida a domicilio");
                                ServicioComida serv2 = s1.getUser().getS2();
                                cancelar = serv2.mostrarInfoServicio(s1);
                                if (cancelar)
                                    System.out.println("Regresando al menu");
                                //System.out.println(s1.getServices());
                                login = s1.verifyLogin();
                                break;
                            case "4":
                                System.out.println("Consultando servicios");
                                login = s1.verifyLogin();
                                break;
                            default:
                                System.out.println("Ingreso incorrecto: ");
                                break;
                    }
                    }while (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("4"));
            }
            
            if (login.equals("AccesoConductor")) {
                s1.mostrarInfoDriver();
                s1.mostrarInicio(); 
            }
        
        login = s1.verifyLogin();
        }
    }
}
