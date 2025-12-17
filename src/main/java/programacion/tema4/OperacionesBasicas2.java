/*
 * Autor: Bernardo Luque
 * 
 * Ejercicio:
 * Escribe un programa que solicite por teclado un nombre compuesto por dos palabras
 * (nombre y apellido) separadas por un único espacio.
 * 
 * Requisitos:
 * - Debe contener exactamente un único espacio.
 * - El espacio no puede ser el primer ni el último carácter.
 * - Todos los caracteres (excepto el espacio) deben ser letras minúsculas (a-z).
 * - No se permiten mayúsculas, números, símbolos ni espacios extras.
 * 
 * Si no cumple las reglas, mostrar mensaje de error y volver a pedir.
 * Una vez válido, mostrar por pantalla:
 * - El nombre completo aceptado.
 * - El primer nombre (primera palabra).
 * - El apellido (segunda palabra).
 */

package programacion.tema4;

import java.util.Scanner;

/**
 * Clase que valida un nombre y apellido en minúsculas separados por un único espacio
 * y, una vez válido, muestra por separado el nombre y el apellido.
 * 
 * @author Bernardo Luque
 */
public class OperacionesBasicas2 {

    /**
     * Método principal que ejecuta la validación y separación del nombre compuesto.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreCompleto;
        boolean valido;

        do {
            System.out.println("Introduce tu nombre y apellido (solo letras minúsculas y un único espacio):");
            nombreCompleto = sc.nextLine().trim(); // Elimina espacios al inicio y final
            valido = true;
            int contadorEspacios = 0;

            // Validamos carácter por carácter
            for (int i = 0; i < nombreCompleto.length(); i++) {
                char c = nombreCompleto.charAt(i);
                if (c == ' ') {
                    contadorEspacios++;
                } else if (c < 'a' || c > 'z') { // Si no es letra minúscula
                    System.out.println("Error: solo se permiten letras minúsculas (a-z).");
                    valido = false;
                    break; // Salimos temprano para no seguir comprobando
                }
            }

            // Comprobamos número exacto de espacios
            if (contadorEspacios != 1) {
                System.out.println("Error: debe haber exactamente un espacio entre nombre y apellido.");
                valido = false;
            }

            // Aunque usamos trim(), reforzamos por si acaso (no debería darse)
            if (nombreCompleto.startsWith(" ") || nombreCompleto.endsWith(" ")) {
                System.out.println("Error: no puede haber espacios al principio ni al final.");
                valido = false;
            }

            // Mensaje de reintento si hay errores
            if (!valido) {
                System.out.println("Inténtalo de nuevo.\n");
            }

        } while (!valido);

        // Si llega aquí, el nombre es válido → extraemos nombre y apellido
        int posicionEspacio = nombreCompleto.indexOf(' '); // Posición del único espacio

        String nombre = nombreCompleto.substring(0, posicionEspacio); // Desde inicio hasta antes del espacio
        String apellido = nombreCompleto.substring(posicionEspacio + 1); // Desde después del espacio hasta el final

        // Mostramos resultados
        System.out.println("Nombre válido: " + nombreCompleto);
        System.out.println("Primer nombre: " + nombre);
        System.out.println("Apellido: " + apellido);

        sc.close();
    }
}