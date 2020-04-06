import java.util.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("------\n" +
				"Per testare al meglio, dato che non c'è alcun database di guide e turisti dietro" +
				" è preferibile creare un profilo come guida e uno come turista e poi iniziare a " +
				"testare le funzionalità." +
				"\nAl turista serve almeno una guida e viceversa, altrimenti si ricevono solo " +
				"messaggi di mancanza di personale.\n" +
				"------");

		ArrayList<Guida> guide = new ArrayList<>();
		ArrayList<Turista> turisti = new ArrayList<>();

		int loggato = 0, index = -1;

		while (true){
			if (loggato == 0) {
				int[] temp = nonLoggato(guide, turisti);
				loggato = temp[0];
				index = temp[1];
			}
			//guida
			if (loggato == 1){
				Guida guidaLoggata = guide.get(index);
				loggato = loggatoGuida(loggato, guidaLoggata);
			}
			//turista
			else {
				Turista turistaLoggato = turisti.get(index);
				loggato = loggatoTurista(loggato, guide, turistaLoggato);
			}
		}
	}

	private static int[] nonLoggato(ArrayList<Guida> guide, ArrayList<Turista> turisti){
		Scanner in = new Scanner(System.in);
		String email, psw;
		int indiceUtente = -1;
		int loggato = 0; // 0 non loggato, 1 guida, 2 turista
		while (loggato == 0){
			System.err.println("Non sei loggato, " +
					"se vuoi effettuare il login digita [L], " +
					"se vuoi registrarti digita [R]");
			switch (in.next().toUpperCase()){
				case ("L"):
					System.out.println("Inserire email");
					email = in.next();
					indiceUtente = -1;
					boolean guida = false;
					for (int i = 0; i < guide.size(); i++) {
						if(guide.get(i).getEmail().equalsIgnoreCase(email)){
							indiceUtente = i;
							guida = true;
							break;
						}
					}
					for (int i = 0; i < turisti.size() && !guida; i++) {
						if(turisti.get(i).getEmail().equalsIgnoreCase(email)){
							indiceUtente = i;
							break;
						}
					}
					if (indiceUtente == -1){
						System.out.println("Email non registrata, riprova.");
						continue;
					}
					System.out.println("Inserire password");
					psw = in.next();
					if (guida){
						if (guide.get(indiceUtente).getPassword().equals(psw)) {
							loggato = 1;
							if (guide.get(indiceUtente).getNome() != null) {
								System.out.println("Benvenuto " + guide.get(indiceUtente).getNome());
							} else {
								System.out.println("Benvenuto " + guide.get(indiceUtente).getEmail());
							}
						}
						else {
							System.out.println("Password errata, riprova.");
							loggato = 0;
							continue;
						}
					}
					else{
						if (turisti.get(indiceUtente).getPassword().equals(psw)){
							loggato = 2;
							if (turisti.get(indiceUtente).getNome() != null) {
								System.out.println("Benvenuto " + turisti.get(indiceUtente).getNome());
							} else {
								System.out.println("Benvenuto " + turisti.get(indiceUtente).getEmail());
							}
						}
						else {
							System.out.println("Password errata, riprova.");
							loggato = 0;
							continue;
						}
					}
					break;
				case ("R"):
					System.out.print("Inserire email: ");
					email = in.next();
					System.out.print("Inserire password: ");
					psw = in.next();
					System.out.println("Vuoi registrarti come guida [G] o come turista [T]?");
					switch (in.next().toUpperCase()){
						case ("G"):
							guide.add(new Guida(email, psw));
							break;
						case ("T"):
							turisti.add(new Turista(email, psw));
							break;
						default:
							System.out.println("Errore, riprova");
					}
			}

		}
		return new int[]{loggato, indiceUtente};
	}

	private static int loggatoGuida(int loggato, Guida guidaLoggata){
		Scanner in = new Scanner(System.in);
		while (loggato == 1) {
			menuGuida();
			menuStandard();
			switch (in.next().toUpperCase()) {
				case ("REC"):
					System.out.println(guidaLoggata.toStringValutazioni());
					break;
				case ("PRE"):
					System.out.println(guidaLoggata.toStringPrenotazioni());
					break;
				case ("PRO"):
					System.out.println(guidaLoggata);
					break;
				case ("PSW"):
					String oldPsw = input("Inserire vecchia password: ");
					if (!oldPsw.equals(guidaLoggata.getPassword())) {
						System.out.println("Vecchia password errata, riprova");
						continue;
					}
					String psw1 = input("Inserire nuova password: ");
					String psw2 = input("Reinserire nuova password: ");
					if (!psw1.equals(psw2)) {
						System.out.println("La password non corrisponde, riprova");
						continue;
					}
					guidaLoggata.cambiaPassword(psw1);
					break;
				case ("MOD"):
					String nome = input("Inserire nome: ");
					String cognome = input("Inserire cognome: ");
					guidaLoggata.modificaProfilo(nome, cognome);
					break;
				case ("OUT"):
					loggato = 0;
					break;
				default:
					System.out.println("Codice non riconosciuto, riprovare");
			}
		}
		return loggato;
	}

	private static int loggatoTurista(int loggato, ArrayList<Guida> guide, Turista turistaLoggato){
		Scanner in = new Scanner(System.in);
		while (loggato == 2) {
			menuTurista();
			menuStandard();
			switch (in.next().toUpperCase()) {
				case ("PRE"):
					int anno = inputInt("Inserire anno in cui si vuole prenotare: ");
					int mese = inputInt("Inserire mese in cui si vuole prenotare [1-12]: ");
					int giorno = inputInt("Inserire giorno in cui si vuole prenotare: ");
					int ora = inputInt("Inserire ora: ");
					int minuto = inputInt("Inserire minuto: ");
					Data data = new Data(giorno, mese, anno, new Orario(ora, minuto));
					int guideDisponibili = guideDisponibili(data, guide);
					if(guideDisponibili>0) {
						int guidaPrenotata = inputInt("Quale guida si vuole prenotare (numero)? ");
						Prenotazione prenotazione = new Prenotazione(data, guide.get(guidaPrenotata - 1), turistaLoggato, guidaPrenotata - 1);
						guide.get(guidaPrenotata - 1).addPrenotazione(prenotazione);
						turistaLoggato.addPrenotazione(prenotazione);
						System.out.println("Prenotazione effettuata con successo.");
					}
					else {
						System.out.println("Non ci sono guide disponibili, cambiare data.");
					}
					break;
				case ("VISPRE"):
					System.out.println(turistaLoggato.toStringPrenotazioni());
					break;
				case ("VAL"):
					System.out.println(turistaLoggato.toStringPrenotazioni());
					int prenotazioneDaValutare = inputInt("Quale prenotazione si vuole valutare? ");
					int voto = inputInt("Inserire voto: ");
					String comm = inputPhrase("Inserire commento (opzionale): ");
					Valutazione valutazione;
					int indiceGuidaValutata = turistaLoggato.getPrenotazioni().get(prenotazioneDaValutare-1).getCodiceGuida();
					if(comm != null){
						valutazione = new Valutazione(voto, comm, guide.get(indiceGuidaValutata), turistaLoggato);
					}
					else {
						valutazione = new Valutazione(voto, guide.get(indiceGuidaValutata), turistaLoggato);
					}
					turistaLoggato.addValutazione(valutazione);
					guide.get(indiceGuidaValutata).addValutazione(valutazione);
					break;
				case ("VISVAL"):
					System.out.println(turistaLoggato.toStringValutazioni());
					break;
				case ("PRO"):
					System.out.println(turistaLoggato);
					break;
				case ("PSW"):
					String oldPsw = input("Inserire vecchia password: ");
					if (!oldPsw.equals(turistaLoggato.getPassword())) {
						System.out.println("Vecchia password errata, riprova");
						continue;
					}
					String psw1 = input("Inserire nuova password: ");
					String psw2 = input("Reinserire nuova password: ");
					if (!psw1.equals(psw2)) {
						System.out.println("La password non corrisponde, riprova");
						continue;
					}
					turistaLoggato.cambiaPassword(psw1);
					break;
				case ("MOD"):
					String nome = input("Inserire nome: ");
					String cognome = input("Inserire cognome: ");
					turistaLoggato.modificaProfilo(nome, cognome);
					break;
				case ("OUT"):
					loggato = 0;
					break;
				default:
					System.out.println("Codice non riconosciuto, riprovare");
			}
		}
		return loggato;
	}

	private static void menuGuida(){
		pause();
		System.err.println(
				"--MENU GUIDA--\n" +
				"Visualizzare recensioni ricevute [REC]\n" +
				"Visualizzare prenotazioni ricevute [PRE]");
	}

	private static void menuTurista(){
		pause();
		System.err.println(
				"--MENU TURISTA--\n" +
				"Prenota una guida [PRE]\n" +
				"Visualizza prenotazioni [VISPRE]\n" +
				"Rilasciare valutazione [VAL]\n" +
				"Visualizza valutazioni effettuate [VISVAL]");

	}

	private static void menuStandard(){
		pause();
		System.err.println(
				"--OPZIONI PROFILO--\n" +
				"Visualizza profilo [PRO]\n" +
				"Cambiare password [PSW]\n" +
				"Aggiornare profilo [MOD]\n" +
				"Logout [OUT]");
	}

	private static int guideDisponibili(Data data, ArrayList<Guida> guide){
		pause();
		int index = 0;
		String out = "Guide disponibili per " + data.toString();
		for (int i = 0; i < guide.size(); i++) {
			if (guide.get(i).isDisponibile(data)){
				index++;
				out += "\n--Guida n° " + index + "\n" + guide.get(i).toStringCompatto();
			}
		}
		System.out.println(out);
		return index;
	}

	private static void pause(){
		try {
			Thread.sleep(50);
		}catch (Exception ignore){}
	}

	private static int inputInt(String arg) {
		Scanner in = new Scanner(System.in);
		System.out.print(arg);
		while(!in.hasNextInt()){
			String temp = in.next();
			System.err.println(temp + " non può essere corretto.");
		}
		return in.nextInt();
	}

	private static String input(String arg) {
		Scanner in = new Scanner(System.in);
		System.out.print(arg);
		return in.next();
	}

	private static String inputPhrase(String arg) {
		Scanner in = new Scanner(System.in);
		System.out.print(arg);
		return in.next();
	}
	
}