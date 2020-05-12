public class Conto {

    private int numeroTessera;
    private int pin;
    private double saldo;

    public Conto(int numeroTessera, int ping, double saldo) {

    }

    public boolean preleva(double importoDaPrelevare) {
        if (importoDaPrelevare > saldo) {
            return false;
        }
        else {
            saldo -= importoDaPrelevare;
            return true;
        }
    }

    public void deposita(double importoDaDepositare) {
        saldo += importoDaDepositare;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public int getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }
}
