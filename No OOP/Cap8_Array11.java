/*Given an array of ints, compute recursively the number of times
that the value 11 appears in the array.
array11([1, 2, 11], 0) → 1
array11([11, 11], 0) → 2
array11([1, 2, 3, 4], 0) → 0
*/

import java.util.*;

public class Cap8_Array11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire la lunghezza del vettore da generare: ");
        int array[] = riempiRandom(in.nextInt());
        System.out.print("Numero da cercare: ");
        int num=in.nextInt();
        System.out.println(Arrays.toString(array));
        System.out.print(array11(array, 0, num));

    }
    public static int array11(int[] array, int index, int num){
        if (index >= array.length) {
            return 0;
        }
        if (array[index] == num) {
            return 1 + array11(array, index + 1, num);
        } else {
            return array11(array, index + 1, num);
        }


    }

    public static int[] riempiRandom(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(19)+1;
        }
        return array;
    }
}
