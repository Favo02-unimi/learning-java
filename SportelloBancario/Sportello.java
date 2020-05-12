import java.util.ArrayList;
import java.util.Random;

public class Sportello {

    private ArrayList<Conto> databaseConti;
    private Conto loginEffettuato;

    public Sportello() {
        databaseConti = new ArrayList<>();
        generaContiRandom();
    }

    public Conto login(int numeroTessera, int pin) {
        for (int i = 0; i < databaseConti.size(); i++) {
            if (databaseConti.get(i).getNumeroTessera() == numeroTessera) {
                if (databaseConti.get(i).getPin() == pin) {
                    return databaseConti.get(i);
                }
            }
        }
        return null;
    }

    public void logout() {

    }

    private void generaContiRandom() {
        System.err.println("/-------GENERAZIONE CONTI-------/");
        Random random = new Random();
        int numeroConti = random.nextInt(5)+5;
        for (int i = 0; i < numeroConti; i++) {
            System.err.println("-> Conto " + i + ":");
            int numeroTessera = random.nextInt(899999) + 100000;
            System.err.println("N° tessera: " + numeroTessera);
            int pin = random.nextInt(8999) + 1000;
            System.err.println("PIN: " + pin);
            double saldo = random.nextInt(10000) + 1;
            System.err.println("Saldo: " + saldo);
            Conto conto = new Conto(numeroTessera, pin, saldo);
            databaseConti.add(conto);
        }
        System.err.println("/-----FINE GENERAZIONE CONTI-----/");
        Thread visualizzatoreConti = new Thread(new VisualizzatoreConti(databaseConti));
        visualizzatoreConti.start();
    }
}
