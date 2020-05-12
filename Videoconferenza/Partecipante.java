import java.util.Random;

public class Partecipante implements Runnable{

    private Videoconferenza videoconferenza;
    private int numeroPartecipante;

    public Partecipante(Videoconferenza videoconferenza, int numeroPartecipante) {
        this.videoconferenza = videoconferenza;
        this.numeroPartecipante = numeroPartecipante;
    }

    public void run() {
        pausa();
        System.out.println("Sono entrato");
        videoconferenza.entraPartecipante();
        System.out.println("Sono entrati tutti, saluto!");
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
