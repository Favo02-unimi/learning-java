/* Metodo ricorsivo che data una stringa restituisce la stringa senza x lettera
Given a string, compute recursively a new string where all the ’x’
chars have been removed.
noX("xaxb") → "ab"
noX("abc") → "abc"
noX("xx") → ""
*/

import java.util.*;

public class Cap8_noX {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in  );
        System.out.print("Lettera da rimuovere: ");
        String str = in.next();
        char x = str.charAt(0);
        System.out.print("Stringa da cui rimuovere X: ");
        String stringa=noX(x, in.next());
        System.out.println(stringa);

    }
    public static String noX(char x, String stringa){
        if (stringa.length()==0){
            return"";
        }
        char c = stringa.charAt(0);
        if (c==x) {
            return noX(x, stringa.substring(1));
        } else {
            return c + noX(x, stringa.substring(1));
        }
    }

}
