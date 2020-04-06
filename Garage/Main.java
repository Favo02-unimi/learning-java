import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    Un garage è composto di diversi livelli. Ogni livello ha un numero di posti disponibili. I posti sono di diversi
    tipi: auto normali, auto di dimensioni notevoli (van, ...), auto di lusso. Le auto GPL possono parcheggiare solo
    nel primo piano. È possibile affittare un posto macchina, se disponibile, su base mensile. Non possono essere
    affittati più del 50% dei posti in ciascuna categoria. I posti non affittati su base mensile sono utilizzati per
    parcheggi ad ore fino ad un massimo di otto ore. Nel caso si sforino le otto ore, viene applicata una penale al
    momento del ritiro dell’auto. Gli utenti del sistema sono sia gli automobilisti che il gestore del sistema che
    fornisce le informazioni configurazione (per esempio, il numero di posti in ciascuna categoria).

     */
    private static VisualizzazioneParcheggio parcheggio;
    private static Garage garage;

    public static void main(String[] args) {

        garage = new Garage(3, 40, new int[]{80, 30, 10});

        parcheggio = new VisualizzazioneParcheggio(garage);

        Scanner in = new Scanner(System.in);

        System.err.println("-------------------\nE' stata caricata una configurazione di default." +
                "\nE' possibile modificarla al 100% tramite appositi comandi.\n-------------------");
        pause();
        System.out.println("\nLa tipologia di posti nel livello GPL è organizzata dall'algoritmo in modo da rispecchiare la proporzione di posti (se viene impostata automatica nella configurazione)" +
                "\nNella configuarazione default, ad esempio sono presenti 120 posti su 3 livelli, con 80 posti normali, 30 grandi e 10 lusso." +
                "\nL'algoritmo ha distrubuito i posti GPL del primo livello rispecchiando le proporzioni (66% normali, 25% grandi, 8% lusso)," +
                "\nquindi nel livello GPL da 40 posti ci sono 27 normali, 10 grandi e 3 lusso.\n");
        pause();
        System.err.println(garage);
        pause();
        while (true){
            System.err.println("Si vuole parcheggiare ad ore [O], utilizzare un abbonamento mensile [M], pagare l'uscita [U] o modificare configuarazione garage [G]");
            switch (in.next().toUpperCase()){
                case ("O"):
                    if (garage.isDisponibilePostoAdOre()){
                        boolean temp = false;
                        while (!temp){
                            temp = richiestaTipo(false);
                        }
                    }
                    else {
                        pause();
                        System.out.println("Il posto riservato per parcheggio ad ore è terminato.");
                    }
                    break;
                case ("M"):
                    System.err.println("Ha già un abbonamento mensile [ABB] o lo vuole acquistare [ACQ]");
                    switch (in.next().toUpperCase()) {
                        case("ACQ"):
                            if (garage.isDisponibilePostoMensile()) {
                                boolean temp = false;
                                while (!temp) {
                                    temp = richiestaTipo(true);
                                }
                            }
                            else {
                                pause();
                                System.out.println("Il posto riservato per parcheggio mensile è terminato.");
                            }
                            break;
                        case("ABB"):
                            loginAbbonato();
                    }
                    break;
                case ("U"):
                    ritira();
                    break;
                case ("G"):
                    System.out.println("!!Modificare configurazione garage resetterà tutti i posti e le auto parcheggiate!!");
                    System.out.println("Inserire password amministratore (per test = \"asd\")");
                    if (in.next().equals("asd")){
                        System.out.println("Inserire numero livelli parcheggio: ");
                        int livelli = in.nextInt();
                        System.out.println("Inserire numero posti per livello: ");
                        int postiPerLivello = in.nextInt();
                        System.err.println("Si vuole configurare il tipo di ogni posto uno alla volta manualmente [M] o automaticamente inserendo numero di posti e lasciandoli gestire dall'algoritmo [A]");
                        switch (in.next().toUpperCase()){
                            case ("M"):
                                garage = new Garage(livelli, postiPerLivello);
                                parcheggio.close();
                                parcheggio = new VisualizzazioneParcheggio(garage);
                                break;
                            case ("A"):
                                int[] tipoPosti = new int[3];
                                System.out.println("Inserire numero posti normali: ");
                                tipoPosti[0] = in.nextInt();
                                System.out.println("Inserire numero posti grandi: ");
                                tipoPosti[1] = in.nextInt();
                                System.out.println("Inserire numero posti lusso: ");
                                tipoPosti[2] = in.nextInt();
                                garage = new Garage(livelli, postiPerLivello, tipoPosti);
                                parcheggio.close();
                                parcheggio = new VisualizzazioneParcheggio(garage);
                        }
                        System.out.println("Inserire tariffa oraria tipo normale");
                        double tariffaOrariaNormale = in.nextDouble();
                        System.out.println("Inserire tariffa oraria tipo grande");
                        double tariffaOrariaGrande = in.nextDouble();
                        System.out.println("Inserire tariffa oraria tipo lusso");
                        double tariffaOrariaLusso = in.nextDouble();
                        Affitto.changeTariffeOrarie(tariffaOrariaNormale, tariffaOrariaGrande, tariffaOrariaLusso);
                        System.out.println("Inserire tariffa mensile tipo normale");
                        double tariffaMensileNormale = in.nextDouble();
                        System.out.println("Inserire tariffa mensile tipo grande");
                        double tariffaMensileGrande = in.nextDouble();
                        System.out.println("Inserire tariffa mensile tipo lusso");
                        double tariffaMensileLusso = in.nextDouble();
                        Affitto.changeTariffeMensili(tariffaMensileNormale, tariffaMensileGrande, tariffaMensileLusso);
                        System.out.println("Inserire penale se si sforano 8 ore");
                        double penale = in.nextDouble();
                        Affitto.changePenale(penale);
                    }
                    pause();
                    System.err.println(garage);
                    pause();
                    break;
                default:
                    pause();
                    System.out.println("Errore: codice non riconosciuto, riprova");
            }
        }

    }

    private static boolean richiestaTipo(boolean isMensile) {
        Scanner in = new Scanner(System.in);
        System.err.println("Che tipo di auto si vuole parcheggiare? Normale [N], Grandi dimensioni [G], Lusso [L]");
        switch (in.next().toUpperCase()) {
            case ("N"):
                if (garage.isDisponibilePostoNormale()) {
                    parcheggia("Normale", checkGPL(), isMensile);
                    return true;
                }
                break;
            case ("G"):
                if (garage.isDisponibilePostoGrande()) {
                    parcheggia("Grande", checkGPL(), isMensile);
                    return true;
                }
                break;
            case ("L"):
                if (garage.isDisponibilePostoLusso()) {
                    parcheggia("Lusso", checkGPL(), isMensile);
                    return true;
                }
                break;
            default:
                System.out.println("Errore: tipo non riconosciuto, riprova");
                pause();
                return false;
        }
        return false;
    }

    private static void parcheggia(String tipo, boolean isGPL, boolean isMensile) {
        ArrayList<Integer>[] postiDisponibili = garage.getListaPostiDisponibili(tipo, isGPL);
        for (int i = 0; i < postiDisponibili.length; i++) {
            System.out.println("Posti liberi livello " + i + ": " + postiDisponibili[i].toString());
        }
        int livello, posto;
        Scanner in = new Scanner(System.in);
        boolean temp = false;
        while (!temp) {
            System.out.println("In quale livello parcheggerà?");
            livello = in.nextInt();
            if (!(livello >= 0 && livello < garage.getNumeroLivelli())) {
                System.out.println("Livello non disponibile, riprova");
                pause();
                continue;
            }
            else {
                System.out.println("In quale posto del livello " + livello + " parcheggerà?");
                posto = in.nextInt();
                if (postiDisponibili[livello].contains(posto)) {
                    temp = true;
                }
                else {
                    System.out.println("Posto non disponibile, riprova");
                    pause();
                    continue;
                }
            }
            String password = "";
            if (isMensile) {
                System.out.println("Inserire password che permetterà accesso al posto a cui si sta abbonando: ");
                password = in.next();
            }
            garage.parcheggioAuto(livello, posto, isMensile, password);
            if (isMensile) {
                System.out.println("Il costo dell'abbonamento è " + garage.getLivelli()[livello].getPosto(posto).getAffitto().calcolaPrezzo(tipo));
            }
            System.out.println("Benvenuto, parcheggi nel posto " + posto + " del livello " + livello);
            parcheggio.close();
            parcheggio = new VisualizzazioneParcheggio(garage);
        }
    }

    private static void ritira() {
        ArrayList<Integer>[] postiOccupati = garage.getListaPostiOccupati();
        for (int i = 0; i < postiOccupati.length; i++) {
            System.out.println("Posti occupati livello " + i + ": " + postiOccupati[i].toString());
        }

        int livello, posto;
        Scanner in = new Scanner(System.in);
        boolean temp = false;
        while (!temp) {
            System.out.println("In quale livello ha parcheggiato? [-1 PER TORNARE INDIETRO]");
            livello = in.nextInt();
            if (livello == -1){
                break;
            }
            if (!(livello >= 0 && livello < garage.getNumeroLivelli())) {
                System.out.println("Livello non disponibile, riprova");
                pause();
                continue;
            }
            else {
                System.out.println("In quale posto del livello " + livello + " ha parcheggiato?");
                posto = in.nextInt();
                if (postiOccupati[livello].contains(posto)) {
                    temp = true;
                }
                else {
                    System.out.println("Posto non occupato, riprova");
                    pause();
                    continue;
                }
            }
            double prezzo = garage.ritiroAuto(livello, posto);
            Affitto affitto = garage.getLivelli()[livello].getPosto(posto).getAffitto();
            if (affitto instanceof AffittoMensile){
                System.out.println("Arrivederci, le rimangono " + affitto.getAccessiRimanenti() + " accessi di abbonamento.");
            }
            else {
                System.out.println("Arrivederci, il prezzo è €" + prezzo);
            }
            parcheggio.close();
            parcheggio = new VisualizzazioneParcheggio(garage);

        }
    }

    private static void loginAbbonato() {
        ArrayList<Integer>[] postiAbbonati = garage.getListaPostiAbbonatiMensili();
        boolean temp = false;
        while (!temp) {
            Scanner in = new Scanner(System.in);
            System.out.println("In quale livello è il suo posto abbonato? [-1 PER TORNARE INDIETRO]");
            int livello = in.nextInt();
            if (livello == -1) {
                break;
            }
            if (!(livello >= 0 && livello < garage.getNumeroLivelli())) {
                System.out.println("Livello non disponibile, riprova");
                pause();
                continue;
            }
            else {
                System.out.println("Quale è il suo posto da abbonato? ");
                int posto = in.nextInt();
                if (postiAbbonati[livello].contains(posto)){
                    System.out.println("Inserire password per posto " + posto + " livello " + livello);
                    String password = in.next();
                    Affitto affitto = garage.getLivelli()[livello].getPosto(posto).getAffitto();
                    if (password.equals(affitto.getPassword()) && garage.getLivelli()[livello].getPosto(posto).getAffitto().getAccessiRimanenti() > 0) {
                        affitto.accessoGiornaliero();
                        garage.parcheggioAuto(livello, posto, true, affitto.getPassword());
                        System.out.println("Benvenuto, accessi dell'abbonamento rimanenti: " + affitto.getAccessiRimanenti());
                        parcheggio.close();
                        parcheggio = new VisualizzazioneParcheggio(garage);
                        temp = true;
                    }
                    else {
                        System.out.println("Password errata o abbonamento scaduto/inesistente");
                        break;
                    }
                }
                else {
                    System.out.println("Posto non associato ad abbonamento mensile, riprovare.");
                }
            }
        }
    }

    private static boolean checkGPL() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.err.println("La macchina che si vuole parcheggiare è GPL? [S/N]");
            switch (in.next().toUpperCase()) {
                case ("S"):
                    return true;
                case ("N"):
                    return false;
                default:
                    System.out.println("Errore: codice non riconosciuto, riprova");
            }
        }
    }

    private static void pause() {
        try {
            Thread.sleep(20);
        } catch (Exception ignore) { }
    }
}
