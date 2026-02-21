package programacion.tema6;

import java.util.Arrays;

/**
 * EJ09 - 3.7 Creación y utilización de clases derivadas.
 *
 * <p>Objetivos:</p>
 * <ul>
 *   <li>Crear una jerarquía: {@link DispositivoE09} (superclase) -> {@link BombillaE09}/{@link CerraduraE09} (subclases).</li>
 *   <li>Crear una clase contenedora {@link CasaDomoticaE09} que almacene un array de {@code DispositivoE09}.</li>
 *   <li>Usar un constructor con <b>parámetros variables</b> (varargs): {@code DispositivoE09... dispositivos}.</li>
 *   <li>Comprobar que podemos trabajar con distintos tipos de dispositivos desde un mismo array (polimorfismo).</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej09_CasaDomotica_Varargs {

    /**
     * Programa de prueba.
     * <p>Crearemos varias instancias de clases derivadas y las pasaremos a CasaDomoticaE09 usando varargs.</p>
     */
    public static void main(String[] args) {

        // Creamos dispositivos (subclases)
        BombillaE09 b1 = new BombillaE09("Bombilla salón", 2, 4);
        BombillaE09 b2 = new BombillaE09("Bombilla cocina", 3); // intensidad por defecto
        CerraduraE09 c1 = new CerraduraE09("Cerradura principal", 1, true);
        CerraduraE09 c2 = new CerraduraE09("Cerradura trastero", 5); // estado por defecto (abierta)

        // Creamos casa: constructor con varargs (podemos pasar N dispositivos)
        CasaDomoticaE09 casa = new CasaDomoticaE09(
                "Bernar",
                "Piso con domótica básica",
                b1, b2, c1, c2
        );

        System.out.println("=== Casa creada ===");
        System.out.println(casa);

        System.out.println("\n=== Listado de dispositivos (polimorfismo) ===");
        casa.listarDispositivos();

        System.out.println("\n=== Ejemplo de uso: encender todas las bombillas ===");
        casa.encenderTodasLasBombillas();
        casa.listarDispositivos();

        System.out.println("\n=== Ejemplo de uso: cerrar todas las cerraduras ===");
        casa.cerrarTodasLasCerraduras();
        casa.listarDispositivos();
    }
}

/* =========================================================
 * SUPERCLASE (BASE)
 * ========================================================= */

/**
 * DispositivoE09: superclase abstracta (no instanciable).
 *
 * <p>Contiene atributos comunes:</p>
 * <ul>
 *   <li>id autogenerado y único</li>
 *   <li>descripción</li>
 *   <li>ubicación (estancia)</li>
 * </ul>
 *
 * <p>Esta clase sirve para poder almacenar distintas subclases en un mismo array:
 * {@code DispositivoE09[]}</p>
 */
abstract class DispositivoE09 {

    /** Rango válido de ubicación (como en el temario). */
    public static final int MIN_UBICACION = 1;
    public static final int MAX_UBICACION = 10;

    /** Contador estático para generar ids únicos. */
    private static int nextId = 1;

    /** Atributos comunes. */
    private final int id;
    private final String descripcion;
    private final int ubicacion;

    /**
     * Constructor común.
     *
     * @param descripcion texto descriptivo
     * @param ubicacion estancia (1..10)
     */
    protected DispositivoE09(String descripcion, int ubicacion) {
        if (ubicacion < MIN_UBICACION || ubicacion > MAX_UBICACION) {
            throw new IllegalArgumentException(String.format("Ubicación no válida: %d", ubicacion));
        }
        this.id = nextId++;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /** @return id del dispositivo */
    public int getId() { return id; }

    /** @return descripción */
    public String getDescripcion() { return descripcion; }

    /** @return ubicación */
    public int getUbicacion() { return ubicacion; }

    /**
     * Representación base reutilizable (ampliable por subclases con super.toString()).
     */
    @Override
    public String toString() {
        return String.format(
                "tipo:%-12s id:%d descripción:\"%s\" ubicacion:%d",
                this.getClass().getSimpleName(), id, descripcion, ubicacion
        );
    }
}

/* =========================================================
 * SUBCLASE: Bombilla
 * ========================================================= */

/**
 * BombillaE09: dispositivo con estado e intensidad.
 */
final class BombillaE09 extends DispositivoE09 {

    public static final int MIN_INTENSIDAD = 0;
    public static final int MAX_INTENSIDAD = 10;

    private boolean encendida;
    private int intensidad;

    /**
     * Constructor con descripción y ubicación.
     * Intensidad por defecto: 0, y apagada.
     */
    public BombillaE09(String descripcion, int ubicacion) {
        this(descripcion, ubicacion, MIN_INTENSIDAD);
    }

