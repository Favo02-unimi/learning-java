import java.util.ArrayList;
import java.util.Scanner;

public class Garage {

    private Livello[] livelli;

    public Garage(int numeroLivelli, int numeroPostiPerLivello, int[] numeroPostiPerTipo) {
        livelli = new Livello[numeroLivelli];
        for (int i = 0; i < numeroLivelli; i++) {
            livelli[i] = new Livello(i, numeroPostiPerLivello);
        }
        setupTipoPosti(numeroPostiPerTipo);
    }

    public Garage(int numeroLivelli, int numeroPostiPerLivello) {
        livelli = new Livello[numeroLivelli];
        for (int i = 0; i < numeroLivelli; i++) {
            livelli[i] = new Livello(i, numeroPostiPerLivello);
        }
        setupTipoPostiManuale();
    }

    private void setupTipoPosti(int[] numeroPostiPerTipo) {

        double doublePostiNormali = numeroPostiPerTipo[0];
        double doublePostiGrandi = numeroPostiPerTipo[1];
        double doublePostiLusso = numeroPostiPerTipo[2];
        double postiTotali = getNumeroPostiTotali();
        double percNormali = (doublePostiNormali / postiTotali) * 100;
        double percGrandi = (doublePostiGrandi / postiTotali) * 100;
        double percLusso = (doublePostiLusso / postiTotali) * 100;
        int postiNormali = (int) doublePostiNormali;
        int postiGrandi = (int) doublePostiGrandi;
        int postiLusso = (int) doublePostiLusso;

        //System.out.println("posti normali:" + doublePostiNormali);
        //System.out.println("posti grandi:" + doublePostiGrandi);
        //System.out.println("posti lusso:" + doublePostiLusso);

        //System.out.println("perc normali:" + percNormali);
        //System.out.println("perc grandi:" + percGrandi);
        //System.out.println("perc lusso:" + percLusso);

        double postiLivelloGPL = livelli[0].getNumeroPostiTotali();
        double doublePostiNormaliGPL = (postiLivelloGPL / 100) * percNormali;
        double doublePostiGrandiGPL = (postiLivelloGPL / 100) * percGrandi;
        double doublePostiLussoGPL = (postiLivelloGPL / 100) * percLusso;
        int postiNormaliGPL = (int) Math.round(doublePostiNormaliGPL);
        int postiGrandiGPL = (int) Math.round(doublePostiGrandiGPL);
        int postiLussoGPL = (int) Math.round(doublePostiLussoGPL);
        while (postiNormaliGPL + postiGrandiGPL + postiLussoGPL > postiLivelloGPL){
            postiLussoGPL--;
        }

        //System.out.println("posti normali gpl:" + postiNormaliGPL);
        //System.out.println("posti grandi gpl:" + postiGrandiGPL);
        //System.out.println("posti lusso gpl:" + postiLussoGPL);

        postiNormali -= postiNormaliGPL;
        postiGrandi -= postiGrandiGPL;
        postiLusso -= postiLussoGPL;

        //livello gpl
        for (int i = 0; i < postiLivelloGPL; i++) {
            while (postiNormaliGPL>0){
                livelli[0].getPosto(i).setTipo("Normale");
                postiNormaliGPL--;
                i++;
            }
            while (postiGrandiGPL>0){
                livelli[0].getPosto(i).setTipo("Grande");
                postiGrandiGPL--;
                i++;
            }
            while (postiLussoGPL>0){
                livelli[0].getPosto(i).setTipo("Lusso");
                postiLussoGPL--;
                i++;
            }
        }
        //altri livelli
        for (int i = 1; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                while (postiNormali>0) {
                    if (j==livelli[i].getNumeroPostiTotali()){
                        break;
                    }
                    livelli[i].getPosto(j).setTipo("Normale");
                    postiNormali--;
                    j++;
                }
                while (postiGrandi>0) {
                    if (j==livelli[i].getNumeroPostiTotali()){
                        break;
                    }
                    livelli[i].getPosto(j).setTipo("Grande");
                    postiGrandi--;
                    j++;
                }
                while (postiLusso>0) {
                    if (j==livelli[i].getNumeroPostiTotali()){
                        break;
                    }
                    livelli[i].getPosto(j).setTipo("Lusso");
                    postiLusso--;
                    j++;
                }
            }
        }
    }

    public void setupTipoPostiManuale() {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire [N] per posto normale, [G] per grande e [L] per lusso");
        for (int i = 0; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                System.out.println("Livello " + i + " posto " + j);
                switch (in.next().toUpperCase()) {
                    case ("N"):
                        livelli[i].getPosto(j).setTipo("Normale");
                        break;
                    case ("G"):
                        livelli[i].getPosto(j).setTipo("Grande");
                        break;
                    case ("L"):
                        livelli[i].getPosto(j).setTipo("Lusso");
                        break;
                    default:
                        System.out.println("Errore nell'assegnazione del posto");
                        j--;
                }
            }
        }
    }

    public void parcheggioAuto(int livello, int posto, boolean isMensile, String password) {
        livelli[livello].getPosto(posto).changeOccupato();
        if (isMensile) {
            livelli[livello].getPosto(posto).setAffitto(isMensile, password);
        }
        else {
            livelli[livello].getPosto(posto).setAffitto(isMensile, null);
        }

    }

    public double ritiroAuto(int livello, int posto) {
        String tipo = livelli[livello].getPosto(posto).getTipo();
        livelli[livello].getPosto(posto).changeOccupato();
        return livelli[livello].getPosto(posto).getAffitto().calcolaPrezzo(tipo);
    }

    public boolean isDisponibilePostoAdOre() {
        int cont = 0;
        for (int i = 0; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                if (livelli[i].getPosto(j).getAffitto() instanceof AffittoAdOre){
                    cont++;
                }
            }
        }
        if (cont >= (getNumeroPostiTotali()/2)){
            return false;
        }
        return true;
    }

    public boolean isDisponibilePostoMensile() {
        int cont = 0;
        for (int i = 0; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                if (livelli[i].getPosto(j).getAffitto() instanceof AffittoMensile){
                    cont++;
                }
            }
        }
        if (cont >= (getNumeroPostiTotali()/2)){
            return false;
        }
        return true;
    }

    public boolean isDisponibilePostoNormale() {
        for (int i = 0; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                if(livelli[i].getPosto(j).getTipo().equals("Normale")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDisponibilePostoGrande() {
        for (int i = 0; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                if(livelli[i].getPosto(j).getTipo().equals("Grande")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDisponibilePostoLusso() {
        for (int i = 0; i < livelli.length; i++) {
            for (int j = 0; j < livelli[i].getNumeroPostiTotali(); j++) {
                if(livelli[i].getPosto(j).getTipo().equals("Lusso")){
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Integer>[] getListaPostiDisponibili(String tipo, boolean isGPL) {
        ArrayList<Integer>[] postiDisponibili = new ArrayList[livelli.length];
        for (int i = 0; i < livelli.length; i++) {
            postiDisponibili[i] = livelli[i].getListaPostiDisponibili(tipo, isGPL);
        }
        return postiDisponibili;
    }

    public ArrayList<Integer>[] getListaPostiOccupati() {
        ArrayList<Integer>[] postiOccupati = new ArrayList[livelli.length];
        for (int i = 0; i < livelli.length; i++) {
            postiOccupati[i] = livelli[i].getListaPostiOccupati();
        }
        return postiOccupati;
    }

    public ArrayList<Integer>[] getListaPostiAbbonatiMensili() {
        ArrayList<Integer>[] postiAbbonati = new ArrayList[livelli.length];
        for (int i = 0; i < livelli.length; i++) {
            postiAbbonati[i] = livelli[i].getListaPostiAbbonatiMensili();
        }
        return postiAbbonati;
    }

    public int getNumeroLivelli() {
        return livelli.length;
    }
    public int getNumeroPostiTotali() {
        int tot = 0;
        for (int i = 0; i < livelli.length; i++) {
            tot +=  livelli[i].getNumeroPostiTotali();
        }
        return tot;
    }
    public int getPostiDisponibili() {
        int tot = 0;
        for (int i = 0; i < livelli.length; i++) {
            tot += livelli[i].getPostiDisponibili();
        }
        return tot;
    }
    public int getPostiOccupati() {
        int tot = 0;
        for (int i = 0; i < livelli.length; i++) {
            tot += livelli[i].getPostiOccupati();
        }
        return tot;
    }
    public int getPostiNormali() {
        int tot = 0;
        for (int i = 0; i < livelli.length; i++) {
            tot += livelli[i].getPostiNormali();
        }
        return tot;
    }
    public int getPostiGrandi() {
        int tot = 0;
        for (int i = 0; i < livelli.length; i++) {
            tot += livelli[i].getPostiGrandi();
        }
        return tot;
    }
    public int getPostiLusso() {
        int tot = 0;
        for (int i = 0; i < livelli.length; i++) {
            tot += livelli[i].getPostiLusso();
        }
        return tot;
    }
    public Livello[] getLivelli() {
        return livelli;
    }

    public String toString() {
        return "-------------------" +
                "\nCONFIGURAZIONE PARCHEGGIO:" +
                "\nLivelli: " + getNumeroLivelli() +
                "\nPosti per livello: " + getLivelli()[0].getNumeroPostiTotali() +
                "\nPosti normali: " + getPostiNormali() +
                "\nPosti grandi: " + getPostiGrandi() +
                "\nPosti lusso: " + getPostiLusso() +
                "\n" + Affitto.printTariffe() +
                "\n-------------------";
    }
}
