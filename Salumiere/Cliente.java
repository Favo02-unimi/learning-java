public class Cliente implements Runnable {

    private Salumeria salumeria;
    private ListaDellaSpesa lista;
    private int ticket;

    public Cliente(Salumeria salumeria, int ticket) {
        this.salumeria = salumeria;
        this.ticket = ticket;
        lista = new ListaDellaSpesa();
    }

    public void run() {
        Salumiere salumiereCheServe = salumeria.richiediTurno(ticket);
        System.err.println("Cliente " + ticket + ": mi serve il salumiere " + salumiereCheServe.getID());
        System.err.println("Cliente " + ticket + ": è il mio turno: " + ticket);
        salumiereCheServe.setOccupato();
        salumiereCheServe.riceviListaSpesa(lista);
        System.err.println("Cliente " + ticket + ": ho finito, me ne vado.");
        salumiereCheServe.setLibero();
        salumiereCheServe.aumentaTurno();
    }

}