
public abstract class Utente {
	private String nome;
	private String cognome;
	private String email;
	private String password;

	public Utente(String email, String password) {
		this.email=email;
		this.password=password;
	}

	public void cambiaPassword(String newPsw) {
		this.password = newPsw;
		System.out.println("Password cambiata con successo");
	}

	public void modificaProfilo(String nome, String cognome){
		this.nome=nome;
		this.cognome=cognome;
		System.out.println("Profilo aggiornato");
	}
	
	public String toString() {
		String out = "Nome: " + nome + "\n"
						+ "Cognome: " + cognome + "\n"
						+ "Email: " + email + "\n"
						+ "Password: " + password + "\n";
		return out;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
}
