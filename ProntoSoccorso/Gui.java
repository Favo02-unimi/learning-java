import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui {

    ArrayList<Paziente> coda;

    private JFrame window;
    private Container content;

    private JPanel buttonArea;
    private JButton arrivo, accettazione;

    private JPanel queueArea;
    private ArrayList<JLabel> queue;

    public Gui(ArrayList<Paziente> coda){
        this.coda = coda;

        window = new JFrame("Pronto Soccorso by Favo");
        window.setBounds(5,5, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = window.getContentPane();
        content.setLayout(new BorderLayout());

        buttonArea = new JPanel();
        queueArea = new JPanel();

        setupButtonArea();

        queue = new ArrayList<>();
        refreshQueue();

        buttonArea.setLayout(new BoxLayout(buttonArea, BoxLayout.X_AXIS));
        queueArea.setLayout(new BoxLayout(queueArea, BoxLayout.Y_AXIS));

        content.add(buttonArea, BorderLayout.CENTER);
        content.add(queueArea, BorderLayout.EAST);

        window.setVisible(true);
    }

    private void setupButtonArea() {
        arrivo = new JButton("Arrivo");
        accettazione = new JButton("Accettazione");
        arrivo.setMinimumSize(new Dimension(150,60));
        arrivo.setSize(new Dimension(150,60));
        arrivo.setMaximumSize(new Dimension(150,60));
        accettazione.setMinimumSize(new Dimension(150,60));
        accettazione.setSize(new Dimension(150,60));
        accettazione.setMaximumSize(new Dimension(150,60));
        buttonArea.add(arrivo);
        buttonArea.add(accettazione);
    }

    public void refreshQueue() {
        queueArea.removeAll();
        System.err.println("Coda: " + coda.size());
        queue.clear();
        queueArea.add(new JLabel("Coda:"));
        for (int i = 0; i < coda.size(); i++) {
            queue.add(new JLabel(coda.get(i).getNome()));
            int codice = coda.get(i).getCodice();
            queue.get(i).setBackground(selezionaCodice(codice));
            queue.get(i).setOpaque(true);
        }
        for (int i = 0; i < queue.size(); i++) {
            queueArea.add(queue.get(i));
        }
    }

    private Color selezionaCodice(int codice) {
        if (codice == Paziente.COD_ROSSO) {
            return Color.RED;
        }
        if (codice == Paziente.COD_GIALLO) {
            return Color.YELLOW;
        }
        if (codice == Paziente.COD_VERDE) {
            return Color.GREEN;
        }
        if (codice == Paziente.COD_BIANCO) {
            return Color.WHITE;
        }
        if (codice == Paziente.COD_AZZURRO) {
            return Color.BLUE.brighter();
        }
        return Color.BLACK;
    }

    public void arrivoPaziente() {
        Paziente paziente = inputPaziente();
        System.err.println(paziente);

        selezioneCodice(paziente);
        if (coda.size()==0){
            coda.add(paziente);
            refreshQueue();
            return;
        }
        int i;
        for (i = coda.size()-1; i > 0; i--) {
            if (coda.get(i).getCodice() >= paziente.getCodice()) {
                break;
            }
        }
        coda.add(i+1, paziente);
        refreshQueue();
    }

    public void accettazionePaziente() {
        if (coda.isEmpty()){
            System.out.println("Non ci sono pazienti in attesa.");
            return;
        }
        coda.remove(0);
        refreshQueue();
    }

    private Paziente inputPaziente() {
        String nome = JOptionPane.showInputDialog("Inserire nome e cognome paziente:");
        String data = JOptionPane.showInputDialog("Inserire data di nascita in questo formato: [AAAA-MM-GG]");
        String[] selezioni = {"Uomo", "Donna"};
        String sesso = String.valueOf(JOptionPane.showInputDialog(null,
                "Inserire sesso paziente", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                selezioni, null));
        boolean isMaschio = false;
        switch (sesso){
            case ("Uomo"):
                isMaschio = true;
                break;
            case ("Donna"):
                isMaschio = false;
                break;
        }
        boolean isGravidanza = false;
        selezioni = new String[]{"Si", "No"};
        if (!isMaschio) {
            String gravidanza = "No";
            gravidanza = String.valueOf(JOptionPane.showInputDialog(null,
                    "La paziente è in gravidanza?", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    selezioni, selezioni[1]));
            switch (gravidanza){
                case ("Si"):
                    isGravidanza = true;
                    break;
                case ("No"):
                    isGravidanza = false;
                    break;
            }
        }
        String handicap = String.valueOf(JOptionPane.showInputDialog(null,
                "Il paziente è portatore di handicap?", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                selezioni, selezioni[1]));
        boolean isHandicap = false;
        switch (handicap){
            case ("Si"):
                isHandicap = true;
                break;
            case ("No"):
                isHandicap = false;
                break;
        }
        return new Paziente(nome, data, isMaschio, isGravidanza, isHandicap);
    }

    private void selezioneCodice(Paziente paziente) {
        String[] selezioni = {"Molto critico", "Mediamente critico", "Poco critico", "Non critico"};
        String codice = String.valueOf(JOptionPane.showInputDialog(null,
                "Selezionare stato criticità paziente?", "Assegnazione codice",
                JOptionPane.INFORMATION_MESSAGE, null,
                selezioni, null));
        switch (codice){
            case ("Molto critico"):
                paziente.setCodice(Paziente.COD_ROSSO);
                break;
            case ("Mediamente critico"):
                paziente.setCodice(Paziente.COD_GIALLO);
                break;
            case ("Poco critico"):
                paziente.setCodice(Paziente.COD_VERDE);
                break;
            case ("Non critico"):
                if (paziente.isPazienteDebole()){
                    paziente.setCodice(Paziente.COD_AZZURRO);
                }
                else {
                    paziente.setCodice(Paziente.COD_BIANCO);
                }
                break;
        }
    }

    public JButton getArrivo() {
        return arrivo;
    }

    public JButton getAccettazione() {
        return accettazione;
    }
}
