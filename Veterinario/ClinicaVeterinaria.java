public class ClinicaVeterinaria {

    private int animaliInAttesa;
    private int gattiInSala;
    private int caniInSala;

    public int getAnimaliInAttesa() {
        return animaliInAttesa;
    }

    public void aggiungiAnimaleInAttesa() {
        animaliInAttesa++;
    }
    
    public synchronized void joinSala(Animale animale) {

        if (animale instanceof Gatto) {
            if (gattiInSala == 0 && caniInSala == 0) {
                gattiInSala++;
                animaliInAttesa--;
                animale.setAttesaFinita(true);
            } else {
                try {
                    wait();
                } catch (InterruptedException ignore) { }
            }
        }

        else {
            if (gattiInSala == 0 && caniInSala < 4) {
                caniInSala++;
                animaliInAttesa--;
                animale.setAttesaFinita(true);
            } else {
                try {
                    wait();
                } catch (InterruptedException ignore) { }
            }
        }
    }

    public synchronized void exitSala(Animale animale) {
        if (animale instanceof Gatto) {
            gattiInSala--;
        }
        else {
            caniInSala--;
        }
        notifyAll();
    }

    public String stampaSala() {
        String out = "";
        for (int i = 0; i < gattiInSala; i++) {
            out += "G ";
        }
        for (int i = 0; i < caniInSala; i++) {
            out += "C ";
        }
        return out;
    }

}
