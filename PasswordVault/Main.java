import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Vault vault = new Vault();

        Scanner in = new Scanner(System.in);
        while (true) {
            int i;
            System.out.println("Cosa fare? [NEW/GET/DELETE/STAMPA]");
            switch (in.next().toUpperCase()){
                case ("NEW"):
                    System.out.println("Inserire uno alla volta url, nome e psw");
                    String url = in.next();
                    String nome = in.next();
                    String psw = in.next();
                    vault.createLogin(new Login(url, nome, psw));
                    break;
                case ("GET"):
                    System.out.println("Quale login vedere?");
                    i = in.nextInt();
                    System.out.println(vault.getLogin(i));
                    break;
                case ("DELETE"):
                    System.out.println("Quale login cancellare?");
                    i = in.nextInt();
                    vault.removeLogin(i);
                    break;
                case ("STAMPA"):
                    System.out.println(vault.toString());
                    break;
            }
        }
    }
}
