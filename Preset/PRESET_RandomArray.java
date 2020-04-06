import java.util.*;
public class PRESET_RandomArray {



    // --------------------------------------------------------------------- //
    // METODO PER GENERARE UN ARRAY DI INT DA 1 A 100 CON LUNGHEZZA DA INPUT //
    // --------------------------------------------------------------------- //

    public static int[] arrayRandom() {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire la lunghezza del vettore da generare: ");
        if (!in.hasNextInt()) {
            String word = in.next();
            System.err.printf("\"%s\" non può essere il valore della lunghezza, riprova.\n", word);
            int[] array = arrayRandom();
            return array;
        }
        int length = in.nextInt();
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(99) + 1;
        }
        return array;
    }

    // --------------------------------------------------------------------- //
    // METODO PER GENERARE UN ARRAY DI INT DA 1 A 100 CON LUNGHEZZA DA INPUT //
    // --------------------------------------------------------------------- //



}
