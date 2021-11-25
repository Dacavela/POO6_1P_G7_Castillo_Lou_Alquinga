/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author DhuDu
 */
import java.util.Scanner;
public class Validacion {
    //Validacion de entradas por teclado para el correcto funcionamiento. 
    public static String validNameUser(Scanner sc){
        String valUser = sc.nextLine();
        while( !(valUser.matches("[a-zA-Z0-9]*"))||(valUser.length()<5 || valUser.equals(""))){
            System.out.println("USUARIO NO PUEDE CONTENER ESPACIOS, CARACTERES ESPECIALES O ESTAR VACIO (mas de 5 caracteres).\nUsuario:");
            valUser = sc.nextLine();
        }
        return valUser.toLowerCase();
    }
    public static String validPassword(Scanner sc){
        String vlidPass = sc.nextLine().trim();
        while(vlidPass.length()<4 || vlidPass.contains(",") ){
            System.out.println("Contraseña no debe tener [ , ] y 4 caracteres mínimo\n(Espacios al inicio o al final seran suprimidos)\nIngrese contraseña valida:");
            vlidPass = sc.nextLine().trim();
        }System.out.println("Su nueva contraseña es:"+vlidPass);
        return vlidPass;
    }
    public static String validarCedula(Scanner sc){
        
        String cedulaValida = sc.nextLine().trim();
        
        while(!(cedulaValida.matches("[0-9]{1,10}")&&cedulaValida.length()==10) || cedulaValida.equals("")){
            
            System.out.println("Ingrese una cedula Valida:");
            cedulaValida = sc.nextLine().trim();
        }
        return cedulaValida;
    }
    public static String validarNames(Scanner sc){
        String validName = sc.nextLine().trim();
        while(!(validName.matches("[a-zA-Z]*"))||validName.equals("")){
            System.out.println("Ingrese dato valido:");
            validName = sc.nextLine().trim();
        }
        return validName;
    }
    public static String validarCelular(Scanner sc){
        String cllValido = sc.nextLine().trim();
        
        while(!(cllValido.matches("[0-9]{1,10}")&&cllValido.length()==10&&cllValido.startsWith("09")) || cllValido.equals("")){

            System.out.println("Ingrese celular valido:");
            cllValido = sc.nextLine().trim();
    }
        return cllValido;}
    public static String validarEdad(Scanner sc){
        String validEdad = sc.nextLine().trim();
        Integer ed;
        boolean tmpV = true;
        while(tmpV){
            while(!(validEdad.matches("[0-9]{2}"))){
                System.out.println("Ingrese Edad Valida:");
                validEdad = sc.nextLine().trim();

            }
            ed = Integer.valueOf(validEdad);
            if(!(ed<100 && ed>11)){
                System.out.println("Ingrese Edad Valida:");
                validEdad = sc.nextLine();
                tmpV = true;
        }else{validEdad = ed.toString(); tmpV=false;}
        }
        return validEdad;
    }
    public static String validarCC(Scanner sc){
        
        String validCC = sc.nextLine().trim();
        
        while(!(validCC.matches("[0-9]{13,19}") && (13<= validCC.length() && validCC.length()<=19) )  ){
            
            System.out.println("Ingrese una Tarjeta Valida:");
            validCC = sc.nextLine().trim();
        }
        return validCC;
    
    }
    public static String validarFecha(Scanner sc){
        String validDate = sc.nextLine().trim();
        while(!validDate.matches("\\d{1,2}/\\d{1,2}/\\d{4}") || validDate.equals("")){
            System.out.println("Ingrese formato correcto: (dd/mm/yyyy)");
            validDate = sc.nextLine();
        }
        return validDate;
    }
    public static String validarHora(Scanner sc){
        String validHora = sc.nextLine().trim();
        while(!validHora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")||validHora.equals("")){
            System.out.println("Ingrese formato correcto: 24Hrs (hh:mm)");
            validHora = sc.nextLine();
        }
        return validHora;
    }
    public static String validarPasajeros(Scanner sc){
        String validPas = sc.nextLine().trim();
        Integer ed1;
        boolean tmpV1 = true;
        while(tmpV1){
            while(!(validPas.matches("[0-9]*"))||validPas.equals("")){
                System.out.println("Ingrese dato numerico:");
                validPas = sc.nextLine();

            }
            ed1 = Integer.valueOf(validPas);
            if(!(ed1>0 && ed1<5)){
                System.out.println("Pueden viajar hasta 4 personas:");
                validPas = sc.nextLine();
                tmpV1 = true;
        }else{validPas = ed1.toString(); tmpV1=false;}
        }
        return validPas;
    }
    public static String validarRuta(Scanner sc){
        String validRuta = sc.nextLine().trim();
        while(validRuta.contains(",") || validRuta.equals("") ||validRuta.matches("[ ]*")){
            System.out.println("RUTA no debe contener ',' ni estar vacio\nIngrese Ruta:");
            validRuta = sc.nextLine().trim();
        }
        return validRuta;
    }
    public static String validarConfirmacion(Scanner sc){
        String validCon = sc.nextLine().trim();
        while(!validCon.matches("(?i)(s|n){1}")  || validCon.equals("") || validCon.matches("[ ]*")){
            System.out.println("Opcion no valida\n¿Desea confirmar su viaje? S/N");
            validCon = sc.nextLine().trim();
        }return validCon;
    }   
}
