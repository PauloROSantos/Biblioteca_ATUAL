package br.com.biblioteca.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	String status="";
	
	public static Connection getConnection(){
		
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao abrir a conexão em CoonectionFactory");
		}
	}

}
