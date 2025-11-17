package programacion.tema3;

/**
 * PROG03_Ej15_Javadoc_Documentacion
 *
 * En este ejercicio aprendemos a documentar clases y métodos usando Javadoc,
 * la herramienta oficial de documentación de Java.
 *
 * Javadoc permite generar documentación profesional en HTML a partir de:
 *   - Descripciones de clases
 *   - Descripciones de métodos
 *   - Etiquetas: @param, @return y @throws
 *
 * Esta documentación es fundamental para:
 *   ✔ Entender cómo funciona una clase sin leer su código interno
 *   ✔ Crear librerías reutilizables
 *   ✔ Mantener código profesional y sostenible
 *
 * En este caso, se utiliza la clase CalculadoraAvanzada para demostrarlo.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej15_Javadoc_Documentacion {

    public static void main(String[] args) {

        CalculadoraAvanzada calc = new CalculadoraAvanzada();

        System.out.println("Suma: " + calc.sumar(4, 2));
        System.out.println("Resta: " + calc.restar(4, 2));
        System.out.println("Multiplicación: " + calc.multiplicar(4, 2));
        System.out.println("Potencia: " + calc.potencia(3, 4));

        // Ejemplo de división con manejo de excepción
        try {
            System.out.println("División: " + calc.dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("ERROR capturado: " + e.getMessage());
        }
    }
}



/**
 * Clase que representa una calculadora capaz de realizar operaciones
 * matemáticas básicas y avanzadas.
 *
 * Esta clase es deliberadamente *sin estado* (stateless), lo que significa:
 *   - No tiene atributos internos
 *   - Cada método calcula valores sin depender de otros
 *   - Es segura, sencilla y muy reutilizable
 *
 * Esto es común en utilidades matemáticas y librerías de funciones.
 */
class CalculadoraAvanzada {

    /**
     * Realiza la suma de dos números enteros.
     *
     * @param a primer número entero
     * @param b segundo número entero
     * @return la suma de ambos números (a + b)
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Realiza la resta entre dos números enteros.
     *
     * @param a número inicial (minuendo)
     * @param b número que se resta (sustraendo)
     * @return el resultado de la operación (a - b)
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param a primer valor a multiplicar
     * @param b segundo valor a multiplicar
     * @return el producto de ambos valores (a * b)
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números enteros.
     *
     * IMPORTANTE:
     *   La división entre cero es una operación no permitida.
     *   Por ello, este método lanza una excepción si el divisor es 0.
     *
     * @param a dividendo (número a dividir)
     * @param b divisor (número que divide)
     * @return el cociente de la división (a / b)
     *
     * @throws ArithmeticException si el divisor es cero
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    /**
     * Calcula la potencia de un número entero.
     *
     * @param base número que se eleva
     * @param exponente número de veces que se multiplica la base por sí misma
     * @return el valor resultante de base elevado a exponente
     */
    public int potencia(int base, int exponente) {
        return (int) Math.pow(base, exponente);
    }
}
