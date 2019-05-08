/*Programma che somma tutti gli elementi di un array*/

import java.util.*;

public class Cap7_SommaArray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire la lunghezza del vettore da generare: ");
        int length = in.nextInt();
        int v[]= riempiRandom(length);

        System.out.println(Arrays.toString(v));

        int somma=0;
        for (int i=0; i<v.length;i++){
            somma+=v[i];
        }
        System.out.println("La somma dell'array è: "+somma);


    }
    public static int[] riempiRandom(int length){
        Random random = new Random();
        int[] array = new int[length];
        for (int i=0; i<length; i++){
            array[i] = random.nextInt(99)+1;
        }
        return array;
    }
}
