package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 102631973239L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res;
		HttpSession session = request.getSession();
		Utente u = UtenteDAO.doLogin(request.getParameter("email"), request.getParameter("password"));
		
		if(request.getParameter("action")==null) {
			if(u==null) {
				res = "Email o password errati.";
				request.setAttribute("result", res);
				RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
				rs.include(request, response);
			} else if (u != null && !u.isAmministratore()) {
				session.setAttribute("Utente", u);
				RequestDispatcher ds = request.getRequestDispatcher("HomeServlet");
				ds.forward(request, response);
			} else if (u != null && u.isAmministratore()) {
				session.setAttribute("Amministratore", u);
				RequestDispatcher ds = request.getRequestDispatcher("HomeServletAdmin");
				ds.forward(request, response);
			}
		}
		
		if(request.getParameter("action").equals("logout")) {
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
			dispatcher.forward(request, response);
		}
	}

}
