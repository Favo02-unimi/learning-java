/*  Attraverso l’utilizzo di vettori, memorizza 8 voti (casuali, compresi tra 1 e 10),
    di 15 studenti, di cui conosci nome e cognome, stampa la media dei voti di ciascuno studente.

    Autore: Luca Favini, Giacopo Macias
    Data: 02/10/2019
*/
import java.util.*;

public class VotiStudenti {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] nomi = new String[15];
        String[] cognomi = new String[15];
        int[][] voti = new int[15][8];

        //genero gli 8 voti random per ogni studente
        voti[0]=votiCasuali(voti[0], 8,1,10);
        voti[1]=votiCasuali(voti[1], 8,1,10);
        voti[2]=votiCasuali(voti[2], 8,1,10);
        voti[3]=votiCasuali(voti[3], 8,1,10);
        voti[4]=votiCasuali(voti[4], 8,1,10);
        voti[5]=votiCasuali(voti[5], 8,1,10);
        voti[6]=votiCasuali(voti[6], 8,1,10);
        voti[7]=votiCasuali(voti[7], 8,1,10);

        //nomi e cognomi studenti preinseriti
        nomi = databaseNomi();
        cognomi = databaseCognomi();

        //per continuare a richiedere voti senza generarli random di nuovo
        while(true){
            System.out.print("Inserire cognome studente: ");
            String cognome = in.next();
            System.out.print("Inserire nome studente: ");
            String nome = in.next();
            stampa(voti, nome, cognome, nomi, cognomi);
            System.out.println("Vuoi visualizzare altri voti? [Sì/No]");
            String temp = in.next();
            if(temp.equalsIgnoreCase("No")){
                break;
            } else if(!(temp.equalsIgnoreCase("Sì"))){
                System.out.println("Risposta non valida");
                break;
            }
        }
    }

    public static String[] databaseNomi(){
        String[] nomi = new String[15];
        nomi[0] = "Lorenzo";
        nomi[1] = "Matteo";
        nomi[2] = "Giacopo";
        nomi[3] = "Luca";
        nomi[4] = "Luca";
        nomi[5] = "Matteo";
        nomi[6] = "Luca";
        nomi[7] = "Francesco";
        nomi[8] = "Andrea";
        nomi[9] = "Alessandro";
        nomi[10] = "Lorenzo";
        nomi[11] = "Matteo";
        nomi[12] = "Alessandro";
        nomi[13] = "Paolo";
        nomi[14] = "Rebas";
        return nomi;
    }
    public static String[] databaseCognomi(){
        String[] cognomi = new String[15];
        cognomi[0] = "Bosa";
        cognomi[1] = "Molinari";
        cognomi[2] = "Macias";
        cognomi[3] = "Favini";
        cognomi[4] = "Bornaghi";
        cognomi[5] = "Consiglio";
        cognomi[6] = "Roncato";
        cognomi[7] = "Ballerini";
        cognomi[8] = "Oreglio";
        cognomi[9] = "Randazzo";
        cognomi[10] = "Cantella";
        cognomi[11] = "Preatoni";
        cognomi[12] = "Delera";
        cognomi[13] = "D'alessandro";
        cognomi[14] = "Ciubas";
        return cognomi;
    }

    public static int[] votiCasuali(int[] v, int len, int min, int max){
        for(int i =0; i<v.length; i++){
            v[i] = (int)(Math.random()*(max-min)+1)+min;
        }
        return v;
    }

    public static void stampa(int[][] voti, String nome,String cognome, String[] nomi, String[] cognomi){
        int index = cercaStudente(nome, cognome, nomi, cognomi);
        if(index==-1) {
            System.out.println("Il nome non è incluso nella lista di studenti");
            return;
        }
        int media = calcolaMedia(voti[index]);
        System.out.println(Arrays.toString(voti[index]));
        System.out.println("Media "+ nome +" "+ cognome+" : " + media);
    }

    public static int cercaStudente(String nome, String cognome, String[] nomi, String[] cognomi){
        for(int i = 0; i<nomi.length; i++){
            if(nome.equalsIgnoreCase(nomi[i]) && cognome.equalsIgnoreCase(cognomi[i])){
                return i;
            }
        }
        return -1;
    }

    public static int calcolaMedia (int[] v){
        int somma = 0;
        int cont = 0;
        for(int i =0; i<v.length; i++){
            somma+=v[i];
            cont++;
        }
        return somma/cont;
    }
}
