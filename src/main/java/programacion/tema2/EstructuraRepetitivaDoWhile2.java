
package programacion.tema2;
import java.util.Scanner;

/**
 *
 * @author Bernar
 */
public class EstructuraRepetitivaDoWhile2 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int     inicio;
        int     fin;
       
        do{
            System.out.println("Número de inicio: ");
            inicio = sc.nextInt();
            System.out.println("Número de fin: ");
            fin = sc.nextInt();
        
        }while(inicio>fin);
        sc.close();
    }

}
