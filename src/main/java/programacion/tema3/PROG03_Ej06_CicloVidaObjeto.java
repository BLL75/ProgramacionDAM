package programacion.tema3;

/**
 * PROG03_Ej06_CicloVidaObjeto
 *
 * Este ejercicio explica COMPLETAMENTE el ciclo de vida de un objeto en Java:
 *
 * 1. Creación del objeto con 'new'
 * 2. Varios alias o referencias apuntan al mismo objeto
 * 3. Pérdida de referencias (asignar null)
 * 4. Objeto inaccesible → candidato a GC (Garbage Collector)
 *
 * Autor: Bernardo Luque
 */
public class PROG03_Ej06_CicloVidaObjeto {

    public static void main(String[] args) {

        // ===============================================================
        // 1. CREACIÓN DEL OBJETO
        // ===============================================================
        /*
         * new ObjetoDemo("Primer objeto") crea un objeto REAL en memoria.
         * obj1 almacena una REFERENCIA a ese objeto.
         */
        ObjetoDemo obj1 = new ObjetoDemo("Primer objeto");

        // Mostramos el nombre usando obj1
        obj1.mostrar();


        // ===============================================================
        // 2. OTRA REFERENCIA APUNTA AL MISMO OBJETO
        // ===============================================================
        /*
         * obj2 = obj1 NO crea otro objeto.
         * Ahora ambos apuntan al MISMO objeto.
         *
         *   obj1 ----> [ObjetoDemo]
         *   obj2 ----> [Mismo ObjetoDemo]
         */
        ObjetoDemo obj2 = obj1;

        obj2.mostrar(); // muestra el mismo nombre


        // ===============================================================
        // 3. PERDEMOS LA REFERENCIA obj1
        // ===============================================================
        /*
         * obj1 ya NO apunta al objeto.
         * Pero obj2 sigue apuntando, así que el objeto sigue “vivo”.
         */
        obj1 = null;

        // Aun así, podemos acceder al objeto:
        obj2.mostrar();


        // ===============================================================
        // 4. PERDEMOS TAMBIÉN LA ÚLTIMA REFERENCIA
        // ===============================================================
        /*
         * Ahora el objeto queda SIN REFERENCIAS.
         * Es imposible acceder a él desde el programa.
         */
        obj2 = null;

        /*
         * En este punto el objeto está “muerto” para el programa:
         * ya no hay variables que lo referencien.
         *
         * El Garbage Collector LO ELIMINARÁ cuando lo considere oportuno.
         */


        // ===============================================================
        // 5. INVOCAR AL GC (no es instantáneo)
        // ===============================================================
        /*
         * Esto NO garantiza su ejecución inmediata,
         * pero el temario exige demostrar su uso.
         */
        System.gc();

        System.out.println("Fin del programa. El objeto quedó sin referencias.");
    }
}



// ----------------------------------------------------------
//                CLASE OBJETODEMO
// ----------------------------------------------------------

/**
 * Clase simple para demostrar el ciclo de vida de un objeto.
 */
class ObjetoDemo {

    String nombre;

    ObjetoDemo(String nombre) {
        this.nombre = nombre;
    }

    void mostrar() {
        System.out.println("Objeto con nombre: " + nombre);
    }
}
