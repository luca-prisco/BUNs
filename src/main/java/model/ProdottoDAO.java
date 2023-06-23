package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "ProdottoDAO", value = "/ProdottoDAO")
public class ProdottoDAO extends HttpServlet {

	private static final long serialVersionUID = 6922812561599756878L;

	public Prodotto doRetrieveByName(String nome) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		Prodotto p = new Prodotto();
		
		String sql = "SELECT * FROM prodotto WHERE nome LIKE ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, '%' + nome + '%');
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				p.setIdProdotto(rs.getInt("IDProdotto"));
				p.setNome(rs.getString("nome"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setPrezzo(rs.getDouble("prezzo"));
				p.setDisponibilita(rs.getInt("disponibilita"));
				p.setDettagli(rs.getString("dettagli"));
				p.setNumVendite(rs.getInt("numVendite"));
				p.setTipologia(rs.getString("tipologia"));
				p.setCategoria(rs.getString("categoria"));
			}
			return p;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Collection<Prodotto> doRetrievePanini() throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		String tipologia = "Panino";
		
		String sql = "SELECT * FROM prodotto WHERE tipologia=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tipologia);
			
			Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
			
			ResultSet rs = ps.executeQuery();
	
			while (rs.next()) {
				Prodotto p = new Prodotto();
				p.setIdProdotto(rs.getInt("IDProdotto"));
				p.setNome(rs.getString("nome"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setPrezzo(rs.getDouble("prezzo"));
				p.setDisponibilita(rs.getInt("disponibilita"));
				p.setDettagli(rs.getString("dettagli"));
				p.setNumVendite(rs.getInt("numVendite"));
				p.setTipologia(rs.getString("tipologia"));
				p.setCategoria(rs.getString("categoria"));
	
				prodotti.add(p);
			}
			return prodotti;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Prodotto> doRetrieveBevande() throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		String tipologia = "Bevanda";
		
		String sql = "SELECT * FROM prodotto WHERE tipologia=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tipologia);
			
			Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
			
			ResultSet rs = ps.executeQuery();
	
			while (rs.next()) {
				Prodotto p = new Prodotto();
				p.setIdProdotto(rs.getInt("IDProdotto"));
				p.setNome(rs.getString("nome"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setPrezzo(rs.getDouble("prezzo"));
				p.setDisponibilita(rs.getInt("disponibilita"));
				p.setDettagli(rs.getString("dettagli"));
				p.setNumVendite(rs.getInt("numVendite"));
				p.setTipologia(rs.getString("tipologia"));
				p.setCategoria(rs.getString("categoria"));
	
				prodotti.add(p);
			}
			return prodotti;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Prodotto> doRetrieveByCategoria(String azione) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		String sql = "SELECT * FROM prodotto WHERE categoria=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, azione);
			
			Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Prodotto p = new Prodotto();
				p.setIdProdotto(rs.getInt("IDProdotto"));
				p.setNome(rs.getString("nome"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setPrezzo(rs.getDouble("prezzo"));
				p.setDisponibilita(rs.getInt("disponibilita"));
				p.setDettagli(rs.getString("dettagli"));
				p.setNumVendite(rs.getInt("numVendite"));
				p.setTipologia(rs.getString("tipologia"));
				p.setCategoria(rs.getString("categoria"));
	
				prodotti.add(p);
			}
			return prodotti;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

    public void doSelectionSort(Collection<Prodotto> bestPanini) {
        for (int i = 0; i < 3; i++) {
            // find position of smallest num between (i + 1)th element and last element
            int pos = i;
            for (int j = i; j < bestPanini.size(); j++) {
            	Prodotto p1 = ((LinkedList<Prodotto>) bestPanini).get(j);
            	Prodotto p2 = ((LinkedList<Prodotto>) bestPanini).get(pos);
                if (p1.getNumVendite() > p2.getNumVendite())
                    pos = j;
            }
            // Swap min (smallest num) to current position on array
            Prodotto min = ((LinkedList<Prodotto>) bestPanini).get(pos);
            ((LinkedList<Prodotto>) bestPanini).set(pos, ((LinkedList<Prodotto>) bestPanini).get(i));
            ((LinkedList<Prodotto>) bestPanini).set(i, min);
        }
    }

	public Prodotto doRetrieveByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}