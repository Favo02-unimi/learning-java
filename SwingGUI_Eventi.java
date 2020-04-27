import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingGUI_Eventi {
    public static void main(String[] args){
        Finestra finestra = new Finestra();
    }
}

class Finestra{
    Container contenuto = null;

    public Finestra(){
        JFrame finestra = new JFrame("Tris");
        finestra.setBounds(5,5, 500, 500);
        contenuto = finestra.getContentPane();
        contenuto.setBackground(Color.GREEN);
        contenuto.setLayout(new BoxLayout(contenuto, BoxLayout.Y_AXIS));

        JButton but1 = new JButton("Bottone 1");
        contenuto.add(but1);
        but1.addActionListener(new clickBottone());

        JTextField testo = new JTextField();
        testo.addKeyListener(new intercettaTasti());

        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private class clickBottone implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            contenuto.setBackground(Color.CYAN);
        }
    }
    private class intercettaTasti implements KeyListener{

        public void keyReleased(KeyEvent e){
            JTextField testo = (JTextField) e.getSource();
            String testoo = testo.getText();
            testo.setText(testoo.toUpperCase());
        }
        public void keyTyped(KeyEvent e){}

        public void keyPressed(KeyEvent e) { }
    }
}
