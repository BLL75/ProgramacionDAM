/**
 * Tema 7 - Ejercicio 01
 * <p>
 * Objetivo: Entender qué es una clase genérica y para qué sirve.
 * Creamos una "Bolsa" capaz de almacenar un único objeto de cualquier tipo.
 *
 * <h2>Conceptos que practica</h2>
 * <ul>
 *   <li>Clases genéricas: &lt;T&gt;</li>
 *   <li>Getters/Setters con tipo genérico</li>
 *   <li>Uso del operador diamante: &lt;&gt;</li>
 *   <li>Diferencia entre tipos primitivos y clases envoltorio (Integer vs int)</li>
 * </ul>
 *
 * @author Bernar
 * @version 1.0
 */
public class T7_E01_BolsaGenerica {

    /**
     * Clase interna genérica.
     * <p>
     * Representa una bolsa que guarda un único objeto de tipo T.
     *
     * @param <T> Tipo del objeto almacenado (debe ser una clase, no un primitivo)
     */
    public static class Bolsa<T> {

        /** Objeto almacenado en la bolsa */
        private T objeto;

        /**
         * Constructor con valor inicial.
         *
         * @param objeto Valor inicial que se guardará en la bolsa
         */
        public Bolsa(T objeto) {
            this.objeto = objeto;
        }

        /**
         * Constructor vacío.
         * Deja la bolsa sin contenido (null).
         */
        public Bolsa() {
            this.objeto = null;
        }

        /**
         * Devuelve el objeto almacenado.
         *
         * @return objeto de tipo T (puede ser null)
         */
        public T getObjeto() {
            return objeto;
        }

        /**
         * Modifica el objeto almacenado.
         *
         * @param objeto nuevo objeto de tipo T
         */
        public void setObjeto(T objeto) {
            this.objeto = objeto;
        }

        /**
         * Muestra el tipo concreto del objeto almacenado.
         * Si el objeto es null, lo indica.
         */
        public void mostrarTipo() {
            if (objeto == null) {
                System.out.println("La bolsa está vacía (null).");
            } else {
                System.out.println("Tipo almacenado: " + objeto.getClass().getSimpleName());
            }
        }

        /**
         * Representación en texto del contenido de la bolsa.
         *
         * @return String descriptivo del contenido
         */
        @Override
        public String toString() {
            return "Bolsa{objeto=" + objeto + "}";
        }
    }

    /**
     * Método de prueba del ejercicio.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // ✅ Ejemplo 1: Bolsa de Integer (ojo: Integer, no int)
        Bolsa<Integer> bolsaEnteros = new Bolsa<>(10);
        System.out.println(bolsaEnteros);
        bolsaEnteros.mostrarTipo();

        // ✅ Ejemplo 2: Bolsa de String
        Bolsa<String> bolsaTexto = new Bolsa<>("Hola DAM");
        System.out.println(bolsaTexto);
        bolsaTexto.mostrarTipo();

        // ✅ Ejemplo 3: Bolsa vacía y luego le metemos un valor
        Bolsa<Double> bolsaDecimales = new Bolsa<>();
        System.out.println(bolsaDecimales);
        bolsaDecimales.mostrarTipo();

        bolsaDecimales.setObjeto(3.1416);
        System.out.println(bolsaDecimales);
        bolsaDecimales.mostrarTipo();

        /*
         * ❌ Esto NO compila:
         * Bolsa<int> bolsaMal = new Bolsa<>(5);
         *
         * Porque los genéricos solo admiten clases, no tipos primitivos.
         * Debes usar Integer en vez de int, Double en vez de double, etc.
         */
    }
}
