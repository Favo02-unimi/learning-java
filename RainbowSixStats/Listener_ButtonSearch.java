import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Listener_ButtonSearch implements MouseListener {

    private JTextField input;
    private JLabel playerInfo;
    private JLabel playerRank;
    private JFrame window;
    private JButton addToFavorites;
    private JPanel researchAreaBottom;

    public Listener_ButtonSearch(JTextField input, JLabel playerInfo, JLabel playerRank, JFrame window, JButton addToFavorites, JPanel researchAreaBottom) {
        this.input = input;
        this.playerInfo = playerInfo;
        this.playerRank = playerRank;
        this.window = window;
        this.addToFavorites = addToFavorites;
        this.researchAreaBottom = researchAreaBottom;
    }

    public void mouseClicked(MouseEvent e) {
        playerInfo.setText("Loading...");
        String name = input.getText();
        Player player = Tracker.track(name);
        if (player != null) {
            playerInfo.setText(player.toStringHTML());
            playerInfo.setText(player.toStringHTML());
            BufferedImage myPicture = null;
            String path = "Ranks\\" + player.getRank() + ".png";
            try {
                myPicture = ImageIO.read(new File(path));
            } catch (IOException ignore) {
                ignore.printStackTrace();
            }
            ImageIcon rank = scaleImage(new ImageIcon(myPicture), 200,100);
            playerRank.setIcon(rank);
            researchAreaBottom.add(addToFavorites, BorderLayout.SOUTH);
        }
        else {
            researchAreaBottom.remove(addToFavorites);
            playerInfo.setText("Player inesistente.");
            playerRank.setIcon(null);
        }
        window.pack();
    }

    public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
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
