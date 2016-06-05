package br.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.library.dao.interf.DevolutionDAO;
import br.library.dao.interf.RentDAO;
import br.library.domain.profile.Devolution;
import br.library.domain.profile.Rent;

public class DevolutionDaoBd extends AbstractDao<Devolution> implements DevolutionDAO {

	@Override
	public void insert(Devolution devolution, boolean late) {
		int id;
		try {
			String sql = "INSERT INTO devolution (id_rent, id_client, id_book, devolutionDate) " + "VALUES (?,?,?,?)";

			conectUsingId(sql);
			comand.setInt(1, devolution.getRent().getId());
			comand.setInt(2, devolution.getRent().getClient().getId());
			comand.setInt(3, devolution.getRent().getBooksRent().getId());

			java.sql.Date dataSql = new java.sql.Date(devolution.getDevolutionDate().getTime());
			comand.setDate(4, dataSql);
			comand.executeUpdate();

			ResultSet result = comand.getGeneratedKeys();
			if (result.next()) {
				// seta o id para o objeto
				id = result.getInt(1);
				devolution.setId(id);
			}
			updateClient(devolution);
			updateBook(devolution);
			if (late == true) {
				ClientUpdateDelay(devolution);
			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao Inserir nova devolução");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

	}

	@Override
	public void updateClient(Devolution devolution) {
		try {
			String sql = "UPDATE client SET rentBooks=(rentBooks-1) " + "WHERE id=(?)";

			conect(sql);
			comand.setInt(1, devolution.getRent().getClient().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao atualizar  cliente na devolução");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void ClientUpdateDelay(Devolution devolucao) {
		try {
			String sql = "UPDATE client SET late=(late+1) " + "WHERE id=(?)";

			conect(sql);
			comand.setInt(1, devolucao.getRent().getClient().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao atualizar atraso no cliente durante a devolução");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void updateBook(Devolution devolution) {
		try {
			String sql = "UPDATE book SET avaliable=true WHERE id=(?)";
			conect(sql);
			comand.setInt(1, devolution.getRent().getBooksRent().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao trocar disponibilidade do livro na devolução");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public List<Devolution> list() {
		List<Devolution> devolutionList = new ArrayList<>();
		String sql = "SELECT * FROM devolution ORDER BY id";
		try {
			conect(sql);
			ResultSet result = comand.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int idRent = result.getInt("idRent");
				// Trabalhando com data: lembrando dataSql -> dataUtil
				java.sql.Date dataSql = result.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				RentDAO rentDao = new RentDaoBd();
				Rent rent = rentDao.searchById(idRent);
				Devolution devolution = new Devolution(id, rent, dataUtil);
				devolutionList.add(devolution);
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao listar devoluções");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
		return (devolutionList);
	}

	@Override
	public Devolution searchByID(int id) {
		String sql = "SELECT * FROM devolution WHERE id = ?";

		try {
			conect(sql);
			comand.setInt(1, id);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int idX = result.getInt("id");
				int idRent = result.getInt("idRent");
				// Trabalhando com data: lembrando dataSql -> dataUtil
				java.sql.Date dataSql = result.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				RentDAO rentDao = new RentDaoBd();
				Rent rent = rentDao.searchById(idRent);
				Devolution devolution = new Devolution(idX, rent, dataUtil);
				return devolution;
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema buscar devolução pelo ID");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (null);
	}

	@Override
	public void save(Devolution dominio) {

	}

	@Override
	public void delete(Devolution paciente) {

	}

	@Override
	public void update(Devolution paciente) {

	}

	@Override
	public Devolution searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
