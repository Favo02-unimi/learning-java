public class Prenotazione {
    private Data data;
    Guida guidaPrenotata;
    Turista prenotante;
    int codiceGuida;


    public Prenotazione(Data data, Guida guidaPrenotata, Turista prenotante, int codiceGuida){
        this.data = data;
        this.guidaPrenotata = guidaPrenotata;
        this.prenotante = prenotante;
        this.codiceGuida = codiceGuida;
    }

    public String toString() {
        return data.toString() +
                "\nGuida prenotata: " + guidaPrenotata.toStringCompatto() +
                "\nTurista prenotante: " + prenotante.toStringCompatto();
    }

    public int getCodiceGuida() {
        return codiceGuida;
    }

    public Data getData() {
        return data;
    }
}
