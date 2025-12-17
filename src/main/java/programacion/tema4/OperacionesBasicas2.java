package programacion.tema4;

import java.util.Scanner;

public class OperacionesBasicas2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nombre;
        boolean valido;

        do {
            System.out.println("Introduce tu nombre y apellido (solo letras minúsculas y un espacio):");
            nombre = sc.nextLine().trim(); // elimina espacios al inicio y al final
            valido = true;
            int contadorEspacios = 0;

            // Validar caracteres y contar espacios
            for (int i = 0; i < nombre.length(); i++) {
                char c = nombre.charAt(i);
                if (c == ' ') {
                    contadorEspacios++;
                } else if (c < 'a' || c > 'z') {
                    System.out.println("Solo se permiten letras minúsculas.");
                    valido = false;
                    break;
                }
            }

            // Validar número de espacios
            if (contadorEspacios != 1) {
                System.out.println("El nombre debe contener un único espacio entre nombre y apellido.");
                valido = false;
            }

            // Validar que el espacio no esté al principio ni al final
            if (nombre.startsWith(" ") || nombre.endsWith(" ")) {
                System.out.println("El nombre no puede tener espacios al principio ni al final.");
                valido = false;
            }

        } while (!valido);

        System.out.println("Nombre válido: " + nombre);
    }
}
