/*
 * Autor: Bernardo Luque
 * 
 * Ejercicio:
 * Escribe un programa que solicite por teclado un nombre cuya longitud debe
 * ser como mínimo de una letra y como máximo de diez.
 * Además, el nombre debe cumplir las siguientes reglas:
 * - La primera letra debe ser mayúscula (A-Z).
 * - El resto de letras deben ser minúsculas (a-z).
 * - No se permiten números, símbolos, espacios ni ningún otro carácter.
 * 
 * Si el nombre introducido no cumple cualquiera de estos criterios, debe mostrarse
 * un mensaje de error y volver a solicitarse hasta que se cumpla todo.
 */

package programacion.tema4;

import java.util.Scanner;

/**
 * Clase que contiene un programa para validar un nombre según reglas específicas
 * de longitud y formato de letras.
 * 
 * @author Bernardo Luque
 */
public class OperacionesBasicas {

    /**
     * Método principal que ejecuta el programa de validación del nombre.
     * 
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        boolean valido;

        do {
            System.out.println("Introduce un nombre con mínimo 1 letra y máximo 10:");
            nombre = sc.nextLine().trim(); // Eliminamos espacios al principio y final

            valido = true; // Suponemos que el nombre es válido hasta demostrar lo contrario

            // 1. Comprobamos la longitud
            if (nombre.length() < 1 || nombre.length() > 10) {
                System.out.println("Error: el nombre debe tener entre 1 y 10 caracteres.");
                valido = false;
            } else {
                // 2. Comprobamos que la primera letra sea mayúscula
                if (nombre.charAt(0) < 'A' || nombre.charAt(0) > 'Z') {
                    System.out.println("Error: la primera letra debe ser mayúscula.");
                    valido = false;
                } else {
                    // 3. Comprobamos que el resto de caracteres sean letras minúsculas
                    for (int i = 1; i < nombre.length(); i++) {
                        char c = nombre.charAt(i);
                        if (c < 'a' || c > 'z') {
                            System.out.println("Error: el resto de caracteres deben ser letras minúsculas (a-z).");
                            valido = false;
                            break; // Salimos del bucle en cuanto encontramos un error
                        }
                    }
                }
            }

            // Si no es válido, mostramos mensaje para intentar de nuevo
            if (!valido) {
                System.out.println("Inténtalo de nuevo.\n");
            }

        } while (!valido); // Repetimos mientras no sea válido

        // Cuando llega aquí, el nombre cumple todas las condiciones
        System.out.println("Nombre aceptado: " + nombre);

        sc.close();
    }
}