package programacion.tema2;

/**
 * Clase que cubre las estructuras de control condicionales (if).
 * Esta clase tiene ejemplos que muestran cómo usar la estructura if para
 * evaluar condiciones y ejecutar bloques de código dependiendo de la evaluación de esas condiciones.
 *
 * @author Bernar
 */

public class EstructuraControlCondicionales {
    
    public static void main(String[] args) {
        
        // EJEMPLO 1: Estructura condicional simple if
        
        int numero = 5; // Se declara e inicializa la variable
        
        // Se comprueba si el valor es negativo con la estructura 'if'
        if (numero < 0){
            // Si la condición es verdadera es ejecuta esta linea
            System.out.println("Es negativo");
        }
        // Si la condición es falsa se ejecuta esta linea
        System.out.println("Es positivo");
        
        // EJEMPLO 2: Estructura 'if' con múltiples sentencias
        
        numero = -20;
        
        // Si el valor es negativo se ejecutarán múltiples sentencias dentro
        // de las llaves
        if (numero < 0){
            System.out.println("El número es negativo: " + numero);
            numero = 25; // Modificamos el valor de la variable
            System.out.println("Ahora el valor es de: " + numero);
        }
        
        // EJEMPLO 3: Estructura 'if' sin llaves, cuando hay una sola sentencia
        
        numero = 10;
        
        // Como solo hay una sentencia dentro del 'if' no hace falta usar llaves
        if (numero < 0)
            System.out.println("El número es negativo");
        System.out.println("El número es positivo");
    }
}
