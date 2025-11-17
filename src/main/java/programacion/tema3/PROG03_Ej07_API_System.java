package programacion.tema3;

/**
 * PROG03_Ej07_API_System
 *
 * Este ejercicio demuestra cómo utilizar la clase System, perteneciente a
 * la API estándar de Java (paquete java.lang, importado automáticamente).
 *
 * Aprenderás:
 *   - a llamar métodos estáticos de System
 *   - a obtener información del sistema operativo
 *   - a diferenciar propiedades del sistema y variables de entorno
 *
 * Autor: Bernardo Luque
 */
public class PROG03_Ej07_API_System {

    public static void main(String[] args) {

        // =============================================================
        // 1. currentTimeMillis() → tiempo actual en milisegundos
        // =============================================================
        /*
         * Este método devuelve la cantidad de milisegundos desde el
         * 1 de enero de 1970. Muy usado para medir tiempos.
         */
        long tiempoActual = System.currentTimeMillis();
        System.out.println("Tiempo actual en milisegundos:");
        System.out.println(tiempoActual);
        System.out.println("----------------------------------------------------");


        // =============================================================
        // 2. getProperty("user.home") → directorio home del usuario
        // =============================================================
        /*
         * Las "system properties" son datos de configuración del sistema.
         * 'user.home' indica la carpeta personal del usuario actual.
         */
        String home = System.getProperty("user.home");
        System.out.println("Directorio HOME del usuario:");
        System.out.println(home);
        System.out.println("----------------------------------------------------");


        // =============================================================
        // 3. getenv("PATH") → obtener variable de entorno PATH
        // =============================================================
        /*
         * Las variables de entorno son proporcionadas por el sistema operativo.
         * 'PATH' contiene rutas donde se buscan programas ejecutables.
         */
        String path = System.getenv("PATH");
        System.out.println("Variable de entorno PATH:");
        System.out.println(path);
        System.out.println("----------------------------------------------------");


        // =============================================================
        // Fin del ejercicio
        // =============================================================
        System.out.println("Datos obtenidos correctamente usando System.");
    }
}
