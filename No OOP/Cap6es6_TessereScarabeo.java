/*Exercise 6.6 In Scrabble1
each player has a set of tiles with letters on them.
The object of the game is to use those letters to spell words. The scoring system
is complex, but longer words are usually worth more than shorter words.
Imagine you are given your set of tiles as a string, like "quijibo", and you
are given another string to test, like "jib".
Write a method called canSpell that takes two strings and checks whether
the set of tiles can spell the word. You might have more than one tile with
the same letter, but you can only use each tile once.
*/

import java.util.Scanner;

public class Cap6es6_TessereScarabeo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire le tessere (in un'unica stringa): ");
        String tiles = in.nextLine();

        System.out.print("\nInserire la parola da controllare: ");
        String word = in.nextLine();

        boolean result = CanSpell(tiles, word);
        if (result) {
            System.out.println("\nE' possibile formare la parola con le tessere.");
        } else {
            System.out.println("\nNon è possibile formare la parola con le tessere.");
        }
    }

    public static boolean CanSpell(String tiles, String word) {
        boolean trovata = false;
        for(int i=0; i<word.length(); i++){
            trovata=false;
            char c = word.charAt(i);
            //System.out.println(c);
            for (int j=0; j<tiles.length(); j++){
                //System.out.println(tiles.charAt(j));
                if(c==tiles.charAt(j)){
                    tiles = togliLettera(tiles, j);
                    trovata = true;
                }
            }
            if (!trovata){
                return false;
            }
        }
        return true;
    }

    public static String togliLettera(String word, int index) {
        String out= "";
        for (int i=0;i<word.length();i++){
            if (index !=i){
                out += word.charAt(i);
            }
        }
        return out;
    }



}
