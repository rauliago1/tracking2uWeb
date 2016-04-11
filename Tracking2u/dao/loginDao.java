package tracking2u.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tracking2u.jdbc.ConnectionFactory;
import tracking2u.modelo.Contato;

public class loginDao {
	private Connection connection;

public loginDao(){
	connection = new ConnectionFactory().getConnection();
}

public Contato buscaPorUsuario(Contato contato) {


	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?");
		stmt.setLong(1, contato.getId());

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			 populaAluno(rs);
			 return populaAluno(rs);

		}

		rs.close();
		stmt.close();

		return null;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}


private Contato populaAluno(ResultSet rs) throws SQLException {
	Contato aluno = new Contato();

	//popula o objeto tarefa
	aluno.setNivel(rs.getString("nivel"));
	aluno.setSenha(rs.getString("senha"));

	return aluno;
}
}





