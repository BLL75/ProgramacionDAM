package programacion.tema3;

/**
 * PROG03_Ej04_RectanguloAreaPerimetro
 *
 * Este ejercicio demuestra:
 *   - Cómo modelar un objeto real (Rectángulo) usando clases.
 *   - Cómo usar un constructor para inicializar atributos.
 *   - Cómo crear métodos que devuelven valores (return).
 *   - Cómo representar el estado y el comportamiento de un objeto.
 *   - Cómo instanciar varios objetos con características distintas.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej04_RectanguloAreaPerimetro {
    
    public static void main(String[] args) {
        
        /*
         * Creamos dos rectángulos distintos.
         * Cada instancia tiene sus propios valores de "alto" y "ancho".
         */
        Rectangulo r1 = new Rectangulo(3.43, 1.22);
        Rectangulo r2 = new Rectangulo(2.66, 4.63);
        
        /*
         * Llamamos al método mostrarDatos(),
         * que imprime:
         *   - alto
         *   - ancho
         *   - área
         *   - perímetro
         * 
         * Esto demuestra el uso de:
         *   - métodos dentro de métodos
         *   - cálculo dinámico según los valores del objeto
         */
        r1.mostrarDatos();
        r2.mostrarDatos();
    }
}



// ---------------------------------------------------------------------
//                          CLASE RECTANGULO
// ---------------------------------------------------------------------

/*
 * Esta clase representa un rectángulo real mediante:
 *   - atributos → describen el ESTADO del objeto
 *   - métodos → describen su COMPORTAMIENTO
 */
class Rectangulo {
    
    // ------------------------------------------------
    // 1. ATRIBUTOS → Estado del objeto
    // ------------------------------------------------
    /*
     * Estos atributos guardan los valores que definen al rectángulo.
     * Cada instancia tendrá sus propios valores.
     */
    double alto;
    double ancho;
    
    
    // ------------------------------------------------
    // 2. CONSTRUCTOR → Inicializa el estado
    // ------------------------------------------------
    /*
     * Este constructor recibe dos valores y los asigna a los atributos.
     * 
     * "this" diferencia entre:
     *      this.alto  → atributo del objeto
     *      alto       → parámetro recibido
     */
    Rectangulo(double alto, double ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }
    
    
    // ------------------------------------------------
    // 3. MÉTODO area() → Devuelve un valor
    // ------------------------------------------------
    /*
     * Calcula y devuelve el área del rectángulo.
     * 
     * Uso de return:
     *   - finaliza el método
     *   - devuelve el resultado del cálculo al que haga la llamada
     */
    double area() {
        return alto * ancho;
    }
    
    
    // ------------------------------------------------
    // 4. MÉTODO perimetro() → Devuelve un valor
    // ------------------------------------------------
    /*
     * Calcula el perímetro usando:
     *    2 × (alto + ancho)
     */
    double perimetro() {
        return 2 * (alto + ancho);
    }
    
    
    // ------------------------------------------------
    // 5. MÉTODO mostrarDatos() → No devuelve nada (void)
    // ------------------------------------------------
    /*
     * Imprime toda la información del rectángulo.
     * 
     * Observa que este método llama internamente a:
     *    area() y perimetro()
     * 
     * Esto demuestra el REUSO de comportamiento dentro de la propia clase.
     */
    void mostrarDatos() {
        System.out.println("--------------------------");
        System.out.println("Alto: " + alto);
        System.out.println("Ancho: " + ancho);
        System.out.println("Área: " + area());           // llama al método area()
        System.out.println("Perímetro: " + perimetro()); // llama al método perimetro()
    }
}
