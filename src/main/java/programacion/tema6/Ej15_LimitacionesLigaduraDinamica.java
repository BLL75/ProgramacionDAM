package programacion.tema6;

import java.time.LocalDate;

/**
 * EJ15 - 5.3 Limitaciones de la ligadura dinámica.
 *
 * <p>Idea clave:</p>
 * <ul>
 *   <li>El <b>tipo de la referencia</b> limita qué métodos puedes llamar (compilación).</li>
 *   <li>El <b>tipo real del objeto</b> decide qué implementación se ejecuta (ejecución).</li>
 * </ul>
 *
 * <p>En este ejemplo:</p>
 * <ul>
 *   <li>PersonaE15 es abstracta.</li>
 *   <li>AlumnoE15 y ProfesorE15 extienden PersonaE15.</li>
 *   <li>AlumnoE15 tiene un método específico: {@code getGrupo()}</li>
 *   <li>ProfesorE15 tiene un método específico: {@code getEspecialidad()}</li>
 * </ul>
 *
 * <p>Demostramos:</p>
 * <ol>
 *   <li>Con una referencia {@code PersonaE15}, NO puedes llamar a métodos específicos de subclases.</li>
 *   <li>Cómo resolverlo si lo necesitas: {@code instanceof} + casting (downcasting) seguro.</li>
 * </ol>
 *
 * @author Bernar
 */
public class Ej15_LimitacionesLigaduraDinamica {

    public static void main(String[] args) {

        // 1) Referencia de superclase (polimorfismo)
        PersonaE15 persona;

        // Caso A: ahora apunta a un Alumno
        persona = new AlumnoE15("Juan", "Torres", LocalDate.parse("1995-03-22"), "1DAM-B");

        System.out.println("=== Caso A: persona -> AlumnoE15 ===");
        // ✅ Esto sí: métodos declarados en PersonaE15
        System.out.println("Nombre completo: " + persona.getNombreCompleto());
        System.out.println("Saludo: " + persona.saludar()); // ligadura dinámica: ejecuta el saludar de AlumnoE15

        // ❌ Esto NO compila (limitación):
        // persona.getGrupo(); // ERROR: PersonaE15 no tiene getGrupo()

        // Para acceder a métodos específicos, hay que comprobar tipo y hacer casting:
        if (persona instanceof AlumnoE15 alumno) {
            System.out.println("Grupo (solo alumno): " + alumno.getGrupo());
        }

        // Caso B: ahora apunta a un Profesor
        persona = new ProfesorE15("Antonio", "Campos", LocalDate.parse("1975-08-16"), "Electricidad");

        System.out.println("\n=== Caso B: persona -> ProfesorE15 ===");
        System.out.println("Nombre completo: " + persona.getNombreCompleto());
        System.out.println("Saludo: " + persona.saludar()); // ligadura dinámica: ejecuta el saludar de ProfesorE15

        // ❌ Esto NO compila:
        // persona.getEspecialidad(); // ERROR: PersonaE15 no tiene getEspecialidad()

        if (persona instanceof ProfesorE15 profesor) {
            System.out.println("Especialidad (solo profesor): " + profesor.getEspecialidad());
        }

        System.out.println("\n=== Ejemplo de casting MAL hecho (peligroso) ===");
        PersonaE15 p2 = new AlumnoE15("Ana", "López", LocalDate.parse("2005-03-10"), "1DAM-A");

        try {
            // ⚠️ Esto compila, pero puede fallar en ejecución si el objeto no es de ese tipo:
            ProfesorE15 profMal = (ProfesorE15) p2; // p2 es AlumnoE15 -> ClassCastException
            System.out.println(profMal.getEspecialidad());
        } catch (ClassCastException e) {
            System.out.println("Casting incorrecto: " + e);
        }

        System.out.println("\nConclusión:");
        System.out.println("- Polimorfismo + ligadura dinámica: llamas a métodos de la superclase y se ejecuta la versión real.");
        System.out.println("- Limitación: con referencia de superclase NO accedes a lo específico de la subclase.");
        System.out.println("- Si lo necesitas: instanceof + casting seguro.");
    }
}

/* =========================================================
 * SUPERCLASE ABSTRACTA
 * ========================================================= */

/**
 * PersonaE15: clase base abstracta.
 *
 * <p>Contiene lo común y define un método abstracto {@link #saludar()}.</p>
 */
abstract class PersonaE15 {

    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    public PersonaE15(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método común (existe para cualquier PersonaE15).
     */
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    /**
     * Método abstracto: cada subclase saluda de forma distinta.
     */
    public abstract String saludar();
}

/* =========================================================
 * SUBCLASE: Alumno
 * ========================================================= */

/**
 * AlumnoE15: PersonaE15 con un dato específico: grupo.
 */
class AlumnoE15 extends PersonaE15 {

    private String grupo;

    public AlumnoE15(String nombre, String apellidos, LocalDate fechaNacimiento, String grupo) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
    }

    /**
     * Método específico del alumno (NO existe en PersonaE15).
     */
    public String getGrupo() {
        return grupo;
    }

    @Override
    public String saludar() {
        return "Hola, soy el alumno " + getNombreCompleto() + " y estoy en el grupo " + grupo;
    }
}

/* =========================================================
 * SUBCLASE: Profesor
 * ========================================================= */

/**
 * ProfesorE15: PersonaE15 con un dato específico: especialidad.
 */
class ProfesorE15 extends PersonaE15 {

    private String especialidad;

    public ProfesorE15(String nombre, String apellidos, LocalDate fechaNacimiento, String especialidad) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
    }

    /**
     * Método específico del profesor (NO existe en PersonaE15).
     */
    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String saludar() {
        return "Hola, mi nombre es profesor " + getNombreCompleto() + " y soy de la especialidad " + especialidad;
    }
}
