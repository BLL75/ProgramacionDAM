package programacion.tema6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * EJ06 - Ampliación de métodos heredados (Tema 3.5).
 *
 * <p>Idea clave del apartado 3.5:</p>
 * <ul>
 *   <li>Una subclase puede <b>sobrescribir</b> un método heredado y, en vez de sustituirlo por completo,
 *       <b>ampliarlo</b>.</li>
 *   <li>Para ampliar, se reutiliza lo que hace la superclase llamando a <b>super.metodo()</b> y luego se añade
 *       el comportamiento extra.</li>
 * </ul>
 *
 * <p>En este ejercicio ampliamos {@code toString()}:</p>
 * <ul>
 *   <li>{@link PersonaE06} imprime los datos comunes: nombre, apellidos y fecha.</li>
 *   <li>{@link AlumnoE06} y {@link ProfesorE06} amplían ese {@code toString()} añadiendo sus datos específicos.</li>
 * </ul>
 *
 * <p>💡 Nota de estudio:</p>
 * <ul>
 *   <li>{@code super} es una referencia a la <b>superclase</b> (padre) desde el contexto de la subclase.</li>
 *   <li>Así evitamos <b>duplicar código</b> (reutilización real con herencia).</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej06_AmpliacionConSuper {

    /**
     * Punto de entrada del programa.
     * <p>
     * Creamos una {@link PersonaE06}, un {@link AlumnoE06} y un {@link ProfesorE06} y mostramos
     * su contenido con {@code System.out.println(objeto)}.
     * </p>
     *
     * <p>Recuerda: {@code println(objeto)} llama automáticamente a {@code objeto.toString()}.</p>
     *
     * @param args argumentos por línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        System.out.println("=== Persona ===");
        PersonaE06 p = new PersonaE06("Pepe", "Pérez", LocalDate.of(1990, 1, 1));
        System.out.println(p);

        System.out.println("\n=== Alumno (amplía toString de Persona) ===");
        AlumnoE06 a = new AlumnoE06(
                "Diosdado",
                "Torres Ramos",
                LocalDate.of(2004, 6, 15),
                "1DAW-B",
                7.314
        );
        System.out.println(a);

        System.out.println("\n=== Profesor (amplía toString de Persona) ===");
        ProfesorE06 pr = new ProfesorE06(
                "Luis",
                "García",
                LocalDate.of(1980, 8, 20),
                "Programación",
                2100
        );
        System.out.println(pr);
    }
}

/* =========================================================
 * SUPERCLASE
 * ========================================================= */

/**
 * Superclase {@code PersonaE06}.
 *
 * <p>Contiene la información común a cualquier persona:</p>
 * <ul>
 *   <li>nombre</li>
 *   <li>apellidos</li>
 *   <li>fecha de nacimiento</li>
 * </ul>
 *
 * <p>Además define un {@link #toString()} "base" (genérico) que las subclases reutilizarán
 * mediante {@code super.toString()}.</p>
 */
class PersonaE06 {

    /**
     * Atributos protegidos (protected):
     * <ul>
     *   <li>Son accesibles desde esta clase.</li>
     *   <li>También desde sus subclases (AlumnoE06, ProfesorE06).</li>
     * </ul>
     * En el temario se usa mucho para practicar herencia.
     */
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    /**
     * Formateador para la fecha en el formato del temario: dd/MM/yyyy.
     * <p>Es {@code static final} porque:</p>
     * <ul>
     *   <li>No cambia (final).</li>
     *   <li>Se comparte por todos los objetos (static).</li>
     * </ul>
     */
    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor de Persona.
     *
     * @param nombre nombre de la persona
     * @param apellidos apellidos de la persona
     * @param fechaNacimiento fecha de nacimiento
     */
    public PersonaE06(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Representación textual (base) del contenido de una Persona.
     * <p>
     * Las subclases pueden:
     * <ul>
     *   <li>sobrescribirlo para cambiarlo</li>
     *   <li>o sobrescribirlo para <b>ampliarlo</b> llamando a {@code super.toString()}</li>
     * </ul>
     * </p>
     *
     * @return String con la información básica de la persona
     */
    @Override
    public String toString() {
        return String.format(
                "Nombre: %s%nApellidos: %s%nFecha de nacimiento: %s",
                nombre,
                apellidos,
                fechaNacimiento.format(FORMATO_FECHA)
        );
    }
}

/* =========================================================
 * SUBCLASE: Alumno (amplía toString)
 * ========================================================= */

/**
 * Subclase {@code AlumnoE06} que hereda de {@link PersonaE06}.
 *
 * <p>Añade información específica:</p>
 * <ul>
 *   <li>grupo</li>
 *   <li>nota media</li>
 * </ul>
 *
 * <p>Su {@code toString()} <b>amplía</b> el de {@code PersonaE06} usando {@code super.toString()}.</p>
 */
class AlumnoE06 extends PersonaE06 {

    /** Grupo del alumno (por ejemplo "1DAW-B"). */
    private String grupo;

    /** Nota media del alumno. */
    private double notaMedia;

    /**
     * Constructor de Alumno.
     *
     * <p>Fíjate en {@code super(...)}:</p>
     * <ul>
     *   <li>Primero se inicializa la parte de Persona (nombre, apellidos, fecha).</li>
     *   <li>Luego se inicializa lo propio de Alumno (grupo, notaMedia).</li>
     * </ul>
     *
     * @param nombre nombre del alumno
     * @param apellidos apellidos del alumno
     * @param fechaNacimiento fecha de nacimiento del alumno
     * @param grupo grupo del alumno
     * @param notaMedia nota media del alumno
     */
    public AlumnoE06(String nombre, String apellidos, LocalDate fechaNacimiento,
                     String grupo, double notaMedia) {
        super(nombre, apellidos, fechaNacimiento); // constructor del padre
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }

    /**
     * {@inheritDoc}
     *
     * <p>AMPLIACIÓN (no sustitución completa):</p>
     * <ol>
     *   <li>Reutilizamos lo que devuelve el {@code toString()} del padre con {@code super.toString()}.</li>
     *   <li>Añadimos los datos propios del alumno.</li>
     * </ol>
     *
     * @return String con datos de Persona + datos específicos de Alumno
     */
    @Override
    public String toString() {
        return String.format(
                "%s%nGrupo: %s%nNota media: %.2f",
                super.toString(), // 👈 parte común (Persona)
                grupo,            // 👈 parte específica
                notaMedia         // 👈 parte específica formateada
        );
    }
}

/* =========================================================
 * SUBCLASE: Profesor (amplía toString)
 * ========================================================= */

/**
 * Subclase {@code ProfesorE06} que hereda de {@link PersonaE06}.
 *
 * <p>Añade información específica:</p>
 * <ul>
 *   <li>especialidad</li>
 *   <li>salario</li>
 * </ul>
 *
 * <p>Su {@code toString()} también <b>amplía</b> el del padre usando {@code super.toString()}.</p>
 */
class ProfesorE06 extends PersonaE06 {

    /** Especialidad del profesor (por ejemplo "Programación"). */
    private String especialidad;

    /** Salario del profesor. */
    private double salario;

    /**
     * Constructor de Profesor.
     *
     * @param nombre nombre del profesor
     * @param apellidos apellidos del profesor
     * @param fechaNacimiento fecha de nacimiento del profesor
     * @param especialidad especialidad del profesor
     * @param salario salario del profesor
     */
    public ProfesorE06(String nombre, String apellidos, LocalDate fechaNacimiento,
                       String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.salario = salario;
    }

    /**
     * {@inheritDoc}
     *
     * <p>AMPLIACIÓN del método heredado:</p>
     * <ul>
     *   <li>Primero: {@code super.toString()} (parte común).</li>
     *   <li>Después: añadimos especialidad y salario.</li>
     * </ul>
     *
     * <p>Formato pedido en temario: salario con anchura 7 y 2 decimales: {@code %7.2f}</p>
     *
     * @return String con datos de Persona + datos específicos de Profesor
     */
    @Override
    public String toString() {
        return String.format(
                "%s%nEspecialidad: %s%nSalario: %7.2f euros",
                super.toString(),
                especialidad,
                salario
        );
    }
}