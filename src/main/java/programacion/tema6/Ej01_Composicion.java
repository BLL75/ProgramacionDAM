package programacion.tema6;

/**
 * Ejercicio 01 - Composición vs Herencia (versión correcta: COMPOSICIÓN).
 * <p>
 * Idea clave: un {@link Circulo} <b>TIENE</b> un {@link Punto} (su centro).
 * </p>
 */
public class Ej01_Composicion {

    public static void main(String[] args) {

        // 1) Creamos el centro (Punto)
        Punto centro = new Punto(33, 44);
        System.out.println("Centro: " + centro);

        // 2) Creamos el círculo (COMPOSICIÓN)
        Circulo c = new Circulo(centro, 5);

        // 3) Mostramos información
        System.out.println("Círculo: " + c);
        System.out.println("Área: " + c.area());
        System.out.println("Perímetro: " + c.perimetro());

        // 4) Movemos el círculo (mueve su centro internamente)
        c.mover(10, -4);
        System.out.println("\nTras mover el círculo: " + c);
    }
}

/**
 * Representa un círculo en el plano.
 * <p>
 * COMPOSICIÓN: un círculo <b>contiene</b> un {@link Punto} como centro.
 * </p>
 *
 * <p><b>Nota</b>: En este Ej01 lo dejamos simple.
 * En el Ej02 verás por qué a veces interesa hacer copias defensivas.</p>
 */
class Circulo {

    /** Centro del círculo (objeto contenido). */
    private Punto centro;

    /** Radio del círculo. */
    private double radio;

    /**
     * Constructor.
     *
     * @param centro centro del círculo
     * @param radio radio del círculo
     */
    public Circulo(Punto centro, double radio) {
        this.centro = centro; // (simple)
        this.radio = radio;
    }

    /**
     * Mueve el círculo: delega el movimiento al centro.
     *
     * @param dx desplazamiento en X
     * @param dy desplazamiento en Y
     */
    public void mover(double dx, double dy) {
        centro.mover(dx, dy);
    }

    /** @return área del círculo */
    public double area() {
        return Math.PI * radio * radio;
    }

    /** @return perímetro del círculo */
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Circulo(centro=" + centro + ", radio=" + radio + ")";
    }
}