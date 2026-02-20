package programacion.tema6;

/**
 * EJ08 - 3.6.1 Constructores y herencia (II)
 *
 * <p>Problema:</p>
 * <ul>
 *   <li>El constructor de la superclase {@code Dispositivo} incrementa {@code nextId}.</li>
 *   <li>Si el constructor de {@code Bombilla} falla después (por ejemplo, intensidad inválida),
 *       el id ya se incrementó y se "pierde" un valor.</li>
 * </ul>
 *
 * <p>Solución del temario:</p>
 * <ul>
 *   <li>Crear un <b>método fábrica</b> estático que haga validaciones ANTES de llamar a {@code new}.</li>
 *   <li>Así evitamos que se ejecute el constructor (y por tanto que suba {@code nextId})
 *       cuando los parámetros son inválidos.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej08_FactoryMethod_SinPerderIds {

    public static void main(String[] args) {

        int[] valoresPrueba = {-1, 0, 2, 12, 15, -1, 7, -5, 0, 9};

        System.out.println("=== Creación con FACTORY (no se pierden ids) ===");

        for (int intensidad : valoresPrueba) {
            try {
                BombillaE08 b = BombillaE08.creaBombilla("b1", 5, intensidad);
                System.out.printf("Bombilla creada correctamente: %s%n", b);
            } catch (IllegalArgumentException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        }

        System.out.println("\nSiguiente id disponible (debería ser 6): " + DispositivoE08.getNextIdPreview());
    }
}

/* =========================================================
 * SUPERCLASE ABSTRACTA
 * ========================================================= */

/**
 * DispositivoE08: superclase abstracta para dispositivos domóticos.
 *
 * <p>Tiene un id autogenerado secuencial (1,2,3...)</p>
 * <p>y valida la ubicación dentro del rango permitido.</p>
 */
abstract class DispositivoE08 {

    /** Rango válido de ubicaciones (como el temario). */
    public static final int MIN_UBICACION = 1;
    public static final int MAX_UBICACION = 10;

    /**
     * Contador estático para ids.
     * <p>IMPORTANTE: se incrementa cuando se ejecuta el constructor.</p>
     */
    private static int nextId = 1;

    /** Atributos de objeto comunes. */
    private final int id;
    private final String descripcion;
    private final int ubicacion;

    /**
     * Constructor común de Dispositivo.
     *
     * <p>Valida ubicación y asigna id.</p>
     * <p>OJO: aquí es donde "se podría perder" un id si la subclase falla después.</p>
     *
     * @param descripcion descripción (no validamos aquí para centrarnos en el ejercicio)
     * @param ubicacion ubicación (1..10)
     * @throws IllegalArgumentException si ubicación inválida
     */
    protected DispositivoE08(String descripcion, int ubicacion) {
        if (ubicacion < MIN_UBICACION || ubicacion > MAX_UBICACION) {
            throw new IllegalArgumentException(String.format("Ubicación no válida: %d", ubicacion));
        }

        // Aquí se "consume" un id
        this.id = nextId++;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /** @return id del dispositivo */
    public int getId() { return id; }

    /** @return descripción del dispositivo */
    public String getDescripcion() { return descripcion; }

    /** @return ubicación del dispositivo */
    public int getUbicacion() { return ubicacion; }

    /**
     * Solo para comprobar en el main cómo va el nextId.
     * (En proyectos reales normalmente no se expone así.)
     */
    public static int getNextIdPreview() {
        return nextId;
    }

    /**
     * toString "base" (ampliable por las subclases con super.toString()).
     */
    @Override
    public String toString() {
        return String.format(
                "tipo:%-12s id:%d descripción:\"%s\" ubicación:%d",
                this.getClass().getSimpleName(),
                id,
                descripcion,
                ubicacion
        );
    }
}

/* =========================================================
 * SUBCLASE: Bombilla
 * ========================================================= */

/**
 * BombillaE08: dispositivo con intensidad y estado.
 *
 * <p>Objetivo del ejercicio:</p>
 * <ul>
 *   <li>Tener un método fábrica {@link #creaBombilla(String, int, int)} que valide ANTES de crear.</li>
 *   <li>Evitar que {@code nextId} aumente cuando la creación falla.</li>
 * </ul>
 */
final class BombillaE08 extends DispositivoE08 {

    public static final int MIN_INTENSIDAD = 0;
    public static final int MAX_INTENSIDAD = 10;

    private final int intensidad;
    private final boolean estado; // true=encendida, false=apagada
    private final int numVecesManipulada;

    /**
     * Constructor "real" (equivalente al de 3 parámetros del temario).
     *
     * <p>Lo hacemos {@code private} para forzar el uso del método fábrica y así
     * controlar que las validaciones ocurren antes de consumir ids.</p>
     *
     * <p>IMPORTANTE: Aun así mantenemos validación defensiva, por seguridad.</p>
     */
    private BombillaE08(String descripcion, int ubicacion, int intensidadInicial) {
        super(descripcion, ubicacion); // si se ejecuta, ya se consume un id

        // Validación específica (defensiva)
        if (intensidadInicial < MIN_INTENSIDAD || intensidadInicial > MAX_INTENSIDAD) {
            throw new IllegalArgumentException(String.format("Intensidad inicial no válida: %d", intensidadInicial));
        }

        this.intensidad = intensidadInicial;
        this.estado = intensidadInicial > 0; // ejemplo: si intensidad>0 la consideramos "encendida"
        this.numVecesManipulada = 0;
    }

    /**
     * Método fábrica (factory method) para crear bombillas SIN perder ids.
     *
     * <p>¿Qué hace?</p>
     * <ol>
     *   <li>Valida parámetros "genéricos" (ubicación) ANTES de hacer {@code new}.</li>
     *   <li>Valida parámetros "específicos" (intensidad) ANTES de hacer {@code new}.</li>
     *   <li>Si todo es correcto, entonces sí crea el objeto.</li>
     * </ol>
     *
     * <p>Si algo es inválido, lanza excepción y NO se ejecuta el constructor,
     * por lo que {@code nextId} NO se incrementa.</p>
     *
     * @param descripcion descripción
     * @param ubicacion ubicación (1..10)
     * @param intensidadInicial intensidad (0..10)
     * @return nueva BombillaE08 creada correctamente
     * @throws IllegalArgumentException si ubicación o intensidad son inválidas
     */
    public static BombillaE08 creaBombilla(String descripcion, int ubicacion, int intensidadInicial) {

        // 1) Validación genérica ANTES del new (evita consumir id)
        if (ubicacion < DispositivoE08.MIN_UBICACION || ubicacion > DispositivoE08.MAX_UBICACION) {
            throw new IllegalArgumentException(String.format("Ubicación no válida: %d", ubicacion));
        }

        // 2) Validación específica ANTES del new (evita consumir id)
        if (intensidadInicial < MIN_INTENSIDAD || intensidadInicial > MAX_INTENSIDAD) {
            throw new IllegalArgumentException(String.format("Intensidad inicial no válida: %d", intensidadInicial));
        }

        // 3) Solo si todo ok, creamos (aquí ya sí se consume id)
        return new BombillaE08(descripcion, ubicacion, intensidadInicial);
    }

    @Override
    public String toString() {
        return String.format(
                "%s estado:%s int:%d NVM:%d",
                super.toString(),
                estado ? "encendida" : "apagada",
                intensidad,
                numVecesManipulada
        );
    }
}