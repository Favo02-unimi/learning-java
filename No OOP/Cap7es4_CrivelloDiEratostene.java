/*Exercise 7.4 The Sieve of Eratosthenes is “a simple, ancient algorithm for
finding all prime numbers up to any given limit,” which you can read about
at https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.
Write a method called sieve that takes an integer parameter, n, and returns
a boolean array that indicates, for each number from 0 to n - 1, whether the
number is prime.

CRIVELLO DI ERATOSTENE
*/

import java.util.Arrays;
import java.util.Scanner;

public class Cap7es4_CrivelloDiEratostene {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Fino a che numero vanno cercati i numeri primi? ");
        int max = in.nextInt();
        int[] array = new int[max];
        int index =0;
        for(int i = 2; i<max; i++){
            array[index]=i;
            index++;
        }
        for(int i = 0; i<array.length-1; i++){
            if (array[i] != 0){
                array=rimuoviMultipli(array[i], array, max);
            }
        }
        boolean[] array2 = new boolean[max];
        array2 = sostituisciTrueFalse(array, max);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }

    public static int[] rimuoviMultipli(int num, int[] array, int max){
        for (int i=0; i<max; i++)
            if(array[i] != num && array[i]%num==0){
                array[i]=0;
            }
        return array;
    }
    public static boolean[] sostituisciTrueFalse(int[] array, int max){
        boolean[] array2 = new boolean[max];
        for(int i=0; i<array.length-1; i++){
            if(array[i]==0){
                array2[i]=false;
            } else {
                array2[i]=true;
            }
        }
        return array2;
    }
}
