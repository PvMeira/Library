package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ConexaoDAO {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DBURL = "jdbc:postgresql://LOCALHOST:5432/library";
	private static final String USER = "postgres";
	private static final String SENHA = "123456";
	private static Connection conn = null;

	String connectionUrl = "jdbc:postgresql://localhost:5432;"
			+ "databaseName=AdventureWorks;user=UserName;password=*****";

	// inicio da conex�o com banco
	public static Connection createConnection() {

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DBURL, USER, SENHA);
			System.out.println("Conex�o OK!");

		} catch (ClassNotFoundException ex) {
			System.out.println("Problemas no Driver de Conex�o");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public void Close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
} // fim da classe
