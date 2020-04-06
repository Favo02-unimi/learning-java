import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener_deleteButton implements MouseListener {

    private Rubrica rubrica;
    private GUI gui;

    Listener_deleteButton(Rubrica rubrica, GUI gui){
        this.rubrica = rubrica;
        this.gui = gui;
    }

    public void mouseClicked(MouseEvent e) {
        String nome = GUI.showInputString("Inserire nome contatto da eliminare");
        String cognome = GUI.showInputString("Inserire cognome contatto da eliminare");
        rubrica.elimina(nome, cognome);
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
