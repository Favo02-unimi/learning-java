public class Videoconferenza {

    int partecipantiTotali;
    int partecipantiEntrati;

    public Videoconferenza(int partecipanti) {
        this.partecipantiTotali = partecipanti;
    }

    public synchronized int getPartecipantiTotali() {
        return partecipantiTotali;
    }

    public synchronized int getPartecipantiEntrati() {
        return partecipantiEntrati;
    }

    public synchronized void entraPartecipante() {
        partecipantiEntrati++;
        if (partecipantiEntrati < partecipantiTotali) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            notifyAll();
        }
    }
}
