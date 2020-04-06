import java.util.HashMap;

public class Ordine {

    private Fornitore fornitore;
    private Cliente cliente;
    private HashMap<Integer, Articolo> articoliOrdine = new HashMap<>();

    public Ordine(Fornitore fornitore, Cliente cliente) {
        this.fornitore = fornitore;
        this.cliente = cliente;
    }

    public void aggiungiArticolo(Articolo articolo) {
        articoliOrdine.put(articolo.getCodice(), articolo);
    }

    public void rimuoviArticolo(int codice, int quantita) {
        if (articoliOrdine.containsKey(codice)) {
            if (articoliOrdine.get(codice).getQuantita() - quantita <= 0) {
                articoliOrdine.remove(codice);
            }
            else {
                articoliOrdine.get(codice).rimuoviQuantita(quantita);
            }
        }
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String toString() {
        return articoliOrdine.toString();
    }

}
