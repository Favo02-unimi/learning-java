class Garage {

  private Veicolo[] veicoli;

  public void addVeicolo(Veicolo veicolo) {
    for (int i = 0; i < veicoli.length; i++) {
      if (veicoli[i] == null) {
        veicoli[i] = veicolo;
        return;
      }
    }
    System.err.print("Il garage è pieno");
  }

  public void removeVeicolo(int i) {
    if (veicoli[i] != null) {
      veicoli[i] = null;
      return;
    }
    System.err.print("Il posto da svuotare è vuoto");
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < veicoli.length; i++) {
      s += "\n\n" + i + ":\n";
      s += veicoli[i].toString();
    }
    return s;
  }

  Garage(int lenght){
    veicoli = new Veicolo[lenght];
  }

}