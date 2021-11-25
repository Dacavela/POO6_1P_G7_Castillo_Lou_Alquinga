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
        s1.mostrarInicio();
        String login = s1.verifyLogin();
        
        while (true) {

            if (login.equals("NoExiste")) {//si el usuario no existe se escribe en el archivo usuarios.txt

                System.out.println("Ingrese Cedula:");
                String id = validarCedula(sc);
                while (s1.userFile.buscar(id, 1)) {
                    System.out.println("----Cedula ya existente----\nIngrese Cedula:");
                    id = validarCedula(sc);
                }
                s1.userFile.setContador(0);

                s1.user.setCedula(id);
                System.out.println("Ingrese Nombre");
                s1.user.setNombre(validarNames(sc));
                System.out.println("Ingrese Apellido");
                s1.user.setApellidos(validarNames(sc));
                System.out.println("Ingrese Celular");
                String cel = validarCelular(sc);
                while (s1.userFile.buscar(cel, 6)) {
                    System.out.println("----Celular ya existente----\nIngrese Celular:");
                    cel = validarCelular(sc);
                }
                s1.userFile.setContador(0);
                s1.user.setCelular(cel);

                System.out.println("Ingrese Edad:");
                s1.user.setEdad(validarEdad(sc));

                System.out.println("Ingrese Tarjeta de Credito:");
                s1.user.setTarjetaCred(validarCC(sc));

                System.out.println("------Establecer contraseña------\nIngrese nueva contraseña: ");
                s1.user.setPassword(validPassword(sc));

                s1.user.setTipoUsuario("C");
                s1.userFile.escribir(s1.user.toString());
                s1.clientesFile.escribir(s1.user.toString("a"));

                login = s1.verifyLogin();

            }
            
            while (login.equals("ClienteWrongPassword") || login.equals("ConductorWrongPassword")) {

                s1.mostrarInicio();
                login = s1.verifyLogin();
            }
            
            if (login.equals("AccesoCliente")) {
               
               s1.setearCliente(s1.userFile.accederLinea(s1.userFile.buscar(s1.user.getUser(), 4)));
               System.out.println(s1.user.getNombre());
               String opcion;
                    do{
                        System.out.println("Elija una opción: ");
                        opcion = s1.mostrarInfoCliente();
                        switch (opcion){
                            case "1":
                                System.out.println("Solicitando servicio de taxi");
                                ServicioTaxi serv1 = s1.user.s1;
                                
                                serv1.mostrarInfoServicio();
                                String tipoPago;
                                do {
                                    System.out.println("Ingresa el número del método de pago que desee\n1: Efectivo: $"+serv1.calcularPrecio()
                                            +"\n2: Tarjeta: $"+serv1.calcularPrecio("s"));
                                    tipoPago = sc.nextLine();
                                    switch (tipoPago) {
                                        case "1":
                                            System.out.println("Pago en efectivo seleccionado.");
                                            
                                            tipoPago = "Efectivo";
                                            break;
                                        case "2":
                                            
                                            System.out.println("Pago con tarjeta seleccionado.");
                                            tipoPago = "Tarjeta";
                                            break;
                                        default:
                                            System.out.println("Opcion incorrecta, vuelva a intentarlo");
                                            break;
                                    }
                                } while (!tipoPago.equals("Efectivo") && !tipoPago.equals("Tarjeta"));
                                
                                
                                System.out.println("¿Desea confirmar su viaje? S/N");                                
                                
                                if (s1.user.confirmarServicio(validarConfirmacion(sc))){
                                    
                                    
                                    s1.viajesFile.escribir(serv1.toString(s1.user, tipoPago.toUpperCase(), s1.driver));
                                }
                                
                                login = s1.verifyLogin();
                                
                                
                                
                                
                                break;
                            case "2":
                                System.out.println("Solicitando comida a domicilio");
                        login = s1.verifyLogin();
                                break;
                            case "3":
                                System.out.println("Solicitando entrega encomienda");
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
