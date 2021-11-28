/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;
import java.util.Scanner;
import Utilities.Archivo;
import static Utilities.Validacion.*;

import com.mycompany.proyecto1p.services.*;
//import java.util.Scanner;

/**
 *
 * @author Davca
 */
//Clase cliente, extiende de Usuario que es su clase abstracta padre, de la que hereda atributos y metodos
public class Cliente extends Usuario {
    //Los atributos para instanciar la clase seran la tarjeta de credito y la edad, aparte de los dados por su padre
    private String tarjetaCred;
    private String edad;
    //public String confirmar;
    //Tenemos los 3 servicios isntanciados para poder utilizar estas clases en la creacion de los metodos para instanciar en si el objeto
    private ServicioTaxi s1 = new ServicioTaxi();
    private ServicioComida s2 = new ServicioComida();
    private ServicioEncomiendas s3 = new ServicioEncomiendas();
    //Tenemos los dos archivos que vamos a necesitar aqui, el de usuarios y clientes, que se escribiran al crear un nuevo cliente.
    private final Archivo userFile = new Archivo("usuarios.txt");
    private final Archivo clientesFile = new Archivo("clientes.txt");

    //Constructor que solo cambia el tipo de usuario a cliente
    public Cliente() {
        this.tipoUsuario = "C";
    }
    
    //Constructor de la clase Cliente que hereda de la clase Usuario
    public Cliente(String cedula, String nombre, String apellido, String user, String password, String celular, String tipoUsuario, String tarjetaCred, String edad) {
        super(cedula, nombre, apellido, user, password, celular, tipoUsuario);
        this.tarjetaCred = tarjetaCred;
        this.edad = edad;
    }
    
    //Getters y Setters
    public ServicioTaxi getS1() {
        return s1;
    }

    public void setS1(ServicioTaxi s1) {
        this.s1 = s1;
    }

    public ServicioComida getS2() {
        return s2;
    }

    public void setS2(ServicioComida s2) {
        this.s2 = s2;
    }

    public ServicioEncomiendas getS3() {
        return s3;
    }

    public void setS3(ServicioEncomiendas s3) {
        this.s3 = s3;
    }
    
    public String getTarjetaCred() {
        return tarjetaCred;
    }

    public void setTarjetaCred(String tarjetaCred) {
        this.tarjetaCred = tarjetaCred;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    //Getters y Setters Finale
    
    public boolean confirmarServicio(String s) {
        return s.toUpperCase().equals("S");
    }
    
    //El metodo toString de la clase, no es un Override porque recibe un parametro, es una sobrecarga.
    public String toString(String a) {
        return this.cedula + "," + this.edad + "," + this.tarjetaCred;
    }
    
    //Metodo que crea nuevo usuario, sirve para crear un cliente con una cedula, si la cedula existe en el archivo no se permitira usar esa cedula.
    public boolean crearNewUsuario(Scanner sc) {

        String cancelar;
        boolean permanecer = false;

        System.out.println("Ingrese Cedula:");
        cancelar = validarCedula(sc);
        if (cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        while (userFile.buscar(cancelar, 1)) {
            System.out.println("----Cedula ya existente----\nIngrese Cedula:");
            cancelar = validarCedula(sc);
            if (cancelar.equals("cancelar")) {
                return permanecer = true;
            }
        }

        setCedula(cancelar);
        System.out.println("Ingrese Nombre");
        cancelar = validarNames(sc);
        if (cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        setNombre(cancelar);
        System.out.println("Ingrese Apellido");
        cancelar = validarNames(sc);
        if (cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        setApellidos(cancelar);
        System.out.println("Ingrese Celular");
        cancelar = validarCelular(sc);
        if (cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        while (userFile.buscar(cancelar, 6)) {
            System.out.println("----Celular ya existente----\nIngrese Celular:");
            cancelar = validarCelular(sc);
            if (cancelar.equals("cancelar")) {
                return permanecer = true;
            }
        }
        setCelular(cancelar);

        System.out.println("Ingrese Edad:");
        cancelar = validarEdad(sc);
        if (cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        setEdad(cancelar);

        System.out.println("Ingrese Tarjeta de Credito:");
        cancelar = validarCC(sc);
        if (cancelar.equals("cancelar")) {
            return permanecer = true;
        }
        setTarjetaCred(cancelar);

        System.out.println("------Establecer contraseña------\nIngrese nueva contraseña: ");
        setPassword(validPassword(sc));

        setTipoUsuario("C");
        userFile.escribir(toString());
        clientesFile.escribir(toString("a"));
        return permanecer = false;
    }
}
