/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema4;

/**
 *
 * @author Bernar
 * Un array es una estructura de datos que almacena múltiples valores del mismo 
 * tipo en posiciones consecutivas de memoria. Puedes pensar en él como una 
 * "caja con compartimentos numerados".
 */
public class Arrays {
    public static void main(String[] args){
        
        // Declaración de un array de 5 enteros
        int[] notas = new int[5];
        
        // Declaración inicializada directa
        String[] asignaturas = {"Lengua", "Mátemáticas", "Física"};
        
        // ACCESO Y MODIFICACIÓN
        int[] numeros = {10, 20, 30, 40, 50};
        System.out.println(numeros[0]);
        
        // Modificación del valor del primer índice
        numeros[0] = 11;
        System.out.println(numeros[0]);
        
        // RECORRER UN ARRAY
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
        
        // Con for-each (más limpio si no se necesita el índice)
        for(int num: numeros){
            System.out.println(num);
        }
        
        // ARRAY BIDIMESIONAL
        int[][] matriz = new int[3][4];
        
        // Acceso matriz[fila][columna]
        matriz[0][0] = 22;
        matriz[1][0] = 32;
        
        // Recorrer matriz
        System.out.println("---Recorrer una matriz---");
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.println(matriz[i][j]); 
            }
            System.out.println();
        }
    }
    
}
