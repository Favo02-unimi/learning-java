import java.awt.*;
public class Frattale extends Canvas {

  private int length;
  private int buff;
  private int livelli;

  public Frattale(int length, int buff, int livelli) {
    this.length = length;
    this.livelli = livelli;
    this.buff = buff;
  }

  public void paint(Graphics g) {
    sierpisnky(g, livelli);
  }

  private void sierpisnky(Graphics g, int livelli) {
    Point A, B, C;
    A = new Point(buff, length - buff);
    B = new Point(length - buff, length - buff);
    C = new Point((length / 2), buff);
    paintSierpi(g, livelli, A, B, C);
  }

  private void paintSierpi(Graphics g, int livello, Point a, Point b, Point c) {
    g.drawPolygon(new int[]{(int) a.getX(), (int) b.getX(), (int) c.getX()}, new int[]{(int) a.getY(), (int) b.getY(), (int) c.getY()}, 3);
    if (livello == 0) {
      return;
    }
    Point abM = new Point((int) (a.getX() + b.getX()) / 2, (int) (a.getY() + b.getY()) / 2);
    Point acM = new Point((int) (a.getX() + c.getX()) / 2, (int) (a.getY() + c.getY()) / 2);
    Point cbM = new Point((int) (c.getX() + b.getX()) / 2, (int) (c.getY() + b.getY()) / 2);

    paintSierpi(g, livello - 1, a, acM, abM);
    paintSierpi(g, livello - 1, c, acM, cbM);
    paintSierpi(g, livello - 1, b, abM, cbM);


  }
}