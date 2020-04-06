public class Articolo {

    public static int generatoreCodice = 0;

    private String nome;
    private int codice;
    private int quantita;

    public Articolo(String nome, int quantita) {
        this.nome = nome;
        this.codice = generatoreCodice;
        generatoreCodice++;
        this.quantita = quantita;
    }

    public int getCodice() {
        return codice;
    }

    public int getQuantita() {
        return quantita;
    }

    public void aggiungiQuantita(int quantita) {
        this.quantita += quantita;
    }

    public void rimuoviQuantita(int quantita) {
        this.quantita -= quantita;
    }

    public String toString() {
        return "Nome: " + nome +
                "\nCodice: " + codice +
                "\nQuantità: " + quantita;
    }

}
