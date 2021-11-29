/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
/**
 *
 * @author DhuDu
 */
//Clase creada para ingresar a archivos, leerlos, escribir en ellos y buscar dentro de
public class Archivo {
    //Tenemos una direccion para usarala en los metodos
    //Un contador para las clases buscar y accederLinea, inicia en 0 y sirve para encontrar lineas en un fichero y retornarlas
    //El arrayList es para 
    private String direccion;
    private int contador = 0;
    //private ArrayList<String> conductores;
    
    public Archivo(String direccion) {
        this.direccion = direccion;
    }
    //Getters y Setters
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

//    public ArrayList<String> getConductores() {
//        return conductores;
//    }
//
//    public void setConductores(ArrayList<String> conductores) {
//        this.conductores = conductores;
//    }
    //Getters y Setters Finale
  
    
    //metodo que busca si existe un dato dentro de la linea de un archivo y devuelve true o false si es que esta en una linea, suma el contador hasta el numero de la linea
    public boolean buscar(String categoria, int elementos){ 
        //boolean bucle;
        this.contador = 0;
        boolean verify = false;
        String tmpVer;
        File f = new File(direccion);
        Scanner s;
        
        try{
            
            s = new Scanner(f);
            
            while (s.hasNextLine()) {
                String linea_0 = s.nextLine();
                
                Scanner sl = new Scanner(linea_0);
                sl.useDelimiter(",");
                
                for(int i=0;i<elementos-1;i++){
                    sl.next();}
                tmpVer= sl.next();
                this.contador++;
                if(tmpVer.equals(categoria)){
                    verify = true;
                    return verify;
                     
                }else{verify = false;}
            }
            s.close();
        }catch (FileNotFoundException e){e.printStackTrace();}
        return verify;
    } //
    
    
    //Metodo que accede a una linea, usa el contador sacado en buscar para acceder a la linea y devuelve la linea.
    public String accederLinea(boolean buscar){
        String linea = null;
        if(buscar==true){
            File f1 = new File(direccion);
            Scanner s1;
            try{
                s1 = new Scanner(f1);
                int p=0;
                while ( p<this.contador) {
                    
                    linea = s1.nextLine();   
                    p++;
                }
                s1.close();
            }catch (FileNotFoundException e){}
            return linea;
        }else return "noexiste,noexiste,noexiste,noexiste,noexiste,noexiste,C";
    }
    
    
    //Metodo que escribe en la ultima linea de un fichero.
    public void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(direccion,true);
            pw = new PrintWriter(fichero);

            pw.print("\n"+cadena);

        } catch (IOException e) {
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (IOException e2) {
           }
        }
        
    }
    
    
    //Metodo que busca un vehiculo en un archivo, revisa si el conductor esta disponible u ocupado y el tipo de vehiculo
    //devuelve una lista de strings con los datos del vehiculo en cuestion.
    public String[] buscarVehiculo(String filedireccion,String disponibilidad, String tipoVeh){
        
        boolean verify = true;
        String[] linea = {"1","2","3","hola"};
        String[] cond = null;
        File f = new File(filedireccion);
        Scanner s;
        int i = 0;
        try{
            
            s = new Scanner(f);
            
            while (s.hasNextLine()&& verify) {
                String[] linea_0 = s.nextLine().split(",");                
                cond = accederLinea(buscar(linea_0[0], 4)).split(",");
                
                if((linea_0[4].equals(tipoVeh))&&(cond[2].equals(disponibilidad))){
                    linea = linea_0;
                    verify = false;
                    
                }else verify = true;
            }
            s.close();
        }catch (FileNotFoundException e){e.printStackTrace();}
        return linea;
    }

    //metodo que busca un conductor ocupado y por su tipo de vehiculo, este metodo va de la mano/asociado al metodo anterior
    //Retorna una lista de strings con los datos del conductor, sirve para instanciar un conductor
    public String[] buscarDriver(String disponibilidad, String tipoVehiculo){
        boolean acceso = true;
        String [] busquedaAuto = null;
        String[] conductor = null;
        while(acceso){
            busquedaAuto = buscarVehiculo("vehículos.txt",disponibilidad, tipoVehiculo);
            
            conductor = accederLinea(buscar(busquedaAuto[0], 4)).split(",");
            
            if(conductor[2].equals(disponibilidad) ){
                acceso = false;
                break;
            }if(conductor[0].equals("noexiste")){acceso = false;}
        }
//        boolean existDrive = buscar(disponibilidad,3);
//        String[] lin1 = accederLinea(existDrive).split(",");
//        return lin1;
        return conductor;
    }
    
    //Metodo que sirve para reemplazar a un conductor de disponible a ocupado, como solo nos pidieron ese cambio de estado no se ha hecho de ocupado a disponible.
    public void reemplazarLineaConductores(String cedula, int idUnico) {
        
        ArrayList<String> conductores = new ArrayList<>();
        String linea;
        File f1 = new File("conductores.txt");
        Scanner s1;
        try {
            s1 = new Scanner(f1);

            while (s1.hasNextLine()) {
                linea = s1.nextLine();
                String[] lineaSeparada = linea.split(",");
                if (lineaSeparada[0].equals(cedula)) {
                    lineaSeparada[2] = "O";
                    lineaSeparada[4]= ""+idUnico;
                    String lineaUnida = lineaSeparada[0] + "," + lineaSeparada[1] + "," + lineaSeparada[2] + "," + lineaSeparada[3]+","+lineaSeparada[4];
                    conductores.add(lineaUnida);
                } else {
                    conductores.add(linea);
                }
            }
            s1.close();
        } catch (FileNotFoundException e) {
        }

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("conductores.txt");
            pw = new PrintWriter(fichero);
            pw.print(conductores.subList(0, 1).toString().replace("[", "").replace("]", ""));
            for (String linea1 : conductores.subList(1, conductores.size())) {
                pw.print("\n" + linea1);
            }
        } catch (IOException e) {
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }

    }
    

    //metodo copiado de sistema linea 41
    //Este metodo recoge todo un fichero, lo separa por lineas y devuelve un ArrayList de strings de cada linea del fichero.
    public ArrayList<String> leerFichero(String nombrearchivo) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }
    
    
    /*Metodo muy similar al anterior, pero que en vez de devolver todas las lineas del fichero devuelve las lineas del fichero de menus que
    coincidan con el codigo del restaurante ingresado como parametro*/
    public ArrayList<String> buscarMenu(String codRes) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("menus.txt");
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                if(linea.split(",")[0].equals(codRes)){
                    lineas.add(linea);
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }
}
