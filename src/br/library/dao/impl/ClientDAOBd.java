package br.library.dao.impl;
/**
 * @author Pedro
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.library.dao.interf.ClientDAO;
import br.library.domain.profile.Client;

public class ClientDAOBd extends AbstractDao<Client> implements ClientDAO {

	@Override
	public void insert(Client client) {
		int id;
		try {
			String sql = "INSERT INTO client (name, cpf, phone, register, rentBooks, quantityOfRentBooks, late) "
					+ "VALUES (?,?,?,?,?,?,?)";

			conectUsingId(sql);
			comand.setString(1, client.getName());
			comand.setLong(2, client.getCpf());
			comand.setString(3, client.getPhone());
			comand.setLong(4, client.getRegister());
			comand.setInt(5, client.getBooksRent());
			comand.setInt(6, client.getQuantityOfBooksRent());
			comand.setInt(7, client.getLate());
			comand.executeUpdate();

			ResultSet resultado = comand.getGeneratedKeys();
			if (resultado.next()) {
				id = resultado.getInt(1);
				client.setId(id);
			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao Inserir novo Cliente");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void delete(Client client) {
		try {
			String sql = "DELETE FROM client WHERE cpf = ?";

			conect(sql);
			comand.setLong(1, client.getCpf());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao deletar Cliente");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

	}

	@Override
	public void update(Client c, String newX, String colum) {
		String sql = "UPDATE client SET " + colum + "=(?) WHERE id=(?)";
		try {
			conect(sql);
			comand.setString(1, newX);
			comand.setInt(2, c.getId());
			comand.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao atualizar novo Cliente");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void update(Client c, long newX, String colum) {
		String sql = "UPDATE client SET " + colum + "=(?) WHERE id=(?)";
		try {
			conect(sql);
			comand.setLong(1, newX);
			comand.setInt(2, c.getId());
			comand.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao atualizar novo Cliente");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}
	}

	@Override
	public List<Client> list() {
		List<Client> listOfClients = new ArrayList<>();

		String sql = "SELECT * FROM client ORDER BY name";

		try {
			conect(sql);

			ResultSet result = comand.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				long cpf = result.getLong("cpf");
				String phone = result.getString("phone");
				long register = result.getLong("register");
				int rentBooks = result.getInt("rentBooks");
				int quantityOfRentBooks = result.getInt("quantityOfRentBooks");
				int late = result.getInt("late");

				Client cli = new Client(id, name, cpf, phone, register, rentBooks, quantityOfRentBooks, late);

				listOfClients.add(cli);

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao listar  Cliente");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}

		return (listOfClients);
	}

	@Override
	public Client searchById(int id) {
		String sql = "SELECT * FROM client WHERE id = ?";

		try {
			conect(sql);
			comand.setInt(1, id);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				String name = result.getString("name");
				long cpf = result.getLong("cpf");
				String phone = result.getString("phone");
				long register = result.getLong("register");
				int rentBooks = result.getInt("rentBooks");
				int quantityOfRentBooks = result.getInt("quantityOfRentBooks");
				int late = result.getInt("late");

				Client cli = new Client(id, name, cpf, phone, register, rentBooks, quantityOfRentBooks, late);

				return cli;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao buscar  Cliente pelo id");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}

		return (null);
	}

	@Override
	public Client searchByCpf(long rg) {
		String sql = "SELECT * FROM client WHERE cpf = ?";

		try {
			conect(sql);
			comand.setLong(1, rg);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				long cpf = result.getLong("cpf");
				String phone = result.getString("phone");
				long register = result.getLong("register");
				int rentBooks = result.getInt("rentBooks");
				int quantityOfRentBooks = result.getInt("quantityOfRentBooks");
				int late = result.getInt("late");

				Client cli = new Client(id, name, cpf, phone, register, rentBooks, quantityOfRentBooks, late);

				return cli;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao buscar Cliente pelo cpf");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}

		return (null);
	}

	@Override
	public Client searchByName(String name) {
		String sql = "SELECT * FROM client WHERE name = ?";

		try {
			conect(sql);
			comand.setString(1, name);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");
				String nameX = result.getString("name");
				long cpf = result.getLong("cpf");
				String phone = result.getString("phone");
				long register = result.getLong("register");
				int rentBooks = result.getInt("rentBooks");
				int quantityOfRentBooks = result.getInt("quantityOfRentBooks");
				int late = result.getInt("late");

				Client cli = new Client(id, nameX, cpf, phone, register, rentBooks, quantityOfRentBooks, late);

				return cli;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao buscar  Cliente pelo nome");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}

		return (null);
	}

	@Override
	public Client searchByRegister(long register) {
		String sql = "SELECT * FROM client WHERE register = ?";

		try {
			conect(sql);
			comand.setLong(1, register);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				long cpf = result.getLong("cpf");
				String phone = result.getString("phone");
				long registerX = result.getLong("register");
				int rentBooks = result.getInt("rentBooks");
				int quantityOfRentBooks = result.getInt("quantityOfRentBooks");
				int late = result.getInt("late");

				Client cli = new Client(id, name, cpf, phone, registerX, rentBooks, quantityOfRentBooks, late);

				return cli;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao buscar  Cliente pelo codigo de registtro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}

		return (null);
	}

	@Override
	public List<Client> listByName(String nome) {
		List<Client> listOfClients = new ArrayList<>();
		String sql = "SELECT * FROM client WHERE name LIKE ?";

		try {
			conect(sql);
			comand.setString(1, "%" + nome + "%");
			ResultSet result = comand.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				long cpf = result.getLong("cpf");
				String phone = result.getString("phone");
				long registerX = result.getLong("register");
				int rentBooks = result.getInt("rentBooks");
				int quantityOfRentBooks = result.getInt("quantityOfRentBooks");
				int late = result.getInt("late");

				Client cli = new Client(id, name, cpf, phone, registerX, rentBooks, quantityOfRentBooks, late);

				listOfClients.add(cli);

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao buscar  listar clientes pelo nome");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
			;
		}

		return (listOfClients);
	}

	@Override
	public void save(Client dominio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Client paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client searchByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
