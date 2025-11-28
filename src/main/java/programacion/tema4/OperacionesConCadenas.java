package programacion.tema4;

/**
 * Clase que demuestra diversas formas de concatenar cadenas en Java, 
 * incluyendo el uso de operadores y métodos propios de la clase {@code String}.
 *
 * <p>Se exploran las siguientes operaciones:</p>
 * <ul>
 *   <li>Concatenación usando el operador {@code +}.</li>
 *   <li>Concatenación directa con literales.</li>
 *   <li>Uso del método {@code concat(String)}.</li>
 *   <li>Concatenación de texto con números mediante conversión implícita o explícita.</li>
 *   <li>Orden de evaluación del operador {@code +} (concatenación vs suma).</li>
 *   <li>Uso del método {@code toString()} explícito para convertir enteros en cadenas.</li>
 * </ul>
 *
 * <p>Este ejemplo es útil para entender cómo Java maneja internamente las operaciones 
 * de concatenación y cómo optimiza el uso de {@code String} como tipo especial.</p>
 *
 * @author Bernar
 */
public class OperacionesConCadenas {

    /**
     * Método principal del programa.
     * Muestra diferentes formas de concatenar cadenas y trabajar con tipos numéricos en texto.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Concatenación usando el operador +
        String saludo = "Hola";
        String nombre = "David";
        String mensaje = saludo + nombre;
        System.out.println("Usando +: " + mensaje);

        // Concatenación directa sin variables
        System.out.println("Concatenación " + " sin " + " variables");

        // Concatenación usando el método concat()
        String mensaje2 = saludo.concat(nombre);
        System.out.println("Usando concat(): " + mensaje2);

        // Concatenación con números
        int edad = 23;
        String mensaje3 = "Su edad es de " + edad;
        System.out.println("Concatenando un entero: " + mensaje3);

        // Evaluación de operadores: de izquierda a derecha
        System.out.println("Evaluación de operadores: de izquierda a derecha");
        System.out.println(2 + 5 + " es siete"); // Suma primero, luego concatena

        // Cambio del orden: primero concatena, luego sigue concatenando
        System.out.println("Cambiando el orden");
        System.out.println("Suma: " + 2 + 5); // Concatena 2 y 5 como texto, no suma

        // Conversión explícita usando toString()
        String mensaje4 = "Edad: " + Integer.valueOf(edad).toString();
        System.out.println("Usando toString(): " + mensaje4);
    }
}
