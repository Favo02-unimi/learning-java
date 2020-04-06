import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisualizzazioneParcheggio {
    private JFrame window;
    private Container content;
    private JPanel infoArea, displayArea;
    private Garage garage;
    private JPanel[] livelli;

    private final Border BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final Color LIBERO = new Color(0, 104, 15);
    private final Color OCCUPATO = new Color(104, 0, 2);

    public VisualizzazioneParcheggio(Garage garage) {
        this.garage = garage;

        window = new JFrame("Visualizzazione grafica Parcheggio");
        window.setBounds(0,0,1400,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = window.getContentPane();
        content.setLayout(new BorderLayout());
        infoArea = new JPanel();
        displayArea = new JPanel();

        setupInfoArea();
        setupDisplayArea();

        content.add(infoArea, BorderLayout.NORTH);
        content.add(displayArea, BorderLayout.WEST);

        window.setVisible(true);
    }

    private void setupInfoArea() {
        infoArea.setLayout(new BoxLayout(infoArea, BoxLayout.Y_AXIS));
        infoArea.add(new JLabel("Livelli: " + garage.getNumeroLivelli()));
        infoArea.add(new JLabel("Posti totali: " + garage.getNumeroPostiTotali()));
        infoArea.add(new JLabel("Posti disponibili: " + garage.getPostiDisponibili()));
        infoArea.add(new JLabel("Posti occupati: " + garage.getPostiOccupati()));
        infoArea.add(new JLabel("Posti normali: " + garage.getPostiNormali()));
        infoArea.add(new JLabel("Posti grandi: " + garage.getPostiGrandi()));
        infoArea.add(new JLabel("Posti lusso: " + garage.getPostiLusso()));
        infoArea.add(new JLabel("Il livello destinato alle macchine GPL è lo 0"));
    }
    
    private void setupDisplayArea() {
        displayArea.setLayout(new BoxLayout(displayArea, BoxLayout.Y_AXIS));
        int numeroLivelli = garage.getNumeroLivelli();
        livelli = new JPanel[numeroLivelli];
        Livello livello;
        for (int i = 0; i < numeroLivelli; i++) {
            livello = garage.getLivelli()[i];
            int numeroPosti = livello.getNumeroPostiTotali();
            JLabel[] posti = new JLabel[numeroPosti];
            livelli[i] = new JPanel();
            livelli[i].setLayout(new BoxLayout(livelli[i], BoxLayout.X_AXIS));
            livelli[i].add(new JLabel("Liv " + i));
            for (int j = 0; j < numeroPosti; j++) {
                posti[j] = new JLabel(j + " " + livello.getPosto(j).getSiglaTipo());
                posti[j].setOpaque(true);
                posti[j].setBorder(BORDER);
                posti[j].setForeground(Color.WHITE);
                posti[j].setMinimumSize(new Dimension(32,25));
                posti[j].setPreferredSize(new Dimension(32,25));
                posti[j].setMaximumSize(new Dimension(32,25));
                if(livello.getPosto(j).isOccupato()){
                    posti[j].setBackground(OCCUPATO);
                }
                else {
                    posti[j].setBackground(LIBERO);
                }

                livelli[i].add(posti[j]);
            }
            displayArea.add(livelli[i]);
        }
    }

    public void close() {
        window.dispose();
    }

}
