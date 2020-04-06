import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/*Un negozio di musica vende diversi articoli quali CD, libri e riviste musicali. Si intende automatizzare il processo
di approvvigionamento della merce. Ogni ordine da inviare al fornitore può contenere una sola tipologia di articoli.
Il sistema deve permettere la creazione di un ordine, l’inserimento di uno o più articoli e l’invio dell’ordine al
fornitore selezionato. Fate in modo che nella classe main si abbia un HashMap (o per chi non riesce ArrayList) di ordini.
L'utente può "autenticarsi" sia come fornitore che come cliente. Nel caso sia un fornitore, esso può visualizzare solo
gli ordini a lui assegnati.*/


public class Main implements Serializable {

    static ArrayList<Fornitore> fornitori = new ArrayList<>();
    static ArrayList<Cliente> clienti = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            Utente utenteLogin = login();

            System.out.println("Hai effettuato il login come " + utenteLogin.getNome());

            if (utenteLogin instanceof Fornitore) {
                menuFornitore((Fornitore) utenteLogin);
            } else if (utenteLogin instanceof Cliente) {
                menuCliente((Cliente) utenteLogin);
            }


        }

    }

    private static Utente login() {
        boolean loop = false;
        while (!loop) {
            System.err.println("Effettuare il login [L] o registrarsi [R]");
            switch (in.next().toUpperCase()) {
                case ("L"):
                    boolean loop2 = false;
                    while (!loop2) {
                        System.err.println("Inserire numero partita IVA:");
                        long partitaIVA = in.nextLong();
                        System.err.println("Inserire password:");
                        String psw = in.next();
                        for (int i = 0; i < fornitori.size(); i++) {
                            if (fornitori.get(i).getPartitaIVA() == partitaIVA) {
                                if (fornitori.get(i).getPassword().equals(psw)) {
                                    return fornitori.get(i);
                                }
                            }
                        }
                        for (int i = 0; i < clienti.size(); i++) {
                            if (clienti.get(i).getPartitaIVA() == partitaIVA) {
                                if (clienti.get(i).getPassword().equals(psw)) {
                                    return clienti.get(i);
                                }
                            }
                        }
                        System.err.println("Partita IVA non registrata o password sbagliata, riprova");
                    }
                    loop = true;
                    break;
                case ("R"):
                    boolean loop3 = false;
                    while (!loop3) {
                        System.err.println("Si vuole registrare un Fornitore [F] o un Cliente [C]");
                        switch (in.next().toUpperCase()) {
                            case ("F"):
                                boolean loop4 = false;
                                while (!loop4) {
                                    System.err.println("Inserire partita IVA");
                                    long partitaIVA = in.nextLong();
                                    System.err.println("Inserire nome attività:");
                                    String nome = in.next();
                                    System.err.println("Inserire password");
                                    String psw = in.next();
                                    for (int i = 0; i < fornitori.size(); i++) {
                                        if (fornitori.get(i).getPartitaIVA() == partitaIVA) {
                                            System.err.println("Partita IVA già registrata");
                                            partitaIVA = -1;
                                        }
                                    }
                                    if (partitaIVA != -1) {
                                        fornitori.add(new Fornitore(nome, partitaIVA, psw));
                                        return fornitori.get(fornitori.size() - 1);
                                    }
                                }
                                loop3 = true;
                                break;
                            case ("C"):
                                if (clienti.size() == 1) {
                                    System.out.println("E' già registrato il cliente proprietario del magazzino");
                                    loop3 = true;
                                    break;
                                }
                                boolean loop5 = false;
                                while (!loop5) {
                                    System.err.println("Inserire partita IVA");
                                    long partitaIVA = in.nextLong();
                                    System.err.println("Inserire nome attività:");
                                    String nome = in.next();
                                    System.err.println("Inserire password");
                                    String psw = in.next();
                                    for (int i = 0; i < clienti.size(); i++) {
                                        if (clienti.get(i).getPartitaIVA() == partitaIVA) {
                                            System.err.println("Partita IVA già registrata");
                                            partitaIVA = -1;
                                        }
                                    }
                                    if (partitaIVA != -1) {
                                        clienti.add(new Cliente(nome, partitaIVA, psw));
                                        return clienti.get(clienti.size() - 1);
                                    }
                                }
                                loop3 = true;
                                break;
                            default:
                                System.err.println("Codice non riconosciuto, riprova");
                        }
                    }
                    loop = true;
                    break;
                default:
                    System.err.println("Codice non riconosciuto, riprova");
            }
        }
        return null;
    }

    private static void menuFornitore(Fornitore fornitore) {
        while (true) {
            System.out.println("------" +
                    "\nSelezionare operazione:" +
                    "\nVisualizzare ordini [VIS]," +
                    "\nRimuovere ordine [RIM]," +
                    "\nLogout [OUT]" +
                    "\n------");
            switch (in.next().toUpperCase()) {
                case ("VIS"):
                    System.out.println(fornitore.toStringOrdini());
                    break;
                case ("RIM"):
                    System.out.println("Selezionare numero di ordine da rimuovere:");
                    System.out.println(fornitore.toStringOrdini());
                    int ind = in.nextInt();
                    Ordine ordine = fornitore.getOrdini().get(ind);
                    ordine.getCliente().getMagazzino().aggiungiOrdine(ordine);
                    fornitore.getOrdini().remove(ind);
                    break;
                case ("OUT"):
                    return;
            }
        }
    }

    private static void menuCliente(Cliente cliente) {
        while (true) {
            System.out.println("------" +
                    "\nSelezionare operazione:" +
                    "\nVisualizzare ordini effettuati [VIS]" +
                    "\nVisualizzare magazzino [MAG]" +
                    "\nEffettuare ordine [ORD]" +
                    "\nLogout [OUT]" +
                    "\n------");
            switch (in.next().toUpperCase()) {
                case ("VIS"):
                    System.out.println(cliente.toStringOrdini());
                    break;
                case ("MAG"):
                    System.out.println(cliente.getMagazzino());
                    break;
                case ("ORD"):
                    creaOrdine(cliente);
                    break;
                case ("OUT"):
                    return;
            }
        }
    }

    private static void creaOrdine(Cliente cliente) {
        stampaFornitori();
        System.out.println("A quale fornitore si vuole ordinare? [N°]");
        Fornitore fornitore =  fornitori.get(in.nextInt());
        Ordine ordine = new Ordine(fornitore, cliente);
        while (true) {
            System.out.println("Si vuole aggiungere, rimuovere o inviare l'ordine? [AGG/RIM/INV]");
            switch (in.next().toUpperCase()) {
                case ("AGG"):
                    System.out.println("Inserire nome prodotto:");
                    String nome = in.next();
                    System.out.println("Inserire quantità:");
                    int qnt = in.nextInt();
                    ordine.aggiungiArticolo(new Articolo(nome, qnt));
                    System.out.println(ordine);
                    break;
                case ("RIM"):
                    System.out.println("Inserire codice articolo da rimuovere");
                    int codice = in.nextInt();
                    System.out.println("Inserire quantità da rimuovere");
                    int quantita = in.nextInt();
                    ordine.rimuoviArticolo(codice, quantita);
                    System.out.println(ordine);
                    break;
                case ("INV"):
                    ordine.getFornitore().aggiungiOrdine(ordine);
                    cliente.aggiungiOrdine(ordine);
                    return;
            }
        }
        
    }

    private static void stampaFornitori() {
        for (int i = 0; i < fornitori.size(); i++) {
            System.out.println("N°" + i + ": " + fornitori.get(i).toStringPubblica());
        }
    }
}
