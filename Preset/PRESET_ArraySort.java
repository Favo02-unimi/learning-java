public class PRESET_ArraySort {



    // ---------------------------------------------------- //
    // METODO PER RIORDINARE UN VETTORE TRAMITE BUBBLE SORT //
    // ---------------------------------------------------- //

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

    // ---------------------------------------------------- //
    // METODO PER RIORDINARE UN VETTORE TRAMITE BUBBLE SORT //
    // ---------------------------------------------------- //



//---------------------------------------------------------------------------------------------------------------------------------//



    // ------------------------------------------------------- //
    // METODO PER RIORDINARE UN VETTORE TRAMITE SELECTION SORT //
    // ------------------------------------------------------- //

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

    // ------------------------------------------------------- //
    // METODO PER RIORDINARE UN VETTORE TRAMITE SELECTION SORT //
    // ------------------------------------------------------- //



}
