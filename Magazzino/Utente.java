public class Utente {
    private String nome;
    private long partitaIVA;
    private String password;

    public Utente(String nome, long partitaIVA, String password) {
        this.nome = nome;
        this.partitaIVA = partitaIVA;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public long getPartitaIVA() {
        return partitaIVA;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "Partita iva: " + partitaIVA +
                "\nNome: " + nome +
                "\nPassword: " + password;
    }

    public String toStringPubblica() {
        return "Partita iva: " + partitaIVA +
                "\nNome: " + nome;
    }
}
