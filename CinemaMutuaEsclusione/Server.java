import java.util.Scanner;

public class Server {

    private Cinema monitor;

    public Server (Cinema monitor) {
        this.monitor = monitor;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            if (monitor.getPostiDisponibili() == 0) {
                System.err.println("Finiti posti disponibili");
                break;
            }
            System.err.println("Quanti biglietti comprare?");
            int bigliettiDaAcquistare = in.nextInt();
            Thread thread = new Thread(new Client(monitor, bigliettiDaAcquistare));
            thread.start();
        }
    }

}
