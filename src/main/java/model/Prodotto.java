package model;

public class Prodotto {
	private int idProdotto;
	private String nome; 
	private String descrizione;
	private Double prezzo;
	private int disponibilita;
	private int numVendite;
	private String dettagli;
	private String tipologia;
	private String categoria;
	
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public void setNumVendite(int numVendite) {
		this.numVendite = numVendite;
	}
	public int getNumVendite() {
		return numVendite;
	}
	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}
	public String getDettagli() {
		return dettagli;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} 
	public String getCategoria() {
		return categoria;
	}
}
