import java.util.ArrayList;

public class Fornitore extends Utente {

    ArrayList<Ordine> ordini = new ArrayList<>();

    public Fornitore(String nome, long partitaIVA, String password) {
        super(nome, partitaIVA, password);
    }

    public void aggiungiOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public String toStringOrdini() {
        String out = "---Ordini ricevuti:---";
        for (int i = 0; i < ordini.size(); i++) {
            out += "\nN°" + i + ": " + ordini.get(i);
        }
        return out;
    }

}
