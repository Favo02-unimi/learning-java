/*Exercise 6.5 A word is said to be a “doubloon” if every letter that appears
in the word appears exactly twice. Here are some example doubloons found
in the dictionary:
Abba, Anna, appall, appearer, appeases, arraigning, beriberi, bilabial, boob, Caucasus, coco, Dada, deed, Emmett, Hannah, horseshoer, intestines, Isis, mama, Mimi, murmur, noon, Otto, papa,
peep, reappear, redder, sees, Shanghaiings, Toto
Write a method called isDoubloon that takes a string and checks whether it is
a doubloon. To ignore case, invoke the toLowerCase method before checking.*/

import java.util.Scanner;

public class Cap6es5_Dubloon{

    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.print("Inserire la parola da controllare: ");
        String parola = in.nextLine();

        boolean risultato = isDoubloon(parola);
        if (risultato==true){
            System.out.println("La parola " + parola + " è Doubloon.");
        } else {
            System.out.println("La parola " + parola + " non è Doubloon.");
        }
    }

    public static boolean isDoubloon(String parola) {

        for(int i=0;i<parola.length();i++) {
            char carattere = parola.charAt(i);
            int cont = 0;
            for (int j = 0; j < parola.length(); j++) {
                //System.out.println(carattere);
                //System.out.println(parola.charAt(j));
                if (carattere == parola.charAt(j))
                    cont++;}
                //System.out.println(cont);
                if (cont != 2)
                    return false;
        }
            return true;

    }
}
//for (int i=0; i<parola.length()-1;i++) {
