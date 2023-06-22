package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973213L;
	UtenteDAO utenteDAO = new UtenteDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String via = request.getParameter("via");
		String citta = request.getParameter("citta");
		String CAP = request.getParameter("CAP");
		String provincia = request.getParameter("provincia");
		
		Utente u = new Utente();
		
		u.setEmail(email);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setPassword(password);
		u.setVia(via);
		u.setCitta(citta);
		u.setProvincia(provincia);
		u.setAmministratore(false);
		
		if(UtenteDAO.controlloEmail(request.getParameter("email"))) {
			request.setAttribute("controllo", "Email già presente");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrazione.jsp");
			dispatcher.forward(request, response);
		}
		
		if(!(utenteDAO.checkFormatUtente(u, CAP))) {
			request.getSession().setAttribute("error", "Sono presenti errori nel form.");
			System.out.println("Errore nel form");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/jsp/registrazione.jsp"));
			dispatcher.forward(request, response);
			return;
		}
		
		u.setCAP(Integer.parseInt(CAP));
		
		UtenteDAO.doRegistrazione(u);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	} 

}
