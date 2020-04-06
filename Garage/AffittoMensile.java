public class AffittoMensile extends Affitto {

    private String password;
    int accessiRimanentiAbbonamento = 30;

    public AffittoMensile(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void accessoGiornaliero() {
        accessiRimanentiAbbonamento--;
    }

    public int getAccessiRimanenti() {
        return accessiRimanentiAbbonamento;
    }

    public double calcolaPrezzo(String tipo) {
        switch (tipo){
            case ("Normale"):
                return tariffaMensileNormale;
            case ("Grande"):
                return tariffaMensileGrande;
            case ("Lusso"):
                return tariffaMensileLusso;
            default:
                System.out.println("Errore di calcolo prezzo");
        }
        return 0;
    }
}
