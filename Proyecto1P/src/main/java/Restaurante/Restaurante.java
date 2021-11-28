/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante;

/**
 *
 * @author Davca
 */
//Clase creada para instanciar restaurantes, clase padre de Menu(mejor dicho platos) y abuela de Pedido
public class Restaurante {
    //Solo tiene el nombre del restaurante y su codigo
    private String codigo;
    private String nombre;
    
    //Constructor sin parámetros para instanciar la clase servicioComida un pedido vacio
    public Restaurante() {
    }
    //Constructor con parametros ya que en servicioComida instanciaremos platos para agregarlos a una lista de platos del menu del restaurante elegido
    public Restaurante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Getters y Setters final
   
}
