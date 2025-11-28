package programacion.tema4;

import java.util.Scanner;

/**
 * Clase que valida si una cadena introducida por el usuario contiene 
 * únicamente letras del alfabeto inglés, sin espacios, números ni caracteres especiales.
 * 
 * <p>Este programa utiliza la expresión regular {@code [a-zA-Z]+} con el método
 * {@code matches(String regex)} para comprobar si la cadena está formada solo por letras.</p>
 * 
 * <p><strong>Reglas de validación:</strong></p>
 * <ul>
 *   <li>Solo se permiten letras mayúsculas o minúsculas (de la A a la Z, sin 'ñ').</li>
 *   <li>No se permiten espacios, números ni signos de puntuación.</li>
 * </ul>
 * 
 * <p><strong>Ejemplo de uso:</strong></p>
 * 
 * <pre>
 * Introduce una palabra sin espacios: Juan
 * Cadena válida
 * 
 * Introduce una palabra sin espacios: Juan12
 * Cadena no válida
 * </pre>
 * 
 * <p>Este ejercicio forma parte del Tema 4 de Programación: Cadenas de caracteres y validación de entrada.</p>
 * 
 * @author Bernar
 */
public class ValidacionCadena {

    /**
     * Método principal del programa.
     * Solicita al usuario una palabra y valida si contiene solo letras.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra sin espacios: ");

        String entrada = sc.nextLine();

        // Validación usando expresión regular: solo letras (mayúsculas o minúsculas)
        if (entrada.matches("[a-zA-Z]+")) {
            System.out.println("Cadena válida");
        } else {
            System.out.println("Cadena no válida");
        }

        sc.close();
    }
}
