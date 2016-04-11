package tracking2u.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tracking2u.jdbc.ConnectionFactory;
import tracking2u.modelo.Contato;
import tracking2u.modelo.financeiro;

public class gastoDao {
	private Connection connection;

public gastoDao(){
	connection = new ConnectionFactory().getConnection();
}


	public void insere(financeiro financa) {
		String sql = "INSERT INTO financas (lucro,gastos,receita) VALUES (?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.print("hello");
			stmt.setString(1, financa.getLucro());
			stmt.setString(2, financa.getGasto());
			stmt.setString(3, financa.getReceita());

			System.out.print("olá");
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				financa.setId((long) rs.getInt(1));
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}}
