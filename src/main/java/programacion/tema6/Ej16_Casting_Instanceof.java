package programacion.tema6;

import java.util.Arrays;

/**
 * EJ16 - 5.4 Conversión de objetos (casting) y operador instanceof.
 *
 * <p>Objetivos:</p>
 * <ul>
 *   <li>Ver la conversión implícita (upcasting): subclase -> superclase.</li>
 *   <li>Ver la conversión explícita (downcasting): superclase -> subclase.</li>
 *   <li>Usar instanceof para saber el tipo real y evitar ClassCastException.</li>
 *   <li>Aplicarlo a un caso real: CasaDomotica con contadores de bombillas/cerraduras.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej16_Casting_Instanceof {

    public static void main(String[] args) {

        System.out.println("========== A) instanceof básico (como el ejemplo del temario) ==========");

        DispositivoE16 disp1 = new BombillaE16("b1", 1, 4);
        DispositivoE16 disp2 = new CerraduraE16("c1", 1, false);

        System.out.printf("disp1 instanceof DispositivoE16 = %s%n", disp1 instanceof DispositivoE16);
        System.out.printf("disp1 instanceof BombillaE16    = %s%n", disp1 instanceof BombillaE16);
        System.out.printf("disp1 instanceof CerraduraE16   = %s%n", disp1 instanceof CerraduraE16);

        System.out.printf("disp2 instanceof DispositivoE16 = %s%n", disp2 instanceof DispositivoE16);
        System.out.printf("disp2 instanceof BombillaE16    = %s%n", disp2 instanceof BombillaE16);
        System.out.printf("disp2 instanceof CerraduraE16   = %s%n", disp2 instanceof CerraduraE16);

        System.out.println("\n========== B) Casting (downcasting) seguro e inseguro ==========");

        // Upcasting (automático): BombillaE16 -> DispositivoE16
        DispositivoE16 d = new BombillaE16("b2", 2, 7);

        // ❌ No puedo llamar a métodos específicos de BombillaE16 con referencia DispositivoE16
        // d.setIntensidad(10);  // NO compila

        // ✅ Downcasting seguro con instanceof
        if (d instanceof BombillaE16 b) {  // pattern matching (Java moderno)
            b.setIntensidad(10);
            System.out.println("Tras cambiar intensidad con casting seguro: " + b);
        }

        // ⚠️ Downcasting inseguro: compila, pero puede romper en ejecución
        DispositivoE16 d2 = new CerraduraE16("c2", 3, true);
        try {
            BombillaE16 mal = (BombillaE16) d2; // d2 NO es una bombilla -> ClassCastException
            System.out.println(mal);
        } catch (ClassCastException ex) {
            System.out.println("Casting incorrecto (esperado): " + ex);
        }

        System.out.println("\n========== C) CasaDomotica con contadores usando instanceof ==========");

        CasaDomoticaE16 casa = new CasaDomoticaE16(
                "Bernar",
                "Vivienda con dispositivos variados",
                new BombillaE16("bombilla salón", 2, 3),
                new CerraduraE16("cerradura puerta", 1, false),
                new BombillaE16("bombilla cocina", 3, 0),
                new CerraduraE16("cerradura trastero", 5, true)
        );

        System.out.println(casa);
        casa.listarDispositivos();

        System.out.println("\nBombillas: " + casa.getNumBombillas());
        System.out.println("Cerraduras: " + casa.getNumCerraduras());
    }
}

/* =========================================================
 * SUPERCLASE
 * ========================================================= */

/**
 * DispositivoE16: superclase abstracta de dispositivos domóticos.
 *
 * <p>Es abstracta: no tiene sentido crear un "dispositivo genérico".</p>
 */
abstract class DispositivoE16 {

    protected final String descripcion;
    protected final int ubicacion;

    public DispositivoE16(String descripcion, int ubicacion) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() { return descripcion; }
    public int getUbicacion() { return ubicacion; }

    @Override
    public String toString() {
        return String.format("tipo:%-12s descripción:\"%s\" ubicacion:%d",
                getClass().getSimpleName(), descripcion, ubicacion);
    }
}

/* =========================================================
 * SUBCLASE: Bombilla
 * ========================================================= */

/**
 * BombillaE16: dispositivo con intensidad.
 */
final class BombillaE16 extends DispositivoE16 {

    private int intensidad;     // 0..10 (no validamos para simplificar)
    private boolean encendida;  // encendida si intensidad > 0

    public BombillaE16(String descripcion, int ubicacion, int intensidadInicial) {
        super(descripcion, ubicacion);
        this.intensidad = intensidadInicial;
        this.encendida = intensidadInicial > 0;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
        this.encendida = intensidad > 0;
    }

    @Override
    public String toString() {
        return super.toString() + " estado:" + (encendida ? "encendida" : "apagada") + " int:" + intensidad;
    }
}

/* =========================================================
 * SUBCLASE: Cerradura
 * ========================================================= */

/**
 * CerraduraE16: dispositivo con estado abierta/cerrada.
 */
final class CerraduraE16 extends DispositivoE16 {

    private boolean cerrada;

    public CerraduraE16(String descripcion, int ubicacion, boolean cerrada) {
        super(descripcion, ubicacion);
        this.cerrada = cerrada;
    }

    @Override
    public String toString() {
        return super.toString() + " estado:" + (cerrada ? "cerrada" : "abierta");
    }
}

/* =========================================================
 * CasaDomoticaE16 (varargs + contadores con instanceof)
 * ========================================================= */

/**
 * CasaDomoticaE16: almacena un array de DispositivoE16 y cuenta bombillas/cerraduras.
 *
 * <p>OJO (como dice el temario): estos contadores son información redundante,
 * porque se podría calcular recorriendo el array. Se usan por eficiencia.</p>
 */
final class CasaDomoticaE16 {

    private final String propietario;
    private final String descripcion;
    private final DispositivoE16[] listaDispositivos;

    private int numBombillas;
    private int numCerraduras;

    /**
     * Constructor con varargs (lista variable de dispositivos).
     *
     * <p>Mientras copiamos dispositivos al array, contamos tipos con instanceof.</p>
     */
    public CasaDomoticaE16(String propietario, String descripcion, DispositivoE16... dispositivos) {
        this.propietario = propietario;
        this.descripcion = descripcion;

        this.listaDispositivos = Arrays.copyOf(dispositivos, dispositivos.length);

        // Inicializamos contadores
        this.numBombillas = 0;
        this.numCerraduras = 0;

        // Contabilizamos usando instanceof
        for (DispositivoE16 d : listaDispositivos) {
            if (d instanceof BombillaE16) {
                numBombillas++;
            } else if (d instanceof CerraduraE16) {
                numCerraduras++;
            }
        }
    }

    public int getNumBombillas() { return numBombillas; }
    public int getNumCerraduras() { return numCerraduras; }

    public void listarDispositivos() {
        System.out.println("\n--- Dispositivos instalados ---");
        for (DispositivoE16 d : listaDispositivos) {
            System.out.println(d);
        }
    }

    @Override
    public String toString() {
        return "CasaDomotica{propietario=\"" + propietario +
                "\", descripcion=\"" + descripcion +
                "\", total=" + listaDispositivos.length + "}";
    }
}