import javax.swing.*;
import java.awt.*;

public class MoireCerchi extends Canvas {

    //solita roba per creare la finestra
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cerchi di Moire");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0,0, 450,450);
        MoireCerchi disegno = new MoireCerchi();
        disegno.setSize(400,400);
        frame.add(disegno);
        frame.setVisible(true);
    }

    //paint che richiama la prima volta il metodo che disegna
    public void paint(Graphics g) {
        drawCerchio(g, 200,200,200);
    }

    //metodo che disegna
    private void drawCerchio(Graphics g, int x, int y, int raggio){
        //calcoliamo le coordinate del rettangolo circoscritto per utilizzare x e y come centro
        int newX = x - raggio;
        int newY = y - raggio;
        int diametro = raggio*2;
        //disegno cerchio
        g.drawOval(newX, newY, diametro, diametro);
        //se il diametro è abbasatanza grosso richiamiamo lo stesso metodo (ricorsione)
        if (diametro > 1) {
            //richiamo passando stesso centro ma ragigo minore
            drawCerchio(g, x, y, (int) (raggio*0.75));
        }
    }

}
