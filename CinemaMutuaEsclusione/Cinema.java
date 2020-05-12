public class Cinema {

    private int postiDisponibili;

    public synchronized int getPostiDisponibili() {
        return postiDisponibili;
    }

    public Cinema(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public synchronized boolean compraBiglietti (int bigliettiDaAcquistare) {
        if (postiDisponibili >= bigliettiDaAcquistare) {
            postiDisponibili -= bigliettiDaAcquistare;
            return true;
        }
        return false;
    }

}
