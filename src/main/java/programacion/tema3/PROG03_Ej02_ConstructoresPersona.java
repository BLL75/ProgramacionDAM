package programacion.tema3;

/**
 * PROG03_Ej02_ConstructoresPersona
 *
 * Este archivo explica y demuestra de forma práctica los conceptos más
 * importantes del Tema 3 de Programación:
 *
 * 1. El código ejecutable SOLO puede estar dentro de métodos.
 * 2. Una clase (fuera de métodos) NO ejecuta código, solo declara.
 * 3. Diferencias entre declarar atributos, crear instancias y llamar a métodos.
 * 4. Sobrecarga de constructores.
 * 5. Inicialización con valores por defecto (constructor vacío).
 * 6. Inicialización personalizada (constructor con parámetros).
 * 7. El estado del objeto y cómo cambia.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej02_ConstructoresPersona {

    /**
     * El método main() es el PUNTO DE ENTRADA del programa.
     * 
     * Todo el código que se "ejecuta" debe estar DENTRO de un método.
     * Java NO permite ejecutar líneas sueltas fuera de un método.
     */
    public static void main(String[] args) {

        // ================================================================
        // 1. CREAR OBJETO USANDO EL CONSTRUCTOR VACÍO
        // ================================================================
        /*
         * Aquí usamos: new Persona()
         * 
         * Esto llama al constructor vacío, que asigna:
         * nombre = "Sin nombre"
         * edad = 0
         * ciudad = "Desconocida"
         * 
         * Estamos creando una INSTANCIA (un objeto real) de la clase Persona.
         */
        Persona persona1 = new Persona();



        // ================================================================
        // 2. CREAR OBJETO CON EL CONSTRUCTOR CON PARÁMETROS
        // ================================================================
        /*
         * Aquí estamos usando la SOBRECARGA DE CONSTRUCTORES.
         * La clase Persona tiene DOS constructores definidos.
         *
         * Este segundo constructor recibe:
         *   (String nombre, int edad, String ciudad)
         * 
         * Gracias a esto, podemos crear un objeto con valores personalizados
         * en el momento de la instanciación.
         */
        Persona persona2 = new Persona("David", 33, "Salamanca");



        // ================================================================
        // 3. CREAR OBJETO, Y LUEGO MODIFICAR SU ESTADO
        // ================================================================
        /*
         * Aquí demostramos que:
         *  - El constructor inicializa el objeto.
         *  - PERO el estado (atributos) puede cambiar después de la creación.
         *
         * Estamos manipulando DIRECTAMENTE los atributos del objeto.
         */
        Persona persona3 = new Persona();
        persona3.nombre = "Carlos";      // Estado modificado después de creado
        persona3.edad = 33;
        persona3.ciudad = "Valencia";



        // ================================================================
        // 4. LLAMAR A MÉTODOS
        // ================================================================
        /*
         * mostrarDatos() es un MÉTODO DE INSTANCIA.
         * 
         * Llamarlo implica que el objeto "hace algo":
         * en este caso, mostrar su estado actual.
         */
        persona1.mostrarDatos();
        persona2.mostrarDatos();
        persona3.mostrarDatos();
    }
}



// ===================================================================================
//                                      CLASE PERSONA
// ===================================================================================

/*
 * Una clase define:
 *   - Atributos → representan el estado del objeto.
 *   - Métodos → representan el comportamiento.
 *   - Constructores → inicializan el objeto en el momento de su creación.
 */
class Persona {

    // -----------------------------------------------------------------------
    // 1. DECLARACIÓN DE ATRIBUTOS (NO EJECUTABLE)
    // -----------------------------------------------------------------------
    /*
     * Estos son atributos, NO código ejecutable.
     * 
     * Aquí NO podemos escribir:
     *   ciudad = "algo";
     *   edad = leerTeclado();
     * 
     * Solo podemos declarar o asignar un valor simple.
     */
    String nombre;
    int edad;
    String ciudad;



    // -----------------------------------------------------------------------
    // 2. CONSTRUCTOR VACÍO (INICIALIZACIÓN POR DEFECTO)
    // -----------------------------------------------------------------------
    /*
     * Este constructor se usa cuando hacemos: new Persona()
     *
     * Aquí definimos el ESTADO INICIAL por defecto del objeto.
     */
    Persona() {
        nombre = "Sin nombre";
        edad = 0;
        ciudad = "Desconocida";
    }



    // -----------------------------------------------------------------------
    // 3. CONSTRUCTOR CON PARÁMETROS (INICIALIZACIÓN PERSONALIZADA)
    // -----------------------------------------------------------------------
    /*
     * Sobrecarga de constructores:
     *
     * Dos constructores con distinta "firma":
     *    Persona()
     *    Persona(String nombre, int edad, String ciudad)
     *
     * El uso de 'this' es fundamental para diferenciar:
     *  - Atributos del objeto → this.nombre
     *  - Parámetros del constructor → nombre
     */
    Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }



    // -----------------------------------------------------------------------
    // 4. MÉTODO mostrarDatos()
    // -----------------------------------------------------------------------
    /*
     * Este método NO devuelve nada (void)
     * y simplemente muestra el ESTADO ACTUAL del objeto.
     *
     * Aquí vemos cómo los atributos representan el estado REAL de una instancia.
     */
    void mostrarDatos() {
        System.out.println("------------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
    }
}
