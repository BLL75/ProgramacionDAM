package programacion.tema6;

/**
 * EJ14 - 5.2 Ligadura dinámica (late binding).
 *
 * <p>Idea clave:</p>
 * <ul>
 *   <li>La referencia puede ser de tipo superclase (ej: PiezaAjedrezE14).</li>
 *   <li>El objeto real puede ser de una subclase (ej: TorreE14 o ReyE14).</li>
 *   <li>Cuando llamas a un método sobrescrito (esMovible), Java decide en TIEMPO DE EJECUCIÓN
 *       qué versión ejecutar según el tipo real del objeto.</li>
 * </ul>
 *
 * <p>Este ejercicio incluye:</p>
 * <ol>
 *   <li>Piezas de ajedrez (PiezaAjedrezE14, TorreE14, ReyE14) como el ejemplo del temario.</li>
 *   <li>Instrumentos (InstrumentoE14, PianoE14, FlautaE14) como ejemplo alternativo.</li>
 * </ol>
 *
 * @author Bernar
 */
public class Ej14_LigaduraDinamica {

    public static void main(String[] args) {

        System.out.println("========== A) Ajedrez: ligadura dinámica en esMovible ==========");

        PiezaAjedrezE14[] arrayPiezas = new PiezaAjedrezE14[4];

        arrayPiezas[0] = new TorreE14("blanco", 1, 1);
        arrayPiezas[1] = new TorreE14("negro", 1, 1);
        arrayPiezas[2] = new ReyE14("blanco", 1, 1);
        arrayPiezas[3] = new ReyE14("negro", 1, 1);

        // Estas llamadas se resuelven en tiempo de ejecución:
        // arrayPiezas[i] es PiezaAjedrezE14, pero el método ejecutado depende del objeto real (TorreE14 o ReyE14)
        boolean resultado1 = arrayPiezas[0].esMovible(1, 3); // Torre: horizontal -> true
        boolean resultado2 = arrayPiezas[1].esMovible(2, 2); // Torre: diagonal -> false
        boolean resultado3 = arrayPiezas[2].esMovible(2, 2); // Rey: 1 casilla diagonal -> true
        boolean resultado4 = arrayPiezas[3].esMovible(1, 3); // Rey: 2 columnas -> false

        System.out.println("resultado1 (Torre a (1,3)): " + resultado1);
        System.out.println("resultado2 (Torre a (2,2)): " + resultado2);
        System.out.println("resultado3 (Rey a (2,2)):   " + resultado3);
        System.out.println("resultado4 (Rey a (1,3)):   " + resultado4);

        System.out.println("\n¿Qué ha pasado?");
        System.out.println("- En compilación, solo sabemos que arrayPiezas[i] es PiezaAjedrezE14.");
        System.out.println("- En ejecución, Java ve si el objeto es TorreE14 o ReyE14 y ejecuta SU esMovible().");

        System.out.println("\n========== B) Instrumentos: ligadura dinámica en tocarNota ==========");

        InstrumentoE14 instrumento; // referencia de la superclase

        instrumento = new PianoE14();
        instrumento.tocarNota("do");  // ejecuta PianoE14.tocarNota

        instrumento = new FlautaE14();
        instrumento.tocarNota("mi");  // ejecuta FlautaE14.tocarNota
    }
}

/* =========================================================
 * A) AJEDREZ
 * ========================================================= */

/**
 * Superclase abstracta de piezas de ajedrez.
 *
 * <p>Nota: aquí esMovible se deja abstracto para obligar a las piezas a implementarlo.</p>
 */
abstract class PiezaAjedrezE14 {

    private final String color; // "BLANCO" o "NEGRO"
    protected int fila;
    protected int columna;

    public PiezaAjedrezE14(String color, int fila, int columna) {
        if (!"blanco".equalsIgnoreCase(color) && !"negro".equalsIgnoreCase(color)) {
            throw new IllegalArgumentException("Color incorrecto: " + color);
        }
        if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
            throw new IllegalArgumentException("Ubicación incorrecta: (" + fila + "," + columna + ")");
        }
        this.color = color.toUpperCase();
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() { return fila; }
    public int getColumna() { return columna; }

    /**
     * Método abstracto: cada pieza define sus reglas.
     */
    public abstract boolean esMovible(int fila, int columna);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + color + ") (" + fila + "," + columna + ")";
    }
}

/**
 * Torre: se mueve en horizontal o vertical.
 */
class TorreE14 extends PiezaAjedrezE14 {

    public TorreE14(String color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovible(int fila, int columna) {

        // Regla general: no salir del tablero y moverse de verdad
        if (fila < 1 || fila > 8 || columna < 1 || columna > 8) return false;
        if (fila == getFila() && columna == getColumna()) return false;

        // Torre: o cambia fila y mantiene columna (vertical),
        // o cambia columna y mantiene fila (horizontal)
        boolean vertical = (fila != getFila() && columna == getColumna());
        boolean horizontal = (fila == getFila() && columna != getColumna());

        return vertical || horizontal;
    }
}

/**
 * Rey: se mueve 1 casilla en cualquier dirección.
 */
class ReyE14 extends PiezaAjedrezE14 {

    public ReyE14(String color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovible(int fila, int columna) {

        // Regla general: no salir del tablero y moverse de verdad
        if (fila < 1 || fila > 8 || columna < 1 || columna > 8) return false;
        if (fila == getFila() && columna == getColumna()) return false;

        int df = Math.abs(fila - getFila());
        int dc = Math.abs(columna - getColumna());

        // Rey: máximo 1 casilla en fila y columna
        return df <= 1 && dc <= 1;
    }
}

/* =========================================================
 * B) INSTRUMENTOS
 * ========================================================= */

/**
 * Instrumento genérico.
 *
 * <p>Si lo sobrescriben Piano/Flauta, la llamada se resuelve con ligadura dinámica.</p>
 */
abstract class InstrumentoE14 {
    public abstract void tocarNota(String nota);
}

/**
 * Piano: implementación específica de tocarNota.
 */
class PianoE14 extends InstrumentoE14 {
    @Override
    public void tocarNota(String nota) {
        System.out.printf("Piano: tocar nota %s.%n", nota);
    }
}

/**
 * Flauta: implementación específica de tocarNota.
 */
class FlautaE14 extends InstrumentoE14 {
    @Override
    public void tocarNota(String nota) {
        System.out.printf("Flauta: tocar nota %s.%n", nota);
    }
}