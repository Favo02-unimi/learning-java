/*  Scrivi i metodi shiftLeft e shiftRight, che richiedono due parametri, il vettore
 e il numero di posizioni da ruotare. Ad esempio, shiftRight(v, 2) sposta a destra di due
  posizioni tutti gli elementi del vettore, facendo tornare in principio gli elementi che escono a destra.
  Es. v [7, 3, 15, 41, 9] applicando la shiftRight(v, 2) otterrò [41, 9, 7, 3, 15]

    Autore: Luca Favini, Giacopo Macias
    Data: 02/10/2019
*/
import java.util.*;

public class MetodiScivolamento {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.print("Inserire dimensione vettore: ");
        int dim = in.nextInt();
        System.out.print("Inserire minimo generabile: ");
        int min = in.nextInt();
        System.out.print("Inserire massimo generabile: ");
        int max = in.nextInt();
        System.out.print("Inserire numero di posizioni di scivolamento: ");
        int n = in.nextInt();

        int[] v = creaVettore(dim, min, max);
        System.out.println("Vettore originale: ");
        System.out.println(Arrays.toString(v));

        v=shiftLeft(v, n);
        System.out.println("Vettore scivolato di " + n + " posizioni a sinistra: ");
        System.out.println(Arrays.toString(v));
    }

    public static int[] creaVettore(int dim, int min, int max){
        int[] vett = new int[dim];
        for (int i = 0; i < dim; i++) {
            vett[i] = (int)(Math.random()*(max-min)+1) +min;
        }
        return vett;
    }

    public static int[] shiftLeft(int[] v, int n){
        int[] temp = new int[n];
        for(int i =0; i<n; i++){
            temp[i] = v[i];
        }
        //System.out.printf(Arrays.toString(temp));
        int pos =0;
        for(int i= n ; i<v.length; i++){
            v[pos] = v[i];
            pos++;
        }
        pos=temp.length-1;
        for(int i=v.length-1; i>v.length-n-1; i--){
            v[i] = temp[pos];
            pos--;
        }
        return v;
    }

}
