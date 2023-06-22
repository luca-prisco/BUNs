package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 * Servlet implementation class DatiPagamentoServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("Utente");
		ArrayList<Prodotto> cartList = new ArrayList<Prodotto>();
		ArrayList<Integer> qList = new ArrayList<Integer>();
		
		if(u == null) {
			response.sendRedirect("/WEB-INF/jsp/login.jsp");
		}
		
		cartList = (ArrayList<Prodotto>) session.getAttribute("cart-list");
		qList = (ArrayList<Integer>) session.getAttribute("quantitaArticoli");
		String numeroCarta = request.getParameter("numeroCarta");
		String intestatarioCarta = request.getParameter("intestatario");
		String dataScadenzaCarta = request.getParameter("dataScadenza");
		
		
		Ordine ordine = new Ordine();
		ordine.setEmailCliente(u.getEmail());
		ordine.setIndirizzo(u.getVia()+u.getCitta()+u.getProvincia()+u.getCAP());
		
		ArrayList<ProdottoOrdine> prodottiOrdine = new ArrayList<ProdottoOrdine>();
		int i=0;
		for(Prodotto prodotto : cartList) {
			ProdottoOrdine prodOrdine = new ProdottoOrdine();
			
			prodOrdine.setIDProdotto(prodotto.getIdProdotto());
			prodOrdine.setNome(prodotto.getNome());
			prodOrdine.setDescrizione(prodotto.getDescrizione());
			prodOrdine.setCategoria(prodotto.getCategoria());
			prodOrdine.setPrezzoUnitario(prodotto.getPrezzo());
			prodOrdine.setTipologia(prodotto.getTipologia());
			prodOrdine.setQuantita(qList.get(i));
			
			prodottiOrdine.add(prodOrdine);
			i++;
		}
		
		ordine.setProdotti(prodottiOrdine);
		
		LocalDate dataOrdine = LocalDate.now();
		
		ordine.setDataOrdine(dataOrdine);
		ordine.setNumeroCarta(numeroCarta);
		ordine.setIntestatarioCarta(intestatarioCarta);
		ordine.setDataScadenzaCarta(dataScadenzaCarta);
		ordine.setStato("In preparazione");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
