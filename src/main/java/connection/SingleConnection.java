package connection;

import java.sql.Connection;
import java.sql.DriverManager;

//Conexão com o Banco de Dados
public class SingleConnection {
	
	private static String banco = "jdbc:mysql://localhost/usuario?useTimezone=true&serverTimezone=America/Sao_Paulo";
	private static String password = "mysql";
	private static String user = "root";
	private static Connection connection = null;
	
	static {
		
		conectar();
		
	}
	
	public SingleConnection() {
		
		conectar();
		
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e){
			
			throw new RuntimeException("Erro de conexão com o banco de dados");
			
		}
				
	}
	
	public static Connection getConnection() {
		
		return connection;
		
	}


}
