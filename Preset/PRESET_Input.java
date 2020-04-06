import java.util.*;
public class PRESET_Input {



    // ------------------------------------------------------------------------------- //
    //                                INT                                              //
    // METODO PER PRENDERE IN INPUT UNA QUALSIASI VARIABILE CON CASI LIMITE E CONFERMA //
    // ------------------------------------------------------------------------------- //

    public static int inputInt(String richiesta, String dato) {
        Scanner in = new Scanner(System.in);
        System.out.print(richiesta);
        if (!in.hasNextInt()) {
            String word = in.next();
            System.err.printf("\"%s\" non può essere il valore di %s, riprova.\n", word, dato);
            int inp = inputInt(richiesta, dato);
            return inp;
        }
        int inp = in.nextInt();

        System.out.printf("Hai appena inserito %s = %f confermi? [\"ok\" per confermare // qualsiasi altra stringa per rifiutare.]\n", dato, inp);
        String conferma = in.next();
        if (!(conferma.equalsIgnoreCase("ok"))) {
            System.err.println("Hai annullato l'input, riprova.");
            inp = inputInt(richiesta, dato);
            return inp;
        }
        return inp;
    }

    // ------------------------------------------------------------------------------- //
    //                                INT                                              //
    // METODO PER PRENDERE IN INPUT UNA QUALSIASI VARIABILE CON CASI LIMITE E CONFERMA //
    // ------------------------------------------------------------------------------- //



//---------------------------------------------------------------------------------------------------------------------------------//



    // ------------------------------------------------------------------------------- //
    //                              DOUBLE                                             //
    // METODO PER PRENDERE IN INPUT UNA QUALSIASI VARIABILE CON CASI LIMITE E CONFERMA //
    // ------------------------------------------------------------------------------- //

    public static double inputDouble(String richiesta, String dato) {
        Scanner in = new Scanner(System.in);
        System.out.print(richiesta);
        if (!in.hasNextDouble()) {
            String word = in.next();
            System.err.printf("\"%s\" non può essere il valore di %s, riprova.\n", word, dato);
            double inp = inputDouble(richiesta, dato);
            return inp;
        }
        double inp = in.nextDouble();

        System.out.printf("Hai appena inserito %s = %f confermi? [\"ok\" per confermare // qualsiasi altra stringa per rifiutare.]\n", dato, inp);
        String conferma = in.next();
        if (!(conferma.equalsIgnoreCase("ok"))) {
            System.err.println("Hai annullato l'input, riprova.");
            inp = inputDouble(richiesta, dato);
            return inp;
        }
        return inp;
    }

    // ------------------------------------------------------------------------------- //
    //                              DOUBLE                                             //
    // METODO PER PRENDERE IN INPUT UNA QUALSIASI VARIABILE CON CASI LIMITE E CONFERMA //
    // ------------------------------------------------------------------------------- //



//---------------------------------------------------------------------------------------------------------------------------------//



    // --------------------------------------------------------------------- //
    //                              DOUBLE                                   //
    // METODO PER PRENDERE IN INPUT UNA QUALSIASI VARIABILE CON CASI LIMITE, //
    // CON SCELTA TRA DUE OPZIONI E CONFERMA                                 //
    // --------------------------------------------------------------------- //

    public static double inputSelezione(String selezione, String richiesta1, String richiesta2, String dato1, String dato2) {
        Scanner in = new Scanner(System.in);
        System.out.print(selezione);
        String scelta = in.next();

        if (scelta.equalsIgnoreCase(dato1)) {
            System.out.print(richiesta1);
            double inp = in.nextDouble();

            System.out.printf("Hai appena inserito %s = %f confermi? [\"ok\" per confermare // qualsiasi altra stringa per rifiutare.]\n", dato1, inp);
            String conferma = in.next();
            if (!(conferma.equalsIgnoreCase("ok"))) {
                System.err.println("Hai annullato l'input, riprova.");
                inp = inputDouble(richiesta1, dato1);
                return inp;
            }
            return inp;
        } else if (scelta.equalsIgnoreCase(dato2)) {
            System.out.print(richiesta2);
            double inp = in.nextDouble();

            System.out.printf("Hai appena inserito %s = %f confermi? [\"ok\" per confermare // qualsiasi altra stringa per rifiutare.]\n", dato2, inp);
            String conferma = in.next();
            if (!(conferma.equalsIgnoreCase("ok"))) {
                System.err.println("Hai annullato l'input, riprova.");
                inp = inputDouble(richiesta2, dato2);
                return inp;
            }
            return inp;
        } else {
            System.err.printf("Risposta non valida, rispondi %s o %s, riprova.\n", dato1, dato2);
            double inp = inputSelezione(selezione, richiesta1, richiesta2, dato1, dato2);
            return inp;
        }
    }

    // --------------------------------------------------------------------- //
    //                              DOUBLE                                   //
    // METODO PER PRENDERE IN INPUT UNA QUALSIASI VARIABILE CON CASI LIMITE, //
    // CON SCELTA TRA DUE OPZIONI E CONFERMA                                 //
    // --------------------------------------------------------------------- //



}

