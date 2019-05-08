/* Dato un array di n numeri generati casualmente da 0 a 10 stampare un vettore con il numero di volte che si
ripete ogni volte ogni numero.
 */

import java.util.*;

public class Cap7_IstogrammaArray {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire la lunghezza del vettore da generare: ");
        int length = in.nextInt();
        int array[] = riempiRandom(length);

        int[] istogramma = new int[10];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 10; j++)
                if (array[i] == j) {
                    istogramma[j]++;
                }
        }
        System.out.println(Arrays.toString(istogramma));
    }

    public static int[] riempiRandom(int length){
        Random random = new Random();
        int[] array = new int[length];
        for (int i=0; i<length; i++){
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
