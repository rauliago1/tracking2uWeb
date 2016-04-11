package tracking2u.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tracking2u.jdbc.ConnectionFactory;
import tracking2u.modelo.Pedidos;



public class pedidoDao {
	private Connection connection;

	public pedidoDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public void envia(Pedidos pedido) {
		String sql = "INSERT INTO pedidos (tarefa1, tarefa2, tarefa3, listadetarefa) VALUES (?,?,?,?)";

		try {
			System.out.println("estive aq");
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, pedido.getTarefa1());
			stmt.setString(2, pedido.getTarefa2());
			stmt.setString(3, pedido.getTarefa3());
			stmt.setString(4, pedido.getListadetarefa());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				pedido.setId((long) rs.getInt(1));
			}



			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

	public void finaliza(Long id) {
		if (id == null) {
			throw new IllegalStateException("Id deve ser nulo.");
		}

		String sql = "update tarefa set listadetarefa = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setLong(2, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public int atividade(){


		try{
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX(ID) FROM tarefa.");

			ResultSet rs = stmt.executeQuery();

			rs.next();

		int posição=rs.getInt("id");
		System.out.print("olá"+ posição);
		return posição;



	}catch (SQLException e) {
		throw new RuntimeException(e);

	}

	}


}
