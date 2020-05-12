import java.util.Random;

public abstract class Animale implements Runnable {

    ClinicaVeterinaria clinica;
    boolean isAttesaFinita;
    int id;

    public Animale(ClinicaVeterinaria clinica, int id) {
        this.clinica = clinica;
        this.id = id;
    }

    public abstract void run();

    public void setAttesaFinita(boolean attesaFinita) {
        isAttesaFinita = attesaFinita;
    }

    void pausa() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(10000)+5000);
        } catch (InterruptedException ignore) { }
    }

}

class Gatto extends Animale{

    public Gatto(ClinicaVeterinaria clinica, int id) {
        super(clinica, id);
    }

    public void run() {
        System.out.println("Gatto " + id + " arriva in clinica");
        while (true) {
            if (isAttesaFinita) {
                break;
            }
            clinica.joinSala(this);
        }
        System.out.println("Gatto " + id + " entra in sala d'attesa");
        pausa();
        System.out.println("Gatto " + id + " lascia la sala d'attesa");
        clinica.exitSala(this);
    }

}

class Cane extends Animale{

    public Cane(ClinicaVeterinaria clinica, int id) {
        super(clinica, id);
    }

    public void run() {
        System.out.println("Cane " + id + " arriva in clinica");
        while (true) {
            if (isAttesaFinita) {
                break;
            }
            clinica.joinSala(this);
        }
        System.out.println("Cane " + id + " entra in sala d'attesa");
        pausa();
        System.out.println("Cane " + id + " lascia la sala d'attesa");
        clinica.exitSala(this);
    }

}


