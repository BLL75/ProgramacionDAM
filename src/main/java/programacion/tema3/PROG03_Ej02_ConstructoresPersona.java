package programacion.tema3;

/**
 * PROG03_Ej02_ConstructoresPersona
 *
 * Ejercicio que demuestra:
 *  - Uso de constructores
 *  - Sobrecarga
 *  - Inicialización de objetos
 *  - Referencias y estado de un objeto
 * 
 * Autor: Bernardo
 */
public class PROG03_Ej02_ConstructoresPersona {
    
    public static void main(String[] args) {

        /*
         * 1) Crear persona con constructor VACÍO
         *    Esta persona tendrá valores por defecto.
         */
        Persona persona1 = new Persona();


        /*
         * 2) Crear persona con constructor con parámetros
         *    Aquí pasamos los valores directamente al instanciar.
         */
        Persona persona2 = new Persona("David", 33, "Salamanca");


        /*
         * 3) Crear persona con constructor vacío y luego modificar atributos
         *    Esto demuestra que el estado del objeto puede cambiar después.
         */
        Persona persona3 = new Persona();
        persona3.nombre = "Carlos";
        persona3.edad = 33;
        persona3.ciudad = "Valencia";


        // Mostrar los datos de las 3 personas
        persona1.mostrarDatos();
        persona2.mostrarDatos();
        persona3.mostrarDatos();
    }
}


// ------------------------------------------------------
//                     CLASE PERSONA
// ------------------------------------------------------

class Persona{
    
    // ---------------------
    //       ATRIBUTOS
    // ---------------------
    String nombre;
    int edad;
    String ciudad;
    
    // ---------------------
    //   CONSTRUCTOR 1 (vacío)
    // ---------------------
    Persona() {
        nombre = "Sin nombre";
        edad = 0;
        ciudad = "Desconocida";
    }
    
    // ---------------------
    //   CONSTRUCTOR 2 (con parámetros)
    // ---------------------
    Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }
    
    // ---------------------
    //    MÉTODO mostrarDatos
    // ---------------------
    void mostrarDatos() {
        System.out.println("------------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
    }
}
