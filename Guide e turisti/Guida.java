import java.util.ArrayList;

public class Guida extends Utente{

	private ArrayList<Valutazione> valutazioni;
	private ArrayList<Prenotazione> prenotazioni;

	public Guida(String email, String password) {
		super(email, password);
	}

	public void addValutazione(Valutazione valutazione) {
		if(valutazioni == null){
			valutazioni = new ArrayList<>();
		}
		valutazioni.add(valutazione);
	}

	public void addPrenotazione(Prenotazione prenotazione){
		if(prenotazioni == null){
			prenotazioni = new ArrayList<>();
		}
		prenotazioni.add(prenotazione);
	}

	public boolean isDisponibile(Data data){
		if (prenotazioni == null){
			return true;
		}
		for (int i = 0; i < prenotazioni.size(); i++) {
			if (prenotazioni.get(i).getData().equals(data)){
				return false;
			}
		}
		return true;
	}

	public String toStringCompatto(){
		if(getNome() != null && getCognome() != null){
			return getNome() + " " + getCognome();
		}
		return getEmail();
	}

	public String toStringValutazioni(){
		if (valutazioni == null){
			return "Nessuna valutazione";
		}
		String out = "Valutazioni ricevute: \n";
		for (int i = 0; i < valutazioni.size(); i++) {
			out += "--N°" + i+1 + "--\n";
			out += valutazioni.get(i).toString() +"\n";
		}
		return out;
	}

	public String toStringPrenotazioni(){
		if (prenotazioni == null){
			return "Nessuna prenotazione";
		}
		String out = "Prenotazioni ricevute: \n";
		for (int i = 0; i < prenotazioni.size(); i++) {
			out += "--N°" + i+1 + "--\n";
			out += prenotazioni.get(i).toString() +"\n";
		}
		return out;
	}

}
