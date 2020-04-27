import javax.swing.*;
import java.awt.*;


/*
   JFrame : cornice dove dentro si mette tutto
      setBounds(x,y,width,height) : grandezza e posizione finestra
      add(pezzo, LayoutSeguito.posizione) : inserire nella cornice pezzi
      setVisible(boolean) : alzare la finestra all'esecuzione
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) : cosa fare quando si chiude la finestra
   Container : è la parte interna alla cornice
      setBackground(colore) : cambia sfondo al contenuto
      setLayout() : cambia layout disposizione
   JLabel : etichetta di testo
      setOpaque(boolean) : visibilità sfondo
      setBackground(colore) : colore sfondo
      setForeground(colore) : cambiare prima piano colore



 */
public class SwingGUI {
    public static void main(String[] args){
       JFrame finestra = new JFrame("Tris");
       finestra.setBounds(5,5, 500, 500);
       Container contenuto = finestra.getContentPane();
       contenuto.setBackground(Color.GREEN);
       contenuto.setLayout(new BoxLayout(contenuto, BoxLayout.X_AXIS)); //boxlayout: uno dopo l'altro, .X_AXIS: il verso

       JPanel sx = new JPanel();
       JPanel dx = new JPanel();
       JPanel mid = new JPanel();
       sx.setLayout(new BoxLayout(sx, BoxLayout.Y_AXIS));
       dx.setLayout(new BoxLayout(dx, BoxLayout.Y_AXIS));
       mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));

       contenuto.add(sx);
       contenuto.add(mid);
       contenuto.add(dx);

       JButton bot1 = new JButton("Bottone 1");
       JButton bot2 = new JButton("Bottone 2");
       JButton bot3 = new JButton("Bottone 3");

       mid.add(bot1);
       mid.add(bot2);
       mid.add(bot3);

       JLabel label1 = new JLabel("TRIIISSS");
       label1.setOpaque(true);
       label1.setBackground(Color.BLUE);
       label1.setForeground(Color.WHITE);
       sx.add(label1);

       JLabel label2 = new JLabel("Tris2");
       label2.setOpaque(true);
       label2.setBackground(Color.RED);
       sx.add(label2);

       JLabel label3 = new JLabel("Tris3");
       label3.setOpaque(true);
       label3.setBackground(Color.YELLOW);
       sx.add(label3);

       JLabel label5 = new JLabel("TRIIISSS");
       label5.setOpaque(true);
       label5.setBackground(Color.BLUE);
       label5.setForeground(Color.WHITE);
       dx.add(label5);

       JLabel label6 = new JLabel("Tris6");
       label6.setOpaque(true);
       label6.setBackground(Color.RED);
       dx.add(label6);

       JLabel label7 = new JLabel("Tris7");
       label7.setOpaque(true);
       label7.setBackground(Color.YELLOW);
       dx.add(label7);



       finestra.setVisible(true);
       finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
