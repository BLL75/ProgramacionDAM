package programacion.tema4;

import java.util.Scanner;

/**
 * Clase para validar distintos tipos de cadenas usando expresiones regulares.
 * Ofrece un menú con validaciones de DNI, correo electrónico, número binario y matrícula.
 * 
 * @author Bernardo Luque
 */
public class ValidadorRegex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú de opciones
            System.out.println("\nVALIDADOR REGEX");
            System.out.println("---------------------------");
            System.out.println("1. Validar DNI");
            System.out.println("2. Validar correo");
            System.out.println("3. Validar número binario");
            System.out.println("4. Validar matrícula española");
            System.out.println("5. Salir");
            System.out.print("Elige una opción (1-5): ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer tras leer número

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Introduce el valor a validar: ");
                String entrada = sc.nextLine().trim(); // Leer y limpiar entrada

                boolean esValido = false;

                // Selección de expresión regular según el tipo
                switch (opcion) {
                    case 1:
                        // Validación DNI: 8 dígitos + 1 letra mayúscula
                        esValido = entrada.matches("\\d{8}[A-Z]");
                        mostrarValidacion("DNI", entrada, esValido);
                        break;
                    case 2:
                        // Validación Email: patrón básico de usuario@dominio.tld
                        esValido = entrada.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
                        mostrarValidacion("Email", entrada, esValido);
                        break;
                    case 3:
                        // Validación binario: solo 0 y 1
                        esValido = entrada.matches("[01]+");
                        mostrarValidacion("Número binario", entrada, esValido);
                        break;
                    case 4:
                        // Validación matrícula: 4 dígitos + 3 letras
                        esValido = entrada.matches("\\d{4}[A-Za-z]{3}");
                        mostrarValidacion("Matrícula", entrada, esValido);
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("Opción incorrecta. Intenta de nuevo.");
            }

        } while (opcion != 5);

        System.out.println("Programa finalizado.");
    }

    /**
     * Método auxiliar para mostrar si la validación fue correcta o no.
     * 
     * @param tipo Tipo de dato que se valida (DNI, email, etc.)
     * @param entrada Valor introducido por el usuario
     * @param esValido true si pasa la validación, false si no
     */
    public static void mostrarValidacion(String tipo, String entrada, boolean esValido) {
        if (esValido) {
            System.out.println(tipo + " \"" + entrada + "\" es válido.");
        } else {
            System.out.println(tipo + " \"" + entrada + "\" no es válido.");
        }
    }
}
