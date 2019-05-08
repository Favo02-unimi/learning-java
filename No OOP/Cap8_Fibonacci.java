/* Calcolatore ricorsivo della successione di Fibonacci di un numero */

import java.util.*;

public class Cap8_Fibonacci {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.print("Successione di Fibonacci di: ");
        long res = fibonacci(in.nextInt());
        System.out.println(res);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
