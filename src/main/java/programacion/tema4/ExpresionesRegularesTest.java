package programacion.tema4;

import java.util.Scanner;

/**
 * Clase de utilidad para validar distintos tipos de cadenas mediante expresiones regulares.
 * 
 * El programa permite al usuario seleccionar el tipo de dato que desea comprobar
 * (DNI, NIE, matrícula, fechas, horas, número binario, nombre, etc.), introducir
 * una cadena y verificar si esta cumple con el formato correcto según la expresión
 * regular correspondiente.
 * 
 * Esta clase sirve como recopilatorio práctico de los principales conceptos de 
 * expresiones regulares tratados en el Tema 4 del módulo de Programación, incluyendo:
 * - Cuantificadores
 * - Agrupaciones
 * - Alternativas
 * - Metacaracteres y escapado
 * 
 * El objetivo es reforzar el aprendizaje de expresiones regulares y ofrecer
 * una herramienta interactiva para practicar su uso en Java.
 * 
 * @author Bernar
 */
public class ExpresionesRegularesTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        String cadena, tipo;
        boolean esValido;

        do {
            // Menú interactivo
            System.out.println("\n---- Elige qué tipo de cadena quieres comprobar ----");
            System.out.println("1. Comprobar DNI");
            System.out.println("2. Comprobar NIE");
            System.out.println("3. Comprobar matrícula");
            System.out.println("4. Comprobar número binario");
            System.out.println("5. Comprobar número entre 100 y 99999");
            System.out.println("6. Nombre con mayúscula + minúsculas");
            System.out.println("7. Palabra de 3 vocales (1ª en mayúscula)");
            System.out.println("8. Hora hh:mm");
            System.out.println("9. Fecha dd/mm/aaaa (2000–2099)");
            System.out.println("10. Hora hh:mm:ss");
            System.out.println("11. Número romano (1–3999)");
            System.out.println("12. Comentario en Java /*...*/");
            System.out.println("13. Correo electrónico personalizado");
            System.out.println("14. Salir");
            System.out.print("Introduce la opción que deseas validar: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpia salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el DNI: ");
                    cadena = sc.nextLine().trim().toUpperCase();
                    esValido = cadena.matches("[0-9]{8}[A-HJ-NP-TV-Z]");
                    tipo = "DNI";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 2:
                    System.out.print("Introduce el NIE: ");
                    cadena = sc.nextLine().trim().toUpperCase();
                    esValido = cadena.matches("[XYZ]\\d{7}[A-HJ-NP-TV-Z]");
                    tipo = "NIE";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 3:
                    System.out.print("Introduce la matrícula: ");
                    cadena = sc.nextLine().trim().toUpperCase();
                    esValido = cadena.matches("\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}");
                    tipo = "Matrícula";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 4:
                    System.out.print("Introduce el número binario: ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("[01]+");
                    tipo = "Número binario";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 5:
                    System.out.print("Introduce el número entre 100 y 99999: ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("[1-9]\\d{2,4}");
                    tipo = "Número (100 a 99999)";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 6:
                    System.out.print("Introduce el nombre propio: ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("([A-Z][a-z]+) ([A-Z][a-z]+) ([A-Z][a-z]+)");
                    tipo = "Nombre completo";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 7:
                    System.out.print("Introduce la palabra de 3 vocales: ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("[AEIOU][aeiou]{2}");
                    tipo = "Palabra de 3 vocales";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 8:
                    System.out.print("Introduce la hora (hh:mm): ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("([01][0-9]|2[0-3]):[0-5][0-9]");
                    tipo = "Hora (hh:mm)";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 9:
                    System.out.print("Introduce la fecha (dd/mm/aaaa): ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(20\\d{2})");
                    tipo = "Fecha (dd/mm/aaaa)";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 10:
                    System.out.print("Introduce la hora con segundos (hh:mm:ss): ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
                    tipo = "Hora con segundos";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 11:
                    System.out.print("Introduce el número romano (1–3999): ");
                    cadena = sc.nextLine().trim().toUpperCase();
                    esValido = cadena.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
                    tipo = "Número romano";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 12:
                    System.out.print("Introduce el comentario Java (/*...*/): ");
                    cadena = sc.nextLine();
                    esValido = cadena.matches("/\\*[\\s\\S]*?\\*/");
                    tipo = "Comentario Java";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 13:
                    System.out.print("Introduce el correo electrónico: ");
                    cadena = sc.nextLine().trim();
                    esValido = cadena.matches("[A-Za-z][\\w.-]{2,14}@[A-Za-z][A-Za-z0-9-]*(\\.[A-Za-z]{2,6})");
                    tipo = "Correo electrónico";
                    mostrarValidacion(tipo, cadena, esValido);
                    break;

                case 14:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("❌ La opción no es correcta.");
            }

        } while (opcion != 14);

        sc.close();
    }

    /**
     * Muestra si una cadena es válida según su tipo.
     *
     * @param tipo Tipo de cadena (ej. "DNI", "Email", etc.)
     * @param cadena Texto ingresado por el usuario
     * @param esValido true si coincide con la expresión regular; false en caso contrario
     */
    public static void mostrarValidacion(String tipo, String cadena, boolean esValido) {
        if (esValido) {
            System.out.println("✅ " + tipo + " \"" + cadena + "\" es válido.");
        } else {
            System.out.println("❌ " + tipo + " \"" + cadena + "\" no es válido.");
        }
    }
}
