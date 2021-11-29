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
import static Utilities.TipoEncomiendas.*;
import java.util.Scanner;

//Esta clase es muy importante, sirve para validar que el usuario no asesine el programa. Puede mejorarse aun mas para realizar otro tipo de validaciones, pero para iniciar hace su trabajo basico
public class Validacion {
    //Nota: Todas estas validaciones reciben un Scanner y algunas sirven para cancelar e ir al menu principal.
    
    //Validacion de entradas por teclado para el correcto funcionamiento, esta sirve para el nombre de usuario o entradas similares
    public static String validNameUser(Scanner sc){
        String valUser = sc.nextLine().trim();
        while( !(valUser.matches("[a-zA-Z0-9]*"))||(valUser.length()<5 || valUser.equals(""))){
            System.out.println("USUARIO NO PUEDE CONTENER ESPACIOS, CARACTERES ESPECIALES O ESTAR VACIO (mas de 5 caracteres).\nUsuario:");
            valUser = sc.nextLine();
        }
        return valUser.toLowerCase();
    }
    
    //Validacion para la contraseña, para que sea de 4 o más numeros o letras y que no contenga comas.
    public static String validPassword(Scanner sc){
        String vlidPass = sc.nextLine().trim();
        while(vlidPass.length()<4 || vlidPass.contains(",") ){
            System.out.println("Contraseña no debe tener [ , ] y 4 caracteres mínimo\n(Espacios al inicio o al final seran suprimidos)\nIngrese contraseña valida:");
            vlidPass = sc.nextLine().trim();
        }System.out.println("Su nueva contraseña es:"+vlidPass);
        return vlidPass;
    }
    
    //Validacion para la cedula, para que solo contenga 10 numeros y que no sea un espacio vacio
    public static String validarCedula(Scanner sc){
        
        String cedulaValida = sc.nextLine().trim();
        
        if(cedulaValida.equals("cancelar")) {
            return cedulaValida;
        }
        
        while(!(cedulaValida.matches("[0-9]{1,10}")&&cedulaValida.length()==10) || cedulaValida.equals("")){
            
            System.out.println("Ingrese una cedula Valida:");
            cedulaValida = sc.nextLine().trim();
        }
        return cedulaValida;
    }
    
    //Validacion para nombres de personas, para que solo contenga letras y no sea vacio.
    public static String validarNames(Scanner sc){
        String validName = sc.nextLine().trim();

        if(validName.equals("cancelar")) {
            return validName;
        }
        while(!(validName.matches("[a-zA-Z]*"))||validName.equals("")){
            System.out.println("Ingrese dato valido:");
            validName = sc.nextLine().trim();
        }
        return validName;
    }
    
    //Validacion de celulares, para que contenga 10 numeros, inicie con 09 y no sea vacio.
    public static String validarCelular(Scanner sc){
        String cllValido = sc.nextLine().trim();
        
        if(cllValido.equals("cancelar")) {
            return cllValido;
        }
        while(!(cllValido.matches("[0-9]{1,10}")&&cllValido.length()==10&&cllValido.startsWith("09")) || cllValido.equals("")){

            System.out.println("Ingrese celular valido:");
            cllValido = sc.nextLine().trim();
    }
        return cllValido;
    }
    
