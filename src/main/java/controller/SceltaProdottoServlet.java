package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prodotto;
import model.ProdottoDAO;


@WebServlet("/SceltaProdotto")
public class SceltaProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 4184749930573678131L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeProdotto = request.getParameter("search");
		Prodotto p = null;
		HttpSession session = request.getSession();
			ProdottoDAO prodottoDAO = new ProdottoDAO();
			String address;
			try {
				p = prodottoDAO.doRetrieveByName(nomeProdotto);
				session.setAttribute("prod", p);
				address = "/WEB-INF/jsp/product.jsp";
				request.setAttribute("prodotto", p);
				RequestDispatcher ds = request.getRequestDispatcher(address);
	            ds.forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
