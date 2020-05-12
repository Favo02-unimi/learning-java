import java.util.Random;

public abstract class Prodotto {

    int quantita;

    public Prodotto(int quantita) {
        this.quantita = quantita;
    }

    public synchronized boolean affetta(int prodottoAcquistato) {
        pausa();
        if ((quantita - prodottoAcquistato) > 0) {
            quantita -= prodottoAcquistato;
            return true;
        }
        else {
            return false;
        }
    }

    public int getQuantita() {
        return quantita;
    }

    private void pausa() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Prosciutto extends Prodotto {

    public Prosciutto(int quantita) {
        super(quantita);
    }

}

class Salame extends Prodotto {

    public Salame(int quantita) {
        super(quantita);
    }

}

class Pancetta extends Prodotto {

    public Pancetta(int quantita) {
        super(quantita);
    }

}

class Mortadella extends Prodotto {

    public Mortadella(int quantita) {
        super(quantita);
    }

}