/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *Clase creada para validar todos los datos ingresados por teclado
 * Esta clase es muy importante, sirve para validar que el usuario no asesine el programa. 
 * Puede mejorarse aun mas para realizar otro tipo de validaciones, pero para iniciar hace su trabajo basico
 * Nota: Todas estas validaciones reciben un Scanner y algunas sirven para cancelar e ir al menu principal.
 * @author DhuDu
 */
import static Utilities.TipoEncomiendas.*;
import java.util.Scanner;


public class Validacion {
    
    /**   
    * Metodo de Validacion de entradas por teclado para el correcto funcionamiento, 
    * esta sirve para el nombre de usuario o entradas similares
    * @param sc define el objeto scanner para ahorrar lineas de codigo
    * @return  retorna un string que no tenga espacios que no es vacio y que no tiene simbolos
    */
    public static String validNameUser(Scanner sc){
        String valUser = sc.nextLine().trim();
        while( !(valUser.matches("[a-zA-Z0-9]*"))||(valUser.length()<5 || valUser.equals(""))){
            System.out.println("USUARIO NO PUEDE CONTENER ESPACIOS, CARACTERES ESPECIALES O ESTAR VACIO (mas de 5 caracteres).\nUsuario:");
            valUser = sc.nextLine();
        }
        return valUser.toLowerCase();
    }//Cierre del metodo
    /**
    //Metodo de Validacion para la contraseña
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string que sea de 4 o más caracteres y que no contenga comas.
    */
    public static String validPassword(Scanner sc){
        String vlidPass = sc.nextLine().trim();
        while(vlidPass.length()<4 || vlidPass.contains(",") ){
            System.out.println("Contraseña no debe tener [ , ] y 4 caracteres mínimo\n(Espacios al inicio o al final seran suprimidos)\nIngrese contraseña valida:");
            vlidPass = sc.nextLine().trim();
        }System.out.println("Su nueva contraseña es:"+vlidPass);
        return vlidPass;
    }//Cierre del metodo
    /**Metodo de Validacion para la cedula
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string que sea de tipo numerico y con length 10.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Nombres y Apellidos
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string que sea de letras sin simbolos.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Celular
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string que sea de 9 digitos empezando por 09.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para la EDAD
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string que sea de 2 digitos entre 12 y 99 anios.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Credit Card
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string de 13 a 19 diitos.
    */
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
    
    }//Cierre del metodo
    /**Metodo de Validacion para Fecha
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string con el formato dd/mm/yyyy.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion Hora
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string con el formato hh:mm maximo 23:59 minimo 00:00.
    */
    public static String validarHora(Scanner sc){
        String validHora = sc.nextLine().trim();
        if(validHora.equals("cancelar")){return validHora;}
        while(!validHora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")||validHora.equals("")){
            System.out.println("Ingrese formato correcto: 24Hrs (hh:mm)");
            validHora = sc.nextLine();
        }
        return validHora;
    }//Cierre del metodo
    /**Metodo de Validacion para Pasajeros
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string de 1 digito menor igual a 4.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Ruta
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string sin comas que representa la ruta.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Encomiendas
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un enum de tipoEncomiendas.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Cantidad de Productos
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string de digitos entre 0 y 100.
    */
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
    }//Cierre del metodo
    /**Metodo de Validacion para Confirmacion
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string s ó n sin discriminar entre mayuscula o minuscula.
    */
    public static String validarConfirmacion(Scanner sc){
        String validCon = sc.nextLine().trim();
        if(validCon.equals("cancelar")){
            return validCon;
        }
        while(!validCon.matches("(?i)(s|n){1}")  || validCon.equals("") || validCon.matches("[ ]*")){
            System.out.println("Opcion no valida\n¿Desea confirmar su viaje? S/N");
            validCon = sc.nextLine().trim();
        }return validCon;
    }//Cierre del metodo
    /**Metodo de Validacion para Restaurante
    * @param sc define el objeto scanner para la entrada por teclado
    * @return devuelve un string sin comas.
    */
    public static String validarRestaurante(Scanner sc){
        String validRes = sc.nextLine().trim();
        if(validRes.toLowerCase().equals("cancelar")){
            return validRes;
        }
        while(!validRes.matches("[a-zA-Z0-9 ]*") || validRes.equals("")){
            System.out.println("Ingrese un restaurante de la lista");
            validRes = sc.nextLine().trim();  }
    return validRes;
    }//Cierre del metodo
}
