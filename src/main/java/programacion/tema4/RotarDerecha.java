/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package programacion.tema4;

/**
 * <h1>Ejercicio 3: Rotar Array a la Derecha</h1>
 * 
 * <p><b>Descripción:</b></p>
 * <p>
 * Dado un array de números enteros, el programa desplaza todos los elementos
 * una posición hacia la derecha. El último elemento pasa a ocupar la primera
 * posición.
 * </p>
 * 
 * <p><b>Ejemplo:</b></p>
 * <pre>
 * Entrada: {1, 2, 3, 4, 5}
 * Salida:  {5, 1, 2, 3, 4}
 * </pre>
 * 
 * <p><b>Reto extra:</b> Rotar N posiciones a la derecha.</p>
 * 
 * @author Bernar
 * @version 1.0
 * @since 2024
 */
public class RotarDerecha {

    /**
     * Método principal del programa.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // ============================================================
        // DATOS DE ENTRADA
        // ============================================================
        int[] numeros = { 1, 2, 3, 4, 5 };

        // Paso 1: Mostrar el array antes de rotar
        System.out.println("Array original:");
        mostrarArray(numeros);

        // Paso 2–4: Rotar una posición a la derecha
        rotarDerecha(numeros);

        // Paso 5: Mostrar el array después de rotar
        System.out.println("Array rotado a la derecha (1 posición):");
        mostrarArray(numeros);

        // ============================================================
        // RETO EXTRA: rotar N posiciones
        // ============================================================
        rotarDerechaN(numeros, 2);
        System.out.println("Array rotado a la derecha (2 posiciones más):");
        mostrarArray(numeros);
    }

    /**
     * Método auxiliar para mostrar un array por consola.
     * Formato de salida: [elemento1, elemento2, elemento3, ...]
     * 
     * @param arr el array a mostrar
     */
    public static void mostrarArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Método que rota un array una posición a la derecha.
     * MODIFICA el array original (no crea uno nuevo).
     * 
     * @param arr el array a rotar
     */
    public static void rotarDerecha(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        // Guardamos el último elemento
        int ultimo = arr[arr.length - 1];

        // Desplazamos todos los elementos una posición a la derecha
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Colocamos el último elemento en la primera posición
        arr[0] = ultimo;
    }

    /**
     * RETO EXTRA: Método que rota un array N posiciones a la derecha.
     * 
     * @param arr        el array a rotar
     * @param posiciones número de posiciones a rotar
     */
    public static void rotarDerechaN(int[] arr, int posiciones) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        // Evita rotaciones innecesarias
        posiciones = posiciones % arr.length;

        // Reutilizamos el método rotarDerecha
        for (int i = 0; i < posiciones; i++) {
            rotarDerecha(arr);
        }
    }
}
