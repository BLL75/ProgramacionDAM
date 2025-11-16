package programacion.tema3;

/**
 * PROG03_Ej05_Sobrecarga
 *
 * En este ejercicio demostramos el concepto de SOBRECARGA DE MÉTODOS (overloading).
 *
 * La sobrecarga permite que varios métodos se llamen igual, siempre que
 * tengan distinta FIRMA:
 *
 *   - diferente número de parámetros
 *   - o diferentes tipos de parámetros
 *
 * El compilador decide automáticamente qué versión usar según los argumentos
 * que recibe la llamada al método.
 *
 * Esto es muy usado en Java, por ejemplo:
 *    System.out.println()  → tiene decenas de versiones sobrecargadas.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej05_Sobrecarga {
    
    public static void main(String[] args) {
        
        // Crear un objeto de tipo Calculadora
        Calculadora calc = new Calculadora();
        
        /*
         * Aquí estamos llamando a:
         *    sumar(int, int)
         * porque los argumentos 3 y 5 son enteros.
         */
        System.out.println("Suma de enteros: " + calc.sumar(3, 5));
        
        /*
         * Aquí estamos llamando a:
         *    sumar(double, double)
         * porque 3.3 y 5.1 son valores decimales (double).
         */
        System.out.println("Suma de decimales: " + calc.sumar(3.3, 5.1));
    }
}



// ---------------------------------------------------------------
//                        CLASE CALCULADORA
// ---------------------------------------------------------------

/**
 * Esta clase demuestra la SOBRECARGA DE MÉTODOS.
 * 
 * Ambos métodos se llaman "sumar", pero tienen firmas distintas.
 */
class Calculadora {
    
    /**
     * Versión del método sumar para ENTEROS.
     * 
     * Esta firma:
     *      sumar(int, int)
     * será seleccionada automáticamente cuando los parámetros sean enteros.
     */
    int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * Versión del método sumar para DECIMALES.
     * 
     * Esta firma:
     *      sumar(double, double)
     * será seleccionada cuando los argumentos sean double.
     */
    double sumar(double a, double b) {
        return a + b;
    }
}
