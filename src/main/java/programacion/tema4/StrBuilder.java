/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema4;

/**
 *
 * @author Bernar
 */
public class StrBuilder {
    public static void main(String[] args){
        
        // Creación de un StringBuilder
        StringBuilder strb = new StringBuilder("Hola Mundo");
        
        strb.delete(0, 2); // Elimina desde posiciones 0 y 1
        System.out.println(strb);
        
        strb.append("!"); // Añade al final
        System.out.println(strb);
        
        strb.insert(0, "!"); // Añade en la posición indicada
        System.out.println(strb);
        
        strb.replace(0, 1, "!Ho");
        System.out.println(strb);
        
    }
}
