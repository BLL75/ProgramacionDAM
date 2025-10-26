
package programacion.tema2;
import  java.util.Scanner;


/**
 *
 * @author Bernar
 * Escribe un programa que solicite dos números por teclado (inicio y fin, donde
 * inicio debería ser menor o igual que fin) y muestre por pantalla cuántos 
 * múltiplos de tres hay entre esos dos números, ambos incluidos. 
 * Utiliza una variable de tipo contador para ir contándolos.

 */
public class ConceptoContador {
    
    public static void main(String[] args){
        
        int     total;
        int     inicio;
        int     fin;
        int     inicioTxt;
        Scanner sc = new Scanner(System.in);
        
        
        do{
            System.out.println("Escribe el primer número: ");
            inicio = sc.nextInt();
            System.out.println("Escribe el segundo número: ");
            fin = sc.nextInt();
            if(inicio > fin){
                System.out.println("El primer número debe ser menor o igual "
                        + "que el segundo.");
            }
        }while(inicio > fin);
        
        total = 0;
        inicioTxt = inicio;
        while(inicio <= fin){
            if (inicio % 3 == 0){
                total++;
            }
            inicio++;
        }
        System.out.println("Entre " + inicioTxt + " y " + fin + " hay " + total 
                + " múltiplos de tres");
    }
    
}
