package programacion.tema6;

/**
 * Representa un punto en un plano 2D mediante coordenadas (x, y).
 * <p>
 * Es una clase <b>mutable</b>: sus coordenadas pueden cambiar (mover()).
 * Por eso, cuando otras clases la contienen (composición),
 * hay que vigilar getters/constructores para no filtrar referencias.
 * </p>
 */
public class Punto {

    /** Coordenada X. */
    private double x;

    /** Coordenada Y. */
    private double y;

    /**
     * Constructor normal.
     *
     * @param x coordenada X inicial
     * @param y coordenada Y inicial
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor copia (copy constructor).
     * <p>
     * Crea un {@code Punto} nuevo con las mismas coordenadas que {@code other}.
     * Se usa para hacer <b>copias defensivas</b>.
     * </p>
     *
     * @param other punto a copiar
     */
    public Punto(Punto other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Mueve el punto sumando un desplazamiento a las coordenadas.
     *
     * @param dx desplazamiento en X
     * @param dy desplazamiento en Y
     */
    public void mover(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /** @return coordenada X actual */
    public double getX() { return x; }

    /** @return coordenada Y actual */
    public double getY() { return y; }

    @Override
    public String toString() {
        return "Punto(" + x + ", " + y + ")";
    }
}