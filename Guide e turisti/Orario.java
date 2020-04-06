public class Orario {
    private int ora, minuto;

    public Orario(int ora, int minuto){
        this.ora = ora;
        this.minuto = minuto;
    }

    public String toString() {
        return ora + ":" + minuto;
    }
    
    public boolean equals(Orario orario){
        return (orario.ora == this.ora && orario.minuto == this.minuto);
    }
}
