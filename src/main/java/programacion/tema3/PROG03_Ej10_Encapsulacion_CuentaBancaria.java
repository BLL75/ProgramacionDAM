package programacion.tema3;

/**
 * PROG03_Ej10_Encapsulacion_CuentaBancaria
 *
 * Este ejercicio demuestra el PRINCIPIO DE ENCAPSULACIÓN, uno de los pilares
 * fundamentales de la Programación Orientada a Objetos (POO).
 *
 * ENCAPSULACIÓN significa:
 *  -----------------------------------------------------------------------
 *  |  → Los datos importantes (estado) de un objeto están protegidos     |
 *  |  → No se puede acceder a ellos directamente desde fuera de la clase |
 *  |  → Solo se accede mediante MÉTODOS PÚBLICOS y CONTROLADOS           |
 *  -----------------------------------------------------------------------
 *
 * Aplicamos:
 *   - Atributos privados (private)
 *   - Métodos públicos para leer o modificar de forma segura (getters/setters)
 *   - Validación interna que evita estados inválidos (saldo negativo, ingresos incorrectos…)
 *
 * Al final del programa, el objeto SIEMPRE tiene un estado válido,
 * sin importar lo que intente hacer el código externo.
 *
 * Autor: Bernardo Luque
 */
public class PROG03_Ej10_Encapsulacion_CuentaBancaria {
    
    public static void main(String[] args){

        // Creamos una cuenta válida
        CuentaBancaria cuenta = new CuentaBancaria("Bernardo", 100);

        // Operaciones seguras mediante métodos controlados
        cuenta.ingresar(200);      // saldo: 300
        cuenta.retirar(50);        // saldo: 250
        cuenta.retirar(9999);      // rechazado: saldo insuficiente

        cuenta.mostrarDatos();
    }
}



// ===================================================================
//                         CLASE CUENTABANCARIA
// ===================================================================

/**
 * Esta clase representa una cuenta bancaria REALISTA:
 * 
 * - El titular nunca cambia desde fuera.
 * - El saldo no puede manipularse directamente.
 * - El estado interno SIEMPRE se mantiene correcto.
 *
 * Esto es posible gracias a la ENCAPSULACIÓN:
 *    → private: oculta los datos
 *    → métodos públicos: verifican reglas antes de modificar
 */
class CuentaBancaria {

    // ---------------------------------------------------------------------------
    // 🔒 1. ATRIBUTOS PRIVADOS — PROTEGEN EL ESTADO DEL OBJETO
    // ---------------------------------------------------------------------------
    /*
     * Usamos private para que NADIE desde fuera pueda hacer:
     * 
     *   cuenta.saldo = -9999;   // PROHIBIDO
     *   cuenta.titular = "Hacker";
     *
     * Gracias a esto, ningún valor incorrecto puede entrar “a la fuerza”.
     */
    private String titular;
    private double saldo;


    // ---------------------------------------------------------------------------
    // 🏗 2. CONSTRUCTOR — VALIDACIÓN DEL ESTADO INICIAL
    // ---------------------------------------------------------------------------
    /*
     * Este constructor garantiza que la cuenta siempre empieza en un estado válido.
     * Si el saldo inicial es negativo, automáticamente se corrige a 0.
     *
     * El propio objeto SE PROTEGE a sí mismo.
     */
    CuentaBancaria(String titular, double saldoInicial) {

        this.titular = titular;

        if (saldoInicial < 0) {
            this.saldo = 0;   // nunca permitimos saldos negativos
        } else {
            this.saldo = saldoInicial;
        }
    }


    // ---------------------------------------------------------------------------
    // 🔍 3. GETTERS — ACCESO DE LECTURA SEGURO
    // ---------------------------------------------------------------------------
    /*
     * Permitimos CONSULTAR los datos, pero NO modificarlos directamente.
     * Eso mantiene el control dentro del objeto.
     */
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }


    // ---------------------------------------------------------------------------
    // ➕ 4. MÉTODO INGRESAR — MÉTODO SEGURO CON VALIDACIÓN
    // ---------------------------------------------------------------------------
    /*
     * Este método permite ingresar dinero, pero SOLO si la cantidad es positiva.
     *
     * Así evitamos errores como:
     *      ingresar(-50) → que equivaldría a retirar dinero de forma no segura.
     *
     * El método actúa como un “GUARDIÁN” que protege el estado del objeto.
     */
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
        // si cantidad <= 0, simplemente se ignora
    }


    // ---------------------------------------------------------------------------
    // ➖ 5. MÉTODO RETIRAR — PROTEGE CONTRA SALDOS NEGATIVOS
    // ---------------------------------------------------------------------------
    /*
     * Solo permite retirar si:
     *   1. La cantidad es positiva
     *   2. Hay saldo suficiente
     *
     * Esto evita que la cuenta quede en números rojos.
     *
     * Este tipo de método es típico en OOP: los métodos DELIMITAN lo que
     * puede o no ocurrir dentro del objeto.
     */
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("OPERACIÓN DENEGADA: saldo insuficiente.");
        }
    }


    // ---------------------------------------------------------------------------
    // 📌 6. MÉTODO MOSTRAR DATOS — LECTURA DEL ESTADO DEL OBJETO
    // ---------------------------------------------------------------------------
    public void mostrarDatos() {
        System.out.println("-----------------------------------");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: " + saldo + " €");
        System.out.println("-----------------------------------");
    }
}
