import java.awt.*;

public class Cap9_PointsRectangles {
    public static void main (String[] args) {
        Point a = new Point(5, 10);
        Point b = new Point(2, 7);
        double distanceAB = a.distance(b);
        System.out.println(distanceAB);
        System.out.println(a);


        Rectangle box = new Rectangle(0, 0, 100, 200);
        Point center = findCenter(box);
        System.out.println(center);

        box.translate(50, 100); //MUOVERE IL RETTANGOLO (MUTABILE)


    }

    //TROVARE IL CENTRO E RITORNARE UN POINT
    public static Point findCenter(Rectangle box) {
        int x = box.x + box.width / 2;
        int y = box.y + box.height / 2;
        return new Point(x, y);
    }
}
