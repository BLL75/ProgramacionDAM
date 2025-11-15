package programacion.tema3;

/**
 * PROG03_Ej01_CocheBasico
 * 
 * Este ejercicio demuestra los conceptos fundamentales del Tema 3:
 *  - Qué es una clase
 *  - Qué es un objeto
 *  - Qué es una instancia
 *  - Qué es un atributo (estado del objeto)
 *  - Qué es un método (comportamiento del objeto)
 *  - Cómo se usa el operador 'new'
 *  - Cómo funcionan las referencias en Java
 *  - Cómo se modifica el estado de un objeto mediante métodos
 *  - Cómo se llama a métodos desde main
 * 
 * Autor: Bernardo
 */
public class PROG03_Ej01_CocheBasico {

    public static void main(String[] args) {

        /*
         * ================
         * CREACIÓN DE OBJETOS
         * ================
         *
         * new Coche() → crea una INSTANCIA (un objeto real) de la clase Coche.
         *
         * Coche coche1 → es una REFERENCIA, una variable que apunta al objeto.
         * La referencia NO es el objeto, solo apunta a él.
         */

        Coche coche1 = new Coche(); // Se crea el primer coche
        coche1.marca = "Citroen";   // Asignamos valores a sus atributos
        coche1.modelo = "Xsara";

        Coche coche2 = new Coche(); // Se crea el segundo coche
        coche2.marca = "BMW";
        coche2.modelo = "M3";

        /*
         * ================
         * CAMBIO DE ESTADO
         * ================
         *
         * Llamamos a métodos que modifican atributos internos del objeto.
         * Este es un concepto CLAVE del Tema 3:
         *
         * Los métodos representan el COMPORTAMIENTO del objeto.
         */

        coche1.acelerar(100);  // El coche 1 aumenta su velocidad
        coche1.frenar(35);     // Reduce velocidad, sin volverse negativa

        coche2.acelerar(90);   // El coche 2 acelera
        coche2.frenar(10);     // Frena un poco

        /*
         * ================
         * MOSTRAR ESTADO ACTUAL
         * ================
         *
         * mostrarDatos() imprime el estado completo del objeto.
         */

        coche1.mostrarDatos();
        coche2.mostrarDatos();
    }
}



// ------------------------------------------------------
//                      CLASE COCHE
// ------------------------------------------------------

/*
 * Esta es la definición de la clase.
 *
 * Una clase es un "molde" o "plantilla" para crear objetos.
 * No representa un coche real: es solo la descripción de qué ES un coche.
 */
class Coche {

    // ---------------------
    //       ATRIBUTOS
    // ---------------------
    /*
     * Los atributos representan el ESTADO del objeto.
     * Cada instancia (coche real) tendrá sus propios valores aquí.
     */
    String marca;      // Marca del coche (ej. Citroen)
    String modelo;     // Modelo del coche (ej. Xsara)
    int velocidad = 0; // Estado inicial: velocidad = 0


    // ---------------------
    //        MÉTODOS
    // ---------------------

    /**
     * Método acelerar:
     * Aumenta la velocidad del coche.
     * 
     * Concepto clave: los métodos representan COMPORTAMIENTO.
     */
    void acelerar(int cantidad) {
        velocidad += cantidad;  // Modificamos el estado del objeto
    }

    /**
     * Método frenar:
     * Reduce la velocidad, sin permitir valores negativos.
     * 
     * Aquí aplicamos lógica interna que protege el estado del objeto.
     */
    void frenar(int cantidad) {
        velocidad -= cantidad;

        // Protegemos el estado del objeto:
        if (velocidad < 0) {
            velocidad = 0;
        }
    }

    /**
     * Método mostrarDatos:
     * Muestra el estado actual del objeto por pantalla.
     * 
     * Aquí vemos cómo un objeto puede "describir" su propio estado.
     */
    void mostrarDatos() {
        System.out.println("-------------------------------");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad actual: " + velocidad + " km/h");
    }
}
