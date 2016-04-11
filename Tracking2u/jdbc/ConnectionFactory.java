package tracking2u.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		System.out.println("Conectando ao banco de dados.");
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/resta", "admin", "admin");
		} catch (Exception e) {
			System.out.println("ERRO!");
			throw new RuntimeException(e);
		}
	}
}
