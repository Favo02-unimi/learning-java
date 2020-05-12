public class Client implements Runnable{

    private Cinema monitor;
    private int bigliettiDaAcquistare;

    public Client (Cinema monitor, int bigliettiDaAcquistare) {
        this.monitor = monitor;
        this.bigliettiDaAcquistare = bigliettiDaAcquistare;
    }

    public void run() {
        if (monitor.compraBiglietti(bigliettiDaAcquistare)) {
            System.out.println("Richiesti " + bigliettiDaAcquistare + " biglietti");
            pausa();
            System.out.println("Consegnati " + bigliettiDaAcquistare + " biglietti");
            System.out.println("Posti rimanenti: " + monitor.getPostiDisponibili());
        } else {
            System.out.println("Sono rimasti solo " + monitor.getPostiDisponibili() + " posti, riprovare");
        }
    }

    private void pausa() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) { }
    }

}
