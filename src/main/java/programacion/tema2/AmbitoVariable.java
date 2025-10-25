/*
 * Clase para explicar el concepto de ámbito de las variables en Java.
 * El ámbito de una variable determina en qué parte del código es accesible.
 * Existen tres tipos de ámbitos: 
 * 1. Ámbito de clase (variables de instancia).
 * 2. Ámbito de método (variables locales).
 * 3. Ámbito de bloque (variables dentro de bloques como `if`, `for`, etc.).
 */
package programacion.tema2;

/**
 *
 * @author Bernar
 */
public class AmbitoVariable {

    // Variable de clase (ámbito de clase)
    // Esta variable es accesible por todos los métodos de esta clase
    private static String nombreClase = "Ámbito de Clase";
    
    public static void main(String[] args){
        // Variable local (ámbito de método)
        // Solo es accesible dentro del método main
        String  saludo = "Hola, soy una variable local en el método main";
        
        // Se imprime la variable local
        System.out.println(saludo);
        
        // Se llama a otro método que tiene acceso a la variable de instancia
        otroMetodo();
        
        // Aquí se accede a la variable de clase usando el nombre clase
        System.out.println("Accediendo desde la clase " + nombreClase);
    }
    
    public static void otroMetodo() {
        // Variable de instancia (ámbito de instancia)
        // Esta variable es accesible en cualquier parte de la clase, incluyendo otros métodos.
        String mensaje = "Soy una variable de instancia, accesible por cualquier método.";

        // Se imprime la variable de instancia
        System.out.println(mensaje);
    }
    
    /**
     * Ejemplo de cómo las variables locales tienen ámbito dentro de bloques.
     * Las variables solo son accesibles dentro del bloque donde se definen.
     */
    public static void ejemploDeBloque() {
        // Variable local dentro de un bloque
        if (true) {
            // Esta variable solo es accesible dentro del bloque `if`
            int numeroBloque = 5;
            System.out.println("Número dentro del bloque if: " + numeroBloque);
        }

        // Intento de acceder a la variable fuera del bloque causaría un error de compilación.
        // System.out.println("Fuera del bloque: " + numeroBloque); // Error: la variable no existe fuera del bloque
    }
}
