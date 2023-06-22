package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.Util;

import model.Prodotto;
import model.ProdottoDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6139539336375381489L;
	ProdottoDAO prodottoDAO = new ProdottoDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.removeAttribute("primoPiano");
			request.removeAttribute("bestPanini");
			request.removeAttribute("bestBevande");
			
			Prodotto primoPiano = prodottoDAO.doRetrieveByName("Il Crusco");
			
			Collection<Prodotto> bestPanini = prodottoDAO.doRetrievePanini();
			prodottoDAO.doSelectionSort(bestPanini);
			
			Collection<Prodotto> bestBevande = prodottoDAO.doRetrieveBevande();
			prodottoDAO.doSelectionSort(bestBevande);
			
			request.setAttribute("primoPiano", primoPiano);
			request.setAttribute("bestPanini", bestPanini);
			request.setAttribute("bestBevande", bestBevande);
			
		} catch (SQLException e) {
			request.setAttribute("error", e.getMessage());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
