import java.util.ArrayList;
import java.util.Arrays;

public class Libro {

    private final String[] libro;
    private ArrayList<Integer> indice;
    private boolean[] giaLetta;
    
    public Libro() {
        libro = new String[15];
        libro[0] = ("0 - Futilely pursuing something that will never be attainable.");
        libro[1] = ("1 - Typically said to indicate that any further investigation into a situation may lead to harm.");
        libro[2] = ("2 - Asking someone to be quiet or to shut up.");
        libro[3] = ("3 - Something that occurs too early before preparations are ready. Starting too soon.");
        libro[4] = ("4 - Finishing a task without making any excuses.");
        libro[5] = ("5 - A rhetorical question used by a person who feels they are being given less consideration than someone else.");
        libro[6] = ("6 - Something that is extremely expensive.");
        libro[7] = ("7 - To retaliate with an attack that is similar to the attack used against you.");
        libro[8] = ("8 - Iron pyrities is a worthless mineral that resembles gold.");
        libro[9] = ("9 - Things that are fixed with great speed, but as a result, it's probably not going to work very well.");
        libro[10] = ("10 - Making fun of something or someone; ridicule.");
        libro[11] = ("11 - Losing money. Being in debt.");
        libro[12] = ("12 - Delicious; something that looks or tastes appetizing.");
        libro[13] = ("13 - Someone or something that one finds to be agreeable or delightful.");
        libro[14] = ("14 - One who escalates small things and turns them into big problems.");

        indice = new ArrayList<>();
        for (int i = 0; i < libro.length; i++) {
            indice.add(i);
        }

        giaLetta = new boolean[libro.length];
        Arrays.fill(giaLetta, false);
    }

    public synchronized ArrayList<Integer> getIndice() {
        return indice;
    }
    
    public synchronized boolean leggi(int numeroStringaDaLeggere) {
        if(giaLetta[numeroStringaDaLeggere]) {
            return false;
        }
        else {
            giaLetta[numeroStringaDaLeggere] = true;
            indice.remove((Integer) numeroStringaDaLeggere);
            return true;
        }
    }

    public synchronized String riceviStringa(int numeroStringaDaLeggere) {
        return libro[numeroStringaDaLeggere];
    }

    public int getSize() {
        return libro.length;
    }

}
