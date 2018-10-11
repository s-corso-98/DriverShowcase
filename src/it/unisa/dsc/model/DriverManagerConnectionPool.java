package it.unisa.dsc.model;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


public class DriverManagerConnectionPool {
	private static List<Connection> freeDbConnections;
	
	//creazione lista e ottenimento driver jdbc
	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
	
	
	//creazione connessione db 
	private static synchronized Connection createDBConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/dbdrivershowcase?autoReconnect=true&useSSL=false";
		String username = "root"; String pwd = "0000" ;
		con = DriverManager.getConnection(url,username,pwd);
		return con;
	}

	public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}

	
	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}

}
