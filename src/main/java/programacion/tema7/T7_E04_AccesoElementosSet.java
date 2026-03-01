package programacion.tema7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Tema 7 - Ejercicio 04
 * <p>
 * Objetivo: Aprender cómo acceder (recorrer) los elementos de un conjunto (Set).
 * Para acceder a todos los elementos de un Set, se recorre usando un bucle for-each
 * (internamente utiliza un iterador).
 *
 * <h2>Conceptos que practica</h2>
 * <ul>
 *   <li>Conjuntos: {@code Set<E>} y {@code HashSet<E>}</li>
 *   <li>Un Set no tiene índices: no existe {@code get(i)}</li>
 *   <li>Recorrido con bucle {@code for-each}</li>
 *   <li>Control de duplicados con {@code add()} (devuelve false si ya existe)</li>
 *   <li>Validación de entrada con {@code try/catch} y {@code Integer.parseInt}</li>
 * </ul>
 *
 * @author Bernar
 * @version 1.0
 */
public class T7_E04_AccesoElementosSet {

    /**
     * Método principal de prueba.
     * <p>
     * Pide al usuario 5 números enteros diferentes, los guarda en un HashSet
     * y después calcula la suma recorriendo el Set con for-each.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // Usamos la interfaz Set para poder cambiar de implementación si queremos
        Set<Integer> conjunto = new HashSet<>();
        Scanner teclado = new Scanner(System.in);

        // 1) Pedir 5 enteros distintos
        while (conjunto.size() < 5) {

            System.out.printf("Introduce el número %dº: ", (conjunto.size() + 1));
            String str = teclado.nextLine();

            try {
                int numero = Integer.parseInt(str);

                // add() devuelve false si ya existía (duplicado)
                if (!conjunto.add(numero)) {
                    System.out.printf("El número %d ya está en el conjunto. Debes introducir otro.%n", numero);
                }

            } catch (NumberFormatException e) {
                System.out.println("Número erróneo. Debe ser un número entero válido.");
            }
        }

        // 2) Recorrer el Set (acceso secuencial) con for-each para sumar
        int suma = 0;
        for (Integer elemento : conjunto) {
            suma += elemento;
        }

        // 3) Mostrar resultado
        System.out.println("\nContenido del conjunto (orden NO garantizado): " + conjunto);
        System.out.printf("La suma es: %d%n", suma);

        teclado.close();
    }
}
