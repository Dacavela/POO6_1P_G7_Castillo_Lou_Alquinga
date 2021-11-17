/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1p;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davca
 */
public class Sistema {
    List <Usuario> usuarios;

    public Sistema(){
        usuarios = new ArrayList<>();
        
        usuarios.add(new Usuario("0923547362","Luis","Mancero","lmancero","qwerty","0983637223","C"));
        usuarios.add(new Usuario("0945698598","Marco","Cárdenas","mcarden","abcde","0975342533","C"));
        usuarios.add(new Usuario("0986353323","Juan" ,"Gómez","jgome","38373","093727266","R"));
    }
    
    public Usuario buscarUsuario(String cedula){
        for(Usuario u: usuarios){
            if(u.getCedula().equals(cedula))
                return u;
        }
        return null;
    }
    
    public boolean agregarUsuario(Usuario u) {
        if (buscarUsuario(u.getCedula()) == null) {
            usuarios.add(u);
            return true;
        }
        return false;
    }


}
    
