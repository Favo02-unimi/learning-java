public class Main {
    public static void main(String[] args) {
        Cinema monitor = new Cinema(20);
        Server server = new Server(monitor);
        server.start();
    }
}
