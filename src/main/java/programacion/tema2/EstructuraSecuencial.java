package programacion.tema2;

/**
 *
 * @author Bernar
 */
public class EstructuraSecuencial {

    public static void main(String[] args) {
        /*
            Bloque de sentencias para ejecución secuencial.
        */
        int dia=15;
        System.out.println("El dia es: " + dia);
        int mes=9;
        System.out.println("El mes es el: " + mes);
        int anyo=2031;
        System.out.println("El año el el: " + anyo);
        
        /*
            Bloque de sentencias con declaración de variables.
        */
        
        // Declaración de variables
        int ventas = 3000;
        int compras = 2000;
        int ganancia = ventas - compras;
        
        // Sentencias que usan variables
        System.out.println("Las ventas han sido:" + ventas);
        System.out.println("Las compras han sido: " + compras);
        System.out.println("Ganancias: " + ganancia);
        
        /*
            Bloque de sentencias  con el código organizado en declaración 
            de variables, entrada de datos, procesamiento y salida
        */
        
        // Zona de declaración de variables
        double  venta;
        double  compra;
        double  gana;
        int     ganaEntero;
        
        // Zona de inicialización o entrada de datos
        venta = 100.98;
        compra = 45.88;
        
        // Zona de procesamiento
        gana = venta - compra;
        ganaEntero = (int)(venta - compra);
        
        // Zona de salida de resultados
        System.out.println("El resultado justo es de: " + gana + "€");
        System.out.println("El resultado redondeando es de: " + ganaEntero + "$");
    }
}
