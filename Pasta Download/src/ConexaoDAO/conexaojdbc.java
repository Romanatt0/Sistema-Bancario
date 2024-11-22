package ConexaoDAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaojdbc {
	
	public static Connection conexaobd() {
		
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/banco?user=root&password=romanatto123";
		conn = DriverManager.getConnection(url);
		
				
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, Erro.getMessage());
		}
		return conn;
	
		}
	
}
  