/*Exercise 6.4 A word is said to be “abecedarian” if the letters in the word
appear in alphabetical order. For example, the following are all six-letter
English abecedarian words:
abdest, acknow, acorsy, adempt, adipsy, agnosy, befist, behint, beknow, bijoux, biopsy, cestuy, chintz, deflux, dehors, dehort, deinos,
diluvy, dimpsy
Write a method called isAbecedarian that takes a String and returns a
boolean indicating whether the word is abecedarian.*/

import java.util.Scanner;

public class Cap6es4_Abecedarian{

    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.print("Inserire la parola da controllare: ");
        String parola = in.nextLine();

        boolean risultato = isAbecedarian(parola);
        if (risultato==true){
            System.out.println("La parola " + parola + " è Abecedariana.");
        } else {
            System.out.println("La parola " + parola + " non è Abecedariana.");
        }
    }

    public static boolean isAbecedarian(String parola){
        for (int i=0; i<parola.length()-1;i++) {
            char lettera = parola.charAt(i);
            char lettera2 = parola.charAt(i+1);
            if (lettera2<lettera){
                return false;
            }
        }
        return true;
    }
}