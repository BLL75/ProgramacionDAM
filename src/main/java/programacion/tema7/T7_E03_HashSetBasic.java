import java.util.HashSet;
import java.util.Set;

/**
 * Tema 7 - Ejercicio 03
 * <p>
 * Objetivo: Entender qué es un conjunto (Set) y cómo funciona HashSet.
 * Se comprueba que:
 * - No permite elementos duplicados.
 * - No mantiene orden de inserción.
 * - El método add() devuelve false si el elemento ya existe.
 *
 * <h2>Conceptos que practica</h2>
 * <ul>
 *   <li>Interfaz Set</li>
 *   <li>Implementación HashSet</li>
 *   <li>Uso de add()</li>
 *   <li>Control de duplicados</li>
 *   <li>Diferencia entre interfaz e implementación</li>
 * </ul>
 *
 * @author Bernar
 * @version 1.0
 */
public class T7_E03_HashSetBasic {

    /**
     * Método principal de prueba.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // Declaramos el conjunto usando la interfaz Set
        Set<Integer> conjunto = new HashSet<>();

        System.out.println("Añadimos elementos al conjunto:");

        // Añadimos números
        System.out.println("Añadir 10: " + conjunto.add(10));
        System.out.println("Añadir 20: " + conjunto.add(20));
        System.out.println("Añadir 30: " + conjunto.add(30));

        // Intentamos añadir duplicado
        System.out.println("Añadir 20 otra vez: " + conjunto.add(20));

        System.out.println("\nContenido del conjunto:");
        System.out.println(conjunto);

        System.out.println("\nTamaño del conjunto: " + conjunto.size());

        /*
         * Observaciones importantes:
         *
         * - El segundo intento de añadir 20 devuelve false.
         * - El orden mostrado puede NO coincidir con el orden de inserción.
         * - HashSet no garantiza ningún orden.
         */
    }
}
