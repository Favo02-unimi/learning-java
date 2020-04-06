import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProntoSoccorso {

    private static ArrayList<Paziente> coda;

    private static Gui gui;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            FileInputStream inn = new FileInputStream("DatabaseProntoSoccorso");
            ObjectInputStream sIn = new ObjectInputStream(inn);
            coda = (ArrayList<Paziente>) sIn.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato.");
            coda = new ArrayList<>();
        }

        gui = new Gui(coda);

        gui.getArrivo().addMouseListener(new Listener_Arrivo(gui));
        gui.getAccettazione().addMouseListener(new Listener_Accettazione(gui));
        Scanner in = new Scanner(System.in);
        while (true) {
            scriviInDB();
            System.out.println("Arrivo paziente o accettazione primo paziente in coda? [ARR / ACC]");
            switch (in.next().toUpperCase()) {
                case ("ARR"):
                    arrivoPaziente();
                    System.err.println(coda.toString());
                    gui.refreshQueue();
                    break;
                case ("ACC"):
                    accettazionePaziente();
                    gui.refreshQueue();
                    break;
                default:
                    System.out.println("Codice non riconosciuto, riprova!");
            }

        }
    }

    private static void arrivoPaziente() {
        Paziente paziente = inputPaziente();
        selezioneCodice(paziente);
        if (coda.size()==0){
            coda.add(paziente);
            return;
        }
        for (int i = 0; i < coda.size(); i++) {
            if (paziente.getCodice() > coda.get(i).getCodice()) {
                coda.add(i, paziente);
            }
        }
    }

    private static void accettazionePaziente() {
        if (coda.isEmpty()){
            System.out.println("Non ci sono pazienti in attesa.");
            return;
        }
        coda.remove(0);
    }

    private static Paziente inputPaziente() {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire nome e cognome paziente: ");
        String nome = in.nextLine();
        System.out.println("Inserire data di nascita in questo formato: [AAAA-MM-GG]");
        String data = in.next();
        System.out.println("Inserire sesso paziente: [U/D]");
        boolean isMaschio = false;
        switch (in.next().toUpperCase()){
            case ("U"):
                isMaschio = true;
                break;
            case ("D"):
                isMaschio = false;
                break;
        }
        boolean isGravidanza = false;
        if (!isMaschio) {
            System.out.println("La paziente è in gravidanza? [S/N]");
            switch (in.next().toUpperCase()){
                case ("S"):
                    isGravidanza = true;
                    break;
                case ("N"):
                    isGravidanza = false;
                    break;
            }
        }
        System.out.println("Il paziente è portatore di handicap? [S/N]");
        boolean isHandicap = false;
        switch (in.next().toUpperCase()){
            case ("S"):
                isHandicap = true;
                break;
            case ("N"):
                isHandicap = false;
                break;
        }
        return new Paziente(nome, data, isMaschio, isGravidanza, isHandicap);
    }

    private static void selezioneCodice(Paziente paziente) {
        Scanner in = new Scanner(System.in);
        System.out.println("Selezionare stato criticità paziente:" +
                "\n[MOL]: Molto critico" +
                "\n[MED]: Mediamente critico" +
                "\n[POC]: Poco critico" +
                "\n[NON]: Non critico");
        switch (in.next().toUpperCase()){
            case ("MOL"):
                paziente.setCodice(Paziente.COD_ROSSO);
                break;
            case ("MED"):
                paziente.setCodice(Paziente.COD_GIALLO);
                break;
            case ("POC"):
                paziente.setCodice(Paziente.COD_VERDE);
                break;
            case ("NON"):
                if (paziente.isPazienteDebole()){
                    paziente.setCodice(Paziente.COD_AZZURRO);
                }
                else {
                    paziente.setCodice(Paziente.COD_BIANCO);
                }
                break;
        }
    }

    public static void scriviInDB() throws IOException{
        FileOutputStream out = new FileOutputStream("DatabaseProntoSoccorso");
        ObjectOutputStream sOut = new ObjectOutputStream(out);
        sOut.writeObject(coda);
        sOut.flush();
        sOut.close();
    }

}
