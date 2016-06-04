package br.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.library.domain.profile.Client;
import br.library.infra.persistence.setup.BDExeption;

public class ClientDAOBd extends AbstractDao<Client> implements ClientDAO {

	@Override
	public void save(Client client) {
		int id = 0;
		try {
			String sql = "INSERT INTO client (name1,registration,phone)"
					+ "VALUES (?,?,?)";
			conectUsingId(sql);
			comand.setString(1, client.getName());
			comand.setLong(2, client.getRegistration());
			comand.setString(3, client.getPhone());
			comand.executeUpdate();
			ResultSet result = comand.getGeneratedKeys();
			if (result.next()) {
				id = result.getInt(1);
				client.setId(id);
			} else {
				System.err.println("Erro de Sistema - Não foi possivel gerar o id comforme o esperado");
				throw new BDExeption("Não gerou o id conforme o esperado");
			}
		} catch (SQLException e) {
			System.err.println("Erro de Sistema - Problema ao Salvar Cliente");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}

	}

	@Override
	public void delete(Client client) {
		try {
			String sql = "DELETE FROM client WHERE id = ?";

			conect(sql);
			comand.setInt(1, client.getId());
			comand.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro de Sistema - Problema ao deletar Cliente");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}

	}

	@Override
	public void update(Client client) {
		try {
			String sql = "UPDATE client SET name1=?, registration=?, phone=?"
					+ "WHERE id=?";
			conect(sql);
			comand.setString(1, client.getName());
			comand.setLong(2, client.getRegistration());
			comand.setString(3, client.getPhone());		
			comand.setInt(4, client.getId());
			comand.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Erro de Systema - Problema ao atualizar Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

	}

	@Override
	public List<Client> list() {
		List<Client> listOfClients = new ArrayList<>();
		String sql = "SELECT * FROM client";
		try {
			conect(sql);

			ResultSet result = comand.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name1");
				int registration = result.getInt("registration");
				String phone = result.getString("phone");

				Client client = new Client(id, name, registration, phone);
				listOfClients.add(client);
			}
		} catch (SQLException e) {
			System.err.println("Erro de Sistema - Problema ao bsucar os Clientes ");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (listOfClients);
	}

	@Override
	public Client searchByID(int id) {
		String sql = "SELECT * FROM client WHERE id = ?";
		try {
			conect(sql);
			comand.setInt(1, id);
			ResultSet result = comand.executeQuery();
			if (result.next()) {
				String name = result.getString("name1");
				int registration = result.getInt("registration");
				String phone = result.getString("phone");

				Client client = new Client(name, registration, phone);
				return client;
			}
		} catch (SQLException e) {
			System.err.println("Erro de Sistema - Problema ao buscar o Cliente pelo ID");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (null);
	}

	@Override
	public Client searchByRegistration(int registration) {
		String sql = "SELECT * FROM client WHERE registration = ?";
		try {
			conect(sql);
			comand.setInt(1, registration);
			ResultSet result = comand.executeQuery();
			if (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name1");
				int registration1 = result.getInt("registration");
				String phone = result.getString("phone");

				Client client = new Client(id, name, registration1, phone);
				return client;
			}
		} catch (SQLException e) {
			System.err.println("Erro de Sistema  - Problema ao buscar livro pelo ISBC");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (null);
	}

	@Override
	public List<Client> searchByName(String name) {
		List<Client> listOfclients = new ArrayList<>();
		String sql = "SELECT * FROM client WHERE name1 LIKE ?";
		try {

			conect(sql);

			comand.setString(1, "%" + name + "%");

			ResultSet result = comand.executeQuery();

			while (result.next()) {

				int id = result.getInt("id");

				String nameZ = result.getString("name1");

				int registration = result.getInt("registration");

				String phone = result.getString("phone");

				Client client = new Client(id, nameZ, registration, phone);
				listOfclients.add(client);
			}

		} catch (SQLException e) {
			System.err.println("Erro de Sistema - Problema ao buscar Cliente pelo nome ");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (listOfclients);
	}

}
