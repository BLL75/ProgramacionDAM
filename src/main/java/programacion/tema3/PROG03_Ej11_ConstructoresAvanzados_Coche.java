package programacion.tema3;

/**
 * PROG03_Ej11_ConstructoresAvanzados_Coche
 *
 * En este ejercicio se practican varios tipos de constructores:
 *
 * 1. Constructor por defecto:
 *      - Inicializa valores predeterminados.
 * 
 * 2. Constructor con parámetros:
 *      - Permite crear el objeto totalmente configurado.
 *      - Incluye validación para evitar velocidades negativas.
 *
 * 3. Constructor copia:
 *      - Crea un NUEVO objeto duplicando otro existente.
 *      - Importante: NO copia la referencia, sino los valores.
 *
 * También se aplican:
 *      - Encapsulación básica mediante atributos privados.
 *      - Métodos que modifican el estado del objeto de forma controlada.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej11_ConstructoresAvanzados_Coche {
    
    public static void main(String[] args){
        
        // 1. Coche con constructor por defecto
        Coche coche1 = new Coche();
        coche1.mostrarDatos();
        
        // 2. Coche con valores personalizados (constructor con parámetros)
        Coche coche2 = new Coche("Toyota", "Corolla", 150);
        coche2.mostrarDatos();
        
        // 3. Coche creado a partir de otro (constructor copia)
        Coche coche3 = new Coche(coche2);
        coche3.mostrarDatos();
        
        // Modificaciones de prueba para comprobar independencia de objetos
        coche1.acelerar(50);
        coche3.frenar(40);
        
        coche1.mostrarDatos();
        coche3.mostrarDatos();
    }
}



class Coche{
    
    // ------------------------------------------------------------
    // 🔒 ATRIBUTOS PRIVADOS — Encapsulación
    // ------------------------------------------------------------
    private String marca;
    private String modelo;
    private int velocidad;
    
    
    // ------------------------------------------------------------
    // 🏗 1. CONSTRUCTOR POR DEFECTO
    // ------------------------------------------------------------
    /**
     * Inicializa un coche con valores genéricos.
     * Útil cuando aún no se conocen los datos concretos.
     */
    Coche(){
        this.marca = "Desconocida";
        this.modelo = "Desconocida";
        this.velocidad = 0;
    }
    
    
    // ------------------------------------------------------------
    // 🏗 2. CONSTRUCTOR CON PARÁMETROS
    // ------------------------------------------------------------
    /**
     * Permite crear un coche completamente configurado.
     * Se valida que la velocidad no sea negativa.
     */
    Coche(String marca, String modelo, int velocidad){
        this.marca = marca;
        this.modelo = modelo;
        
        if (velocidad < 0){
            this.velocidad = 0;
        } else {
            this.velocidad = velocidad;
        }
    }
    
    
    // ------------------------------------------------------------
    // 🏗 3. CONSTRUCTOR COPIA
    // ------------------------------------------------------------
    /**
     * Crea un coche NUEVO copiando los datos de otro coche.
     * MUY IMPORTANTE:
     *
     *  - Esto copia el OBJETO, NO la referencia.
     *  - Permite tener dos coches independientes,
     *    aunque uno haya sido creado a partir del otro.
     *
     * Ejemplo:
     *
     *    Coche c1 = new Coche("Ford", "Focus", 90);
     *    Coche c2 = new Coche(c1);     // copia REAL
     *
     *    c2.acelerar(20);  // solo afecta a c2
     */
    Coche(Coche original){
        this.marca = original.marca;
        this.modelo = original.modelo;
        this.velocidad = original.velocidad;
    }
    
    
    // ------------------------------------------------------------
    // ➕ MÉTODO ACELERAR — Modifica el estado del objeto
    // ------------------------------------------------------------
    /**
     * Aumenta la velocidad del coche.
     * Solo acepta cantidades positivas.
     */
    public void acelerar(int cantidad){
        if (cantidad > 0){
            velocidad += cantidad;
        }
    }
    
    
    // ------------------------------------------------------------
    // ➖ MÉTODO FRENAR — Evita valores inválidos
    // ------------------------------------------------------------
    /**
     * Reduce la velocidad. Nunca puede ser negativa.
     */
    public void frenar(int cantidad) {
        if (cantidad > 0) {
            velocidad -= cantidad;
            
            if (velocidad < 0) {
                velocidad = 0;
            }
        }
    }
    
    
    // ------------------------------------------------------------
    // 📌 MOSTRAR DATOS — Lectura del estado del objeto
    // ------------------------------------------------------------
    public void mostrarDatos() {
        System.out.println("------------------------------------------");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad actual: " + velocidad + " km/h");
    }
}
