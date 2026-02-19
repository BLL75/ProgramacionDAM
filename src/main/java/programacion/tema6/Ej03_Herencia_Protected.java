package programacion.tema6;

import java.time.LocalDate;

/**
 * Ejercicio 3.1 y 3.2:
 * - Sintaxis de herencia con extends
 * - Acceso a miembros heredados usando protected
 *
 * TODO para experimentar:
 * 1) Ejecuta tal cual (funciona).
 * 2) Cambia en Persona los atributos de protected a private y mira qué falla.
 */
public class Ej03_Herencia_Protected {

    public static void main(String[] args) {

        Alumno a = new Alumno("Ana", "López", LocalDate.of(2005, 3, 10),
                              "1DAM-A", 7.5);

        Profesor p = new Profesor("Luis", "García", LocalDate.of(1980, 8, 20),
                                  "Programación", 2100);

        System.out.println(a);
        System.out.println(p);

        // Polimorfismo: Alumno ES una Persona (referencia de tipo Persona)
        Persona ref = a;
        System.out.println("Como Persona: " + ref.getNombreCompleto());

        a.subirNota(0.5);
        p.subirSalario(150);

        System.out.println("\nTras cambios:");
        System.out.println(a);
        System.out.println(p);
    }
}

/* =========================
   SUPERCLASE (PADRE)
   ========================= */

/**
 * Clase base: Persona.
 * Contiene atributos comunes a Alumno y Profesor.
 */
class Persona {

    // PROTECTED: accesibles desde clases hijas (Alumno, Profesor)
    // y desde clases del mismo paquete.
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    @Override
    public String toString() {
        return "Persona{nombre=" + nombre + ", apellidos=" + apellidos +
               ", fechaNacimiento=" + fechaNacimiento + "}";
    }
}

/* =========================
   SUBCLASES (HIJAS)
   ========================= */

/**
 * Alumno ES una Persona => extends Persona
 */
class Alumno extends Persona {

    protected String grupo;
    protected double notaMedia;

    public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento,
                  String grupo, double notaMedia) {
        super(nombre, apellidos, fechaNacimiento); // llama al constructor del padre
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }

    public void subirNota(double puntos) {
        this.notaMedia += puntos;
    }

    @Override
    public String toString() {
        // Podemos usar nombre/apellidos heredados porque son protected en Persona
        return "Alumno{nombre=" + nombre +
               ", apellidos=" + apellidos +
               ", grupo=" + grupo +
               ", notaMedia=" + notaMedia + "}";
    }
}

/**
 * Profesor ES una Persona => extends Persona
 */
class Profesor extends Persona {

    protected String especialidad;
    protected double salario;

    public Profesor(String nombre, String apellidos, LocalDate fechaNacimiento,
                    String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public void subirSalario(double euros) {
        this.salario += euros;
    }

    @Override
    public String toString() {
        return "Profesor{nombre=" + nombre +
               ", apellidos=" + apellidos +
               ", especialidad=" + especialidad +
               ", salario=" + salario + "}";
    }
}