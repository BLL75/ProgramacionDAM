package programacion.tema6;

import java.time.LocalDate;

/**
 * EJ11 - 4.1 Declaración de una clase abstracta.
 *
 * <p>Este ejercicio demuestra:</p>
 * <ul>
 *   <li>Una clase abstracta NO se puede instanciar con {@code new}.</li>
 *   <li>Una clase abstracta puede tener métodos normales (implementados) y métodos abstractos.</li>
 *   <li>Las subclases (concretas) sí pueden instanciarse y deben implementar métodos abstractos.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej11_ClasesAbstractas_Tema41 {

    public static void main(String[] args) {

        System.out.println("=== A) Persona abstracta ===");

        // ❌ NO compila (PersonaE11 es abstract):
        // PersonaE11 p = new PersonaE11("Pepe", "Pérez", LocalDate.of(1990, 1, 1));

        AlumnoE11 a = new AlumnoE11("Ana", "López", LocalDate.of(2005, 3, 10), "1DAM-A");
        ProfesorE11 pr = new ProfesorE11("Luis", "García", LocalDate.of(1980, 8, 20), "Programación");

        // ✅ Polimorfismo: referencia de tipo abstracto apuntando a objetos concretos
        PersonaE11 refA = a;
        PersonaE11 refP = pr;

        // Método normal (ya implementado en la abstracta)
        System.out.println(refA.presentacionBasica());
        System.out.println(refP.presentacionBasica());

        // Método abstracto (implementado por las hijas)
        System.out.println(refA.identificacion());
        System.out.println(refP.identificacion());

        System.out.println("\n=== B) Dispositivo abstracto ===");

        // ❌ NO compila (DispositivoE11 es abstract):
        // DispositivoE11 d = new DispositivoE11(1, "genérico", 1);

        BombillaE11 b = new BombillaE11(1, "bombilla salón", 2);
        CerraduraE11 c = new CerraduraE11(3, "cerradura puerta", 1, false);

        // ✅ Array de la superclase abstracta (polimorfismo)
        DispositivoE11[] dispositivos = { b, c };

        for (DispositivoE11 d : dispositivos) {
            System.out.println(d);              // usa toString heredado/extendido
            System.out.println(d.resumen());    // método normal heredado
        }
    }
}

/* =========================================================
 * A) JERARQUÍA Persona
 * ========================================================= */

/**
 * PersonaE11 (abstract):
 * - NO instanciable
 * - Sirve como modelo genérico para AlumnoE11 y ProfesorE11
 */
abstract class PersonaE11 {

    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    /**
     * Constructor de clase abstracta:
     * sí existe y se llama desde las subclases con super(...).
     */
    public PersonaE11(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método NORMAL (implementado): se hereda tal cual.
     */
    public String presentacionBasica() {
        return nombre + " " + apellidos + " (" + fechaNacimiento + ")";
    }

    /**
     * Método ABSTRACTO: obliga a las subclases a implementarlo.
     */
    public abstract String identificacion();
}

/** Subclase concreta: sí instanciable */
class AlumnoE11 extends PersonaE11 {

    private String grupo;

    public AlumnoE11(String nombre, String apellidos, LocalDate fechaNacimiento, String grupo) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
    }

    @Override
    public String identificacion() {
        return "Alumno: " + nombre + " " + apellidos + " | Grupo: " + grupo;
    }
}

/** Subclase concreta: sí instanciable */
class ProfesorE11 extends PersonaE11 {

    private String especialidad;

    public ProfesorE11(String nombre, String apellidos, LocalDate fechaNacimiento, String especialidad) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
    }

    @Override
    public String identificacion() {
        return "Profesor: " + nombre + " " + apellidos + " | Especialidad: " + especialidad;
    }
}

/* =========================================================
 * B) JERARQUÍA Dispositivo
 * ========================================================= */

/**
 * DispositivoE11 (abstract):
 * - NO instanciable
 * - Contiene atributos comunes a BombillaE11 y CerraduraE11
 */
abstract class DispositivoE11 {

    protected final int id;
    protected final String descripcion;
    protected int ubicacion;

    public DispositivoE11(int id, String descripcion, int ubicacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /**
     * Método NORMAL (implementado): se hereda por las subclases.
     */
    public String resumen() {
        return "Dispositivo #" + id + " en estancia " + ubicacion;
    }

    @Override
    public String toString() {
        return String.format("tipo:%s id:%d descripción:\"%s\" ubicacion:%d",
                getClass().getSimpleName(), id, descripcion, ubicacion);
    }
}

/** Subclase concreta: sí instanciable */
final class BombillaE11 extends DispositivoE11 {

    private int intensidad;

    public BombillaE11(int id, String descripcion, int ubicacion) {
        super(id, descripcion, ubicacion);
        this.intensidad = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " int:" + intensidad;
    }
}

/** Subclase concreta: sí instanciable */
final class CerraduraE11 extends DispositivoE11 {

    private boolean cerrada;

    public CerraduraE11(int id, String descripcion, int ubicacion, boolean cerrada) {
        super(id, descripcion, ubicacion);
        this.cerrada = cerrada;
    }

    @Override
    public String toString() {
        return super.toString() + " estado:" + (cerrada ? "cerrada" : "abierta");
    }
}