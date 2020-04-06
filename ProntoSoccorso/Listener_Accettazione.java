import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Listener_Accettazione implements MouseListener {

    private Gui gui;

    public Listener_Accettazione(Gui gui){
        this.gui = gui;
    }

    public void mouseClicked(MouseEvent e) {
        gui.accettazionePaziente();
        try {
            ProntoSoccorso.scriviInDB();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) {

    }

}