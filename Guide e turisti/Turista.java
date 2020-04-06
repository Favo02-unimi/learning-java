import java.util.ArrayList;

public class Turista extends Utente{
	
	private ArrayList<Prenotazione> prenotazioni;
	private ArrayList<Valutazione> valutazioni;

	public Turista(String email, String password) {
		super(email, password);
	}
	
	public void addPrenotazione(Prenotazione prenotazione){
		if(prenotazioni == null){
			prenotazioni = new ArrayList<>();
		}
		prenotazioni.add(prenotazione);
	}

	public void addValutazione(Valutazione valutazione){
		if(valutazioni == null){
			valutazioni = new ArrayList<>();
		}
		valutazioni.add(valutazione);
	}

	public String toStringCompatto(){
		if(getNome() != null && getCognome() != null){
			return getNome() + " " + getCognome();
		}
		return getEmail();
	}

	public String toStringPrenotazioni(){
		if (prenotazioni == null){
			return "Nessuna prenotazione";
		}
		String out = "Prenotazioni effettuate: \n";
		for (int i = 0; i < prenotazioni.size(); i++) {
			out += "--N°" + i+1 + "--\n";
			out += prenotazioni.get(i).toString() +"\n";
		}
		return out;
	}

	public String toStringValutazioni(){
		if (valutazioni == null){
			return "Nessuna valutazione";
		}
		String out = "Valutazioni effettuate: \n";
		for (int i = 0; i < valutazioni.size(); i++) {
			out += "--N°" + i+1 + "--\n";
			out += valutazioni.get(i).toString() +"\n";
		}
		return out;
	}

	public ArrayList<Prenotazione> getPrenotazioni(){
		return prenotazioni;
	}

}
