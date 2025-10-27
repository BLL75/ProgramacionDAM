/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema2;
import java.util.Scanner;
/**
 *
 * @author Bernar
 */
public class EstructuraRepetitivaFor2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Bucle de validación
        do {
            System.out.print("Introduce un número entre 1 y 10: ");
            n = sc.nextInt();
        } while (n < 1 || n > 10);

        // Mostrar la tabla de multiplicar
        System.out.println("Tabla del " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        sc.close();
    }
}

