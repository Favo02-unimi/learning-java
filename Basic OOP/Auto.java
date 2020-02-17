

class Auto extends Veicolo {

  private int porte;

  public int getPorte() {
    return porte;
  }

  Auto(String marca, String modello) {
    super(marca, modello);
  }

  Auto(String marca, String modello, int anno) {
    super(marca, modello, anno);
  }

  Auto(String marca, String modello, int anno, int porte) {
    super(marca, modello, anno);
    this.porte = porte;
  }

  public String toString() {
    String s = super.toString();
    if (porte != 0){
      s += "Porte: " + porte;
    }
    return s;
  }


}