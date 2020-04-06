public class PostoAuto {

    private int numeroPosto;
    private boolean isOccupato;
    private String tipo;
    private Affitto affitto;

    public PostoAuto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
        isOccupato = false;
    }

    public boolean isOccupato() {
        return isOccupato;
    }

    public void changeOccupato() {
        isOccupato = !isOccupato;
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSiglaTipo() {
        if (tipo == null){
            return "-";
        }
        return tipo.substring(0,1);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Affitto getAffitto() {
        return affitto;
    }

    public void setAffitto(boolean isMensile, String password) {
        Affitto affitto;
        if (isMensile){
            affitto = new AffittoMensile(password);
        }
        else {
            affitto = new AffittoAdOre();
        }
        this.affitto = affitto;
    }

}
