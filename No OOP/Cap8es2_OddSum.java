/*Exercise 8.2 Write a recursive method named oddSum that takes a positive
odd integer n and returns the sum of odd integers from 1 to n. Start with
a base case, and use temporary variables to debug your solution. You might
find it helpful to print the value of n each time oddSum is invoked.*/

import java.util.*;

public class Cap8es2_OddSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Numero: ");
        int num = in.nextInt();
        if (num%2==0){
            num++;
        }
        oddSum(num, 0);

    }
    public static void oddSum(int n, int cont){
        if (n<0){
            System.out.println(cont);
            return;
        }
        cont+=n;
        //System.out.println(cont);
        oddSum(n-2, cont);
    }
}
