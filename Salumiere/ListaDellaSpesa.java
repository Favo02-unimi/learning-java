import java.util.ArrayList;
import java.util.Random;

public class ListaDellaSpesa {

    private ArrayList<Prodotto> prodotti;

    public ListaDellaSpesa() {
        prodotti = new ArrayList<>();
        generaListaRandom();
    }

    public Prodotto getProssimoProdottoVoluto() {
        if (prodotti.size()>0) {
            return prodotti.get(0);
        }
        else {
            return null;
        }
    }

    public void prodottoPreso() {
        prodotti.remove(0);
    }

    public int size() {
        return prodotti.size();
    }

    private void generaListaRandom() {
        //genero la lista con una probabilità che non voglia quel prodotto
        Random random = new Random();
        if (!(random.nextInt(4)==0)) {
            prodotti.add(new Prosciutto(random.nextInt(10)));
        }
        if (!(random.nextInt(4)==0)) {
            prodotti.add(new Salame(random.nextInt(10)));
        }
        if (!(random.nextInt(4)==0)) {
            prodotti.add(new Pancetta(random.nextInt(10)));
        }
        if (!(random.nextInt(4)==0)) {
            prodotti.add(new Mortadella(random.nextInt(10)));
        }
    }
}
