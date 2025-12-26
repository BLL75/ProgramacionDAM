/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema4;
import java.util.Scanner;
/**
 *
 * @author Bernar
 */
public class Palindromo {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce una cadena de texto: ");
        String cadena = sc.nextLine();
        
        // Creamos el reverso con StringBuilder
        String inversa = new StringBuilder(cadena).reverse().toString();
        
        // Comparamos ignorando mayúsculas y minúsculas
        boolean esPalindromo = cadena.equalsIgnoreCase(inversa);
        
        System.out.println("La cadena " + (esPalindromo ? "si" : "no") + 
                " es palíndromo");
    }
}
