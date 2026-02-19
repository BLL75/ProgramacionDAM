package programacion.tema6;

/**
 * Ej02 - Preservación de la ocultación en composición (getters/constructores/setters).
 * <p>
 * Demuestra:
 * <ol>
 *   <li><b>RectanguloMalo</b>: fuga de referencia (getter devuelve el objeto interno).</li>
 *   <li><b>RectanguloSeguro</b>: copias defensivas en constructor, getters y setters.</li>
 * </ol>
 * </p>
 *
 * <p>
 * Requisito para que funcione sin problemas:
 * Debe existir la clase {@link Punto} en su propio archivo {@code Punto.java}
 * dentro del mismo paquete {@code programacion.tema6}.
 * </p>
 */
public class Ej02_Rectangulo_GettersSeguros {

    public static void main(String[] args) {

        System.out.println("=== 1) RECTÁNGULO MALO (fuga de referencia) ===");
        Punto a = new Punto(0, 0);
        Punto b = new Punto(2, 1);

        RectanguloMalo rm = new RectanguloMalo(a, b);
        System.out.println("Inicial: " + rm);

        // Getter devuelve la referencia REAL del atributo interno:
        Punto v1 = rm.getVertice1();
        v1.mover(100, 100); // modifico desde fuera SIN pasar por Rectangulo

        System.out.println("Tras mover v1 (obtenido por getter): " + rm);
        System.out.println("BUG FANTASMA: el rectángulo cambió sin llamar a métodos del rectángulo.\n");

        // Además, como el constructor guardó las referencias a y b:
        a.mover(0, 999); // toco el punto original a
        System.out.println("Tras mover 'a' (externo) otra vez: " + rm);
        System.out.println("Efecto colateral: compartir referencias rompe el aislamiento.\n");


        System.out.println("=== 2) RECTÁNGULO SEGURO (copias defensivas) ===");
        Punto c = new Punto(0, 0);
        Punto d = new Punto(2, 1);

        RectanguloSeguro rs = new RectanguloSeguro(c, d);
        System.out.println("Inicial: " + rs);

        // Getter devuelve COPIA:
        Punto copiaV1 = rs.getVertice1();
        copiaV1.mover(100, 100); // esto NO debe afectar al rectángulo

        System.out.println("Tras mover copiaV1 (devuelta por getter): " + rs);

        // Como el constructor hizo copia, mover el punto externo tampoco afecta:
        c.mover(0, 999);
        System.out.println("Tras mover 'c' (externo): " + rs);

        // Para cambiar el rectángulo correctamente, usamos su interfaz:
        rs.mover(1, 1);
        System.out.println("Tras mover el rectángulo con rs.mover(): " + rs);
    }
}

/**
 * Rectángulo MAL encapsulado.
 * <p>
 * Problemas intencionados:
 * <ul>
 *   <li>Constructor: guarda referencias externas (aliasing).</li>
 *   <li>Getters: devuelven referencias internas (fuga de referencia).</li>
 * </ul>
 * </p>
 */
class RectanguloMalo {

    /** Vértice inferior izquierdo. */
    private Punto vertice1;

    /** Vértice superior derecho. */
    private Punto vertice2;

    /**
     * Constructor peligroso: guarda directamente referencias externas.
     *
     * @param vertice1 punto externo (se comparte si no se copia)
     * @param vertice2 punto externo (se comparte si no se copia)
     */
    public RectanguloMalo(Punto vertice1, Punto vertice2) {
        this.vertice1 = vertice1; // MAL: comparte referencias
        this.vertice2 = vertice2; // MAL: comparte referencias
    }

    /**
     * Getter peligroso: devuelve la referencia interna real.
     *
     * @return referencia al objeto interno (fuga de referencia)
     */
    public Punto getVertice1() {
        return vertice1; // MAL
    }

    /**
     * Getter peligroso: devuelve la referencia interna real.
     *
     * @return referencia al objeto interno (fuga de referencia)
     */
    public Punto getVertice2() {
        return vertice2; // MAL
    }

    /**
     * Mueve el rectángulo moviendo ambos vértices.
     *
     * @param dx desplazamiento X
     * @param dy desplazamiento Y
     */
    public void mover(double dx, double dy) {
        vertice1.mover(dx, dy);
        vertice2.mover(dx, dy);
    }

    @Override
    public String toString() {
        return "RectanguloMalo(v1=" + vertice1 + ", v2=" + vertice2 + ")";
    }
}

/**
 * Rectángulo BIEN encapsulado (solución).
 * <p>
 * Aplica <b>copias defensivas</b>:
 * <ul>
 *   <li>Constructor: copia los puntos recibidos.</li>
 *   <li>Getters: devuelven copias.</li>
 *   <li>Setters: guardan copias.</li>
 * </ul>
 * </p>
 */
class RectanguloSeguro {

    private Punto vertice1;
    private Punto vertice2;

    /**
     * Constructor seguro: crea copias de los puntos recibidos.
     * <p>
     * Esto evita que el rectángulo "comparta" los puntos con el exterior.
     * </p>
     *
     * @param vertice1 punto recibido
     * @param vertice2 punto recibido
     */
    public RectanguloSeguro(Punto vertice1, Punto vertice2) {
        this.vertice1 = new Punto(vertice1); // copia defensiva
        this.vertice2 = new Punto(vertice2); // copia defensiva
    }

    /**
     * Getter seguro: devuelve una copia del vértice 1.
     *
     * @return copia de vertice1
     */
    public Punto getVertice1() {
        return new Punto(vertice1);
    }

    /**
     * Getter seguro: devuelve una copia del vértice 2.
     *
     * @return copia de vertice2
     */
    public Punto getVertice2() {
        return new Punto(vertice2);
    }

    /**
     * Setter seguro: guarda una copia del punto recibido.
     *
     * @param p nuevo vértice 1
     */
    public void setVertice1(Punto p) {
        this.vertice1 = new Punto(p);
    }

    /**
     * Setter seguro: guarda una copia del punto recibido.
     *
     * @param p nuevo vértice 2
     */
    public void setVertice2(Punto p) {
        this.vertice2 = new Punto(p);
    }

    /**
     * Mueve el rectángulo moviendo ambos vértices internos.
     *
     * @param dx desplazamiento X
     * @param dy desplazamiento Y
     */
    public void mover(double dx, double dy) {
        vertice1.mover(dx, dy);
        vertice2.mover(dx, dy);
    }

    @Override
    public String toString() {
        return "RectanguloSeguro(v1=" + vertice1 + ", v2=" + vertice2 + ")";
    }
}