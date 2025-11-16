package programacion.tema3;

/**
 * PROG03_Ej03_Referencias
 *
 * Este ejercicio demuestra uno de los conceptos MÁS IMPORTANTES de Java:
 * 
 *   ➜ En Java, las variables de tipo objeto NO almacenan el objeto,
 *     sino una REFERENCIA (una especie de puntero) hacia él.
 * 
 *   ➜ Si asignamos p2 = p1, NO se crea un objeto nuevo. Ambas referencias
 *     apuntan al MISMO objeto en memoria.
 * 
 *   ➜ Si modificamos el objeto usando p2, el cambio también se ve usando p1.
 * 
 * Este comportamiento es fundamental para entender cómo Java maneja objetos,
 * memoria y paso de parámetros.
 * 
 * Autor: Bernardo
 */
public class PROG03_Ej03_Referencias {
    
    public static void main(String[] args) {

        // ================================================================
        // 1. CREACIÓN DEL OBJETO INICIAL
        // ================================================================
        /*
         * new Persona("Juan", 34)
         *
         * Crea un objeto REAL en memoria. La variable p1 NO contiene el objeto,
         * contiene SOLO una referencia hacia él.
         */
        Persona p1 = new Persona("Juan", 34);


        // ================================================================
        // 2. COPIA DE LA REFERENCIA, NO DEL OBJETO
        // ================================================================
        /*
         * Aquí NO estamos creando una nueva persona.
         * 
         * p2 recibe una COPIA DE LA REFERENCIA almacenada en p1.
         *
         * Es decir:
         * 
         *      p1 -----> [Objeto Persona]
         *      p2 -----> [Mismo Objeto Persona]
         * 
         * NO existe un "segundo objeto".
         */
        Persona p2 = p1;


        // ================================================================
        // 3. MODIFICAR EL OBJETO A TRAVÉS DE p2
        // ================================================================
        /*
         * Como p2 apunta al MISMO objeto que p1,
         * cambiar el nombre desde p2 modifica el MISMO objeto.
         */
        p2.nombre = "Luis";


        // ================================================================
        // 4. MOSTRAR RESULTADOS
        // ================================================================
        /*
         * Ambos imprimirán EL MISMO NOMBRE y LA MISMA EDAD
         * porque acceden al mismo objeto en memoria.
         */
        System.out.println("Nombre: " + p1.nombre + "\nEdad: " + p1.edad);
        System.out.println("Nombre: " + p2.nombre + "\nEdad: " + p2.edad);

        /*
         * CONCLUSIÓN:
         *
         * Java trabaja SIEMPRE con referencias cuando tratamos con objetos.
         * 
         * - p1 y p2 NO son objetos.
         * - p1 y p2 son "etiquetas" que apuntan al mismo objeto.
         * - Cambiar el objeto desde cualquier referencia afecta al mismo lugar.
         *
         * Este concepto es esencial para:
         *  - estructuras de datos
         *  - listas
         *  - arrays
         *  - paso de parámetros
         *  - alias de objetos
         *  - evitar errores de duplicación involuntaria
         */
    }
}


// ------------------------------------------------------
//                      CLASE PERSONA
// ------------------------------------------------------

/**
 * Clase sencilla usada para demostrar la gestión de referencias.
 */
class Persona {
    
    String nombre;
    int edad;
    
    // Constructor que inicializa los atributos del objeto
    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
