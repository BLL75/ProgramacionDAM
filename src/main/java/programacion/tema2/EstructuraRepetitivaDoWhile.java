/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema2;
import  java.util.Scanner;

/**
 *
 * @author Bernar
 * Escribe un programa que solicite dos números por teclado (inicio y fin) y 
 * muestre por pantalla todos los números que van desde inicio hasta fin, 
 * todos en una misma línea. Este ejercicio ya lo hemos planteado usando un 
 * bucle while. En este caso debes utilizar un bucle do-while.
 */
public class EstructuraRepetitivaDoWhile {
    
    public static void main(String[] args){
        int     inicio;
        int     fin;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el primer número: ");
        inicio = sc.nextInt();
        System.out.println("Escribe el último número: ");
        fin = sc.nextInt();
        
        if (inicio > fin){
            System.out.println("Primer número debe ser igual o menor que el "
                    + "segundo");
            return;
        }
        if (inicio == fin){
            System.out.println(inicio);
            return;
        }
        do{
            System.out.print((inicio++) + " ");
        }while(inicio <= fin-1);
        System.out.println(inicio);
    }  
}
