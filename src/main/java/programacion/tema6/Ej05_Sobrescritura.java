package programacion.tema6;

import java.time.LocalDate;

/**
 * Ej05 - 3.4 Redefinición (sobrescritura) de métodos heredados.
 *
 * Demuestra:
 * 1) @Override para sobrescribir métodos heredados.
 * 2) Uso de super para llamar al método original del padre.
 * 3) Que no se puede reducir accesibilidad al sobrescribir.
 */
public class Ej05_Sobrescritura {

    public static void main(String[] args) {

        PersonaE05 p = new PersonaE05("Pepe", "Pérez", LocalDate.of(1990, 1, 1));
        AlumnoE05 a = new AlumnoE05("Ana", "López", LocalDate.of(2005, 3, 10), "1DAM-A");
        ProfesorE05 pr = new ProfesorE05("Luis", "García", LocalDate.of(1980, 8, 20), "Programación");

        System.out.println("=== getNombre() sin sobrescritura (Persona) ===");
        System.out.println(p.getNombre());

        System.out.println("\n=== getNombre() sobrescrito (Alumno / Profesor) ===");
        System.out.println(a.getNombre());   // "Alumno: Ana"
        System.out.println(pr.getNombre());  // "Profesor: Luis"

        System.out.println("\n=== Llamada al método del padre usando super ===");
        System.out.println(a.getNombreOriginalDePersona());   // "Ana"
        System.out.println(pr.getNombreOriginalDePersona());  // "Luis"
        
        pr.setNombre("Rodolfo");
        System.out.println(pr.getNombre());
        a.setNombre("Lola");
        System.out.println(a.getNombre());
        System.out.println(a.getNombreOriginalDePersona());
        
        
    }
}

/* =========================
   SUPERCLASE
   ========================= */

class PersonaE05 {

    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    public PersonaE05(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método heredable que vamos a sobrescribir en las subclases.
     */
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}

/* =========================
   SUBCLASE: Alumno
   ========================= */

class AlumnoE05 extends PersonaE05 {

    private String grupo;

    public AlumnoE05(String nombre, String apellidos, LocalDate fechaNacimiento, String grupo) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
    }

    /**
     * Sobrescritura: cambia el comportamiento del método heredado.
     * IMPORTANTE: misma firma (nombre, parámetros y tipo de retorno).
     */
    @Override
    public String getNombre() {
        return "Alumno: " + this.nombre;
    }

    /**
     * Demostración de super:
     * llama al método ORIGINAL de PersonaE05 (sin el prefijo "Alumno: ").
     */
    public String getNombreOriginalDePersona() {
        return super.getNombre();
    }
}

/* =========================
   SUBCLASE: Profesor
   ========================= */

class ProfesorE05 extends PersonaE05 {

    private String especialidad;

    public ProfesorE05(String nombre, String apellidos, LocalDate fechaNacimiento, String especialidad) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
    }

    @Override
    public String getNombre() {
        return "Profesor: " + this.nombre;
    }

    public String getNombreOriginalDePersona() {
        return super.getNombre();
    }
}