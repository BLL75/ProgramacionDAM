package programacion.tema6;

/**
 * EJ17 - Tema 6: Interfaces (concepto y uso).
 *
 * <p>Demostración:</p>
 * <ul>
 *   <li>Interfaces = lista de métodos (contrato de comportamiento).</li>
 *   <li>Una clase puede implementar varias interfaces (simula "herencia múltiple" de comportamiento).</li>
 *   <li>Polimorfismo con interfaces: una referencia Depredador puede apuntar a León o Rana.</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej17_Interfaces_DepredadorPresa {

    public static void main(String[] args) {

        // Clases "sin relación de herencia entre ellas", pero comparten comportamientos vía interfaces
        Leon leon = new Leon("Simba");
        Gacela gacela = new Gacela("Gace");
        Rana rana = new Rana("Rani");

        System.out.println("=== Acciones directas por clase ===");
        leon.rugir();
        gacela.pastar();
        rana.croar();

        System.out.println("\n=== Polimorfismo con interfaces (Depredador) ===");
        Depredador[] cazadores = { leon, rana }; // ambos "son" Depredador (implementan la interfaz)

        for (Depredador d : cazadores) {
            // En compile-time sabemos que d tiene los métodos de Depredador.
            // En runtime se ejecuta la versión concreta (león o rana).
            System.out.println(d.observarPresa());
            System.out.println(d.perseguir());
            System.out.println(d.comer());
            System.out.println("---");
        }

        System.out.println("\n=== Polimorfismo con interfaces (Presa) ===");
        Presa[] presas = { gacela, rana }; // rana también es presa

        for (Presa p : presas) {
            System.out.println(p.detectarPeligro());
            System.out.println(p.huir());
            System.out.println(p.esconderse());
            System.out.println("---");
        }

        System.out.println("\n=== Lo importante del tema ===");
        System.out.println("- León y Gacela NO comparten una clase padre útil para 'depredador/presa'.");
        System.out.println("- Rana puede ser Depredador y Presa a la vez -> varias interfaces.");
    }
}

/* =========================================================
 * INTERFACES (contratos de comportamiento)
 * ========================================================= */

/**
 * Interfaz Depredador: define el comportamiento de un animal cazador.
 *
 * <p>Una interfaz normalmente declara métodos SIN implementar.</p>
 * <p>Cualquier clase que la implemente debe definir estos métodos.</p>
 */
interface Depredador {
    String observarPresa();
    String perseguir();
    String comer();
}

/**
 * Interfaz Presa: define el comportamiento de un animal que puede ser cazado.
 */
interface Presa {
    String detectarPeligro();
    String huir();
    String esconderse();
}

/* =========================================================
 * "Jerarquías" distintas (sin relación entre sí)
 * ========================================================= */

/**
 * Clase base de felinos (podría tener muchas cosas de felino).
 * No nos sirve para "presa/depredador" porque no todos los felinos serían presas, etc.
 */
class Felino {
    protected String nombre;

    public Felino(String nombre) {
        this.nombre = nombre;
    }

    public void rugir() {
        System.out.println(nombre + " (felino) ruge: ROAR!");
    }
}

/**
 * Clase base de bóvidos.
 */
class Bovido {
    protected String nombre;

    public Bovido(String nombre) {
        this.nombre = nombre;
    }

    public void pastar() {
        System.out.println(nombre + " (bóvido) está pastando...");
    }
}

/**
 * Clase base de anfibios.
 */
class Anfibio {
    protected String nombre;

    public Anfibio(String nombre) {
        this.nombre = nombre;
    }

    public void croar() {
        System.out.println(nombre + " (anfibio) croa: croac croac");
    }
}

/* =========================================================
 * CLASES CONCRETAS que implementan interfaces
 * ========================================================= */

/**
 * León:
 * - Hereda de Felino (extends)
 * - Implementa Depredador (implements)
 */
class Leon extends Felino implements Depredador {

    public Leon(String nombre) {
        super(nombre);
    }

    @Override
    public String observarPresa() {
        return "León " + nombre + " observa una presa desde la distancia.";
    }

    @Override
    public String perseguir() {
        return "León " + nombre + " persigue rápidamente a la presa.";
    }

    @Override
    public String comer() {
        return "León " + nombre + " se alimenta de la presa.";
    }
}

/**
 * Gacela:
 * - Hereda de Bovido (extends)
 * - Implementa Presa (implements)
 */
class Gacela extends Bovido implements Presa {

    public Gacela(String nombre) {
        super(nombre);
    }

    @Override
    public String detectarPeligro() {
        return "Gacela " + nombre + " detecta peligro y se pone alerta.";
    }

    @Override
    public String huir() {
        return "Gacela " + nombre + " huye a toda velocidad.";
    }

    @Override
    public String esconderse() {
        return "Gacela " + nombre + " intenta esconderse en el grupo.";
    }
}

/**
 * Rana:
 * - Hereda de Anfibio (extends)
 * - Implementa Depredador Y Presa (dos interfaces)
 *
 * <p>Esto es justo lo que NO puedes hacer con clases (no hay herencia múltiple de clases),
 * pero SÍ con interfaces (múltiples comportamientos).</p>
 */
class Rana extends Anfibio implements Depredador, Presa {

    public Rana(String nombre) {
        super(nombre);
    }

    // Depredador
    @Override
    public String observarPresa() {
        return "Rana " + nombre + " observa un insecto.";
    }

    @Override
    public String perseguir() {
        return "Rana " + nombre + " se acerca lentamente y lanza la lengua.";
    }

    @Override
    public String comer() {
        return "Rana " + nombre + " se come el insecto.";
    }

    // Presa
    @Override
    public String detectarPeligro() {
        return "Rana " + nombre + " detecta vibraciones (posible depredador).";
    }

    @Override
    public String huir() {
        return "Rana " + nombre + " huye saltando hacia el agua.";
    }

    @Override
    public String esconderse() {
        return "Rana " + nombre + " se esconde entre plantas acuáticas.";
    }
}