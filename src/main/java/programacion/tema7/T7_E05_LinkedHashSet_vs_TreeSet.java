package programacion.tema7;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Tema 7 - Ejercicio 05
 * <p>
 * Objetivo: Comparar el comportamiento de LinkedHashSet y TreeSet.
 * Se observa cómo cambia el orden de los elementos al recorrerlos.
 *
 * <h2>Conceptos que practica</h2>
 * <ul>
 *   <li>Diferencias entre HashSet, LinkedHashSet y TreeSet</li>
 *   <li>Orden de inserción vs orden natural</li>
 *   <li>Uso de la interfaz Set</li>
 *   <li>Recorrido con for-each</li>
 * </ul>
 *
 * @author Bernar
 * @version 1.0
 */
public class T7_E05_LinkedHashSet_vs_TreeSet {

    /**
     * Método principal de prueba.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // 🔹 LinkedHashSet (mantiene orden de inserción)
        Set<Integer> conjuntoLinked = new LinkedHashSet<>();
        conjuntoLinked.add(4);
        conjuntoLinked.add(3);
        conjuntoLinked.add(1);
        conjuntoLinked.add(99);

        System.out.println("LinkedHashSet (orden de inserción):");
        for (Integer elemento : conjuntoLinked) {
            System.out.print(elemento + " ");
        }

        System.out.println("\n");

        // 🔹 TreeSet (ordena automáticamente)
        Set<Integer> conjuntoTree = new TreeSet<>();
        conjuntoTree.add(4);
        conjuntoTree.add(3);
        conjuntoTree.add(1);
        conjuntoTree.add(99);

        System.out.println("TreeSet (orden natural):");
        for (Integer elemento : conjuntoTree) {
            System.out.print(elemento + " ");
        }

        /*
         * Observaciones:
         *
         * - LinkedHashSet respeta el orden en que se insertan los elementos.
         * - TreeSet los ordena automáticamente de menor a mayor.
         * - Ninguno permite duplicados.
         */
    }
}