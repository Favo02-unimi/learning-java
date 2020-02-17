class Moto extends Veicolo {

  private int tempi;

  public int getTempi() {
    return tempi;
  }

  Moto(String marca, String modello) {
    super(marca, modello);
  }

  Moto(String marca, String modello, int anno) {
    super(marca, modello, anno);
  }

  Moto(String marca, String modello, int anno, int tempi) {
    super(marca, modello, anno);
    this.tempi = tempi;
  }

  public String toString() {
    String s = super.toString();
    if (tempi != 0){
      s += "Tempi: " + tempi;
    }
    return s;
  }

}