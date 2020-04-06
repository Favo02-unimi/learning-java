public class Contatto {
    private Contatto nextNome;
    private Contatto nextCognome;

    private long numero;
    private String nome, cognome;

    public Contatto(String nome, String cognome, long numero){
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String toString(){
        return "--------------" +  "\n" +
                "Nome: " + nome + "\n" +
                "Cognome: " + cognome + "\n" +
                "Numero: " + numero + "\n" +
                "--------------";
    }
    public String toStringOneLine(){
        return nome + " " + cognome + " " + numero;
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public long getNumero() {
        return numero;
    }

    public Contatto getNextCognome() {
        return nextCognome;
    }
    public Contatto getNextNome() {
        return nextNome;
    }

    public void setNextNome(Contatto nextNome) {
        this.nextNome = nextNome;
    }
    public void setNextCognome(Contatto nextCognome) {
        this.nextCognome = nextCognome;
    }
}
