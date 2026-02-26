package programacion.tema6;

import java.time.LocalDate;

/**
 * EJ10 - 4.1 Declaración de una clase abstracta.
 *
 * - Una clase abstracta NO se puede instanciar con new.
 * - Puede tener métodos normales (implementados) y métodos abstractos (sin implementar).
 * - Las subclases deben implementar los métodos abstractos.
 *
 * @author Bernar
 */
public class Ej10_ClasesAbstracta {

    public static void main(String[] args) {

        // ❌ Esto NO compila (PersonaE10 es abstract):
        // PersonaE10 p = new PersonaE10("Pepe", "Pérez", LocalDate.of(1990, 1, 1));

        AlumnoE10 a = new AlumnoE10("Ana", "López", LocalDate.of(2005, 3, 10), "1DAM-A", 7.8);
        ProfesorE10 pr = new ProfesorE10("Luis", "García", LocalDate.of(1980, 8, 20), "Programación", 2100);

        // ✅ Polimorfismo: referencia de tipo abstracto apuntando a objetos concretos
        PersonaE10 ref1 = a;
        PersonaE10 ref2 = pr;

        System.out.println("=== Presentación (método normal heredado) ===");
        System.out.println(ref1.presentacionBasica());
        System.out.println(ref2.presentacionBasica());

        System.out.println("\n=== Identificación (método abstracto implementado por hijas) ===");
        System.out.println(ref1.identificacion()); // ejecuta el de AlumnoE10
        System.out.println(ref2.identificacion()); // ejecuta el de ProfesorE10
    }
}

/* =========================================================
 * SUPERCLASE ABSTRACTA
 * ========================================================= */

/**
 * PersonaE10 es una clase abstracta:
 * - No se puede instanciar con new.
 * - Sirve como "molde" para que otras clases hereden de ella.
 *
 * Puede contener:
 * - Métodos normales (con implementación)
 * - Métodos abstractos (sin implementación) que obligan a las subclases a implementarlos
 */
abstract class PersonaE10 {

    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    /**
     * Aunque sea abstracta, puede tener constructor.
     * Se usa cuando las subclases llaman a super(...).
     */
    public PersonaE10(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método NORMAL (no abstract): ya está implementado y se hereda.
     */
    public String presentacionBasica() {
        return nombre + " " + apellidos + " (" + fechaNacimiento + ")";
    }

    /**
     * Método ABSTRACTO: no tiene cuerpo.
     * Las subclases están obligadas a implementarlo (o también ser abstractas).
     */
    public abstract String identificacion();
}

/* =========================================================
 * SUBCLASE: AlumnoE10
 * ========================================================= */

/**
 * AlumnoE10 es una clase concreta (instanciable) que extiende PersonaE10.
 */
class AlumnoE10 extends PersonaE10 {

    private String grupo;
    private double notaMedia;

    public AlumnoE10(String nombre, String apellidos, LocalDate fechaNacimiento,
                     String grupo, double notaMedia) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }

    /**
     * Implementación obligatoria del método abstracto.
     */
    @Override
    public String identificacion() {
        return "Alumno: " + nombre + " " + apellidos
                + " | Grupo: " + grupo
                + " | Nota: " + String.format("%.2f", notaMedia);
    }
}

/* =========================================================
 * SUBCLASE: ProfesorE10
 * ========================================================= */

/**
 * ProfesorE10 es una clase concreta (instanciable) que extiende PersonaE10.
 */
class ProfesorE10 extends PersonaE10 {

    private String especialidad;
    private double salario;

    public ProfesorE10(String nombre, String apellidos, LocalDate fechaNacimiento,
                       String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.salario = salario;
    }

    /**
     * Implementación obligatoria del método abstracto.
     */
    @Override
    public String identificacion() {
        return "Profesor: " + nombre + " " + apellidos
                + " | Especialidad: " + especialidad
                + " | Salario: " + String.format("%.2f", salario);
    }
}