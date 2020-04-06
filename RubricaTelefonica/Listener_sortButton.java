import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener_sortButton implements MouseListener {

    private Rubrica rubrica;
    private GUI gui;
    private int selector;

    Listener_sortButton(Rubrica rubrica, GUI gui, int selector){
        this.rubrica = rubrica;
        this.gui = gui;
        this.selector = selector;
    }

    public void mouseClicked(MouseEvent e) {
        if(selector == 1){
            gui.refreshContactsName();
            gui.sortName.setBackground(Color.RED);
            gui.sortSurname.setBackground(Color.GRAY);
            gui.setName();
        }
        if(selector == 2){
            gui.refreshContactsSurname();
            gui.sortName.setBackground(Color.GRAY);
            gui.sortSurname.setBackground(Color.RED);
            gui.setSurname();
        }
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
