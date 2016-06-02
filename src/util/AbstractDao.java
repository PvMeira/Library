package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import repository.dao;

public abstract class AbstractDao<T> implements dao<T> {
	protected Connection conection;
	protected PreparedStatement comand;

	public Connection conect(String sql) throws SQLException {
		conection = ConexaoDAO.createConnection();
		comand = conection.prepareStatement(sql);
		return conection;
	}

	public void conectUsingId(String sql) throws SQLException {
		conection = ConexaoDAO.createConnection();
		comand = conection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	}

	public void closeConection() {
		try {
			if (comand != null) {
				comand.close();
			}
			if (conection != null) {
				conection.close();
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Erro ao encerrar a conexao");
			throw new BDExeption(ex);

		}

	}
}
