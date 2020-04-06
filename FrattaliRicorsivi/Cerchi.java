import javax.swing.*;
import java.awt.*;

public class Cerchi extends Canvas {

    //solita roba per creare la finestra
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cerchi, troppi cerchi");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0,0, 450,450);
        Cerchi disegno = new Cerchi();
        disegno.setSize(400,400);
        frame.add(disegno);
        frame.setVisible(true);
    }

    //paint che richiama la prima volta il metodo che disegna
    public void paint(Graphics g) {
        drawCircle(g, 200,200,200);
    }

    //metodo che disegna
    public void drawCircle(Graphics g, int x, int y, int raggio) {
        //pausa per far vedere la creazione mano a mano
        pause();
        //calcoliamo le coordinate del rettangolo circoscritto per utilizzare x e y come centro
        int newX = x - raggio;
        int newY = y - raggio;
        int diametro = raggio*2;
        //disegnamo il cerchio
        g.drawOval(newX, newY, diametro, diametro);
        //se il raggio è abbasatanza grosso richiamiamo lo stesso metodo (ricorsione)
        if (raggio > 10) {
            //cambia la posizione e il raggio
            drawCircle(g, x + raggio/2, y + raggio/2, raggio/2);
            drawCircle(g, x - raggio/2, y - raggio/2, raggio/2);
            drawCircle(g, x - raggio/2, y + raggio/2, raggio/2);
            drawCircle(g, x + raggio/2, y - raggio/2, raggio/2);
        }
    }

    //metodo pausa
    private void pause() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
