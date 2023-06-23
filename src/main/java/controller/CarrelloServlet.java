package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 4855603885789516953L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("Utente");
		ArrayList<Prodotto> cartList = new ArrayList<Prodotto>();
		ArrayList<Integer> qList = new ArrayList<Integer>();
		int quantitaProd = Integer.valueOf(request.getParameter("quantita"));
		
		if (u != null) {
			ArrayList<Prodotto> carrelloList = (ArrayList<Prodotto>) session.getAttribute("cart-list");
			ArrayList<Integer> quantitaList = (ArrayList<Integer>) session.getAttribute("quantitaArticoli");
			Prodotto p = (Prodotto) session.getAttribute("prod");
			int id = p.getIdProdotto();
			if (carrelloList == null && quantitaList == null) {
				cartList.add(p);
				qList.add(quantitaProd);
				session.setAttribute("cart-list", cartList);
				session.setAttribute("quantitaArticoli", qList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
				dispatcher.forward(request, response);
			} else {
				cartList = carrelloList;
				qList = quantitaList;
				boolean exist = false;
				for (int i = 0; i < carrelloList.size(); i++) {
					if ((carrelloList.get(i).getIdProdotto() == id) && quantitaProd > 0) {
						exist = true;
						int qval = qList.get(i);
						qval += quantitaProd;
						qList.set(i, qval);
					}
				}
				if (!exist && request.getParameter("quantita") != null) {
					cartList.add(p);
					qList.add(quantitaProd);
					RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
					dispatcher.forward(request, response);
				}
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
		//inizializzazione prodotto carrello
		Ordine ordine = new Ordine();
		ordine.setEmailCliente(u.getEmail());
		
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
	}
}
