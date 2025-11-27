/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bernar
 */
public class BusquedaApellidos {
    
    public static void main(String[] args){
    
        List<String> apellidos = new ArrayList<>();
        apellidos.add("Garcés Pérez");
        apellidos.add("García López");
        apellidos.add("García Pineda");
        apellidos.add("García Lomas");
        apellidos.add("Pérez López");
        apellidos.add("Piñeiro Solis");
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Introduce los caracteres a buscar (inicio o parte del apellido):");
        String filtro = scanner.nextLine().toLowerCase();
        
        System.out.println("Resultados que *empiezan por* \"" + filtro + "\":");
        
        for (String apellido: apellidos){
            if (apellido.toLowerCase().startsWith(apellido)){
                System.out.println(" - " + apellido);
            }
        }
        
        System.out.println("Resultados que contienen* \"" + filtro + "\":");
        for (String apellido: apellidos){
            if (apellido.toLowerCase().contains(filtro)){
                System.out.println(" - " + apellido);
            }
        }
        scanner.close();
    }
    
    
    
    
}
