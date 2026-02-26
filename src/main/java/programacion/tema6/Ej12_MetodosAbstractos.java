package programacion.tema6;

import java.time.LocalDate;

/**
 * EJ12 - 4.2 Métodos abstractos
 *
 * <p>Este ejercicio contiene 2 mini-ejercicios del temario:</p>
 * <ol>
 *   <li><b>PersonaE12</b> (abstract) con método abstracto {@code saludar()}.</li>
 *   <li><b>PiezaAjedrezE12</b> (abstract) con lógica común en {@code mover()} y parte genérica en {@code esMovible()}.
 *       Las piezas concretas (TorreE12, ReyE12) implementan/sobrescriben su movimiento específico.</li>
 * </ol>
 *
 * <p>Ideas clave:</p>
 * <ul>
 *   <li>Un método abstracto es una "deuda": obliga a las subclases concretas a implementarlo.</li>
 *   <li>Una clase con algún método abstracto debe ser abstracta.</li>
 *   <li>Los métodos abstractos NO pueden ser {@code private} ni {@code static}.</li>
 *   <li>La clase abstracta puede tener métodos normales (ya implementados) para reutilizar código.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej12_MetodosAbstractos {

    public static void main(String[] args) {

        System.out.println("========== A) Persona + método abstracto saludar() ==========");

        PersonaE12 alumno = new AlumnoE12("Juan", "Torres", LocalDate.parse("1995-03-22"), "1DAM-B", 7.5);
        PersonaE12 profesor = new ProfesorE12("Antonio", "Campos", LocalDate.parse("1975-08-16"), "Electricidad", 2000);

        // Polimorfismo: la referencia es PersonaE12 (abstract), pero el objeto real es Alumno/Profesor
        System.out.println(alumno.saludar());
        System.out.println(profesor.saludar());

        System.out.println("\n========== B) Ajedrez: método mover() común + esMovible() especializado ==========");

        // Creamos piezas concretas (la clase base es abstracta, NO se puede instanciar)
        PiezaAjedrezE12 torre = new TorreE12("blanco", 1, 1);
        PiezaAjedrezE12 rey = new ReyE12("negro", 4, 4);

        System.out.println("Inicial torre: " + torre);
        System.out.println("Inicial rey:   " + rey);

        // Movimientos válidos
        torre.mover(1, 8); // horizontal
        rey.mover(5, 5);   // diagonal 1 casilla

        System.out.println("\nTras movimientos válidos:");
        System.out.println("Torre: " + torre);
        System.out.println("Rey:   " + rey);

        // Movimientos no válidos (lanzan excepción)
        System.out.println("\nMovimientos NO válidos (esperamos excepciones):");
        try {
            torre.mover(2, 7); // diagonal (no permitido para torre)
        } catch (IllegalStateException e) {
            System.out.println("Error torre: " + e.getMessage());
        }

        try {
            rey.mover(8, 8); // demasiado lejos para un rey
        } catch (IllegalStateException e) {
            System.out.println("Error rey: " + e.getMessage());
        }
    }
}

/* =========================================================
 * A) JERARQUÍA Persona: método abstracto saludar()
 * ========================================================= */

/**
 * PersonaE12: clase abstracta.
 *
 * <p>Contiene atributos comunes y un método abstracto {@link #saludar()}.</p>
 * <p>Ese método es una "deuda": obliga a AlumnoE12/ProfesorE12 a implementarlo.</p>
 */
abstract class PersonaE12 {

    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    public PersonaE12(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método abstracto: no tiene cuerpo.
     * <p>Las clases hijas concretas lo deben implementar.</p>
     *
     * @return saludo específico según el tipo de persona
     */
    public abstract String saludar();
}

/**
 * AlumnoE12: implementa el método abstracto saludar().
 */
class AlumnoE12 extends PersonaE12 {

    private String grupo;
    private double notaMedia;

    public AlumnoE12(String nombre, String apellidos, LocalDate fechaNacimiento,
                     String grupo, double notaMedia) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }

    /**
     * Implementación del método abstracto.
     */
    @Override
    public String saludar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hola, soy el alumno ")
          .append(this.nombre).append(" ")
          .append(this.apellidos)
          .append(" y estoy en el grupo ")
          .append(this.grupo);
        return sb.toString();
    }
}

/**
 * ProfesorE12: implementa el método abstracto saludar().
 */
class ProfesorE12 extends PersonaE12 {

    private String especialidad;
    private double salario;

    public ProfesorE12(String nombre, String apellidos, LocalDate fechaNacimiento,
                       String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.salario = salario;
    }

    /**
     * Implementación del método abstracto.
     */
    @Override
    public String saludar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hola, mi nombre es profesor ")
          .append(this.nombre).append(" ")
          .append(this.apellidos)
          .append(" y soy de la especialidad de ")
          .append(this.especialidad);
        return sb.toString();
    }
}

/* =========================================================
 * B) AJEDREZ: método mover común + esMovible con super
 * ========================================================= */

