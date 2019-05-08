/* Confronto tra gli algoritmi di ordinamento:
Bubble Sort, Selection Sort e Array Sort (Array.sort())
*/

import java.util.*;

public class Cap7_OrdinamentoArraysConfronto {
    public static void main(String[] args){
        long inizio = System.currentTimeMillis();

        int array[]= arrayRandom();
        int array2[]= Arrays.copyOf(array, array.length);
        int array3[]= Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(array));

        long inizioBubble = System.currentTimeMillis();
        array=bubbleSort(array);
        System.out.println(Arrays.toString(array));
        long fineBubble = System.currentTimeMillis();

        long inizioSelection = System.currentTimeMillis();
        array2=selectionSort(array);
        System.out.println(Arrays.toString(array2));
        long fineSelection = System.currentTimeMillis();


        long inizioArray = System.currentTimeMillis();
        Arrays.sort(array3);
        System.out.println(Arrays.toString(array3));
        long fineArray = System.currentTimeMillis();

        long fine = System.currentTimeMillis();

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Il programma ha impiegato in totale: "+ (fine-inizio)+" ms");
        System.out.println("La BubbleSort ha impiegato: "+(fineBubble-inizioBubble)+" ms");
        System.out.println("La SelectionSort ha impiegato: "+(fineSelection-inizioSelection)+ " ms");
        System.out.println("La ArraySort ha impiegato: "+(fineArray-inizioArray)+ " ms");
        System.out.println("----------------------------------------------------------------");
    }

    public static int[] arrayRandom(){
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire la lunghezza del vettore da generare: ");
        int length = in.nextInt();
        Random random = new Random();
        int[] array = new int[length];
        for (int i=0; i<length; i++){
            array[i] = random.nextInt(99)+1;
        }
        return array;
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

}
