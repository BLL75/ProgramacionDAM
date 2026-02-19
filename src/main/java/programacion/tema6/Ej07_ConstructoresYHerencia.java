package programacion.tema6;

/**
 * EJ07 - 3.6 Constructores y herencia (I)
 *
 * <p>Objetivos didácticos:</p>
 * <ul>
 *   <li>Entender cómo una subclase llama al constructor de su superclase con {@code super(...)}.</li>
 *   <li>Entender cómo un constructor puede reutilizar a otro constructor de la misma clase con {@code this(...)}.</li>
 *   <li>Ver la regla: {@code super(...)} o {@code this(...)} deben ser la <b>primera línea</b> del constructor.</li>
 *   <li>Practicar validaciones en constructores y lanzamiento de excepciones.</li>
 * </ul>
 *
 * <p>Escenario del temario:</p>
 * <ul>
 *   <li>{@link DispositivoE07}: clase abstracta con id autogenerado, descripción e ubicación.</li>
 *   <li>{@link CerraduraE07}: hereda de DispositivoE07 y añade estado.</li>
 *   <li>{@link BombillaE07}: hereda de DispositivoE07 y añade intensidad y contador de manipulaciones.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej07_ConstructoresYHerencia {

    /**
     * Programa de prueba.
     * Probamos constructores correctos e incorrectos para ver:
     * - cómo se asigna el id automáticamente
     * - cómo funcionan super(...) y this(...)
     * - cómo saltan excepciones cuando los datos no son válidos
     */
    public static void main(String[] args) {

        System.out.println("=== 1) Crear dispositivos válidos ===");
        CerraduraE07 c1 = new CerraduraE07("Cerradura puerta", 1, true);
        CerraduraE07 c2 = new CerraduraE07("Cerradura trastero", 2); // usa this(..., false)

        BombillaE07 b1 = new BombillaE07("Bombilla salón", 3); // usa this(..., 0)
        BombillaE07 b2 = new BombillaE07("Bombilla cocina", 4, 5);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("\n=== 2) Ver ids autoincrementales ===");
        // Los ids se asignan en el constructor de DispositivoE07 (superclase)
        // y deben ir 1,2,3,4... según el orden de creación.
        System.out.println("ID c1: " + c1.getId());
        System.out.println("ID c2: " + c2.getId());
        System.out.println("ID b1: " + b1.getId());
        System.out.println("ID b2: " + b2.getId());

        System.out.println("\n=== 3) Probar excepciones (ubicación inválida) ===");
        try {
            // Ubicación 0 es inválida (mínimo 1)
            BombillaE07 bx = new BombillaE07("Bombilla inválida", 0);
            System.out.println(bx); // no debería llegar aquí
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\n=== 4) Probar excepciones (intensidad inválida) ===");
        try {
            // Intensidad 99 es inválida (máximo 10)
            BombillaE07 by = new BombillaE07("Bombilla inválida", 5, 99);
            System.out.println(by); // no debería llegar aquí
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}

/* =========================================================
 * SUPERCLASE ABSTRACTA
 * ========================================================= */

/**
 * Clase abstracta Dispositivo (no instanciable).
 *
 * <p>Contiene lo común a cualquier dispositivo domótico:</p>
 * <ul>
 *   <li>id único autogenerado (inmutable)</li>
 *   <li>descripción (inmutable)</li>
 *   <li>ubicación (variable)</li>
 * </ul>
 *
 * <p>Además define un rango válido para ubicación:</p>
 * <ul>
 *   <li>{@link #MIN_UBICACION} = 1</li>
 *   <li>{@link #MAX_UBICACION} = 10</li>
 * </ul>
 *
 * <p>El id se genera con un contador estático {@link #nextId} que se incrementa en cada creación.</p>
 */
abstract class DispositivoE07 {

    /** Ubicación mínima permitida. */
    public static final int MIN_UBICACION = 1;

    /** Ubicación máxima permitida. */
    public static final int MAX_UBICACION = 10;

    /**
     * Contador estático para generar ids únicos.
     * <p>Empieza en 1 y se incrementa cada vez que se crea un dispositivo.</p>
     */
    private static int nextId = 1;

    /** Identificador único del dispositivo (inmutable). */
    private final int id;

    /** Descripción del dispositivo (inmutable). */
    private final String descripcion;

    /** Ubicación (estancia) del dispositivo (variable). */
    private int ubicacion;

    /**
     * Constructor de la superclase.
     *
     * <p>Responsabilidades típicas de un constructor de superclase:</p>
     * <ul>
     *   <li>Validar lo común (ubicación en rango).</li>
     *   <li>Asignar el id único.</li>
     *   <li>Inicializar atributos comunes.</li>
     * </ul>
     *
     * @param descripcion descripción del dispositivo
     * @param ubicacion número de estancia (debe estar entre 1 y 10)
     * @throws IllegalArgumentException si la ubicación no es válida
     */
    public DispositivoE07(String descripcion, int ubicacion) {
        // Validación de ubicación según el temario
        if (ubicacion < MIN_UBICACION || ubicacion > MAX_UBICACION) {
            throw new IllegalArgumentException(String.format("Ubicación no válida: %d", ubicacion));
        }

        // Asignaciones comunes
        this.id = nextId++;          // genera id y luego incrementa contador
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /** @return id del dispositivo */
    public int getId() {
        return id;
    }

    /** @return descripción del dispositivo */
    public String getDescripcion() {
        return descripcion;
    }

    /** @return ubicación del dispositivo */
    public int getUbicacion() {
        return ubicacion;
    }

    /**
     * Cambia la ubicación del dispositivo (siempre validando).
     *
     * @param ubicacion nueva ubicación
     * @throws IllegalArgumentException si la ubicación no es válida
     */
    public void setUbicacion(int ubicacion) {
        if (ubicacion < MIN_UBICACION || ubicacion > MAX_UBICACION) {
            throw new IllegalArgumentException(String.format("Ubicación no válida: %d", ubicacion));
        }
        this.ubicacion = ubicacion;
    }

    /**
     * Representación textual “base” (para reutilizar con super.toString()).
     *
     * <p>Incluye el tipo real del objeto usando:</p>
     * <ul>
     *   <li>{@code getClass().getSimpleName()}</li>
     * </ul>
     *
     * @return String con tipo, id, descripción y ubicación
     */
    @Override
    public String toString() {
        return String.format(
                "tipo:%-12s id:%d descripción:\"%s\" ubicacion:%d",
                this.getClass().getSimpleName(),
                id,
                descripcion,
                ubicacion
        );
    }
}

/* =========================================================
 * SUBCLASE: Cerradura
 * ========================================================= */

/**
 * Cerradura: especialización de DispositivoE07.
 *
 * <p>Añade un atributo específico:</p>
 * <ul>
 *   <li>estado: true = cerrada, false = abierta</li>
 * </ul>
 *
 * <p>Constructores:</p>
 * <ul>
 *   <li>3 parámetros: usa {@code super(descripcion, ubicacion)} y luego inicializa estado.</li>
 *   <li>2 parámetros: usa {@code this(descripcion, ubicacion, false)} para no repetir código.</li>
 * </ul>
 */
class CerraduraE07 extends DispositivoE07 {

    /** true=cerrada, false=abierta */
    private boolean estado;

    /**
     * Constructor principal (completo) de Cerradura.
     *
     * @param descripcion descripción
     * @param ubicacion ubicación (1..10)
     * @param estadoInicial estado inicial (true=cerrada, false=abierta)
     */
    public CerraduraE07(String descripcion, int ubicacion, boolean estadoInicial) {
        super(descripcion, ubicacion);  // 1ª línea: inicializa la parte heredada
        this.estado = estadoInicial;    // inicializa lo específico
    }

    /**
     * Constructor “corto” que usa un valor por defecto.
     *
     * <p>OJO: aquí usamos {@code this(...)} para reutilizar el constructor completo.</p>
     *
     * @param descripcion descripción
     * @param ubicacion ubicación (1..10)
     */
    public CerraduraE07(String descripcion, int ubicacion) {
        this(descripcion, ubicacion, false); // false = abierta (por defecto)
    }

    public void abrir() { estado = false; }
    public void cerrar() { estado = true; }

    @Override
    public String toString() {
        // Ampliamos el toString base del padre
        return String.format("%s estado:%s", super.toString(), estado ? "cerrada" : "abierta");
    }
}

/* =========================================================
 * SUBCLASE: Bombilla
 * ========================================================= */

/**
 * Bombilla: especialización de DispositivoE07.
 *
 * <p>Añade:</p>
 * <ul>
 *   <li>intensidad (0..10)</li>
 *   <li>numVecesManipulada (contador)</li>
 * </ul>
 *
 * <p>Constructores:</p>
 * <ul>
 *   <li>3 parámetros (completo): valida intensidad inicial y la asigna.</li>
 *   <li>2 parámetros (simplificado): llama a {@code this(descripcion, ubicacion, 0)}.</li>
 * </ul>
 */
class BombillaE07 extends DispositivoE07 {

    /** Intensidad mínima permitida. */
    public static final int MIN_INTENSIDAD = 0;

    /** Intensidad máxima permitida. */
    public static final int MAX_INTENSIDAD = 10;

    private int intensidad;
    private int numVecesManipulada;
    private boolean estado; // true=encendida, false=apagada (para el toString del temario)

    /**
     * Constructor completo de Bombilla (con intensidad inicial).
     *
     * <p>Orden correcto:</p>
     * <ol>
     *   <li>Llamar a {@code super(...)} para validaciones e inicialización genérica (ubicación, id...).</li>
     *   <li>Validar lo específico (intensidad).</li>
     *   <li>Inicializar lo específico.</li>
     * </ol>
     *
     * @param descripcion descripción
     * @param ubicacion ubicación (1..10)
     * @param intensidadInicial intensidad inicial (0..10)
     * @throws IllegalArgumentException si la intensidad inicial es inválida
     */
    public BombillaE07(String descripcion, int ubicacion, int intensidadInicial) {
        super(descripcion, ubicacion); // 1ª línea: inicializa lo heredado

        // Validación específica de Bombilla
        if (intensidadInicial < MIN_INTENSIDAD || intensidadInicial > MAX_INTENSIDAD) {
            throw new IllegalArgumentException(String.format("Intensidad inicial no válida: %d", intensidadInicial));
        }

        // Inicialización específica
        this.intensidad = intensidadInicial;
        this.numVecesManipulada = 0;
        this.estado = false; // por defecto apagada
    }

    /**
     * Constructor simplificado: intensidad inicial por defecto = 0.
     *
     * <p>Reutiliza el constructor completo con {@code this(...)} para evitar duplicar código.</p>
     *
     * @param descripcion descripción
     * @param ubicacion ubicación (1..10)
     */
    public BombillaE07(String descripcion, int ubicacion) {
        this(descripcion, ubicacion, 0); // delega en el constructor completo
    }

    public void encender() {
        if (!estado) {
            estado = true;
            numVecesManipulada++;
        }
    }

    public void apagar() {
        if (estado) {
            estado = false;
            numVecesManipulada++;
        }
    }

    public void setIntensidad(int intensidad) {
        if (intensidad < MIN_INTENSIDAD || intensidad > MAX_INTENSIDAD) {
            throw new IllegalArgumentException(String.format("Intensidad no válida: %d", intensidad));
        }
        this.intensidad = intensidad;
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