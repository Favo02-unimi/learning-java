/*Chiedi un valore intero N all’utente. Crea un vettore di 2N + 1 elementi interi, inizializzandolo con coppie di
valori uguali tra loro, ed un solo valore spaiato. Al termine trova quello spaiato.
*/

import java.util.*;

public class Cap7_NumeriCoppie {
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        System.out.print("Inserire la lunghezza del vettore (in caso sia pari verrà aggiunto 1 per renderla dispari): ");
        int length = in.nextInt();
        long inizio = System.currentTimeMillis();
        if (length%2==0){
            length++;
        }
        int[] vettore = new int[length];
        int numRandom;
        for(int i = 0;i<length-1; i+=2){
            numRandom=numeroRandom(99);
            vettore[i]=numRandom;
            vettore[i+1]=numRandom;
        }
        vettore[length-1]=numeroRandom(99);

        vettore=mischia(vettore, length);

        /*Abbiamo pensato di generare sia l'indice che il numero casualmete, altrimenti il numero da solo è sempre l'ultimo,
ma dato che non ci siamo riusciti abbiamo deciso di genrare le coppie di numeri e riempire la lista in "ordine" e poi
mischiarla, per poi cecare il numero da solo.*/

        System.out.println(Arrays.toString(vettore));

        int indiceSolo=cercaSolo(vettore, length);

        System.out.println(vettore[indiceSolo]);
        long fine=System.currentTimeMillis();
        System.out.println("Il programma ha impiegato "+ (fine-inizio)+" millisecondi");
    }


    public static int numeroRandom(int max){
        Random random = new Random();
        int num = random.nextInt(max)+1;
        //System.out.println(num);
        return num;
    }

    public static int[] mischia(int[] vettore, int length){
        int indice;
        int indice2;
        int temp; //variabile di appoggio per lo scambio
        for(int i=0;i<length-1; i++) {
            indice = numeroRandom(length-1);
            indice2 = numeroRandom(length-1);
            temp = vettore[indice];
            vettore[indice] = vettore[indice2];
            vettore[indice2] = temp;
        }
        return vettore;
    }

    public static int cercaSolo(int[] vettore, int length){
        int cont = 0;
        for(int i=0;i<length;i++) {
            for (int j = 0; j < length; j++) {
                if (vettore[i] == vettore[j]){
                    cont++;}}
            if (cont % 2!=0) {
                return i;
            }
        }
        return -1;
    }
}