import javax.swing.*;

public class Main{

  public static void main(String[]args) {
      int length = 800;
      int buff = 75;
      int livelli = 5;
      JFrame frame = new JFrame("Sierpinski");
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setBounds(0, 0, length, length);
      frame.add(new Frattale(length, buff, livelli));
      frame.setVisible(true);
  }
}