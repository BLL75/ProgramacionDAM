/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema2;

/**
 * Ejemplo didáctico sobre el uso de etiquetas y saltos incondicionales en Java.
 * 
 * Se muestra cómo pueden utilizarse etiquetas con la sentencia break dentro
 * de bucles anidados, aunque su uso se considera una mala práctica de programación.
 * 
 * @author Bernar
 */
public class Etiquetas {

    public static void main(String[] args) {

        System.out.println("Versión usando etiquetas y break etiquetado:\n");

        // Bucle exterior: controla las filas (de 1 a 5)
        fila: // ← etiqueta para el bucle exterior
        for (int i = 1; i <= 5; i++) {

            // Bucle interior: imprime los asteriscos de cada fila
            for (int j = 1; j <= 5; j++) {

                // Condición de salida usando break etiquetado
                // Cuando j supera el valor de i, salimos del bucle actual
                if (j > i) {
                    break fila; // ⚠️ Este salto rompe la lógica y sale del bucle etiquetado "fila"
                }

                System.out.print("*");
            }

            System.out.println(); // Salto de línea al terminar cada fila
        }

        /*
         * 🔴 IMPORTANTE:
         * 
         * Aunque este ejemplo funciona, es un MAL USO del break etiquetado,
         * porque altera el flujo natural del programa y hace difícil entender 
         * a simple vista qué está ocurriendo.
         * 
         * En programas más grandes, este tipo de "saltos" complica el mantenimiento 
         * y puede generar errores difíciles de detectar.
         * 
         * La mejor práctica es estructurar la lógica correctamente, de modo que 
         * no sea necesario usar saltos incondicionales.
         */

        System.out.println("\nVersión correcta sin usar etiquetas:\n");

        // ✅ Versión recomendada sin etiquetas ni saltos incondicionales
        for (int i = 1; i <= 5; i++) {
            String linea = ""; // Se acumulan los asteriscos en una cadena
            for (int j = 1; j <= i; j++) {
                linea += "*";
            }
            System.out.println(linea);
        }

        /*
         * ✅ En esta versión:
         * 
         * - No usamos etiquetas ni break.
         * - La lógica es clara: el bucle exterior controla las filas y el interior
         *   imprime la cantidad de asteriscos correspondiente a cada fila.
         * - Es fácil de leer, mantener y ampliar.
         * 
         * 🧠 Conclusión:
         * Los saltos etiquetados solo deberían considerarse en casos extremadamente
         * raros de bucles muy anidados (3 o más niveles), donde reorganizar el código
         * no sea viable. En el 99% de los casos, una buena estructura de control
         * hace innecesario el uso de etiquetas.
         */
    }
}

