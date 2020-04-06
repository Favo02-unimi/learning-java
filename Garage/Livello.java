import java.util.ArrayList;

public class Livello {

    private int numeroLivello;
    private PostoAuto[] posti;

    public Livello (int numeroLivello, int numeroPosti) {
        this.numeroLivello = numeroLivello;
        posti = new PostoAuto[numeroPosti];
        for (int i = 0; i < numeroPosti; i++) {
            posti[i] = new PostoAuto(i);
        }
    }

    public ArrayList<Integer> getListaPostiDisponibili(String tipo, boolean isGPL) {
        ArrayList<Integer> postiDisponibili = new ArrayList<Integer>();
        if (isGPL && numeroLivello != 0) {
            return postiDisponibili;
        }
        for (int i = 0; i < posti.length; i++) {
            Affitto affitto = posti[i].getAffitto();
            if (posti[i].getTipo().equals(tipo) && !posti[i].isOccupato()){
                if (affitto == null || affitto.getAccessiRimanenti() == 0){
                    postiDisponibili.add(i);
                }
            }
        }
        return postiDisponibili;
    }

    public ArrayList<Integer> getListaPostiOccupati() {
        ArrayList<Integer> postiOccupati = new ArrayList<Integer>();
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].isOccupato()){
                postiOccupati.add(i);
            }
        }
        return postiOccupati;
    }

    public ArrayList<Integer> getListaPostiAbbonatiMensili() {
        ArrayList<Integer> postiAbbonati = new ArrayList<Integer>();
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].getAffitto() instanceof AffittoMensile) {
                postiAbbonati.add(i);
            }
        }
        return postiAbbonati;
    }


    public int getNumeroPostiTotali() {
        return posti.length;
    }
    public int getPostiDisponibili() {
        int cont = 0;
        for (int i = 0; i < posti.length; i++) {
            if (!posti[i].isOccupato()){
                cont++;
            }
        }
        return cont;
    }
    public int getPostiOccupati() {
        int cont = 0;
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].isOccupato()){
                cont++;
            }
        }
        return cont;
    }
    public int getPostiNormali() {
        int cont = 0;
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].getTipo().equals("Normale")){
                cont++;
            }
        }
        return cont;
    }
    public int getPostiGrandi() {
        int cont = 0;
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].getTipo().equals("Grande")){
                cont++;
            }
        }
        return cont;
    }
    public int getPostiLusso() {
        int cont = 0;
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].getTipo().equals("Lusso")){
                cont++;
            }
        }
        return cont;
    }
    public PostoAuto getPosto(int numero) {
        return posti[numero];
    }

}
