
//public class Salumiere implements Runnable{
public class Salumiere {

    private boolean isLibero;
    private Salumeria salumeria;
    private int id;

    public Salumiere(Salumeria salumeria, int id) {
        this.salumeria = salumeria;
        isLibero = true;
        this.id = id;
    }

    //public void run() { }

    public boolean isLibero() {
        return isLibero;
    }

    public void setOccupato() {
        isLibero = false;
    }

    public void setLibero() {
        isLibero = true;
    }

    public void riceviListaSpesa(ListaDellaSpesa lista) {
        for (int i = 0; i < lista.size(); i++) {
            Prodotto prodottoDaAffettare = lista.getProssimoProdottoVoluto();
            if (salumeria.affetta(prodottoDaAffettare)) {
                System.out.println("Salumiere " + id + ": " + prodottoDaAffettare.getClass().getName() + " affettato");
                lista.prodottoPreso();
            }
            else {
                System.out.println("Salumiere " + id + ": " + prodottoDaAffettare.getClass().getName() + " non disponibile");
            }
        }
    }

    public void aumentaTurno() {
        salumeria.aumentaTurno();
    }

    public int getID() {
        return id;
    }


}

