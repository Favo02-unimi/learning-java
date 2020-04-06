import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Si vuole creare una lista normale [N] o ordinata [O]");
        String temp = in.next();
        if(temp.equalsIgnoreCase("N")){
            Sequenza lista = new Sequenza();
            while (true){
                stampaMenu();
                temp = in.next();
                if(temp.equalsIgnoreCase("I")){
                    System.out.print("Inserire valore da inserire");
                    int value = in.nextInt();
                    lista.inserisci(value);
                    System.out.print(lista);
                }
                else if(temp.equalsIgnoreCase("E")){
                    lista.cancella();
                    System.out.print(lista);
                }
                else if(temp.equalsIgnoreCase("EV")){
                    System.out.print("Quale valore si vuole cancellare? ");
                    lista.cancellaValore(in.nextInt());
                    System.out.print(lista);
                }
                else if(temp.equalsIgnoreCase("C")){
                    System.out.println("Numero di valori: " + lista.conta());
                }
                else if(temp.equalsIgnoreCase("S")) {
                    System.out.print(lista);
                }
                else if(temp.equalsIgnoreCase("CE")){
                    System.out.print("Quale valore si vuole cercare? ");
                    Nodo cercato = lista.cerca(in.nextInt());
                    System.out.println("Valore cercato: " + cercato);
                }
                else if(temp.equalsIgnoreCase("CI")){
                    System.out.print("Quale valore si vuole cercare? ");
                    System.out.println("Indice: " + lista.cercaIndice(in.nextInt()));
                }
            }
        }
        else {
            SequenzaOrdinata listaOrdinata = new SequenzaOrdinata();
            while (true){
                stampaMenu();
                temp = in.next();
                if(temp.equalsIgnoreCase("I")){
                    System.out.print("Inserire valore da inserire");
                    int value = in.nextInt();
                    listaOrdinata.inserisci(value);
                    System.out.print(listaOrdinata);
                }
                else if(temp.equalsIgnoreCase("E")){
                    listaOrdinata.cancella();
                    System.out.print(listaOrdinata);
                }
                else if(temp.equalsIgnoreCase("C")){
                    System.out.println("Numero di valori: " + listaOrdinata.conta());
                }
                else if(temp.equalsIgnoreCase("S")){
                    System.out.print(listaOrdinata);
                }

            }
        }

    }
    static void stampaMenu(){
        System.out.println("------------------" +
                "\nCosa si vuole fare?" +
                "\nStampare: [S]" +
                "\nInserire: [I]" +
                "\nEliminare in coda: [E]" +
                "\nEliminare valore: [EV]" +
                "\nConta: [C]" +
                "\nCercare: [CE]" +
                "\nCercare indice: [CI]" +
                "\n------------------");
    }
}
