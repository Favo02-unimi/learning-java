public class Main {
    public static void main(String[] args) {
        Server server = new Server(new Libro());

        //stringa da leggere in input
        server.startInput();

        //stringa da leggere random
        //server.startRandom();
    }
}
