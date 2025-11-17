/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema3.empresa.productos;

/**
 *
 * @author Bernar
 */

/**
 * Clase producto
 * Representa un producto con nombre y precio
 * 
 */
public class Producto {
    
   private String nombreProducto;
   private double precio;
   
   public Producto(String nombreProducto, double precio){
       this.nombreProducto = nombreProducto;
       
       if (precio <= 0){
           System.out.println("El precio no puede ser 0 ni menor que 0");
           this.precio = 0;
       }
       else{
           this.precio = precio;
       }
   }
   
   public void mostrarDatos(){
       System.out.println("Productos");
       System.out.println("Producto: " + nombreProducto + "| Precio: " 
               + precio + "€");
   }
    
}
