public class Lampadario{
	public static void main(String[] args){
		Lampadina lampa = new Lampadina("marcaaaa", 1000);
		System.out.println(lampa);
		lampa.accendi();
		System.out.println(lampa);
		lampa.spegni();
		System.out.println(lampa);
		Lampadina lampa2 = new Lampadina("marcaa", 1000);
		System.out.println(lampa.equals(lampa2));
		StrisciaLed striscia = new StrisciaLed("awp", 100, 300);
		System.out.println(striscia);
	}
}

class Lampadina {
	private String marca;
	private int potenza;
	private boolean accesa;

	public Lampadina(String marca, int potenza){
		this.marca = marca;
		this.potenza = potenza;
	}

	public String getMarca(){
		return marca;
	}
	public int getPotenza() {
		return potenza;
	}
	public boolean isAccesa() {
		return accesa;
	}

	public void accendi() {
		accesa = true;
	}
	public void spegni() {
		accesa = false;
	}

	public String toString(){
		String out = "Marca: " +marca;
		out += "\nPotenza: " + potenza + " W";
		out += "\nLa lampadina è " + (accesa ? "accesa" : "spenta");
		return out;
	}

	public boolean equals(Lampadina lampa){
		if(!(this.marca.equals(lampa.marca))){ return false; }
		if(!(this.potenza==lampa.potenza)){ return false; }
		return true;
	}
}

class StrisciaLed extends Lampadina {
	private int lunghezza;

	public StrisciaLed(String marca, int potenza, int lunghezza){
		super(marca, potenza);
		this.lunghezza = lunghezza;
	}

	public int getLunghezza(){ return lunghezza; }

	public String toString(){
		String out = "";
		out += "\nLunghezza: " + lunghezza + " cm";
		out += super.toString();
		return out;
	}

	public boolean equals(StrisciaLed striscia){
		if(!(super.equals(striscia))){ return false;}
		if(!(this.lunghezza==striscia.lunghezza)){ return false; }
		return true;
	}
}