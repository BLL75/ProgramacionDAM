package programacion.tema4;

import java.util.Scanner;

/**
 * Clase que solicita al usuario un nombre y valida que cumpla con los siguientes requisitos:
 * <ul>
 *   <li>Debe tener entre 1 y 10 caracteres.</li>
 *   <li>Debe comenzar por una letra mayúscula (entre 'A' y 'Z').</li>
 *   <li>El resto de caracteres deben ser letras minúsculas (entre 'a' y 'z').</li>
 * </ul>
 * 
 * <p>Si el nombre no cumple las condiciones, se muestra un mensaje de error y se vuelve a pedir
 * al usuario. El proceso se repite hasta que el nombre sea válido.</p>
 * 
 * <p>Este ejercicio permite practicar los métodos de la clase {@code String} como:</p>
 * <ul>
 *   <li>{@code length()}</li>
 *   <li>{@code charAt(int)}</li>
 * </ul>
 * Así como estructuras de control: bucles, condicionales y validaciones carácter a carácter.
 * 
 * @author Bernar
 */
public class ValidacionNombre {

    /**
     * Método principal que gestiona la entrada del usuario y valida el nombre
     * hasta que cumpla con todas las condiciones requeridas.
     *
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nombre;

        while (true) {
            System.out.print("Introduce un nombre de 1 a 10 caracteres: ");
            nombre = sc.nextLine();

            // Validación de longitud
            if (nombre.length() >= 1 && nombre.length() <= 10) {
                char primeraLetra = nombre.charAt(0);

                // Validación de la primera letra (debe ser mayúscula)
                if (primeraLetra >= 'A' && primeraLetra <= 'Z') {
                    boolean restoValido = true;

                    // Validación del resto de caracteres (minúsculas)
                    for (int i = 1; i < nombre.length(); i++) {
                        char c = nombre.charAt(i);
                        if (c < 'a' || c > 'z') {
                            restoValido = false;
                            System.out.println("❌ Error: El resto de letras deben ser minúsculas.");
                            break;
                        }
                    }

                    // Si todo es válido, mostrar y salir
                    if (restoValido) {
                        System.out.println("✅ El nombre introducido es: " + nombre);
                        break;
                    }
                } else {
                    System.out.println("❌ Error: El nombre debe comenzar por una letra mayúscula (A-Z).");
                }
            } else {
                System.out.println("❌ Error: El nombre debe tener entre 1 y 10 caracteres.");
            }

            System.out.println("Por favor, vuelve a intentarlo.\n");
        }

        sc.close();
    }
}
