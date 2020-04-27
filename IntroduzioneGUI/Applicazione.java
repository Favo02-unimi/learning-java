import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Applicazione {

    public static void main(String[] args) {
        //crea nuovo oggetto Applicazione
        new Applicazione();
    }

    //costrutture
    public Applicazione() {
        JFrame finestra = new JFrame();
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //imposta il titolo della finestra
        finestra.setTitle("Titolo finestra");
        //dimensioni finstra
        finestra.setSize(700,500);
        //centra la finestra nello schermo
        finestra.setLocationRelativeTo(null);

        String[] listaFrutti = {"Apple", "Apricot", "Banana","Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"};
        String[] listaVerdure = {"Asparagus", "Beans", "Broccoli", "Cabbage", "Carrot", "Celery", "Cucumber"};

        //JPanel = un contenitore
        final JPanel contenitorePannelloFrutta = new JPanel();
        //JLabel = etichetta di testo non cliccabile (parametro: testo da visualizzare)
        JLabel etichettaFrutta = new JLabel("Frutta:");
        //JComboBox = menù a tendina (parametro: contenuto da cui scegliere)
        JComboBox menuFrutta = new JComboBox(listaFrutti);

        //aggiungiamo l'etichetta al pannello
        contenitorePannelloFrutta.add(etichettaFrutta);
        //aggiungiamo anche il menù a tendina
        contenitorePannelloFrutta.add(menuFrutta);

        //JPanel = un altro contenitore
        final JPanel contenitorePannelloVerdura = new JPanel();
        //imposta la visibilità del cont a falsa
        contenitorePannelloVerdura.setVisible(false);
        //altra etichetta
        JLabel etichettaVerdura = new JLabel("Verdure:");
        //lista selezionabile
        JList listaCliccabileVerdura = new JList(listaVerdure);
        //imposta come si deve espandere la lista
        //vegs.setLayoutOrientation(JList.VERTICAL_WRAP);
        //aggiungiamo al secondo contenitore gli elementi creati
        contenitorePannelloVerdura.add(etichettaVerdura);
        contenitorePannelloVerdura.add(listaCliccabileVerdura);

        //Jbutton = pulsante (arg: testo)
        JButton pulsante = new JButton( "Fruit or Veg");

        //"ascoltatore" del pulsante, cosa fare quando cliccato
        pulsante.addActionListener(new ActionListener()
            //viene creata una inner anonymous class: classe interna anonima,
            // è una classe che viene usata solo per questo pulsante, non si può
            //utilizzare in altre parti, che implementa ActionListener e quindi ha bisogno
            //del metodo actionPerformed
        {
            //metodo che viene richiamato quando succede un azione, quindi quando clicka il pulsante
            public void actionPerformed(ActionEvent event)
            {
                //inverte visibilità contenitori
                contenitorePannelloVerdura.setVisible(!contenitorePannelloVerdura.isVisible());
                contenitorePannelloFrutta.setVisible(!contenitorePannelloFrutta.isVisible());
            }
        });

        //vengono aggiunti alla finestra i due contenitori, alla posizione voluta
        finestra.add(contenitorePannelloFrutta, BorderLayout.NORTH);
        finestra.add(contenitorePannelloVerdura, BorderLayout.CENTER);
        //viene aggiunto alla finestra il pulsante, in basso (SOUTH)
        finestra.add(pulsante, BorderLayout.SOUTH);

        //viene visualizzata la finestra
        finestra.setVisible(true);
    }
}