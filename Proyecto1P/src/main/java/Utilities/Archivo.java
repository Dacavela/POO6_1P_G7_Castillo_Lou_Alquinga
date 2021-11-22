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
    String linea = null;
    public Archivo(String direccion) {
        this.direccion = direccion;
        
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
    
    
    public boolean buscar(String categoria, int elementos){ 
        //boolean bucle;
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
                    
                    sl.next();
                    
               
                }
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
    } 
    
    public String accederLinea(){
        //if(buscar()==true){
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
        //}
            
        return linea;
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
    
}