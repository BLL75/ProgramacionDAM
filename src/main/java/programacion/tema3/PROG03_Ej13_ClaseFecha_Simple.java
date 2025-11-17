package programacion.tema3;

/**
 * PROG03_Ej13_ClaseFecha_Simple
 *
 * En este ejercicio se trabaja:
 *   - Encapsulación (atributos privados)
 *   - Validación de estado interno
 *   - Métodos auxiliares privados
 *   - Reglas de negocio para manejar fechas reales
 *   - Simulación de avance del tiempo (avanzarDia)
 *
 * Esta clase es un excelente ejemplo de cómo un objeto controla
 * sus propias reglas internas y mantiene SIEMPRE un estado válido.
 *
 * Autor: Bernardo
 */
public class PROG03_Ej13_ClaseFecha_Simple {

    public static void main(String[] args) {
        
        // Fecha válida
        Fecha f1 = new Fecha(10, 3, 2024);
        f1.mostrarFecha();
        
        // Fecha inválida → se asigna fecha por defecto
        Fecha f2 = new Fecha(40, 2, 2020);
        f2.mostrarFecha();
        
        // Avanzamos varios días
        System.out.println("Avanzando días...");
        for (int i = 0; i < 15; i++) {
            f1.avanzarDia();
        }
        
        f1.mostrarFecha();
    }
}



// ===================================================================
//                                CLASE FECHA
// ===================================================================

class Fecha {

    // ------------------------------------------------------------
    // 🔒 ATRIBUTOS PRIVADOS — Encapsulan y protegen el estado
    // ------------------------------------------------------------
    private int dia;
    private int mes;
    private int año;


    // ------------------------------------------------------------
    // 🏗 CONSTRUCTOR CON PARÁMETROS
    // ------------------------------------------------------------
    /**
     * Recibe día, mes y año.
     * Si la fecha NO es válida, usa una fecha por defecto (1/1/2000).
     */
    Fecha(int dia, int mes, int año) {

        if (esValida(dia, mes, año)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        } else {
            // Fecha por defecto
            this.dia = 1;
            this.mes = 1;
            this.año = 2000;
        }
    }


    // ------------------------------------------------------------
    // 🔐 MÉTODO PRIVADO — VALIDACIÓN DE FECHA
    // ------------------------------------------------------------
    /**
     * Comprueba que la fecha sea válida.
     * Método privado porque NO debe ser accesible desde fuera,
     * solo se usa internamente por el constructor.
     */
    private boolean esValida(int d, int m, int a) {

        if (a <= 0) return false;
        if (m < 1 || m > 12) return false;

        int diasMes = diasDelMes(m);

        return d >= 1 && d <= diasMes;
    }


    // ------------------------------------------------------------
    // 🔐 MÉTODO PRIVADO — DÍAS DEL MES
    // ------------------------------------------------------------
    /**
     * Devuelve la cantidad de días de un mes determinado.
     * No contemplamos años bisiestos en esta versión simple
     * (aunque podríamos añadirlo fácilmente).
     */
    private int diasDelMes(int m) {
        return switch (m) {
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }


    // ------------------------------------------------------------
    // 🔄 MÉTODO AVANZAR DÍA
    // ------------------------------------------------------------
    /**
     * Avanza un día respetando las reglas del calendario:
     *
     * - Si el día pasa del número máximo del mes → cambiamos de mes
     * - Si el mes pasa de 12 → cambiamos de año
     */
    public void avanzarDia() {

        dia++;

        if (dia > diasDelMes(mes)) {
            dia = 1;
            mes++;

            if (mes > 12) {
                mes = 1;
                año++;
            }
        }
    }


    // ------------------------------------------------------------
    // 📌 MÉTODO MOSTRAR FECHA
    // ------------------------------------------------------------
    public void mostrarFecha() {
        System.out.println(dia + "/" + mes + "/" + año);
    }
}
