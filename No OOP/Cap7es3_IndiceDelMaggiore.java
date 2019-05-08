/*Exercise 7.3 Write a method called indexOfMax that takes an array of
integers and returns the index of the largest element. Can you write this
method using an enhanced for loop? Why or why not?
*/


public class Cap7es3_IndiceDelMaggiore {
    public static void main(String[] args){
        int[] array = {5, 9, 2, 1,6, 2,0};
        int indexMax = indexOfMax(array);
        System.out.println(indexMax);
    }

    public static int indexOfMax(int[] array){
        int indexMax = 0;
        for(int i=0; i< array.length; i++){
            if (array[i] > array[indexMax]){
                    indexMax = i;
            }
        }
        return indexMax;
    }
}