/**
 * PiezaAjedrezE12: clase abstracta para piezas del ajedrez.
 *
 * <p>Atributos:</p>
 * <ul>
 *   <li>{@code color}: inmutable ("BLANCO"/"NEGRO")</li>
 *   <li>{@code fila} y {@code columna}: mutables (1..8) y accesibles por hijas (protected)</li>
 * </ul>
 *
 * <p>Diseño (la mejora del temario):</p>
 * <ul>
 *   <li>{@link #mover(int, int)} es <b>común</b>: el mismo para todas las piezas.</li>
 *   <li>{@link #esMovible(int, int)} contiene una parte <b>genérica</b> (no salir del tablero, moverse de verdad).</li>
 *   <li>Las piezas concretas (TorreE12, ReyE12) sobrescriben {@code esMovible} y llaman a {@code super.esMovible(...)}
 *       para reutilizar las comprobaciones genéricas.</li>
 * </ul>
 */
abstract class PiezaAjedrezE12 {

    private final String color; // "BLANCO" o "NEGRO"
    protected int fila;
    protected int columna;

    /**
     * Constructor con validación.
     *
     * @param color "blanco" o "negro" (case-insensitive)
     * @param fila 1..8
     * @param columna 1..8
     * @throws IllegalArgumentException si algún dato es inválido
     */
    public PiezaAjedrezE12(String color, int fila, int columna) {
        String msgError = null;

        if (!"blanco".equalsIgnoreCase(color) && !"negro".equalsIgnoreCase(color)) {
            msgError = String.format("Color incorrecto: %s", color);
        } else if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
            msgError = String.format("Ubicación incorrecta: (%d, %d)", fila, columna);
        }

        if (msgError != null) {
            throw new IllegalArgumentException(msgError);
        }

        this.color = color.toUpperCase();
        this.fila = fila;
        this.columna = columna;
    }

    public String getColor() { return color; }
    public int getFila() { return fila; }
    public int getColumna() { return columna; }

    /**
     * Movimiento genérico (común para todas las piezas).
     *
     * <p>La regla es:</p>
     * <ul>
     *   <li>Si {@code esMovible(...)} dice que no, lanzamos excepción.</li>
     *   <li>Si sí, actualizamos fila/columna.</li>
     * </ul>
     *
     * <p>Esto evita duplicar este método en Torre, Rey, etc.</p>
     *
     * @param fila destino
     * @param columna destino
     * @throws IllegalStateException si el movimiento no está permitido
     */
    public void mover(int fila, int columna) throws IllegalStateException {
        if (!this.esMovible(fila, columna)) {
            throw new IllegalStateException(
                    String.format("Movimiento no permitido: (%d,%d) -> (%d,%d)",
                            this.getFila(), this.getColumna(), fila, columna)
            );
        }
        // Si es movible, actualizamos posición
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Parte GENÉRICA de la comprobación de movimiento:
     * <ul>
     *   <li>Debe haber movimiento (no quedarse igual).</li>
     *   <li>No salirse del tablero (1..8).</li>
     * </ul>
     *
     * <p>Las piezas concretas llamarán a {@code super.esMovible(...)} y, si pasa,
     * harán su comprobación específica.</p>
     *
     * @param fila destino
     * @param columna destino
     * @return true si pasa las comprobaciones genéricas
     */
    public boolean esMovible(int fila, int columna) {
        boolean ok = true;

        if (fila == this.getFila() && columna == this.getColumna()) {
            ok = false; // no hay movimiento
        } else if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
            ok = false; // fuera del tablero
        }

        return ok;
    }

    @Override
    public String toString() {
        return String.format("%s(%s) pos=(%d,%d)",
                this.getClass().getSimpleName(), color, fila, columna);
    }
}

/**
 * TorreE12: se mueve horizontal o vertical, cualquier distancia.
 */
class TorreE12 extends PiezaAjedrezE12 {

    public TorreE12(String color, int fila, int columna) {
        super(color, fila, columna);
    }

    /**
     * Sobrescribimos esMovible:
     * 1) Primero comprobaciones genéricas con super.esMovible(...)
     * 2) Luego regla específica de torre (horizontal o vertical)
     */
    @Override
    public boolean esMovible(int fila, int columna) {
        boolean ok = super.esMovible(fila, columna);
        if (ok) {
            // vertical: cambia fila, misma columna
            if (fila != this.getFila() && columna == this.getColumna()) {
                ok = true;
            }
            // horizontal: misma fila, cambia columna
            else if (fila == this.getFila() && columna != this.getColumna()) {
                ok = true;
            } else {
                ok = false;
            }
        }
        return ok;
    }
}

/**
 * ReyE12: se mueve 1 casilla en cualquier dirección (horizontal, vertical o diagonal).
 */
class ReyE12 extends PiezaAjedrezE12 {

    public ReyE12(String color, int fila, int columna) {
        super(color, fila, columna);
    }

    /**
     * Sobrescribimos esMovible:
     * 1) super.esMovible(...) para lo genérico
     * 2) regla específica: diferencia máxima 1 en fila y 1 en columna
     */
    @Override
    public boolean esMovible(int fila, int columna) {
        boolean ok = super.esMovible(fila, columna);
        if (ok) {
            int df = Math.abs(fila - this.getFila());
            int dc = Math.abs(columna - this.getColumna());
            ok = (df <= 1 && dc <= 1); // 1 casilla máximo (incluye diagonal)
        }
        return ok;
    }
}