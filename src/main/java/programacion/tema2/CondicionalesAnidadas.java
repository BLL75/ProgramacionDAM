package programacion.tema2;

import java.util.Scanner;

/**
 * @author Bernar
 *
 * Programa que, a partir de una nota cuantitativa (0–10),
 * determina su calificación cualitativa equivalente usando un enum.
 *
 * - < 5   → INSUFICIENTE
 * - 5–6   → SUFICIENTE
 * - 6–7   → BIEN
 * - 7–9   → NOTABLE
 * - 9–10  → SOBRESALIENTE
 */

public class CondicionalesAnidadas {

    // Declaración del enum dentro de la clase
    /*enum Calificacion {
        INSUFICIENTE,
        SUFICIENTE,
        BIEN,
        NOTABLE,
        SOBRESALIENTE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double notaCuantitativa;
        Calificacion notaCualitativa = null; // variable del tipo enum

        System.out.print("Introduce la nota (0 a 10): ");
        notaCuantitativa = sc.nextDouble();

        if (notaCuantitativa < 0 || notaCuantitativa > 10) {
            System.out.println("❌ Error: la nota debe estar entre 0 y 10.");
        } else {

            if (notaCuantitativa < 5)
                notaCualitativa = Calificacion.INSUFICIENTE;

            if (notaCuantitativa >= 5 && notaCuantitativa < 6)
                notaCualitativa = Calificacion.SUFICIENTE;

            if (notaCuantitativa >= 6 && notaCuantitativa < 7)
                notaCualitativa = Calificacion.BIEN;

            if (notaCuantitativa >= 7 && notaCuantitativa < 9)
                notaCualitativa = Calificacion.NOTABLE;

            if (notaCuantitativa >= 9 && notaCuantitativa <= 10)
                notaCualitativa = Calificacion.SOBRESALIENTE;

            System.out.println("La calificación cualitativa equivalente es: " + notaCualitativa);
        }

        sc.close();
    }*/
    
    // Enum para las calificaciones cualitativas
    enum Calificacion {
        SUSPENSO,
        SUFICIENTE,
        BIEN,
        NOTABLE,
        SOBRESALIENTE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aciertos;
        int fallos;
        double notaCuantitativa;
        Calificacion notaCualitativa = null;

        System.out.print("Introduce el número de aciertos: ");
        aciertos = sc.nextInt();

        System.out.print("Introduce el número de errores: ");
        fallos = sc.nextInt();

        // Validación del total de preguntas
        if ((aciertos + fallos) > 20 || aciertos < 0 || fallos < 0) {
            System.out.println("❌ Datos erróneos: el total de preguntas no puede superar 20 ni ser negativo.");
            sc.close();
            return;
        }

        // Cálculo de nota bruta
        notaCuantitativa = aciertos - (fallos * 0.5);

        // Escalado a nota sobre 10
        notaCuantitativa = (notaCuantitativa / 20) * 10;

        // Forzamos el rango 0–10
        if (notaCuantitativa < 0) notaCuantitativa = 0;
        if (notaCuantitativa > 10) notaCuantitativa = 10;

        // Asignación de la calificación cualitativa
        if (notaCuantitativa < 5) {
            notaCualitativa = Calificacion.SUSPENSO;
        }

        if (notaCuantitativa >= 5 && notaCuantitativa < 6) {
            notaCualitativa = Calificacion.SUFICIENTE;
        }

        if (notaCuantitativa >= 6 && notaCuantitativa < 7) {
            notaCualitativa = Calificacion.BIEN;
        }

        if (notaCuantitativa >= 7 && notaCuantitativa < 9) {
            notaCualitativa = Calificacion.NOTABLE;
        }

        if (notaCuantitativa >= 9 && notaCuantitativa <= 10) {
            notaCualitativa = Calificacion.SOBRESALIENTE;
        }

        // Resultado final
        System.out.printf("Nota numérica: %.2f%n", notaCuantitativa);
        System.out.println("Calificación cualitativa: " + notaCualitativa);

        sc.close();
    }
}

