package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	protected Connection con = null;
	
	public ConexionBD() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/America", "postgres",
					"postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
