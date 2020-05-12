/*
Un veterinario ha una sala d'attesa che può contenere solo
cani e gatti
Un gatto non può entrare nella sala se sono già presenti un
cane o un gatto
Un cane non può entrare nella sala se è già presente un gatto
Non ci possono essere più di 4 cani in tutto
Gli animali restano all'interno della stanza per un periodo di
tempo randomico
Gli animali che non possono entrare attendono finché diventa
possibile
Risolvere il problema con synchronized, wait e notify:
implementando un metodo enterRoom e un metodo exitRoom
generando randomicamente animali (thread) che chiamano
questi metodi
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ClinicaVeterinaria clinica = new ClinicaVeterinaria();
        Random random = new Random();
        for (int i = 0; true; i++) {
            /*if (clinica.getAnimaliInAttesa() >= 4) {
                continue;
            }*/
            //System.err.println(clinica.stampaSala());
            pausa();
            Animale animale;
            if (random.nextInt(2) == 0) {
                animale = new Gatto(clinica, i);
            } else {
                animale = new Cane(clinica, i);
            }
            Thread thread = new Thread(animale);
            clinica.aggiungiAnimaleInAttesa();
            thread.start();
        }
    }
    static void pausa() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException ignore) { }
    }
}
