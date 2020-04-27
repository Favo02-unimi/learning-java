import java.awt.*;
import javax.swing.JFrame;


public class Drawing extends Canvas {

    public static void main(String[] args) {
        //creare una finestra
        JFrame finestra = new JFrame("Disegno");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //creare nuovo disegno
        Drawing disegno = new Drawing();
        //dato dimensioni al disegno (finestra prende queste dimensioni)
        disegno.setSize(700, 500);
        //aggiunto alla finestra il disegno
        finestra.add(disegno);
        //adattiamo la grandezza finestra al disegno
        finestra.pack();
        //reso visibile la finestra
        finestra.setVisible(true);
    }

    //viene richiamato dal disegno
    public void paint(Graphics g) {
        int r = (int)(Math.random()*256);
        int gr = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        g.setColor(new Color(r, gr, b));
        g.fillOval(200, 100, 200, 200);
        g.fillOval(150, 80, 100, 100);
        g.fillOval(350, 80, 100, 100);
        g.fillRect(1,1, 100, 100);
        g.drawLine(0,0,700,500);
        g.drawLine(700,0,0,500);
    }
}