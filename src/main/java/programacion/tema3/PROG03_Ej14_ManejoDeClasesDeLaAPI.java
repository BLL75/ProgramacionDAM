package programacion.tema3;

/**
 * PROG03_Ej14_ManejoDeClasesDeLaAPI
 *
 * Este ejercicio muestra cómo utilizar algunas clases muy importantes
 * de la API estándar de Java:
 *
 *   - StringBuilder  → construcción eficiente de cadenas
 *   - Integer        → wrapper de tipos primitivos
 *   - Character      → utilidades para caracteres
 *   - String         → manipulación de texto
 *
 * Aprender estas clases es fundamental para manejar Java a nivel real.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej14_ManejoDeClasesDeLaAPI {

    public static void main(String[] args) {

        // =============================================================
        // 1. STRINGBUILDER — Construcción eficiente de cadenas
        // =============================================================
        System.out.println("=== STRINGBUILDER ===");

        StringBuilder sb = new StringBuilder();

        sb.append("Hola");
        sb.append(" ");
        sb.append("esto es una prueba.");

        System.out.println("Texto inicial: " + sb.toString());

        // Insertamos texto al principio
        sb.insert(0, "INICIO: ");
        System.out.println("Tras insert(): " + sb.toString());

        // Eliminamos "prueba."
        sb.delete(25, sb.length());
        System.out.println("Tras delete(): " + sb.toString());

        System.out.println();


        // =============================================================
        // 2. INTEGER — Clase wrapper
        // =============================================================
        System.out.println("=== INTEGER ===");

        String numeroTexto = "123";
        int valor = Integer.parseInt(numeroTexto);  // String → int

        System.out.println("String '123' convertido a int: " + valor);

        String convertido = Integer.toString(valor); // int → String
        System.out.println("int convertido a String: " + convertido);

        System.out.println("Valor máximo de Integer: " + Integer.MAX_VALUE);
        System.out.println("Valor mínimo de Integer: " + Integer.MIN_VALUE);

        System.out.println();


        // =============================================================
        // 3. CHARACTER — Métodos útiles
        // =============================================================
        System.out.println("=== CHARACTER ===");

        char c = 'A';
        char d = '7';

        System.out.println("¿'A' es letra?: " + Character.isLetter(c));
        System.out.println("¿'7' es letra?: " + Character.isLetter(d));

        System.out.println("¿'a' es mayúscula?: " + Character.isUpperCase('a'));
        System.out.println("'a' en mayúscula: " + Character.toUpperCase('a'));

        System.out.println();


        // =============================================================
        // 4. STRING — Métodos importantes
        // =============================================================
        System.out.println("=== STRING ===");

        String frase = "   Hola Mundo desde Java   ";

        System.out.println("Original con espacios: '" + frase + "'");
        System.out.println("trim(): '" + frase.trim() + "'");
        System.out.println("toUpperCase(): " + frase.toUpperCase());
        System.out.println("substring(3, 8): '" + frase.substring(3, 8) + "'");
        System.out.println("contains('Mundo'): " + frase.contains("Mundo"));
    }
}
