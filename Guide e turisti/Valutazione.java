public class Valutazione {

	private Guida guida;
	private Turista turista;
	private int rating;
	private String commento;

	public Valutazione(int rating, Guida guida, Turista turista) {
		this.guida = guida;
		this.turista = turista;
		this.rating=rating;
	}

	public Valutazione(int rating, String commento, Guida guida, Turista turista) {
		this.guida = guida;
		this.turista = turista;
		this.rating=rating;
		this.commento=commento;
	}
	
	public String toString() {
		String out = "Guida valutata: " + guida.toStringCompatto() +
				"\nTurista valutante: " + turista.toStringCompatto() +
				"\nValutazione: " + rating;
		if (commento != null){
			return out += "\nCommento: " + commento;
		}
		return out;
	}
}
