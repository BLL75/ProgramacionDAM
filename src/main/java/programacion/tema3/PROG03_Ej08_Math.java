package programacion.tema3;

/**
 * PROG03_Ej08_Math
 *
 * Este ejercicio demuestra el uso de la clase Math del paquete java.lang.
 * 
 * Math contiene métodos estáticos para cálculos matemáticos:
 *   - sqrt()   → raíz cuadrada
 *   - abs()    → valor absoluto
 *   - max()    → máximo de dos valores
 *   - min()    → mínimo de dos valores
 *   - pow()    → potencia
 *   - random() → número aleatorio entre 0.0 y 1.0
 *
 * Autor: Bernardo
 */
public class PROG03_Ej08_Math {

    public static void main(String[] args) {

        // =============================================================
        // 1. Raíz cuadrada
        // =============================================================
        double raiz = Math.sqrt(729);
        System.out.println("Raíz cuadrada de 729: " + raiz);


        // =============================================================
        // 2. Valor absoluto
        // =============================================================
        int absoluto = Math.abs(-57);
        System.out.println("Valor absoluto de -57: " + absoluto);


        // =============================================================
        // 3. Máximo entre dos números
        // =============================================================
        int max = Math.max(88, 123);
        System.out.println("Máximo entre 88 y 123: " + max);


        // =============================================================
        // 4. Mínimo entre dos números
        // =============================================================
        int min = Math.min(88, 123);
        System.out.println("Mínimo entre 88 y 123: " + min);


        // =============================================================
        // 5. Potencia
        // =============================================================
        double potencia = Math.pow(3, 9);
        System.out.println("3 elevado a 9: " + potencia);


        // =============================================================
        // 6. Número aleatorio entre 0.0 y 1.0
        // =============================================================
        double aleatorio01 = Math.random();
        System.out.println("Número aleatorio [0,1): " + aleatorio01);


        // =============================================================
        // 7. Número aleatorio entre 1 y 100 (MUY TÍPICO DE EXAMEN)
        // =============================================================

        /*
         * Math.random() genera un número entre 0 y 1 (sin incluir 1).
         *
         * Para obtener de 1 a 100:
         * 
         *   Math.random() * 100  → rango 0 a 99.999...
         *   (int) (...)          → lo convierte en entero: 0 a 99
         *   + 1                  → rango final: 1 a 100
         */
        int aleatorio100 = (int)(Math.random() * 100) + 1;
        System.out.println("Número aleatorio entre 1 y 100: " + aleatorio100);
    }
}
