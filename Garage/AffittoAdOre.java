public class AffittoAdOre extends Affitto {

    private long oraInizio, oraFine, tempoTrascorso;
    private double prezzo;

    public AffittoAdOre() {
        oraInizio = System.currentTimeMillis();
    }

    public double calcolaPrezzo(String tipo) {
        oraFine = System.currentTimeMillis();
        tempoTrascorso = oraFine-oraInizio;
        if (tempoTrascorso > 28800000) {
            prezzo += penale;
        }
        double tariffa = 0.00;
        switch (tipo) {
            case ("Normale"):
                tariffa = tariffaOrariaNormale;
                break;
            case ("Grande"):
                tariffa = tariffaOrariaGrande;
                break;
            case ("Lusso"):
                tariffa = tariffaOrariaLusso;
                break;
            default:
                System.out.println("Errore calcolo prezzo");
        }
        while (tempoTrascorso > 0) {
            prezzo += tariffa;
            tempoTrascorso -= 3600000;
        }
        return prezzo;
    }

    public String getPassword() {
        return null;
    }

    public int getAccessiRimanenti() {
        return 0;
    }

    public void accessoGiornaliero() {
        return;
    }
}
