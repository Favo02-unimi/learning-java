import java.util.ArrayList;
import java.util.HashMap;

public class Magazzino {
    HashMap<Integer, Articolo> magazzino = new HashMap<>();
    ArrayList<Ordine> ordini = new ArrayList<>();

    public Magazzino() {
        magazzino = new HashMap<>();
    }

    public void aggiungiOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public void aggiungiArticolo(Articolo articolo) {
        magazzino.put(articolo.getCodice(), articolo);
    }

    public void rimuoviArticolo(Articolo articolo) {
        magazzino.remove(articolo.getCodice());
    }

    public int getQntArticolo(int codice) {
        return magazzino.get(codice).getQuantita();
    }

    public String toString() {
        return ordini.toString();
    }
}
