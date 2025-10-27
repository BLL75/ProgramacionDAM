package programacion.tema2;

/**
 * Ejemplo práctico y documentado del uso de las sentencias break y continue.
 * 
 * En este programa se recorren los números del 1 al 100 mostrando los primeros 
 * 10 números pares, con una particularidad: los múltiplos de 5 se ignoran.
 * 
 * Se utiliza:
 *   - La sentencia continue → para saltarse los múltiplos de 5.
 *   - La sentencia break → para detener el bucle al encontrar 10 números pares válidos.
 * 
 * Este ejemplo es ideal para comprender cómo estas sentencias afectan al flujo 
 * de ejecución de un bucle for.
 * 
 * @author Bernar
 */
public class SentenciasBreakContinue {
    
    public static void main(String[] args) {
        
        // Variable para contar cuántos números pares válidos se han mostrado
        int contadorPares = 0;
        
        System.out.println("Mostrando los primeros 10 números pares entre 1 y 100 (ignorando múltiplos de 5):\n");
        
        // Bucle for que recorre los números del 1 al 100
        for (int i = 1; i <= 100; i++) {
            
            // Si el número es múltiplo de 5, se ignora usando 'continue'
            // Esto provoca que la iteración actual termine y se pase a la siguiente
            if (i % 5 == 0) {
                continue;  // Saltar al siguiente número sin ejecutar el resto del bucle
            }
            
            // Si el número es par, se muestra por pantalla y se incrementa el contador
            if (i % 2 == 0) {
                System.out.print(i + " ");
                contadorPares++;
            }
            
            // Si ya se han mostrado 10 números pares válidos, se sale del bucle con 'break'
            if (contadorPares == 10) {
                break;  // Rompe el flujo del bucle 'for'
            }
        }
        
        // Mensaje final una vez terminado el bucle
        System.out.println("\n\nPrograma finalizado correctamente.");
        
        /*
         * --- REFLEXIÓN ---
         * 
         * La sentencia 'continue' permite saltarse el resto de instrucciones de una
         * iteración y continuar con la siguiente. Aquí la usamos para ignorar los múltiplos de 5.
         * 
         * La sentencia 'break' detiene el bucle de forma inmediata, sin esperar a que 
         * se cumpla la condición normal del bucle. En este caso, la usamos para salir 
         * del bucle cuando ya se han mostrado 10 números pares válidos.
         * 
         * ⚠️ Buenas prácticas:
         * Aunque ambas sentencias pueden ser útiles, su uso debe limitarse a casos 
         * muy concretos, ya que pueden dificultar la lectura del código si se abusa 
         * de ellas. Siempre que sea posible, se recomienda estructurar la lógica del 
         * bucle sin depender de 'break' o 'continue'.
         */
    }
}
