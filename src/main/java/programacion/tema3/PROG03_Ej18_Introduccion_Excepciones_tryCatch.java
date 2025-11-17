package programacion.tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PROG03_Ej18_Introduccion_Excepciones_tryCatch
 *
 * Este ejercicio introduce el manejo de excepciones en Java mediante
 * bloques try/catch/finally. Además, se practican conceptos clave:
 * 
 *  - Lectura de datos desde teclado mediante BufferedReader
 *  - Conversión de texto a números con Integer.parseInt()
 *  - Captura de excepciones frecuentes (NumberFormatException, ArithmeticException)
 *  - Bloque finally (código que SIEMPRE se ejecuta)
 *  - Controlar errores sin interrumpir el programa
 *
 * También se explica detalladamente el motivo de cada import.
 *
 * Autor: Bernardo Luque
 */
public class PROG03_Ej18_Introduccion_Excepciones_tryCatch {

    /**
     * Método main: punto de entrada del programa.
     * 
     * Dentro del main se realiza:
     *   1. Creación del BufferedReader para leer datos del usuario.
     *   2. Lectura de dos números enteros desde el teclado.
     *   3. División del primer número entre el segundo.
     *   4. Manejo de las excepciones más comunes del proceso.
     *
     * @param args argumentos de línea de comandos (no se usan en este ejercicio)
     */
    public static void main(String[] args) {

        /*
         * =====================================================
         * EXPLICACIÓN DE LOS IMPORTS:
         * =====================================================
         *
         * import java.io.InputStreamReader;
         * ---------------------------------
         * Convierte los BYTES que vienen desde System.in
         * (el teclado) en CARACTERES que Java puede entender.
         *
         * import java.io.BufferedReader;
         * --------------------------------
         * Crea un "buffer" eficiente para leer texto completo
         * mediante el método readLine().
         *
         * BufferedReader es más rápido y eficiente que leer byte a byte.
         *
         * import java.io.IOException;
         * --------------------------
         * Necesario porque readLine() puede causar una excepción
         * de entrada/salida, y Java exige manejarla.
         */

        // =====================================================
        // 1. Crear el lector de texto para leer del teclado
        // =====================================================
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            // =====================================================
            // 2. Lectura del primer número
            // =====================================================
            System.out.print("Introduce el primer número: ");
            int num1 = Integer.parseInt(br.readLine()); 
            // readLine() devuelve SIEMPRE un String → hay que convertirlo

            // =====================================================
            // 3. Lectura del segundo número
            // =====================================================
            System.out.print("Introduce el segundo número: ");
            int num2 = Integer.parseInt(br.readLine());

            // =====================================================
            // 4. División
            // =====================================================
            int resultado = num1 / num2;  // Aquí puede ocurrir ArithmeticException

            System.out.println("--------------------------------");
            System.out.println("Resultado de la división: " + resultado);

        } catch (NumberFormatException e) {
            /*
             * EXCEPCIÓN NÚMERO 1:
             * NumberFormatException ocurre cuando el usuario introduce texto
             * que no puede convertirse a número entero (por ej: "hola").
             */
            System.out.println("ERROR: Debes introducir números enteros.");

        } catch (ArithmeticException e) {
            /*
             * EXCEPCIÓN NÚMERO 2:
             * División entre cero → Java lanza ArithmeticException.
             */
            System.out.println("ERROR: No se puede dividir entre cero.");

        } catch (IOException e) {
            /*
             * EXCEPCIÓN NÚMERO 3:
             * Cualquier fallo en la lectura del teclado.
             */
            System.out.println("ERROR de entrada/salida.");

        } finally {
            /*
             * BlOQUE FINALLY:
             * Siempre, SIEMPRE se ejecuta, ocurra o no ocurra error.
             */
            System.out.println("Programa terminado.");
        }
    }
}
