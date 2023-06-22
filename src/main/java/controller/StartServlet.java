package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import model.Prodotto;
import model.ProdottoDAO;

import java.util.LinkedList;

/**
 * Servlet implementation class startServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String azione = request.getParameter("action");
		
		try {
			if(azione.equals("login")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("filtro", azione);
			ProdottoDAO prodottoDAO = new ProdottoDAO();
			Collection<Prodotto> prodottiFiltrati = new LinkedList<Prodotto>();
			prodottiFiltrati = prodottoDAO.doRetrieveByCategoria(azione);
			request.setAttribute(azione, prodottiFiltrati);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/catalogo.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
