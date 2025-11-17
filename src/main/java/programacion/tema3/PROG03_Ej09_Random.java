package programacion.tema3;

import java.util.Random;
import java.util.HashSet;

/**
 * PROG03_Ej09_Random
 *
 * Este ejercicio demuestra el uso de la clase java.util.Random para:
 *   - Generar números aleatorios en distintos rangos.
 *   - Simular tiradas de un dado varias veces.
 *   - Generar 10 números aleatorios sin repetirse usando HashSet.
 *
 * Además, se explica la estructura HashSet y por qué evita duplicados.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej09_Random {
    
    public static void main(String[] args) {
        
        // Crear un objeto Random → fuente de números aleatorios
        Random r = new Random();
        
        
        // =============================================================
        // 1. Número aleatorio entre 1 y 100
        // =============================================================
        /*
         * nextInt(100) genera valores entre 0 y 99.
         * Sumamos +1 para convertirlo en rango 1 a 100.
         */
        int numero = r.nextInt(100) + 1;
        System.out.println("Número aleatorio entre 1 y 100: " + numero);
        System.out.println("-------------------------------");
        
        
        // =============================================================
        // 2. Simulación lanzamiento dado 20 veces
        // =============================================================
        /*
         * nextInt(6) → valores 0 a 5
         * +1 → valores reales de un dado: 1 a 6
         */
        System.out.println("Simulación de 20 tiradas de dado:");
        
        for (int i = 1; i <= 20; i++) {
            int dado = r.nextInt(6) + 1;
            System.out.println("Tirada " + i + ": ha salido " + dado);
        }
        
        System.out.println("-------------------------------");
        
        
        // =============================================================
        // 3. Generar 10 números aleatorios SIN REPETIRSE
        // =============================================================
        /*
         * Aquí utilizamos un HashSet.
         *
         * ¿Qué es un HashSet?
         * --------------------
         * Es una estructura de datos que NO permite valores duplicados.
         * Internamente usa una "tabla hash", que es como un ARRAY especial
         * donde cada elemento se coloca en un "bucket" según su hashcode.
         * 
         * Si intentas añadir un número que ya existe en el HashSet, simplemente:
         *    → NO lo añade.
         *
         * Por eso es ideal para generar listas de números únicos.
         *
         * No mantiene orden y no tiene índices, pero es muy rápido y evita
         * duplicados automáticamente.
         */
        HashSet<Integer> numerosUnicos = new HashSet<>();
        
        /*
         * Añadimos números hasta tener 10 distintos.
         * Si un número generado ya existe, HashSet lo ignora.
         */
        while (numerosUnicos.size() < 10) {
            int valor = r.nextInt(100) + 1; // rango 1 a 100
            numerosUnicos.add(valor);
        }
        
        System.out.println("10 números aleatorios SIN repetirse:");
        System.out.println(numerosUnicos);
        System.out.println("--------------------------------------------------");
    }
}
