/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Queremos saber si en un texto aparecen las letras 'm', 'a', 'l' de manera 
consecutiva, ya sea porque se trate de la palabra "mal" o bien porque forme 
parte de otra palabra como "maldad", "ramal", "formalizar", etc. 
¿cómo lo harías? ¿Qué alternativas se te ocurren?
 */
package programacion.tema4;

/**
 *
 * @author Bernar
 */
public class EjercicioSubcadena {
    public static void main(String[] args){
        String cadena = "  Malamente está la cosa si aparece malamente o mal   ";
        boolean contiene;
        
        contiene = cadena.contains("mal");
        System.out.println(contiene);
        
        // Imagina ahora que no solo queremos saber si la cadena "mal" aparece en
        // un texto determinado, sino en qué posición del texto aparece. 
        // ¿Cómo podríamos resolverlo?
        int posicion;
        
        posicion = cadena.indexOf("jal");
        System.out.println(posicion);
        
        // Supongamos ahora que lo que nos interesa saber es si la cadena "mal" 
        // aparece más de una vez en el texto, ¿qué se te ocurre para resolverlo?
        // Procesamiento
        posicion= cadena.indexOf("mal");  // Buscamos unan primera coincidencia
        if (posicion >=0) {
            // Buscamos más allá de la primera coincidencia
            posicion = (cadena.indexOf("jal", posicion+1));
        }
        boolean encontrado = posicion >= 0; // Si se produjo una segunda coincidencia

        // Salida de resultados
        System.out.printf ("Texto \"mal\"%s encontrado más de una vez.\n", encontrado ? "" : " no");

        // Siguiendo con el ejercicio anterior, imagina que nos interesa saber si una 
        // cadena comienza con el texto "mal", sin tener en cuenta los posibles 
        // espacios iniciales ni las mayúsculas/minúsculas.
        cadena = cadena.trim();
        String filtrado = cadena.toLowerCase();

        if (filtrado.startsWith("mal")){
            System.out.println("La cadena comienza con mal");
        }
        else{
            System.out.println("La cadena no comienza con mal");
        }
        
        if (filtrado.endsWith("mal")){
            System.out.println("La cadena acaba con mal");
        }
        else{
            System.out.println("La cadena NO acaba con mal");
        }
        
        String textoModificado;
        
        textoModificado = cadena.toLowerCase().replace("mal", "---");
        System.out.println(textoModificado);
    }
}
