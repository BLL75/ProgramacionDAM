package programacion.tema4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que permite realizar búsquedas dentro de una lista de apellidos
 * utilizando distintos métodos de comparación y búsqueda proporcionados 
 * por la clase {@code String}.
 * 
 * <p>Este programa permite practicar los métodos más comunes para realizar
 * búsquedas de texto en Java, como:</p>
 * 
 * <ul>
 *   <li>{@code toLowerCase()} – para normalizar y evitar diferencias entre
 *       mayúsculas y minúsculas.</li>
 *   <li>{@code startsWith(String)} – para comprobar si un apellido empieza 
 *       por un grupo de caracteres determinado.</li>
 *   <li>{@code contains(CharSequence)} – para comprobar si un apellido 
 *       contiene un texto dado en cualquier posición.</li>
 * </ul>
 *
 * <p>El usuario introduce un filtro de búsqueda y el programa mostrará 
 * todos los apellidos de una lista predefinida que cumplan con:</p>
 * 
 * <ul>
 *   <li>Empezar por el texto introducido.</li>
 *   <li>Contener ese texto en cualquier parte del apellido.</li>
 * </ul>
 * 
 * <p><strong>Ejemplo de uso:</strong></p>
 * 
 * <pre>
 * Introduce los caracteres a buscar (inicio o parte del apellido): garc
 * 
 * Resultados que empiezan por "garc":
 *  - Garcés Pérez
 *  - García López
 *  - García Pineda
 *  - García Lomas
 *
 * Resultados que contienen "garc":
 *  - Garcés Pérez
 *  - García López
 *  - García Pineda
 *  - García Lomas
 * </pre>
 * 
 * <p>Este ejercicio forma parte del Tema 4 de Programación: Cadenas de caracteres.</p>
 * 
 * @author Bernar
 */
public class BusquedaApellidos {

    /**
     * Método principal del programa.  
     * Solicita un filtro al usuario, recorre una lista fija de apellidos y 
     * muestra coincidencias tanto por inicio como por contenido parcial.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        
        // Lista de apellidos simulando una base de datos
        List<String> apellidos = new ArrayList<>();
        apellidos.add("Garcés Pérez");
        apellidos.add("García López");
        apellidos.add("García Pineda");
        apellidos.add("García Lomas");
        apellidos.add("Pérez López");
        apellidos.add("Piñeiro Solis");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce los caracteres a buscar (inicio o parte del apellido): ");
        String filtro = scanner.nextLine().toLowerCase();

        // -----------------------------------------------
        //   Búsqueda: apellidos que empiezan por el filtro
        // -----------------------------------------------
        System.out.println("\nResultados que empiezan por \"" + filtro + "\":");
        
        for (String apellido : apellidos) {
            if (apellido.toLowerCase().startsWith(filtro)) {
                System.out.println(" - " + apellido);
            }
        }

        // -----------------------------------------------
        //   Búsqueda: apellidos que contienen el filtro
        // -----------------------------------------------
        System.out.println("\nResultados que contienen \"" + filtro + "\":");
        
        for (String apellido : apellidos) {
            if (apellido.toLowerCase().contains(filtro)) {
                System.out.println(" - " + apellido);
            }
        }

        scanner.close();
    }
}
