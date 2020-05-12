public class Server {

    private Videoconferenza videoconferenza;

    public Server(Videoconferenza videoconferenza) {
        this.videoconferenza = videoconferenza;
    }

    public void start() {
        for (int i = 0; i < videoconferenza.getPartecipantiTotali(); i++) {
            Thread thread = new Thread(new Partecipante(videoconferenza, i));
            thread.start();
        }
    }
}