    //Validacion para la edad, solo pueden entrar personas mayores a 11 y menores de 100
    public static String validarEdad(Scanner sc){
        String validEdad = sc.nextLine().trim();
        if(validEdad.equals("cancelar")) {
            return validEdad;
        }
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
    
    //Validacion para validar tarjetas de credito, pueden tener de 13 a 19 digitos.
    public static String validarCC(Scanner sc){
        String validCC = sc.nextLine().trim();
        if(validCC.equals("cancelar")) {
            return validCC;
        }
        
        while(!(validCC.matches("[0-9]{13,19}") && (13<= validCC.length() && validCC.length()<=19) )  ){
            
            System.out.println("Ingrese una Tarjeta Valida:");
            validCC = sc.nextLine().trim();
        }
        return validCC;
    
    }
    
    //Validacion para la fehca, para que se ingrese solo de la forma DD/MM/AAAA
    public static String validarFecha(Scanner sc){
        String validDate = sc.nextLine().trim();
        if(validDate.equals("cancelar")) {
            return validDate;
        }
        while(!validDate.matches("\\d{1,2}/\\d{1,2}/\\d{4}") || validDate.equals("")){
            System.out.println("Ingrese formato correcto: (dd/mm/yyyy)");
            validDate = sc.nextLine();
        }
        return validDate;
    }
    
    //Validacion de la hora para que se ingrese de manera hh:mm
    public static String validarHora(Scanner sc){
        String validHora = sc.nextLine().trim();
        if(validHora.equals("cancelar")){return validHora;}
        while(!validHora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")||validHora.equals("")){
            System.out.println("Ingrese formato correcto: 24Hrs (hh:mm)");
            validHora = sc.nextLine();
        }
        return validHora;
    }
    
    //Validacion de pasajeros, solo pueden entrar hasta 4 pasajeros en un auto, ya que no disponemos de autos de mas asientos
    public static String validarPasajeros(Scanner sc){
        String validPas = sc.nextLine().trim();
        if(validPas.equals("cancelar")){return validPas;}
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
    
    //Validacion de la ruta para que no contenga comas ni sea un espacio vacio.
    public static String validarRuta(Scanner sc){
        String validRuta = sc.nextLine().trim();
        if(validRuta.equals("cancelar")) {
            return validRuta;
        }
        while(validRuta.contains(",") || validRuta.equals("") ||validRuta.matches("[ ]*")){
            System.out.println("RUTA no debe contener ',' ni estar vacio\nIngrese Ruta:");
            validRuta = sc.nextLine().trim();
        }
        return validRuta;
    }
    
    //Vlidacion de encomiendas que retorna un objeto de TipoEncomiendas
    public static TipoEncomiendas validarEncomienda(Scanner sc){
        TipoEncomiendas tipo = null;
        
        //MEDICAMENTOS,DOCUMENTOS,ROPA, cancelar;
        String entrada;
        do{
            entrada = sc.nextLine();
            switch(entrada){
                    case "1":
                        tipo = MEDICAMENTOS;
                        break;
                    case "2":
                        tipo = DOCUMENTOS;
                        break;
                    case "3":
                        tipo = ROPA;
                        break;
                    case"cancelar":
                        tipo = cancelar;
                        break;
                    default: 
                        System.out.printf("Ingrese un número del 1 al 3:\n1. Medicamentos\n2. Documentos\n3. Ropa\n");
                        break;
            } 
        }while(!entrada.equals("1") && !entrada.equals("2") && !entrada.equals("3") && !entrada.equals("cancelar"));
        return tipo;
    }
    
    //Validacion de la cantidad de productos para que en las encomiendas ingresen de 1 a 99 objetos, no mas porque no entran en una moto :)
    public static String validarCantidadProductos(Scanner sc){
        String validCant = sc.nextLine().trim();
        if(validCant.equals("cancelar")){return validCant;}
        Integer cant;
        if(validCant.equals("cancelar")) {
            return validCant;
        }
        boolean tmpV = true;
        while(tmpV){
            while(!(validCant.matches("[0-9]{2}")) && !(validCant.matches("[0-9]{1}"))){
                System.out.println("Ingrese cantidad valida:");
                validCant = sc.nextLine().trim();

            }
            cant = Integer.valueOf(validCant);
            if(!(cant<100 && cant>0)){
                System.out.println("Ingrese cantidad valida entre 0 y 100:");
                validCant = sc.nextLine();
                tmpV = true;
        }else{validCant = cant.toString(); tmpV=false;}
        }
        return validCant;
    }
    
    //Validacion de la confirmacion, para que ingresen solo S o N mayuscula o minuscula.
    public static String validarConfirmacion(Scanner sc){
        String validCon = sc.nextLine().trim();
        if(validCon.equals("cancelar")){
            return validCon;
        }
        while(!validCon.matches("(?i)(s|n){1}")  || validCon.equals("") || validCon.matches("[ ]*")){
            System.out.println("Opcion no valida\n¿Desea confirmar su viaje? S/N");
            validCon = sc.nextLine().trim();
        }return validCon;
    }   

    //Validacion de restaurantes para que ingresen solo letras y no sea igual a espacios.
    public static String validarRestaurante(Scanner sc){
        String validRes = sc.nextLine().trim();
        if(validRes.toLowerCase().equals("cancelar")){
            return validRes;
        }
        while(!validRes.matches("[a-zA-Z ]*") || validRes.equals("")){
            System.out.println("Ingrese un restaurante de la lista");
            validRes = sc.nextLine().trim();  }
    return validRes;
    }
}
