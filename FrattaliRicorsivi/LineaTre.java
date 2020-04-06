import javax.swing.*;
import java.awt.*;

public class LineaTre extends Canvas {

    //solita roba per creare la finestra
    public static void main(String[] args) {
        JFrame frame = new JFrame("Linea divisa in tre");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 450, 400);
        LineaTre disegno = new LineaTre();
        disegno.setSize(400, 400);
        frame.add(disegno);
        frame.setVisible(true);
    }

    //paint che richiama la prima volta il metodo che disegna
    public void paint(Graphics g) {
        Point a = new Point(10,10);
        Point b = new Point(400,10);
        g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
        drawLine(g, a, b);
    }

    //metodo che disegna
    public void drawLine(Graphics g, Point a, Point b) {
        //pausa per far vedere la creazione mano a mano
        pause();
        //calcolo la distanza tra i due estremi della linea
        double distanza = Math.abs(a.getX() - b.getX());
        //divido in tre segmenti la lunghezza
        int segmento = (int)(distanza / 3);
        //se segmento troppo piccolo stoppo
        if (segmento <= 1) {
            return;
        }
        //calcolo gli estremi del primo pezzo della linea spezzata
        Point aLinea = new Point((int)a.getX(), (int)a.getY()+5);
        Point bLinea = new Point((int)(a.getX()+segmento), (int)a.getY()+5);
        //disegno il primo pezzo
        g.drawLine((int)aLinea.getX(), (int)aLinea.getY(), (int)bLinea.getX(), (int)bLinea.getY());
        //richiamo la ricorsione sul primo pezzo
        drawLine(g, aLinea, bLinea);

        //secondo pezzo bianco quindi nulla

        //calcolo gli estremi del terzo pezzo della linea spezzata
        Point cLinea = new Point((int)b.getX(), (int)b.getY()+5);
        Point dLinea = new Point((int)(b.getX()-segmento), (int)b.getY()+5);
        //disegno il terzo pezzo
        g.drawLine((int)cLinea.getX(), (int)cLinea.getY(), (int)dLinea.getX(), (int)dLinea.getY());
        //richiamo la ricorsione sul terzo pezzo
        drawLine(g, cLinea, dLinea);
    }

    //metodo pausa
    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
