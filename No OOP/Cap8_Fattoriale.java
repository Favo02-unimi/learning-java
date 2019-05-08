/* Calcolatore ricorsivo del fattoriale di un numero */

import java.util.*;

public class Cap8_Fattoriale {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.print("Fattoriale di: ");
        long res = factorial(in.nextInt());
        System.out.println(res);

    }
    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }



}
