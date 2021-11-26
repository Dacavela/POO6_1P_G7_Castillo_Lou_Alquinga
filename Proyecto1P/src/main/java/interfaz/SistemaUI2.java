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
               //System.out.println(s1.user.getNombre());
               String opcion;
                    do{
                        System.out.println("Elija una opción: ");
                        opcion = s1.mostrarInfoCliente();
                        switch (opcion){
                            case "1":
                                System.out.println("Solicitando servicio de taxi");
                                ServicioTaxi serv1 = s1.user.s1;
                                
                                serv1.mostrarInfoServicio();
                                String tipoPago=serv1.tipoPago();
                                
                                
                                System.out.println("¿Desea confirmar su viaje? S/N");                                
                                
                                if (s1.user.confirmarServicio(validarConfirmacion(sc))){
                                    Servicio.setIdUnico(serv1.getIdUnico()+1);
                                    String[] lineaConductor = s1.conductoreFile.buscarDriver("D","A");
                                    s1.setearConductor(lineaConductor,s1.userFile.accederLinea(s1.userFile.buscar(lineaConductor[0], 1)));
                                    s1.conductoreFile.reemplazarLineaConductores(s1.driver.getCedula());
                                    
                                    s1.viajesFile.escribir(serv1.toString(s1.user, tipoPago.toUpperCase(), s1.driver));
                                    s1.agregaServicioLista(serv1);
                                }
                                //Agregamos el servicio a la lista de servicios
                                
                                //System.out.println(s1.getServices());
                                login = s1.verifyLogin();
                                break;
                            case "2":
                                System.out.println("Solicitando entrega de encomienda");
                                ServicioEncomiendas serv3 = s1.user.s3;
                                serv3.mostrarInfoServicio();
                                String tipoPago3 = serv3.tipoPago();
                                
                                System.out.println("¿Desea confirmar su viaje? S/N");                                
                                
                                if (s1.user.confirmarServicio(validarConfirmacion(sc))){
                                    Servicio.setIdUnico(serv3.getIdUnico()+1);
                                    String[] lineaConductor = s1.conductoreFile.buscarDriver("D","M");
                                    s1.setearConductor(lineaConductor,s1.userFile.accederLinea(s1.userFile.buscar(lineaConductor[0], 1)));
                                    s1.conductoreFile.reemplazarLineaConductores(s1.driver.getCedula());
                                    
                                    s1.encomiendasFile.escribir(serv3.toString(s1.user, tipoPago3.toUpperCase(), s1.driver));
                                    //System.out.println(s1.driver.getNombre());
                                    s1.agregaServicioLista(serv3);
                                }
                                login = s1.verifyLogin();
                                break;
                            case "3":
                                System.out.println("Solicitando comida a domicilio");
                                ServicioComida serv2 = s1.user.s2;
                                serv2.mostrarInfoServicio();
                                String tipoPago2=serv2.tipoPago();
                                
                                
                                s1.agregaServicioLista(serv2);
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
