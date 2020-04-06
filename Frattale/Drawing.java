import java.awt.*;
import javax.swing.*;


public class Drawing extends Canvas {

    int cont;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Frattale by Favo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Drawing drawing = new Drawing();
        drawing.setSize(400, 400);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

    }

    public void paint(Graphics g) {
        disegna(g,new Centro(200,200));
        JOptionPane.showMessageDialog(null, "BOOM");
    }

    public void disegna(Graphics g, Centro centro) {
        Centro.giaFatti.add(centro);
        System.out.println(centro);
        if (cont%2==0) {
            g.setColor(Color.BLACK);
        }
        else {
            g.setColor(Color.RED);
        }
        cont++;
        pausa(50);
        g.drawLine(centro.centroX - 10, centro.centroY - 10, centro.centroX + 10, centro.centroY + 10);
        pausa(50);
        g.drawLine(centro.centroX + 10, centro.centroY - 10, centro.centroX - 10, centro.centroY + 10);

        Centro newCentro;

        newCentro = new Centro(centro.centroX - 10, centro.centroY - 10);
        if (!(centro.centroX <= 0 || centro.centroY <= 0) && !centro.fatto(newCentro)) {
            disegna(g, newCentro);
        }

        newCentro = new Centro(centro.centroX + 10, centro.centroY + 10);
        if (!(centro.centroX >= 400 || centro.centroY >= 400) && !centro.fatto(newCentro)) {
            disegna(g, newCentro);
        }

        newCentro = new Centro(centro.centroX + 10, centro.centroY - 10);
        if (!(centro.centroX >= 400 || centro.centroY <= 0) && !centro.fatto(newCentro)) {
            disegna(g, newCentro);
        }

        newCentro = new Centro(centro.centroX - 10, centro.centroY + 10);
        if (!(centro.centroX <= 0 || centro.centroY >= 400) && !centro.fatto(newCentro)) {
            disegna(g, newCentro);
        }
    }

    public void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignore) {}
    }


}

