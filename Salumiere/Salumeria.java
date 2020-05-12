import java.util.ArrayList;
import java.util.Random;

public class Salumeria {

    private int turno;
    private ArrayList<Prodotto> prodottiDisponibili;
    private Salumiere salumiere01, salumiere02;

    public Salumeria() {
        turno = 1; // lo inizializzo ad 1 perchè ci sono già due
        // salumieri liberi quindi due clienti possono essere seviti subito
        prodottiDisponibili = new ArrayList<>();
        generaProdottiDisponibiliRandom();

        salumiere01 = new Salumiere(this, 1);
        //Thread threadSalumiere1 = new Thread(salumiere01);
        //threadSalumiere1.start();

        salumiere02 = new Salumiere(this, 2);
        //Thread threadSalumiere2 = new Thread(salumiere02);
        //threadSalumiere2.start();
    }

    public synchronized Salumiere richiediTurno(int ticket) {
        if (turno < ticket) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (salumiere01.isLibero()) {
            salumiere01.setOccupato();
            return salumiere01;
        }
        if (salumiere02.isLibero()) {
            salumiere02.setOccupato();
            return salumiere02;
        }
        return null;
    }

    public boolean affetta(Prodotto prodottoVoluto) {
        for (int i = 0; i < prodottiDisponibili.size(); i++) {
            if (prodottoVoluto.getClass().getName().equals(prodottiDisponibili.get(i).getClass().getName())) {
                if (prodottiDisponibili.get(i).affetta(prodottoVoluto.getQuantita())) {
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    public synchronized void aumentaTurno() {
        turno++;
        notify();
    }



    private void generaProdottiDisponibiliRandom() {
        Random random = new Random();
        prodottiDisponibili.add(new Prosciutto(random.nextInt(20)+10));
        prodottiDisponibili.add(new Salame(random.nextInt(20)+10));
        prodottiDisponibili.add(new Pancetta(random.nextInt(20)+10));
        prodottiDisponibili.add(new Mortadella(random.nextInt(20)+10));
    }

}
