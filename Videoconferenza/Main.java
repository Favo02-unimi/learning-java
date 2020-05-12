import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Quanti partecipanti?");
        int partecipanti = in.nextInt();
        Server server = new Server(new Videoconferenza(partecipanti));
        server.start();
    }
}
