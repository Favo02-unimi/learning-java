import java.util.ArrayList;

public class Centro {

    static ArrayList<Centro> giaFatti = new ArrayList<>();

    public Centro(int x, int y) {
        centroX = x;
        centroY = y;
    }
    int centroX;
    int centroY;

    public String toString() {
        return  "centroX=" + centroX +
                ", centroY=" + centroY;
    }

    public boolean fatto(Centro centro) {
        for (int i = 0; i < giaFatti.size(); i++) {
            if (centro.equals(giaFatti.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Centro centro) {
        return centroX == centro.centroX &&
                centroY == centro.centroY;
    }

}
