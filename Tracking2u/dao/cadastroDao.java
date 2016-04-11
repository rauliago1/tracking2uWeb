package tracking2u.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import tracking2u.jdbc.ConnectionFactory;
import tracking2u.modelo.Contato;

public class cadastroDao {
	private Connection connection;

public cadastroDao(){
	connection = new ConnectionFactory().getConnection();
}


	public void insere(Contato contato) {
		String sql = "INSERT INTO contatos (nome, email, endereco, celular,usuario, senha, nivel) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setString(4, contato.getCelular());
			stmt.setString(5, contato.getUsuario());
			stmt.setString(6, contato.getSenha());
			stmt.setString(7, contato.getNivel());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				contato.setId((long) rs.getInt(1));
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}


	public void remove(Contato contato) {
		String sql = "DELETE FROM alunos WHERE id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, contato.getId());

			stmt.execute();

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}


}