    /**
     * Constructor con intensidad inicial.
     *
     * @param descripcion descripción
     * @param ubicacion ubicación (1..10)
     * @param intensidadInicial intensidad (0..10)
     */
    public BombillaE09(String descripcion, int ubicacion, int intensidadInicial) {
        super(descripcion, ubicacion);
        if (intensidadInicial < MIN_INTENSIDAD || intensidadInicial > MAX_INTENSIDAD) {
            throw new IllegalArgumentException(String.format("Intensidad inicial no válida: %d", intensidadInicial));
        }
        this.intensidad = intensidadInicial;
        this.encendida = intensidadInicial > 0; // si tiene intensidad, la consideramos encendida
    }

    public void encender() { encendida = true; }
    public void apagar() { encendida = false; }

    @Override
    public String toString() {
        return String.format(
                "%s estado:%s int:%d",
                super.toString(),
                encendida ? "encendida" : "apagada",
                intensidad
        );
    }
}

/* =========================================================
 * SUBCLASE: Cerradura
 * ========================================================= */

/**
 * CerraduraE09: dispositivo con estado abierto/cerrado.
 */
final class CerraduraE09 extends DispositivoE09 {

    /** true=cerrada, false=abierta */
    private boolean cerrada;

    /**
     * Constructor con descripción y ubicación.
     * Estado por defecto: abierta (false).
     */
    public CerraduraE09(String descripcion, int ubicacion) {
        this(descripcion, ubicacion, false);
    }

    /**
     * Constructor completo.
     */
    public CerraduraE09(String descripcion, int ubicacion, boolean estadoInicial) {
        super(descripcion, ubicacion);
        this.cerrada = estadoInicial;
    }

    public void cerrar() { cerrada = true; }
    public void abrir() { cerrada = false; }

    @Override
    public String toString() {
        return String.format(
                "%s estado:%s",
                super.toString(),
                cerrada ? "cerrada" : "abierta"
        );
    }
}

/* =========================================================
 * CLASE CONTENEDORA: CasaDomotica
 * ========================================================= */

/**
 * CasaDomoticaE09: vivienda con dispositivos domóticos.
 *
 * <p>Lo importante del punto 3.7:</p>
 * <ul>
 *   <li>Guarda un array de {@link DispositivoE09}, pero dentro puede haber bombillas, cerraduras, etc.</li>
 *   <li>El constructor usa <b>varargs</b>: recibe N dispositivos.</li>
 * </ul>
 */
final class CasaDomoticaE09 {

    /** Array con referencias a dispositivos (polimorfismo). */
    private final DispositivoE09[] listaDispositivos;

    private final String propietario;
    private final String descripcion;

    /**
     * Constructor con varargs.
     *
     * <p>Varargs: {@code DispositivoE09... dispositivos} significa que el llamante puede pasar:</p>
     * <ul>
     *   <li>0 dispositivos</li>
     *   <li>1 dispositivo</li>
     *   <li>N dispositivos</li>
     * </ul>
     *
     * <p>Dentro del constructor, {@code dispositivos} se comporta como un array.</p>
     *
     * @param propietario dueño de la vivienda
     * @param descripcion descripción de la vivienda
     * @param dispositivos lista variable de dispositivos
     */
    public CasaDomoticaE09(String propietario, String descripcion, DispositivoE09... dispositivos) {
        this.propietario = propietario;
        this.descripcion = descripcion;

        // Copia del array (para no depender del array externo)
        this.listaDispositivos = Arrays.copyOf(dispositivos, dispositivos.length);
    }

    /**
     * Lista los dispositivos mostrando su toString().
     * Aquí se ve el polimorfismo: cada objeto imprime su toString() especializado.
     */
    public void listarDispositivos() {
        for (DispositivoE09 d : listaDispositivos) {
            System.out.println(d);
        }
    }

    /**
     * Método de ejemplo: encender todas las bombillas.
     * <p>Necesitamos comprobar el tipo real usando {@code instanceof}.</p>
     */
    public void encenderTodasLasBombillas() {
        for (DispositivoE09 d : listaDispositivos) {
            if (d instanceof BombillaE09 b) { // pattern matching (Java moderno)
                b.encender();
            }
        }
    }

    /**
     * Método de ejemplo: cerrar todas las cerraduras.
     */
    public void cerrarTodasLasCerraduras() {
        for (DispositivoE09 d : listaDispositivos) {
            if (d instanceof CerraduraE09 c) {
                c.cerrar();
            }
        }
    }

    @Override
    public String toString() {
        return "CasaDomotica{propietario=\"" + propietario + "\", descripcion=\"" + descripcion +
                "\", numDispositivos=" + listaDispositivos.length + "}";
    }
}