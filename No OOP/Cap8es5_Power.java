/*Exercise 8.5 Write a recursive method called power that takes a double x
and an integer n and returns x^n.
Hint: A recursive definition of this operation is x^n = x · x^n−1
Also, remember that anything raised to the zeroth power is 1.
Optional challenge: you can make this method more efficient, when n is even,
using x^n = (x^n/2)^2
*/

import java.util.*;

public class Cap8es5_Power {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Numero base: ");
        double base = in.nextDouble();
        System.out.print("Numero esponente: ");
        int esponente = in.nextInt();

        power(base, esponente, base);

    }
    public static void power(double base, int esponente, double res){
        if(esponente==1){
            System.out.println(res);
            return;
        }
        res = res * base;
        power(base, esponente-1, res);
    }
}
