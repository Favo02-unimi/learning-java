import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener_addButton implements MouseListener {

    private Rubrica rubrica;
    private GUI gui;

    Listener_addButton(Rubrica rubrica, GUI gui){
        this.rubrica = rubrica;
        this.gui = gui;
    }

    public void mouseClicked(MouseEvent e) {
        String nome = GUI.showInputString("Inserire nome contatto da inserire: ");
        String cognome = GUI.showInputString("Inserire cognome contatto da inserire: ");
        int num = GUI.showInputInt("Inserire numero contatto da inserire: ");
        rubrica.inserisci(new Contatto(nome, cognome, num));
        gui.refreshNumber();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
