package programacion.tema6;

import java.time.LocalDate;

public class Ej04_MiembrosHeredados {

    public static void main(String[] args) {

        AlumnoE04 alumno = new AlumnoE04(
                "Diosdado",
                "Torres Ramos",
                LocalDate.of(2004, 6, 15),
                "1DAW-B",
                7.314
        );

        System.out.println("=== Alumno ===");
        System.out.println(alumno.toStringPresentacion());
        System.out.println(alumno);

        alumno.setNombre("Ana");
        alumno.setApellidos("López Pérez");
        alumno.setFechaNacimiento(LocalDate.of(2005, 3, 10));

        alumno.setGrupo("1DAM-A");
        alumno.setNotaMedia(8.0);

        System.out.println("\n=== Alumno tras cambios ===");
        System.out.println(alumno.toStringPresentacion());
        System.out.println(alumno);

        ProfesorE04 profesor = new ProfesorE04(
                "Luis",
                "García",
                LocalDate.of(1980, 8, 20),
                "Programación",
                2100
        );

        System.out.println("\n=== Profesor ===");
        System.out.println(profesor);

        profesor.setEspecialidad("Bases de Datos");
        profesor.setSalario(2250);

        System.out.println("\n=== Profesor tras cambios ===");
        System.out.println(profesor);
    }
}

/* ===== SUPERCLASE ===== */

class PersonaE04 {

    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    public PersonaE04(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}

/* ===== SUBCLASES ===== */

class AlumnoE04 extends PersonaE04 {

    protected String grupo;
    protected double notaMedia;

    public AlumnoE04(String nombre, String apellidos, LocalDate fechaNacimiento,
                     String grupo, double notaMedia) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }

    public String toStringPresentacion() {
        return String.format(
                "El alumno %s %s del grupo %s tiene una nota media de %.2f",
                this.nombre,
                this.apellidos,
                this.grupo,
                this.notaMedia
        );
    }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    public double getNotaMedia() { return notaMedia; }
    public void setNotaMedia(double notaMedia) { this.notaMedia = notaMedia; }

    @Override
    public String toString() {
        return "Alumno{nombre=" + nombre +
                ", apellidos=" + apellidos +
                ", fechaNacimiento=" + fechaNacimiento +
                ", grupo=" + grupo +
                ", notaMedia=" + String.format("%.2f", notaMedia) + "}";
    }
}

class ProfesorE04 extends PersonaE04 {

    protected String especialidad;
    protected double salario;

    public ProfesorE04(String nombre, String apellidos, LocalDate fechaNacimiento,
                       String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return "Profesor{nombre=" + nombre +
                ", apellidos=" + apellidos +
                ", fechaNacimiento=" + fechaNacimiento +
                ", especialidad=" + especialidad +
                ", salario=" + String.format("%.2f", salario) + "}";
    }
}