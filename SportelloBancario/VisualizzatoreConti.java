import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VisualizzatoreConti implements Runnable {

    private ArrayList<Conto> databaseConti;

    private JFrame window;
    private Container content;

    private JPanel researchArea;

    private JPanel researchAreaTop;

    public VisualizzatoreConti(ArrayList<Conto> databaseConti) {
        this.databaseConti = databaseConti;
        JFrame finestra = new JFrame("Conti:");

    }

    public void run() {
        new VisualizzatoreConti(databaseConti);
    }

}
