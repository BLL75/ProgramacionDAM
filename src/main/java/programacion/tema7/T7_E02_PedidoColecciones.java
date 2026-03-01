import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Tema 7 - Ejercicio 02
 * <p>
 * Objetivo: Introducción a las colecciones en Java.
 * Creamos un sistema sencillo de "Pedido" que almacena varios artículos usando
 * una colección (Collection) y practicamos los métodos principales de la interfaz:
 * add, remove, contains, size, isEmpty, clear, addAll, removeAll, retainAll.
 *
 * <h2>Conceptos que practica</h2>
 * <ul>
 *   <li>Uso de colecciones: {@code Collection<E>} y {@code ArrayList<E>}</li>
 *   <li>Genéricos en colecciones: {@code Collection<Articulo>}</li>
 *   <li>Recorrido con {@code for-each}</li>
 *   <li>Operaciones típicas: add/remove/contains/size/isEmpty/clear</li>
 *   <li>Operaciones entre colecciones: addAll/removeAll/retainAll</li>
 *   <li>Sobrescritura de {@code equals()} y {@code hashCode()} (clave para contains/remove)</li>
 * </ul>
 *
 * @author Bernar
 * @version 1.0
 */
public class T7_E02_PedidoColecciones {

    /**
     * Clase interna Articulo.
     * <p>
     * Representa un producto que puede añadirse a un pedido.
     */
    public static class Articulo {

        /** Código único del artículo (lo usaremos como "identidad") */
        private String codigo;

        /** Nombre del artículo */
        private String nombre;

        /** Precio del artículo */
        private double precio;

        /**
         * Constructor.
         *
         * @param codigo código único
         * @param nombre nombre descriptivo
         * @param precio precio del artículo
         */
        public Articulo(String codigo, String nombre, double precio) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        /**
         * Dos artículos se consideran iguales si tienen el mismo código.
         * <p>
         * Esto es FUNDAMENTAL para que métodos como contains(), remove(),
         * removeAll() y retainAll() funcionen como esperamos.
         *
         * @param o objeto a comparar
         * @return true si tienen el mismo código
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Articulo)) return false;
            Articulo articulo = (Articulo) o;
            return Objects.equals(codigo, articulo.codigo);
        }

        /**
         * hashCode coherente con equals (mismo criterio: codigo).
         *
         * @return hash basado en el código
         */
        @Override
        public int hashCode() {
            return Objects.hash(codigo);
        }

        /**
         * Representación en texto del artículo.
         *
         * @return String con datos del artículo
         */
        @Override
        public String toString() {
            return "Articulo{" +
                    "codigo='" + codigo + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    '}';
        }
    }

    /**
     * Clase interna Pedido.
     * <p>
     * Almacena una colección de artículos y ofrece operaciones básicas
     * definidas en la interfaz Collection.
     */
    public static class Pedido {

        /** Colección de artículos del pedido */
        private final Collection<Articulo> articulos;

        /**
         * Constructor: inicializa la colección con un ArrayList.
         */
        public Pedido() {
            this.articulos = new ArrayList<>();
        }

        /**
         * Añade un artículo al pedido.
         *
         * @param a artículo a añadir
         * @return true si se añadió correctamente
         */
        public boolean addArticulo(Articulo a) {
            return articulos.add(a);
        }

        /**
         * Elimina un artículo del pedido (según equals()).
         *
         * @param a artículo a eliminar
         * @return true si existía y se eliminó
         */
        public boolean removeArticulo(Articulo a) {
            return articulos.remove(a);
        }

        /**
         * Comprueba si el pedido contiene un artículo (según equals()).
         *
         * @param a artículo a comprobar
         * @return true si está en la colección
         */
        public boolean contiene(Articulo a) {
            return articulos.contains(a);
        }

        /**
         * Devuelve el número de artículos del pedido.
         *
         * @return tamaño de la colección
         */
        public int getNumeroArticulos() {
            return articulos.size();
        }

