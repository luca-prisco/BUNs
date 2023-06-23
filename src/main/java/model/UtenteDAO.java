package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "UtenteDAO", value = "/UtenteDAO")
public class UtenteDAO extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void doRegistrazione(Utente utente) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO Utente (email, nome, cognome, password, via, citta, CAP, provincia, amministratore) VALUES (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, utente.getEmail());
			ps.setString(2, utente.getNome());
			ps.setString(3, utente.getCognome());
			ps.setString(4, utente.getPassword());
			ps.setString(5, utente.getVia());
			ps.setString(6, utente.getCitta());
			ps.setLong(7, utente.getCAP());
			ps.setString(8, utente.getProvincia());
			ps.setBoolean(9, utente.getAmministratore());
			
			if(ps.executeUpdate() != 1)
				throw new RuntimeException("Errore registrazione utente");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean controlloEmail(String email) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("SELECT email FROM Utente WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
	public boolean checkFormatUtente(Utente utente, String CAP) {

		if (!((utente.getEmail() != null) && (utente.getEmail().trim().length() > 0) 
				&& (utente.getEmail().matches("^\\S+@\\S+\\.\\S+$"))))
			return false;
		if (!((utente.getNome() != null) && (utente.getNome().trim().length() > 0)
				&& (utente.getNome().matches("^[A-Za-z]+${1,15}$")))) 
			return false;
		if (!((utente.getCognome() != null) && (utente.getCognome().trim().length() > 0) 
				&& (utente.getCognome().matches("^([A-Za-z\\s]+){1,15}$")))) 
			return false;
		if (!((utente.getPassword() != null) && (utente.getPassword().trim().length() > 0) && (utente.getPassword().matches("^[a-zA-Z0-9!@?]*$")))) 
			return false;
		if (!((utente.getVia() != null) && (utente.getVia().trim().length() > 3)
				&& (utente.getVia().matches("^([A-Za-z0-9\\s]+){3,30}$")))) 
			return false;
		if (!((utente.getCitta() != null) && (utente.getCitta().trim().length() > 1)
				&& (utente.getCitta().matches("^[A-Za-zìòàèéù' ']*$")))) 
			return false;
		if (!((CAP != null) && (CAP.trim().length() > 0)
				&& (CAP.matches("^(\\d{5})+$")))) 
			return false;
		
		return true;
	}
	
	public static Utente doLogin(String email, String password) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		Utente utente = new Utente();
		try {
			ps = con.prepareStatement("SELECT * FROM Utente WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				utente.setEmail(rs.getString(1));
				utente.setNome(rs.getString(2));
				utente.setCognome(rs.getString(3));
				utente.setPassword(rs.getString(4));
				utente.setVia(rs.getString(5));
				utente.setCitta(rs.getString(6));
				utente.setCAP(rs.getInt(7));
				utente.setProvincia(rs.getString(8));
				utente.setAmministratore(rs.getBoolean(9));
				return utente;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}