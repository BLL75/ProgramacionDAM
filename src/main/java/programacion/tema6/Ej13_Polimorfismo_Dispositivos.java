package programacion.tema6;

/**
 * EJ13 - 5.1 Concepto de polimorfismo.
 *
 * <p>Idea clave:</p>
 * <ul>
 *   <li>Una referencia de tipo {@link DispositivoE13} puede apuntar a objetos de subclases
 *       como {@link BombillaE13} o {@link CerraduraE13}.</li>
 *   <li>Cuando llamamos a un método sobrescrito (por ejemplo {@code toString()}),
 *       Java decide en TIEMPO DE EJECUCIÓN qué versión ejecutar (ligadura dinámica).</li>
 * </ul>
 *
 * <p>Demostración:</p>
 * <ul>
 *   <li>Creamos un array {@code DispositivoE13[]}.</li>
 *   <li>Guardamos dentro cerraduras y bombillas.</li>
 *   <li>Recorremos el array e imprimimos: cada objeto imprime su toString() específico.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej13_Polimorfismo_Dispositivos {

    public static void main(String[] args) {

        // 1) Reservamos espacio para 4 referencias a DispositivoE13 (inicialmente null)
        DispositivoE13[] arrayDispositivos = new DispositivoE13[4];

        // 2) Asignamos referencias a objetos de SUBCLASES
        arrayDispositivos[0] = new CerraduraE13("cerradura 1", 1, false);
        arrayDispositivos[1] = new CerraduraE13("cerradura 2", 2, true);
        arrayDispositivos[2] = new BombillaE13("bombilla 1", 1, 4);
        arrayDispositivos[3] = new BombillaE13("bombilla 2", 2, 0);

        System.out.println("=== Listado polimórfico (ligadura dinámica con toString) ===");
        for (DispositivoE13 d : arrayDispositivos) {
            // Aunque d es DispositivoE13, el toString que se ejecuta es el de la clase real
            System.out.println(d);
        }

        System.out.println("\n=== Misma referencia, distintos tipos en distintos momentos ===");
        DispositivoE13 ref; // referencia de la superclase

        ref = new CerraduraE13("cerradura X", 3, false);
        System.out.println("ref apunta a: " + ref.getClass().getSimpleName() + " -> " + ref);

        ref = new BombillaE13("bombilla X", 4, 7);
        System.out.println("ref apunta a: " + ref.getClass().getSimpleName() + " -> " + ref);
    }
}

/* =========================================================
 * SUPERCLASE
 * ========================================================= */

/**
 * Superclase (base) de dispositivos.
 * <p>En el temario, esta clase suele ser abstracta porque no tiene sentido instanciarla.</p>
 */
abstract class DispositivoE13 {

    protected final String descripcion;
    protected final int ubicacion;

    public DispositivoE13(String descripcion, int ubicacion) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /**
     * Método heredable (común) para todos los dispositivos.
     */
    public String infoBasica() {
        return "descripcion=\"" + descripcion + "\" ubicacion=" + ubicacion;
    }

    /**
     * toString base (las subclases lo amplían con super.toString()).
     */
    @Override
    public String toString() {
        return String.format("tipo:%-12s %s",
                this.getClass().getSimpleName(), // tipo real en ejecución
                infoBasica());
    }
}

/* =========================================================
 * SUBCLASE: Cerradura
 * ========================================================= */

final class CerraduraE13 extends DispositivoE13 {

    // true=cerrada, false=abierta
    private boolean cerrada;

    public CerraduraE13(String descripcion, int ubicacion, boolean cerrada) {
        super(descripcion, ubicacion);
        this.cerrada = cerrada;
    }

    @Override
    public String toString() {
        // Amplía lo del padre (super.toString) añadiendo estado
        return super.toString() + " estado:" + (cerrada ? "cerrada" : "abierta");
    }
}

/* =========================================================
 * SUBCLASE: Bombilla
 * ========================================================= */

final class BombillaE13 extends DispositivoE13 {

    private int intensidad; // 0..10 (no validamos aquí para centrar el ejemplo)
    private boolean encendida;

    public BombillaE13(String descripcion, int ubicacion, int intensidadInicial) {
        super(descripcion, ubicacion);
        this.intensidad = intensidadInicial;
        this.encendida = intensidadInicial > 0;
    }

    @Override
    public String toString() {
        return super.toString()
                + " estado:" + (encendida ? "encendida" : "apagada")
                + " int:" + intensidad;
    }
}