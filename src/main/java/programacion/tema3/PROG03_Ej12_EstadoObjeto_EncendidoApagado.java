package programacion.tema3;

/**
 * PROG03_Ej12_LamparaEstado
 *
 * En este ejercicio trabajamos con uno de los conceptos más importantes
 * de la Programación Orientada a Objetos: **el estado del objeto**.
 *
 * Un objeto puede tener diferentes estados en función de sus atributos,
 * y esos estados determinan cómo se comporta.
 *
 * En nuestro caso, la lámpara tiene DOS atributos fundamentales:
 *
 *   - encendida (boolean): indica si está encendida o apagada
 *   - intensidad (int): nivel de luz entre 0 y 100
 *
 * Esto permite modelar un comportamiento muy parecido al de un dispositivo real.
 *
 * Puntos clave que aprendes aquí:
 *
 *   ✔ Atributos privados → protegen el estado
 *   ✔ Uso de boolean para representar estados lógicos
 *   ✔ Métodos que modifican ese estado de forma controlada
 *   ✔ Evitar estados inválidos (intensidad < 0 o > 100)
 *   ✔ Encapsulación: el objeto controla sus propias reglas internas
 *
 * Autor: Bernardo
 */
public class PROG03_Ej12_EstadoObjeto_EncendidoApagado {

    public static void main(String[] args) {

        Lampara l = new Lampara();

        // Primera lectura del estado inicial (apagada)
        l.mostrarEstado();

        // Cambios de estado a través de métodos seguros
        l.encender();
        l.subirIntensidad(40);
        l.bajarIntensidad(20);
        l.apagar();

        // Estado final
        l.mostrarEstado();
    }
}



// ===================================================================
//                          CLASE LAMPARA
// ===================================================================

class Lampara {

    // ------------------------------------------------------------
    // 🔒 Atributos privados — protección del estado del objeto
    // ------------------------------------------------------------
    /*
     * IMPORTANTE:
     * Los atributos están en "private" para impedir que el usuario
     * del objeto pueda manipular directamente valores críticos.
     *
     * Ejemplo (algo que NO debería permitirse):
     *
     *      lampara.intensidad = 999;
     *      lampara.encendida = true;  // sin control
     *
     * Eso rompería la lógica interna.
     *
     * Gracias a la ENCPSULACIÓN, los únicos que pueden modificar el
     * estado del objeto son sus métodos públicos, que actúan como
     * "guardianes" que aplican las reglas correctamente.
     */
    private boolean encendida;
    private int intensidad;   // valores válidos: 0 a 100


    // ------------------------------------------------------------
    // 🏗 Constructor por defecto — estado inicial del objeto
    // ------------------------------------------------------------
    /*
     * Aquí definimos el estado inicial de TODA lámpara al ser creada.
     *
     * Esto forma parte del "ciclo de vida" del objeto.
     * El constructor es el punto donde se garantiza que el objeto
     * empieza su vida de manera válida.
     */
    Lampara() {
        encendida = false;  // apagada al inicio
        intensidad = 0;     // sin luz
    }


    // ------------------------------------------------------------
    // 💡 Método encender — Cambio de estado controlado
    // ------------------------------------------------------------
    /**
     * Enciende la lámpara.
     *
     * - Solo cambia el estado si realmente estaba apagada.
     * - Establece una intensidad mínima de 10 para simular el
     *   funcionamiento real de una lámpara (no tiene sentido
     *   encenderla con intensidad 0).
     */
    public void encender() {
        if (!encendida) {      // solo si estaba apagada
            encendida = true;
            intensidad = 10;   // nivel básico al encenderse
            System.out.println("Lámpara encendida.");
        }
    }


    // ------------------------------------------------------------
    // 🔌 Método apagar — Modifica el estado de forma segura
    // ------------------------------------------------------------
    /**
     * Cambia el estado a "apagada".
     * Al apagarse, la intensidad siempre debe quedar en 0,
     * porque una lámpara apagada NO emite luz.
     */
    public void apagar() {
        encendida = false;
        intensidad = 0;
        System.out.println("Lámpara apagada.");
    }


    // ------------------------------------------------------------
    // 🔺 Método subirIntensidad — Modifica estado con validación
    // ------------------------------------------------------------
    /**
     * Aumenta la intensidad de la luz.
     *
     * - Solo se permite si la lámpara está encendida.
     * - El objeto se protege a sí mismo para NO superar 100.
     *
     * El objetivo es mantener SIEMPRE un estado válido.
     */
    public void subirIntensidad(int cantidad) {
        if (encendida && cantidad > 0) {
            intensidad += cantidad;

            if (intensidad > 100) {
                intensidad = 100;  // límite máximo permitido
            }

            System.out.println("Intensidad aumentada a " + intensidad);
        }
    }


    // ------------------------------------------------------------
    // 🔻 Método bajarIntensidad — Estado nunca inválido
    // ------------------------------------------------------------
    /**
     * Reduce la intensidad si está encendida.
     * Nunca se permite que la intensidad sea menor de 0.
     */
    public void bajarIntensidad(int cantidad) {
        if (encendida && cantidad > 0) {
            intensidad -= cantidad;

            if (intensidad < 0) {
                intensidad = 0;  // nunca valores negativos
            }

            System.out.println("Intensidad reducida a " + intensidad);
        }
    }


    // ------------------------------------------------------------
    // 📌 Mostrar estado — Lectura del estado interno
    // ------------------------------------------------------------
    public void mostrarEstado() {
        System.out.println("----------------------------------------");
        System.out.println("¿Encendida?: " + (encendida ? "Sí" : "No"));
        System.out.println("Intensidad actual: " + intensidad);
    }
}
