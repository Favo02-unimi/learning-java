
class Veicolo {

  private String marca, modello;
  private int anno, valore;

  Veicolo(String marca, String modello) {
    this.marca = marca;
    this.modello = modello;
  }

  Veicolo(String marca, String modello, int anno) {
    this.marca = marca;
    this.modello = modello;
    this.anno = anno;
  }

  public String toString() {
    String s = "" +
            "Marca: " + marca +
            "\nModello: " + modello;
    if(anno != 0){
      s += "\nAnno: " + anno;
    }
    return s;
  }

  public String getMarca() {
    return marca;
  }

  public String getModello() {
    return modello;
  }

  public int getAnno() {
    return anno;
  }

  public int getValore() {
    return valore;
  }

  public void setValore(int valore) {
    this.valore = valore;
  }

  public boolean equals (Veicolo veicolo){
    if(!(this.marca.equalsIgnoreCase(veicolo.getMarca()))){
      return false;
    }
    if(!(this.modello.equalsIgnoreCase(veicolo.getModello()))){
      return false;
    }
    return true;
  }

  public Veicolo clone(){
    return new Veicolo(marca, modello);
  }

}