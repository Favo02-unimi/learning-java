import java.util.ArrayList;

public class Cliente extends Utente {

    private ArrayList<Ordine> ordini = new ArrayList<>();
    private Magazzino magazzino = new Magazzino();

    public Cliente(String nome, long partitaIVA, String password) {
        super(nome, partitaIVA, password);
    }

    public void aggiungiOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public String toStringOrdini() {
        String out = "---Ordini effettuati:---";
        for (int i = 0; i < ordini.size(); i++) {
            out += "\nN°" + i + ": " + ordini.get(i);
        }
        return out;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }
}
