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
public class SistemaUI2 {
    
    
    public void SistemaUI() {
        
        
        Scanner sc = new Scanner(System.in);
        Sistema2 s1 = new Sistema2();
        s1.mostrarInicio();
        String login = s1.verifyLogin();
        
        while(true){
            
            if(login.equals("NoExiste")){//si el usuario no existe se escribe en el archivo usuarios.txt
                
                
                System.out.println("Ingrese Cedula:");
                String id = validarCedula(sc);
                while(s1.userFile.buscar(id, 1)){
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
                while(s1.userFile.buscar(cel, 6)){
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
            while(login.equals("ClienteWrongPassword")||login.equals("ConductorWrongPassword")){

                s1.mostrarInicio();
                login = s1.verifyLogin();
                

            }
            if(login.equals("AccesoCliente")){
                String opcionMenu = s1.mostrarInfoCliente();
                
                if(opcionMenu.equals("1")){
                    
                    System.out.println("Solicitando servicio de taxi");
                    login = s1.verifyLogin();
                }if(opcionMenu.equals("2")){
                    System.out.println("Solicitando comida a domicilio");
                    login = s1.verifyLogin();
                }if(opcionMenu.equals("3")){
                    System.out.println("Solicitando entrega encomienda");
                    login = s1.verifyLogin();
                }if(opcionMenu.equals("4")){
                    System.out.println("Consultando servicios");
                    login = s1.verifyLogin();
                }

            }if(login.equals("AccesoConductor")){
                System.out.println("Mostrar opciones conductor");
                s1.mostrarInicio();
                
                
                
            }
        
        login = s1.verifyLogin();
        }
    }
}
