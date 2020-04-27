import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Listener_ButtonAddToFavorites implements MouseListener {

    private JFrame window;
    private ArrayList<String> nameFavorites;
    private JTextField input;
    private ArrayList<JPanel> namesDisplayed;
    private JPanel favoritesArea;

    public Listener_ButtonAddToFavorites(JFrame window, ArrayList<String> nameFavorites, JTextField input, ArrayList<JPanel> namesDisplayed, JPanel favoritesArea) {
        this.window = window;
        this.nameFavorites = nameFavorites;
        this.input = input;
        this.namesDisplayed = namesDisplayed;
        this.favoritesArea = favoritesArea;
        refresh();
    }

    public void mouseClicked(MouseEvent e) {
        String name = input.getText();
        for (int i = 0; i < nameFavorites.size(); i++) {
            if (nameFavorites.get(i).equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(window, "Player già tra i preferiti");
                return;
            }
        }
        nameFavorites.add(name);
        System.err.println(nameFavorites);
        refresh();
        window.pack();
    }

    private void refresh() {
        favoritesArea.removeAll();
        namesDisplayed.clear();
        for (int i = 0; i < nameFavorites.size(); i++) {
            namesDisplayed.add(new JPanel());
            namesDisplayed.get(i).add(new JLabel(nameFavorites.get(i)));
            favoritesArea.add(namesDisplayed.get(i));
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
