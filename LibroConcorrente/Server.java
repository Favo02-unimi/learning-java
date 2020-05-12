import java.util.Random;
import java.util.Scanner;

public class Server {

    private final Libro libro;

    public Server (Libro libro) {
        this.libro = libro;
    }

    public void startInput() {
        Scanner in = new Scanner(System.in);
        while (libro.getIndice().size() > 0) {
            System.err.println("Quale stringa leggere?");
            System.err.println("Stringhe disponibili: " + libro.getIndice());
            int stringa = in.nextInt();
            Thread thread = new Thread(new Client(libro, stringa));
            thread.start();
        }
    }

    public void startRandom() {
        Random random = new Random();
        while (libro.getIndice().size() > 0) {
            System.err.println("Stringhe disponibili: " + libro.getIndice());
            int stringa = random.nextInt(libro.getSize());
            Thread thread = new Thread(new Client(libro, stringa));
            thread.start();
        }
    }

    private void pause() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ignored) { }
    }

}
