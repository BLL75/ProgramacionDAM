
package programacion.tema2;
import  java.util.Scanner;

/**
 *
 * @author Bernar
 * Escribe un programa que solicite dos números por teclado (inicio y fin, 
 * donde inicio debería ser menor o igual que fin) y muestre por pantalla la 
 * suma de los múltiplos de tres hay entre esos dos números, ambos incluidos. 
 * Utiliza una variable de tipo acumulador para calcular esa suma.

 */
public class ConceptoAcumulador {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int     inicio;
        int     fin;
        int     acumulador;
        int     inicioTxt;
        
        
        
        do{
            System.out.println("Introduces el primer número: ");
            inicio = sc.nextInt();
            System.out.println("Introduce el segundo número: ");
            fin = sc.nextInt();
            if (inicio > fin){
                System.out.println("El primer número menor o igual, repite");
            }
        }while(inicio > fin);
        
        acumulador = 0;
        inicioTxt = inicio;
        while(inicio <= fin){
            if (inicio % 3 == 0){
                acumulador += inicio;
            }
            inicio++;
        }
        System.out.println("La suma de los múltiplos de 3 entre " + inicioTxt + 
                " y " + fin + " es " + acumulador);
        sc.close();
    }
}
