import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Gui extends JFrame{

    private JFrame window;
    private Container content;

    //-------------------------
    private JPanel researchArea;

    private JPanel researchAreaTop;
    private JPanel researchAreaBottom;
    private JTextField input;
    private JButton search;
    private JLabel playerInfo;
    private JLabel playerRank;
    private JButton addToFavorites;


    //-------------------------
    private JPanel favoritesArea;
    private ArrayList<String> favoritesName;
    private ArrayList<JPanel> namesDisplayed;


    //-------------------------
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 4);

    Gui() {
        window = new JFrame("Rainbow Six Tracker - by imprudenza");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content = window.getContentPane();
        content.setLayout(new BorderLayout());

        setupResearchArea();
        setupFavoritesArea();
        
        content.add(researchArea, BorderLayout.CENTER);
        content.add(favoritesArea, BorderLayout.EAST);

        window.pack();
        window.setMinimumSize(new Dimension(400, 250));
        window.setVisible(true);
    }

    private void setupResearchArea() {
        researchArea = new JPanel();
        researchArea.setLayout(new BoxLayout(researchArea, BoxLayout.Y_AXIS));

        researchAreaTop = new JPanel();
        researchAreaBottom = new JPanel();

        researchAreaTop.setMaximumSize(new Dimension(400, 50));
        researchAreaBottom.setMinimumSize(new Dimension(400, 350));
        researchAreaTop.setBorder(border);

        researchArea.add(researchAreaTop);
        researchArea.add(researchAreaBottom);

        researchAreaTop.setLayout(new BoxLayout(researchAreaTop, BoxLayout.X_AXIS));
        researchAreaBottom.setLayout(new BorderLayout());

        input = new JTextField();
        input.setText("Inserire nickname da trackare");
        input.setSize(350, 50);
        input.setMaximumSize(new Dimension(350, 50));
        input.setHorizontalAlignment(SwingConstants.CENTER);

        playerInfo = new JLabel();
        playerRank = new JLabel();
        playerRank.setSize(100,200);
        playerRank.setMaximumSize(new Dimension(100,200));
        playerRank.setMinimumSize(new Dimension(100,200));

        addToFavorites = new JButton("Aggiungi ai preferiti");

        search = new JButton("Cerca!");
        search.addMouseListener(new Listener_ButtonSearch(input, playerInfo, playerRank, window, addToFavorites, researchAreaBottom));

        playerInfo.setVerticalAlignment(SwingConstants.CENTER);
        playerInfo.setHorizontalAlignment(SwingConstants.CENTER);

        researchAreaTop.add(input);
        researchAreaTop.add(search);
        researchAreaBottom.add(playerInfo, BorderLayout.CENTER);
        researchAreaBottom.add(playerRank, BorderLayout.EAST);
    }
    
    private void setupFavoritesArea() {
        favoritesName = new ArrayList<>();
        namesDisplayed = new ArrayList<>();
        favoritesArea = new JPanel();
        favoritesArea.setLayout(new BoxLayout(favoritesArea, BoxLayout.Y_AXIS));

        addToFavorites.addMouseListener(new Listener_ButtonAddToFavorites(window, favoritesName, input, namesDisplayed, favoritesArea));

    }

}
