/*Calcolatore che in base al resto della divisione del numero per 2 stampa il valore
binario di un numero
 */

import java.util.*;

public class Cap8_CalcolatoreBinario {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Numero decimale: ");
        binario(in.nextInt());

    }
    public static void binario(int num){
        if(num>0){
            System.out.print(num%2);
            binario(num/2);
        }
    }
}
