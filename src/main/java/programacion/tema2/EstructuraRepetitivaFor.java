package programacion.tema2;

import java.util.Scanner;

/**
 * @author Bernar
 * Escribe un programa que solicite dos números por teclado (inicio y fin) y 
 * muestre por pantalla todos los números que van desde inicio hasta fin, 
 * todos en una misma línea. 
 * Este ejercicio utiliza un bucle for.
 */
public class EstructuraRepetitivaFor {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inicio;
        int fin;
        
        // Control de entrada
        do {
            System.out.print("Introduce el primer número: ");
            inicio = sc.nextInt();
            System.out.print("Introduce el segundo número: ");
            fin = sc.nextInt();
            
            if (inicio > fin) {
                System.out.println("❌ El primer número debe ser menor o igual"
                        + " que el segundo. Repite.\n");
            }
        } while (inicio > fin);
        
        // Caso especial: si son iguales
        if (inicio == fin) {
            System.out.println(inicio);
        } 
        else {
            // Bucle for para recorrer desde inicio hasta fin
            for (int i = inicio; i <= fin; i++) {
                System.out.print(i + " ");
            }
            System.out.println(); // salto de línea final
        }
        
        sc.close();
    }
}
