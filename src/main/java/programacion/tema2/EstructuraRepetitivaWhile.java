/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema2;

import  java.util.Scanner;

/**
 *
 * @author Bernar
 * Escribe un programa que solicite dos números por teclado (inicio y fin, 
 * donde inicio debería ser menor o igual que fin) y muestre por pantalla todos 
 * los números que van desde inicio hasta fin, todos en una misma línea.
 */
public class EstructuraRepetitivaWhile {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int     inicio;
        int     fin;
        
        System.out.println("Escribe el primer número: ");
        inicio = sc.nextInt();
        System.out.println("Escribe el segundo número: ");
        fin = sc.nextInt();
        
        if (inicio > fin){
            System.out.println("El primero número debe ser menor o igual "
                    + "que el segundo");
            return;
        }
        System.out.println("Secuencia va desde " + inicio + " hasta " + fin);
        if (inicio == fin){
            System.out.println(fin);
        }
        while (inicio <= fin){
            System.out.print(inicio + " ");
            inicio++;
        }
        System.out.println ();
        sc.close();
    }  
}
