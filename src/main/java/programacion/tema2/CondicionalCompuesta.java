
package programacion.tema2;

import java.util.Scanner;

/**
 *
 * @author Bernar
 * Crea un programa en Java que pida por teclado un número entero.
   El programa debe indicar si el número es positivo y menor que 100.
   * 
   * Escribe un programa que pida por teclado la edad y si tiene carnet 
   * de conducir (sí / no).
    El programa debe mostrar si la persona puede alquilar un coche.

    💡 Solo puede alquilar si tiene 25 años o más y posee carnet de conducir.
 */
public class CondicionalCompuesta {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int     edad;
        boolean tiene;
        char    carnet;
        
        System.out.println("Edad del cliente: ");
        edad = sc.nextInt();
        
        System.out.println("Tiene carnet: S/N");
        carnet = sc.next().charAt(0);
        
        if ((carnet == 's' || carnet == 'S') && edad >= 25){
            System.out.println("Puede alquilar");
        }
        else{
            System.out.println("No puede");
        }
        
    }
    
    /*public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        int     numero;
        
        System.out.println("Escribe un número entero: ");
        numero = sc.nextInt();
        
        if (numero < 100 && numero >= 0){
            System.out.println("El número es positivo y menor de 100");
        }
        else{
            System.out.println("El número es mayor de cien o negativo");
        }
    } */ 
    
}
