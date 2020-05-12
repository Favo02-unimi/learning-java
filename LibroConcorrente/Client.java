import java.util.Random;

public class Client implements Runnable {

    private final Libro libro;
    private int rigaDaLeggere;

    public Client(Libro libro, int stringaDaLeggere) {
        this.libro = libro;
        this.rigaDaLeggere = stringaDaLeggere;
    }

    public void run() {
        pause();
        if (libro.leggi(rigaDaLeggere)) {
            System.out.println(libro.riceviStringa(rigaDaLeggere));
        }
        else {
            System.out.println("Stringa già letta");
        }
    }

    private void pause() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException ignored) { }
    }

}
