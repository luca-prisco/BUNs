package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ordine {
	private ArrayList<ProdottoOrdine> prodotti;
	private int IDOrdine;
	private String emailCliente;
	private String emailAdmin;
	private String stato;
	private LocalDate dataOrdine;
	private Double prezzoTotale; //derivato
	private String numeroCarta;
	private String intestatarioCarta;
	private String dataScadenzaCarta;
	private String indirizzo;
	
	public ArrayList<ProdottoOrdine> getProdotti() {
		return prodotti;
	}
	public void setProdotti(ArrayList<ProdottoOrdine> prodotti) {
		this.prodotti = prodotti;
	}
	public int getIDOrdine() {
		return IDOrdine;
	}
	public void setIDOrdine(int iDOrdine) {
		IDOrdine = iDOrdine;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public LocalDate getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(LocalDate dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public Double getPrezzoTotale() {
		return prezzoTotale;
	}
	public void setPrezzoTotale(Double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public String getIntestatarioCarta() {
		return intestatarioCarta;
	}
	public void setIntestatarioCarta(String intestatarioCarta) {
		this.intestatarioCarta = intestatarioCarta;
	}
	public String getDataScadenzaCarta() {
		return dataScadenzaCarta;
	}
	public void setDataScadenzaCarta(String dataScadenzaCarta) {
		this.dataScadenzaCarta = dataScadenzaCarta;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	
	
}
