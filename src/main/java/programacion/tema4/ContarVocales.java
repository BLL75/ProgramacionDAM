package programacion.tema4;

/**
 * <h1>Ejercicio 2: Contar Vocales en un Array de Caracteres</h1>
 * 
 * <p><b>Descripción:</b></p>
 * <p>
 * Dado un array de caracteres, el programa cuenta cuántas vocales contiene.
 * Se consideran vocales tanto en mayúsculas como en minúsculas.
 * </p>
 * 
 * <p><b>Ejemplo:</b></p>
 * <pre>
 * Entrada: {'H', 'o', 'l', 'a', ' ', 'M', 'u', 'n', 'd', 'o'}
 * Salida:  4 vocales
 * </pre>
 * 
 * <p><b>Conceptos practicados:</b></p>
 * <ul>
 *   <li>Recorrido de arrays</li>
 *   <li>Uso de métodos auxiliares</li>
 *   <li>Comparación de caracteres</li>
 *   <li>Normalización de mayúsculas y minúsculas</li>
 * </ul>
 * 
 * @author Bernar
 * @version 1.0
 * @since 2024
 */
public class ContarVocales {

    /**
     * Método principal del programa.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // ============================================================
        // DATOS DE ENTRADA
        // ============================================================
        char[] letras = { 'H', 'o', 'l', 'a', ' ', 'M', 'u', 'n', 'd', 'o' };

        // ============================================================
        // MOSTRAR EL TEXTO ORIGINAL
        // ============================================================
        System.out.print("Texto original: ");
        for (char c : letras) {
            System.out.print(c);
        }
        System.out.println();

        // ============================================================
        // CONTAR VOCALES
        // ============================================================
        int totalVocales = contarVocales(letras);

        // ============================================================
        // MOSTRAR RESULTADO
        // ============================================================
        System.out.println("Número total de vocales: " + totalVocales);
    }

    /**
     * Cuenta el número de vocales presentes en un array de caracteres.
     * 
     * @param caracteres array de caracteres a analizar
     * @return número total de vocales encontradas
     */
    public static int contarVocales(char[] caracteres) {
        int contador = 0;

        for (char c : caracteres) {
            if (esVocal(c)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Comprueba si un carácter es una vocal.
     * No distingue entre mayúsculas y minúsculas.
     * 
     * @param c carácter a comprobar
     * @return true si es vocal, false en caso contrario
     */
    public static boolean esVocal(char c) {
        // Convertimos el carácter a minúscula para simplificar la comparación
        c = Character.toLowerCase(c);

        // Comprobamos si está dentro del conjunto de vocales
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
