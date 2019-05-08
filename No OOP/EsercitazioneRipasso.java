import java.util.*;

/*  Esercitazione Ripasso
    Autore: Luca Favini, Giacopo Macias
    Data: 25/09/2019
*/

public class EsercitazioneRipasso {
    public static void main(String[] args){

        /*Crea un vettore di 10 valori casuali, attraverso il metodo creaVettore, che richiede come primo parametro la
        dimensione del vettore, come secondo e terzo parametro il valore minimo e massimo per i numeri casuali.
        Ad esempio creaVettore(10, 1, 100) crea un vettore di 10 valori interi compresi tra 1 e 100.*/

        Scanner in = new Scanner (System.in);
        System.out.print("Inserire dimensione vettore: ");
        int dim = in.nextInt();
        System.out.print("Inserire minimo generabile: ");
        int min = in.nextInt();
        System.out.print("Inserire massimo generabile: ");
        int max = in.nextInt();
        System.out.print("Vuoi vedere stampati i vettori? [si/no]");
        String temp = in.next();
        boolean stampa;
        if(temp.equalsIgnoreCase("si"))
            stampa = true;
        else if(temp.equalsIgnoreCase("no"))
            stampa = false;
        else {
            System.out.println("Rispondere \"si\" o \"no\"");
            return;
        }


        int[] vett = creaVettore(dim, min, max);

        /*Stampa i vettore creato attraverso nei seguenti due modi: metodo stampaVettore(int[] v), utilizzando
         l’enhanced for,  e utilizzando la classe java.util.Arrays */
        if(stampa) {
            System.out.println("----------------------------------------------------");
            System.out.println("Stampa tramite enhanced for: ");
            stampaVettore(vett);
            System.out.println("Stampa tramite classe Arrays: ");
            System.out.println(Arrays.toString(vett));
            System.out.println("----------------------------------------------------");
        }

        /*Ordina il vettore creato attraverso i seguenti quattro modi:
	        3.1 metodo sort della classe Arrays
	    */

        int[] vettOrd1;
        vettOrd1= Arrays.copyOf(vett, dim);
        long inizioClasse = System.currentTimeMillis();
        Arrays.sort(vettOrd1);
        long fineClasse = System.currentTimeMillis();
        System.out.println("----------------------------------------------------");
        if(stampa) {
            System.out.println("Ordinato tramite classe Arrays: ");
            System.out.println(Arrays.toString(vettOrd1));
        }
        long diffClasse = fineClasse - inizioClasse;
        System.out.println("Tempo ordinamento classe Arrays: " + diffClasse);
        System.out.println("----------------------------------------------------");

        /*Ordina il vettore creato attraverso i seguenti quattro modi:
	        3.2 metodo sortBubble che utilizza il bubblesort (con i miglioramenti che ritieni utili)
	    */
        int[] vettOrd2;
        vettOrd2= Arrays.copyOf(vett, dim);
        long inizioBubble = System.currentTimeMillis();
        vettOrd2=bubbleSort(vettOrd2);
        long fineBubble = System.currentTimeMillis();
        System.out.println("----------------------------------------------------");
        if(stampa) {
            System.out.println("Ordinato tramite bubble sort: ");
            System.out.println(Arrays.toString(vettOrd2));
        }
        long diffBubble = fineBubble - inizioBubble;
        System.out.println("Tempo ordinamento Bubble sort: " + diffBubble);
        System.out.println("----------------------------------------------------");

        /*Ordina il vettore creato attraverso i seguenti quattro modi:
	        3.3 metodo sortSelect con l’ordinamento per selezione
	    */
        int[] vettOrd3;
        vettOrd3= Arrays.copyOf(vett, dim);
        long inizioSelect = System.currentTimeMillis();
        vettOrd3=selectionSort(vettOrd3);
        long fineSelect = System.currentTimeMillis();
        System.out.println("----------------------------------------------------");
        if(stampa) {
            System.out.println("Ordinato tramite select sort: ");
            System.out.println(Arrays.toString(vettOrd3));
        }
        long diffSelect = fineSelect - inizioSelect;
        System.out.println("Tempo ordinamento Selection sort: " + diffSelect);
        System.out.println("----------------------------------------------------");

        /*Ordina il vettore creato attraverso i seguenti quattro modi:
	        3.4 metodo sortInsert con l’ordinamento per inserimento
	    */
        int[] vettOrd4;
        vettOrd4= Arrays.copyOf(vett, dim);
        long inizioInsert = System.currentTimeMillis();
        vettOrd3=insertSort(vettOrd4);
        long fineInsert = System.currentTimeMillis();
        System.out.println("----------------------------------------------------");
        if(stampa) {
            System.out.println("Ordinato tramite insert sort: ");
            System.out.println(Arrays.toString(vettOrd4));
        }
        long diffInsert = fineInsert - inizioInsert;
        System.out.println("Tempo ordinamento Insert sort: " + diffInsert);
        System.out.println("----------------------------------------------------");
    }

    public static int[] creaVettore(int dim, int min, int max){
        Random random = new Random();
        int[] vett = new int[dim];
        for (int i = 0; i < dim; i++) {
            vett[i] = (int)(Math.random()*(max-min)+1) +min;
        }
        return vett;
    }
    public static void stampaVettore(int[] vett){
        System.out.print("[");
        for (int val : vett) {
            System.out.print(val+ " ");
        }
        System.out.println("]");
    }
    public static int[] bubbleSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]) {
                    int k = array[j];
                    array[j] = array[j+1];
                    array[j+1] = k;
                }
            }
        }
        return array;
    }
    public static int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length-1; i++) {
            int minimo = i;
            for(int j=i+1; j < array.length; j++) {
                if(array[minimo]>array[j]) {
                    minimo = j;
                }
            }
            int k = array[minimo];
            array[minimo]= array[i];
            array[i] = k;
        }
        return array;
    }
    public static int[] insertSort(int vett[]){
        int n = vett.length;
        for (int i = 1; i < n; i++){
            int key = vett[i];
            int j = i-1;
            while ((j > -1) && ( vett [j] > key )){
                vett [j+1] = vett [j];
                j--;
            }
            vett[j+1] = key;
        }
        return vett;
    }
}
