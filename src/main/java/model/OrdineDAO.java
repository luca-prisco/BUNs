package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdineDAO {

	public void doSaveOrder(Ordine ordine) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		Prodotto p = new Prodotto();
		
		String sql = "INSERT INTO Ordine (IDOrdine, stato, dataOrdine, numeroCarta, intestatarioCarta, dataScadenzaCarta, indirizzo, emailCliente, emailAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setInt(1, ordine.getIDOrdine());
		ps.setString(2, ordine.getStato());
		ps.setString(3, ordine.getDataOrdine().toString());
		ps.setString(4, ordine.getNumeroCarta());
		ps.setString(5, ordine.getIntestatarioCarta());
		ps.setString(6, ordine.getDataScadenzaCarta());
		ps.setString(7, ordine.getIndirizzo());
		ps.setString(8, ordine.getEmailCliente());
		ps.setString(9, ordine.getEmailAdmin());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();

		String sql2 = "INSERT INTO prodotto_ordine (IDProdotto, IDOrdine, nome, descrizione, prezzoUnitario, quantita, tipologia, categoria) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement psProdOrd = con.prepareStatement(sql2);

		psProdOrd.executeBatch();
	}
}
