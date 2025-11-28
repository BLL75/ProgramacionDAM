package programacion.tema4;

/**
 * Clase de ejemplo para comparar dos cadenas de texto usando distintos métodos
 * proporcionados por la clase {@code String} en Java.
 *
 * <p>Se comparan dos cadenas con distintas combinaciones de mayúsculas y minúsculas
 * utilizando los siguientes métodos:</p>
 * <ul>
 *   <li>{@code equals(String)}: compara el contenido de las cadenas respetando mayúsculas.</li>
 *   <li>{@code equalsIgnoreCase(String)}: compara ignorando diferencias entre mayúsculas/minúsculas.</li>
 *   <li>{@code compareTo(String)}: compara lexicográficamente, sensible a mayúsculas.</li>
 *   <li>{@code compareToIgnoreCase(String)}: compara lexicográficamente ignorando mayúsculas/minúsculas.</li>
 * </ul>
 *
 * <p>Este ejercicio permite entender cómo se comparan cadenas en Java y cuándo usar cada método.</p>
 *
 * @author Bernar
 */
public class ComparacionCadenas {

    /**
     * Método principal que realiza las comparaciones entre dos cadenas.
     *
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        String cadena1 = "Hola";
        String cadena2 = "hola";

        // Compara si el contenido es exactamente igual (sensible a mayúsculas)
        System.out.println("equals(): " + cadena1.equals(cadena2)); // false

        // Compara ignorando mayúsculas y minúsculas
        System.out.println("equalsIgnoreCase(): " + cadena1.equalsIgnoreCase(cadena2)); // true

        // Compara lexicográficamente (como en un diccionario), sensible a mayúsculas
        System.out.println("compareTo(): " + cadena1.compareTo(cadena2)); // valor positivo o negativo

        // Compara lexicográficamente, ignorando mayúsculas
        System.out.println("compareToIgnoreCase(): " + cadena1.compareToIgnoreCase(cadena2)); // 0
    }
}