        /**
         * Indica si el pedido está vacío.
         *
         * @return true si no hay artículos
         */
        public boolean estaVacio() {
            return articulos.isEmpty();
        }

        /**
         * Vacía el pedido.
         */
        public void vaciar() {
            articulos.clear();
        }

        /**
         * Muestra los artículos del pedido.
         */
        public void mostrar() {
            if (articulos.isEmpty()) {
                System.out.println("Pedido vacío.");
                return;
            }
            for (Articulo a : articulos) {
                System.out.println("  - " + a);
            }
        }

        /**
         * Añade al pedido actual todos los artículos de otro pedido.
         * (addAll)
         *
         * @param otro pedido del que se añaden los artículos
         * @return true si la colección cambió
         */
        public boolean agregarTodos(Pedido otro) {
            return articulos.addAll(otro.articulos);
        }

        /**
         * Elimina del pedido actual los artículos que estén en el otro pedido.
         * (removeAll)
         *
         * @param otro pedido con artículos a eliminar
         * @return true si la colección cambió
         */
        public boolean eliminarLosDe(Pedido otro) {
            return articulos.removeAll(otro.articulos);
        }

        /**
         * Conserva SOLO los artículos que estén en el otro pedido.
         * (retainAll)
         *
         * @param otro pedido con los artículos que se conservarán
         * @return true si la colección cambió
         */
        public boolean conservarSoloLosDe(Pedido otro) {
            return articulos.retainAll(otro.articulos);
        }
    }

    /**
     * Método de prueba del ejercicio.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // Creamos algunos artículos
        Articulo a1 = new Articulo("A01", "Teclado", 19.99);
        Articulo a2 = new Articulo("A02", "Ratón", 9.99);
        Articulo a3 = new Articulo("A03", "Monitor", 129.99);
        Articulo a4 = new Articulo("A04", "Alfombrilla", 4.99);

        // ✅ Pedido 1
        Pedido p1 = new Pedido();
        p1.addArticulo(a1);
        p1.addArticulo(a2);
        p1.addArticulo(a3);

        System.out.println("== Pedido 1 ==");
        p1.mostrar();
        System.out.println("Número de artículos: " + p1.getNumeroArticulos());
        System.out.println("¿Está vacío? " + p1.estaVacio());

        // ✅ contains: comprobamos por código (aunque creemos un objeto nuevo)
        System.out.println("\n¿Contiene A02? " + p1.contiene(new Articulo("A02", "Cualquier nombre", 0)));

        // ✅ remove: eliminamos también por código
        System.out.println("\nEliminamos A02...");
        p1.removeArticulo(new Articulo("A02", "Ratón", 9.99));
        p1.mostrar();

        // ✅ Pedido 2
        Pedido p2 = new Pedido();
        p2.addArticulo(a3); // coincide con p1 por código
        p2.addArticulo(a4);

        System.out.println("\n== Pedido 2 ==");
        p2.mostrar();

        // ✅ addAll
        System.out.println("\naddAll -> agregamos todo Pedido 2 en Pedido 1");
        p1.agregarTodos(p2);
        p1.mostrar();

        // ✅ removeAll
        System.out.println("\nremoveAll -> eliminamos de Pedido 1 los que estén en Pedido 2");
        p1.eliminarLosDe(p2);
        p1.mostrar();

        // Volvemos a añadir para probar retainAll
        p1.addArticulo(a1);
        p1.addArticulo(a3);

        // ✅ retainAll
        System.out.println("\nretainAll -> conservamos en Pedido 1 solo los que estén en Pedido 2");
        p1.conservarSoloLosDe(p2);
        p1.mostrar();

        // ✅ clear
        System.out.println("\nVaciamos Pedido 2...");
        p2.vaciar();
        System.out.println("¿Pedido 2 está vacío? " + p2.estaVacio());
    }
}