package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDao<T> implements dao<T> {
	protected Connection conexao;
	protected PreparedStatement comando;

	public Connection conectar(String sql) throws SQLException {
		conexao = ConexaoDAO.createConnection();
		comando = conexao.prepareStatement(sql);
		return conexao;
	}

	public void conectarObtendoId(String sql) throws SQLException {
		conexao = ConexaoDAO.createConnection();
		comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	}

	public void fecharConexao() {
		try {
			if (comando != null) {
				comando.close();
			}
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Erro ao encerrar a conexao");
			throw new BDExeption(ex);

		}

	}
}
