/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema4;
import java.util.StringTokenizer;
import java.util.Scanner;
/**
 *
 * @author Bernar
 * ¿Qué es StringTokenizer?
 * Es una clase de Java que permite dividir una cadena de texto en partes 
 * (llamadas tokens) usando un delimitador (como coma, espacio, punto y coma, etc.).
 * Está en el paquete java.util, por lo que hay que importar: 
 * import java.util.StringTokenizer;
 */
public class Tokenizer {
    public static void main(String[] args){
        
        String nombreCompleto = "Bernardo Luque Lafuente";
        StringTokenizer tokens = new StringTokenizer(nombreCompleto);
        Scanner sc = new Scanner(System.in);
        
        String nombre = tokens.nextToken();
        String apellido1 = tokens.nextToken();
        String apellido2 = tokens.nextToken();
        
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido 1: " + apellido1);
        System.out.println("Apellido 2: " + apellido2);
        
        // Ejemplo dinámico (lista de palabras separadas por coma)
        System.out.println("Introduce palabras separadas por ,");
        String linea = sc.nextLine();
        
        StringTokenizer tokens2 = new StringTokenizer(linea, ",");
        
        System.out.println("\n Las palabras son: ");
        /*while(tokens2.hasMoreTokens()){
            String palabra = tokens2.nextToken().trim();
            System.out.println(palabra);
        } */
        
        // Alternativa con countTokens();
        int cantidad = tokens2.countTokens();
        //System.out.println(cantidad);
        for (int i=0; i < cantidad; i++){
            String palabra = tokens2.nextToken().trim();
            System.out.println(palabra);
        }
    }}
