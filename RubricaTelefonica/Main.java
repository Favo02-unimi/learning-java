import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();

        GUI gui = new GUI(rubrica);
        gui.removeContact.addMouseListener(new Listener_deleteButton(rubrica, gui));
        gui.addContact.addMouseListener(new Listener_addButton(rubrica, gui));
        gui.sortName.addMouseListener(new Listener_sortButton(rubrica, gui, 1));
        gui.sortSurname.addMouseListener(new Listener_sortButton(rubrica, gui, 2));
        while (true) {
            stampaMenu();
            String temp = in.next();
            if (temp.equalsIgnoreCase("sn")) {
                System.out.print(rubrica.stampaPerNome());
            }
            else if (temp.equalsIgnoreCase("sc")){
                System.out.print(rubrica.stampaPerCognome());
            }
            else if (temp.equalsIgnoreCase("i")) {
                rubrica.inserisci(inputContatto());
            }
            else if (temp.equalsIgnoreCase("e")) {
                System.out.print("Inserire nome contatto da eliminare: ");
                String nome = in.next();
                System.out.print("Inserire cognome contatto da eliminare: ");
                String cognome = in.next();
                rubrica.elimina(nome, cognome);
            }
            else if (temp.equalsIgnoreCase("c")){
                System.out.println("Contatti rubrica: " + rubrica.conta());
            }
            else {
                System.out.println("Riprovare, errore");
            }

        }
    }

    private static void stampaMenu(){
        try {
            Thread.sleep(50);
        }
        catch (Exception ignore){}
        System.err.println("------------------" +
                "\nCosa si vuole fare?" +
                "\nStampare per Nome: [SN]" +
                "\nStampare per Cognome: [SC]" +
                "\nInserire contatto: [I]" +
                "\nEliminare contatto: [E]" +
                "\nContare contatti: [C]" +
                "\n------------------");
    }

    private static Contatto inputContatto(){
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire nome contatto: ");
        String nome = in.next();
        System.out.print("Inserire cognome contatto: ");
        String cognome = in.next();
        System.out.print("Inserire numero contatto: ");
        long numero = in.nextLong();

        return new Contatto(nome, cognome, numero);
    }
}
