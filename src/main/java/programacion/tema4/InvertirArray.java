package programacion.tema4;

/**
 * <h1>Ejercicio 1: Invertir un Array</h1>
 *
 * <p><b>Descripción:</b></p>
 * <p>Dado un array de números enteros, muestra sus elementos en orden inverso y
 * crea un nuevo array con los valores invertidos.</p>
 *
 * <p><b>Ejemplo:</b></p>
 * <pre>
 *   Entrada: {1, 2, 3, 4, 5}
 *   Salida:  {5, 4, 3, 2, 1}
 * </pre>
 *
 * <p><b>Conceptos practicados:</b></p>
 * <ul>
 *   <li>Recorrido de arrays en orden inverso</li>
 *   <li>Creación de un nuevo array a partir de otro</li>
 *   <li>Cálculo de índices complementarios</li>
 * </ul>
 *
 * <p><b>Pistas:</b></p>
 * <ul>
 *   <li>Recorrido inverso: for (int i = array.length - 1; i >= 0; i--)</li>
 *   <li>Índice opuesto: array.length - 1 - i</li>
 * </ul>
 *
 * @author Bernar
 * @version 1.0
 * @since 2024
 */
public class InvertirArray {

    public static void main(String[] args) {
        // ============================================================
        // DATOS DE ENTRADA: array original a invertir
        // ============================================================
        int[] original = {1, 2, 3, 4, 5};

        // Paso 1: Mostrar el array original
        System.out.print("Array original: ");
        mostrarArray(original);

        // Paso 2: Mostrar los elementos en orden inverso sin crear un nuevo array
        System.out.print("Array en orden inverso (sin crear nuevo array): [");
        for (int i = original.length - 1; i >= 0; i--) {
            System.out.print(original[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Paso 3: Crear un nuevo array con los valores invertidos
        int[] invertido = invertirArray(original);

        // Paso 4: Mostrar el nuevo array invertido
        System.out.print("Nuevo array invertido: ");
        mostrarArray(invertido);
    }

    /**
     * Muestra por consola los elementos del array en formato: [1, 2, 3]
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
     * Devuelve un nuevo array con los elementos del original en orden inverso.
     *
     * @param arr el array original
     * @return un nuevo array invertido
     */
    public static int[] invertirArray(int[] arr) {
        int[] resultado = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // Cálculo del índice complementario
            resultado[i] = arr[arr.length - 1 - i];
        }
        return resultado;
    }
}
