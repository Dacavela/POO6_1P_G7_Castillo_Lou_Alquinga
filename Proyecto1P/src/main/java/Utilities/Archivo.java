/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;
import java.io.*;
import java.util.*;
/**
 *
 * @author DhuDu
 */
public class Archivo {
    private String direccion;
    private int contador = 0;
    private ArrayList<String> conductores;
    
    public Archivo(String direccion) {
        this.direccion = direccion;
    }
    
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

    public ArrayList<String> getConductores() {
        return conductores;
    }

    public void setConductores(ArrayList<String> conductores) {
        this.conductores = conductores;
    }

  
    
    //metodos para manejar datos provenientes de archivos txt
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
        }else return "noexiste,2,3,4,5,6,C";
    }
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
                System.out.println("Primer bucle"+(i++));
                
                
                
                cond = accederLinea(buscar(linea_0[0], 4)).split(",");
                System.out.println(linea_0[4]+"+"+cond[3]);
                if((linea_0[4].equals(tipoVeh))&&(cond[2].equals(disponibilidad))){
                    System.out.println("Segundo bucle"+(i++));
                    System.out.println(linea_0[4]+"+"+cond[3]+"+"+cond[1]);
                    linea = linea_0;
                    verify = false;
                    
                }else verify = true;
            }
            s.close();
        }catch (FileNotFoundException e){e.printStackTrace();}
        return linea;
    }

    public String[] buscarDriver(String disponibilidad, String tipoVehiculo){
        boolean acceso = true;
        String [] busquedaAuto = null;
        String[] conductor = null;
        while(acceso){
            busquedaAuto = buscarVehiculo("vehículos.txt",disponibilidad, tipoVehiculo);
            
            conductor = accederLinea(buscar(busquedaAuto[0], 4)).split(",");
            System.out.println(conductor[2]);
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
    
    public void reemplazarLineaConductores(String cedula, boolean buscar) {
        conductores = new ArrayList<>();
        String linea;
        if (buscar == true) {
            File f1 = new File("conductores.txt");
            Scanner s1;
            try {
                s1 = new Scanner(f1);

                while (s1.hasNextLine()) {
                    linea = s1.nextLine();
                    String[] lineaSeparada = linea.split(",");
                    if (lineaSeparada[0].equals(cedula)) {
                        lineaSeparada[2] = "O";
                        String lineaUnida = lineaSeparada[0] + "," + lineaSeparada[1] + "," + lineaSeparada[2] + "," + lineaSeparada[3];
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
                for (String linea1: conductores.subList(1, conductores.size())){
                    pw.print("\n"+ linea1);
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
    }
    
    
    
}
