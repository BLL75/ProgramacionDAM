/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema4;

/**
 *
 * @author Bernar
 */
public class OpereacionesAvanzadas {
    public static void main(String[] args){
         // Paso 1: Cadena original con espacios
        String mensajeOriginal = "   Bienvenidos al curso de Programación en Java. "
                + "Java es un lenguaje orientado a objetos.   ";
        
        // TODO Paso 2: Eliminar espacios al principio y al final
        String mensaje = mensajeOriginal.trim();
        System.out.println(mensaje);
        
        // TODO Paso 3: Mostrar si contiene la palabra "Java"
        Boolean contiene;
        
        contiene = mensaje.contains("Java");
        System.out.println(contiene);
        
        // TODO Paso 4: Reemplazar "Java" por "Kotlin"
        String mensaje2;
        mensaje2 = mensaje.replace("Java", "Kotlin");
        System.out.println(mensaje2);
        
        // TODO Paso 5: Ver si empieza por "Bienvenidos"
        if (mensaje2.startsWith("Bienvenidos")){
            System.out.println("El mensaje comienza por Bienvenidos");
        }
        
        // TODO Paso 6: Ver si termina por "objetos."
        boolean contieneFinal;
        contieneFinal = mensaje2.endsWith("objetos.");
        
        System.out.println("El final contiene objetos: " + contieneFinal);
        
        // TODO Paso 7: Posición de la primera aparición de "Kotlin"
        int posicion = mensaje2.indexOf("Kotlin");
        System.out.println("Primera aparición de 'Kotlin': " + posicion);
    }
}