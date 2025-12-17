/*
 * Clase de ejemplo que muestra operaciones básicas con cadenas de texto (Strings)
 * en Java: comparación, conversión a mayúsculas/minúsculas y uso de métodos
 * fundamentales de la clase String.
 */

package programacion.tema4;

import java.util.Locale;

/**
 * @author Bernar
 * Clase OperacionesBasicas3 - Muestra ejemplos prácticos del uso de métodos
 * comunes de la clase String en Java.
 */
public class OperacionesBasicas3 {
    public static void main(String[] args) {
        
        // Declaración e inicialización de dos cadenas con diferencia en la primera letra (mayúscula vs minúscula)
        String cadena1 = "hola";
        String cadena2 = "Hola";
        
        int comparacion;
        boolean iguales;

        // --- compareTo ---
        /*
         * compareTo(String otraCadena) compara dos cadenas lexicográficamente.
         * Devuelve:
         *   0 si ambas cadenas son iguales
         *   < 0 si cadena1 va antes que cadena2 en orden alfabético
         *   > 0 si cadena1 va después que cadena2
         * Este método **distingue mayúsculas de minúsculas**.
         */
        comparacion = cadena1.compareTo(cadena2);
        System.out.println("Resultado de compareTo(): " + comparacion);

        // --- equals ---
        /*
         * equals(Object otroObjeto) compara si dos cadenas tienen el mismo contenido exacto.
         * Es sensible a mayúsculas/minúsculas.
         * NUNCA se debe usar == para comparar cadenas en Java, ya que == compara referencias, no contenido.
         */
        iguales = cadena1.equals(cadena2);
        System.out.println("Resultado de equals(): " + iguales);

        // --- compareToIgnoreCase ---
        /*
         * compareToIgnoreCase(String otraCadena) compara dos cadenas ignorando diferencias
         * entre mayúsculas y minúsculas.
         */
        comparacion = cadena1.compareToIgnoreCase(cadena2);
        System.out.println("Resultado de compareToIgnoreCase(): " + comparacion);

        // --- equalsIgnoreCase ---
        /*
         * equalsIgnoreCase(String otraCadena) comprueba si dos cadenas son iguales,
         * ignorando mayúsculas y minúsculas.
         */
        iguales = cadena1.equalsIgnoreCase(cadena2);
        System.out.println("Resultado de equalsIgnoreCase(): " + iguales);

        // --- toLowerCase ---
        /*
         * toLowerCase() convierte todos los caracteres de una cadena a minúsculas.
         * Puede recibir un Locale para controlar el idioma (útil para algunos acentos o caracteres especiales).
         */
        String mayus = "HOLA";
        String minus = cadena1.toLowerCase(); // cadena1 ya es "hola", pero se muestra como ejemplo
        System.out.println("Resultado de cadena1.toLowerCase(): " + minus);

        // --- toUpperCase ---
        /*
         * toUpperCase() convierte todos los caracteres de una cadena a mayúsculas.
         */
        minus = "hola";
        mayus = cadena1.toUpperCase();
        System.out.println("Resultado de cadena1.toUpperCase(): " + mayus);
    }
}
