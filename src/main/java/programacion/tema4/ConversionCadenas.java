package programacion.tema4;

/**
 * Clase de ejemplo que muestra cómo convertir una cadena de caracteres a 
 * mayúsculas y minúsculas utilizando los métodos de la clase {@code String}.
 *
 * <p>Este ejercicio permite practicar el uso de los métodos:</p>
 * 
 * <ul>
 *   <li>{@code toUpperCase()} – Convierte todos los caracteres a mayúsculas.</li>
 *   <li>{@code toLowerCase()} – Convierte todos los caracteres a minúsculas.</li>
 * </ul>
 *
 * <p>Los métodos devuelven una nueva cadena modificada sin alterar la original, ya que
 * los objetos de tipo {@code String} en Java son inmutables.</p>
 * 
 * <p><strong>Ejemplo de salida del programa:</strong></p>
 * 
 * <pre>
 * Original: JuAn LiKeo
 * Mayúsculas: JUAN LIKEO
 * Minúsculas: juan likeo
 * </pre>
 *
 * <p>Este ejercicio forma parte del Tema 4 de Programación: Cadenas de caracteres.</p>
 * 
 * @author Bernar
 */
public class ConversionCadenas {

    /**
     * Método principal del programa.
     * Demuestra la conversión de una cadena a mayúsculas y minúsculas.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Cadena de texto original
        String nombre = "JuAn LiKeo";

        // Mostrar la cadena original
        System.out.println("Original: " + nombre);

        // Convertir a mayúsculas
        System.out.println("Mayúsculas: " + nombre.toUpperCase());

        // Convertir a minúsculas
        System.out.println("Minúsculas: " + nombre.toLowerCase());
    }
}
