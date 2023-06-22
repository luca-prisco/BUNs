package model;

public class Utente {
	private String email;
	private String nome;
	private String cognome;
	private String password;
	private String via;
	private String citta;
	private int CAP;
	private String provincia;
	private boolean amministratore;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getCAP() {
		return CAP;
	}

	public void setCAP(int CAP) {
		this.CAP = CAP;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public boolean isAmministratore() {
		return amministratore;
	}
	
	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}
	public boolean getAmministratore() {
		return amministratore;
	}
}
