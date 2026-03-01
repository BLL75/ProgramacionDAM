package programacion.tema7;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Tema 7 - Ejercicio 06
 * <p>
 * Objetivo: Combinar datos de varias colecciones (conjuntos) usando operaciones
 * del álgebra de conjuntos: unión, intersección y diferencia.
 *
 * <h2>¿Qué vas a aprender aquí?</h2>
 * <ul>
 *   <li>Cómo crear conjuntos en Java con {@code Set} y {@code HashSet}</li>
 *   <li>Cómo rellenar un conjunto con números aleatorios SIN duplicados</li>
 *   <li>Cómo combinar dos conjuntos SIN recorrerlos a mano:</li>
 *   <ul>
 *     <li><b>Unión</b> (A ∪ B): todos los elementos que estén en A o en B</li>
 *     <li><b>Intersección</b> (A ∩ B): solo los elementos comunes a A y B</li>
 *     <li><b>Diferencia</b> (A - B): elementos que están en A pero NO en B</li>
 *     <li><b>Diferencia</b> (B - A): elementos que están en B pero NO en A</li>
 *   </ul>
 * </ul>
 *
 * <p><b>IMPORTANTE:</b> Estas operaciones NO son sumas matemáticas. Son operaciones
 * entre conjuntos (teoría de conjuntos).</p>
 *
 * @author Bernar
 * @version 1.1
 */
public class T7_E06_OperacionesEntreConjuntos {

    /**
     * Genera un conjunto con una cantidad de números enteros aleatorios,
     * en el rango [min, max] (ambos incluidos), sin duplicados.
     *
     * <h3>¿Por qué se usa Set?</h3>
     * <ul>
     *   <li>Un Set NO permite duplicados.</li>
     *   <li>Eso nos viene genial para generar "números distintos" sin complicarnos.</li>
     *   <li>Si sale un número repetido, {@code add()} lo ignora y el tamaño no sube.</li>
     * </ul>
     *
     * <h3>¿Por qué hay una validación?</h3>
     * Si pides más números de los que existen en el rango, sería imposible
     * completar el conjunto y el bucle podría volverse infinito.
     *
     * <p>Ejemplo: pedir 10 números distintos entre 1 y 2 es imposible (solo hay 2 valores).</p>
     *
     * @param cantidad número de elementos deseados
     * @param min valor mínimo (incluido)
     * @param max valor máximo (incluido)
     * @return Set con enteros aleatorios sin repetidos
     * @throws IllegalArgumentException si el rango no permite generar la cantidad pedida
     */
    public static Set<Integer> generarConjuntoAleatorio(int cantidad, int min, int max) {

        // "posibles" es la cantidad de valores distintos que existen en el rango [min, max]
        // Ej: min=20, max=100 -> posibles = 81 (20..100)
        int posibles = max - min + 1;

        // Si pides más elementos que los posibles, es imposible llenar el Set con valores distintos.
        if (cantidad > posibles) {
            throw new IllegalArgumentException(
                    "No se pueden generar " + cantidad + " valores distintos en el rango [" + min + ", " + max + "]. " +
                    "Valores posibles: " + posibles
            );
        }

        // HashSet es rápido y no admite duplicados
        Set<Integer> conjunto = new HashSet<>();

        // Repetimos hasta tener el tamaño deseado
        while (conjunto.size() < cantidad) {

            // Genera un entero entre min (incluido) y max (incluido)
            // nextInt(origen, límite) -> incluye origen y excluye límite, por eso usamos max+1
            int numero = ThreadLocalRandom.current().nextInt(min, max + 1);

            // Si ya existe, no lo añade y add() devuelve false (pero no lo necesitamos aquí)
            conjunto.add(numero);
        }

        return conjunto;
    }

    /**
     * Método principal de prueba.
     *
     * <h3>Qué hace el main:</h3>
     * <ol>
     *   <li>Genera dos conjuntos A y B con números aleatorios (sin duplicados).</li>
     *   <li>Calcula:</li>
     *   <ul>
     *     <li>Unión (A ∪ B)</li>
     *     <li>Intersección (A ∩ B)</li>
     *     <li>Diferencia (A - B)</li>
     *     <li>Diferencia (B - A)</li>
     *   </ul>
     * </ol>
     *
     * <p><b>IMPORTANTE:</b> addAll / retainAll / removeAll MODIFICAN el conjunto sobre el que
     * se aplican, por eso hacemos copias para no tocar A y B.</p>
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // Puedes cambiar estos valores para probar
        int cantidad = 5;
        int min = 20;
        int max = 100;

        // Conjunto A y B: 5 enteros aleatorios distintos dentro del rango [20..100]
        Set<Integer> conjuntoA = generarConjuntoAleatorio(cantidad, min, max);
        Set<Integer> conjuntoB = generarConjuntoAleatorio(cantidad, min, max);

        System.out.println("Conjunto A: " + conjuntoA);
        System.out.println("Conjunto B: " + conjuntoB);

        /*
         * MUY IMPORTANTE:
         * Si hacemos conjuntoA.addAll(conjuntoB), estamos cambiando el conjuntoA original.
         * Como queremos calcular resultados sin modificar A y B, hacemos copias:
         * new HashSet<>(conjuntoA) crea un set nuevo con los mismos elementos.
         */

        // =========================
        // 1) Unión (A ∪ B)
        // =========================
        // "Todos los elementos que están en A o en B"
        // Se hace con addAll: añade todos los de B en la copia de A (sin duplicar)
        Set<Integer> union = new HashSet<>(conjuntoA);
        union.addAll(conjuntoB);

        // =========================
        // 2) Intersección (A ∩ B)
        // =========================
        // "Solo los elementos comunes a A y B"
        // retainAll significa "retén SOLO los que también estén en B"
        Set<Integer> interseccion = new HashSet<>(conjuntoA);
        interseccion.retainAll(conjuntoB);

        // =========================
        // 3) Diferencia (A - B)
        // =========================
        // "Elementos que están en A pero NO están en B"
        // removeAll elimina de la copia de A todos los que aparezcan en B
        Set<Integer> diferenciaAmenosB = new HashSet<>(conjuntoA);
        diferenciaAmenosB.removeAll(conjuntoB);

        // =========================
        // 4) Diferencia (B - A)
        // =========================
        // "Elementos que están en B pero NO están en A"
        Set<Integer> diferenciaBmenosA = new HashSet<>(conjuntoB);
        diferenciaBmenosA.removeAll(conjuntoA);

        // Mostrar resultados
        System.out.println("\nA ∪ B (Unión): " + union);
        System.out.println("A ∩ B (Intersección): " + interseccion);
        System.out.println("A - B (Diferencia): " + diferenciaAmenosB);
        System.out.println("B - A (Diferencia): " + diferenciaBmenosA);

        /*
         * Resumen final:
         * - Unión: junta sin repetir.
         * - Intersección: deja solo lo común.
         * - Diferencia: quita lo que se repite con el otro.
         *
         * NO son sumas matemáticas, es álgebra de conjuntos.
         */
    }
}