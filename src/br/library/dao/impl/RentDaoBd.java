package br.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.library.dao.interf.BookDAO;
import br.library.dao.interf.ClientDAO;
import br.library.dao.interf.RentDAO;
import br.library.domain.profile.Book;
import br.library.domain.profile.Client;
import br.library.domain.profile.Rent;

public class RentDaoBd extends AbstractDao<Rent> implements RentDAO {
	@Override
	public void save(Rent rent) {
		int id;
		try {
			String sql = "INSERT INTO rent (rentDate, id_client, id_book,avaliable) " + "VALUES (?,?,?,?)";

			conectUsingId(sql);

			java.sql.Date dataSql = new java.sql.Date(rent.getRentData().getTime());
			comand.setDate(1, dataSql);
			comand.setInt(2, rent.getClient().getId());
			comand.setInt(3, rent.getBooksRent().getId());
			comand.setBoolean(4, rent.isAvaliable());
			comand.executeUpdate();

			ResultSet result = comand.getGeneratedKeys();
			if (result.next()) {
				id = result.getInt(1);
				rent.setId(id);
			}
			updateClient(rent);
			updateBook(rent);
			updateQuntityOfBooks(rent);
			updateQuantityOfRentBooksByClient(rent);

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao Inserir novo aluguel");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void updateClient(Rent rent) {
		try {
			String sql = "UPDATE client SET rentBooks=(rentBooks+1) " + "WHERE id=?";

			conect(sql);
			comand.setInt(1, rent.getClient().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao atualizar Cliente no aluguel");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void updateBook(Rent rent) {
		try {
			String sql = "UPDATE book SET avaliable=false " + "WHERE id=?";
			conect(sql);
			comand.setInt(1, rent.getBooksRent().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao atualizar Livro no aluguel");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void updateQuntityOfBooks(Rent rent) {
		try {
			String sql = "UPDATE book SET totalRentQuantity=(totalRentQuantity+1) " + "WHERE id=?";
			conect(sql);
			comand.setInt(1, rent.getBooksRent().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao  atualizar quantidade do Livro no aluguel");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void updateQuantityOfRentBooksByClient(Rent rent) {
		try {
			String sql = "UPDATE client SET quantityOfRentBooks=(quantityOfRentBooks+1) " + "WHERE id=?";
			conect(sql);
			comand.setInt(1, rent.getClient().getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println(
					"Erro de Sistema - Problema ao  atualizar quantidade de livros alugados pelo cliente no aluguel");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public List<Rent> list() {
		List<Rent> rentList = new ArrayList<>();
		String sql = "SELECT * FROM rent ORDER BY id";
		try {
			conect(sql);
			ResultSet result = comand.executeQuery();
			while (result.next()) {
				int idRent = result.getInt("id");
				java.sql.Date dataSql = result.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idClient = result.getInt("id_client");
				int idBook = result.getInt("id_book");
				boolean status = result.getBoolean("avaliable");
				ClientDAO clientDao = new ClientDAOBd();
				BookDAO bookDao = new BookDaoBd();
				Client client1 = clientDao.searchById(idClient);
				Book book = bookDao.searchByIsbn(idBook);

				Rent rent = new Rent(idRent, dataUtil, client1, book, status);
				rentList.add(rent);
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao  listar os alugueis ativos");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
		return (rentList);
	}

	@Override
	public Rent searchById(int id) {
		String sql = "SELECT * FROM rent WHERE id=?";

		try {
			conect(sql);
			comand.setLong(1, id);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int idRent = result.getInt("id");
				java.sql.Date dataSql = result.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idClient = result.getInt("id_client");
				int idBook = result.getInt("id_book");
				boolean status = result.getBoolean("avaliable");
				ClientDAO clientDao = new ClientDAOBd();
				BookDAO bookDao = new BookDaoBd();
				Client client = clientDao.searchById(idClient);
				Book book = bookDao.searchByID(idBook);

				Rent rent = new Rent(idRent, dataUtil, client, book, status);
				return rent;
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao buscar alugueis pelo id ");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (null);
	}

	@Override
	public void delete(Rent rent) {
		try {
			String sql = "DELETE FROM rent WHERE id = ?";

			conect(sql);
			comand.setInt(1, rent.getId());
			comand.executeQuery();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao deletar cadastro de venda");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void updateRentStatus(Rent rent) {
		try {
			String sql = "UPDATE rent SET avaliable=false " + "WHERE id=?";
			conect(sql);
			comand.setInt(1, rent.getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao  atualizar quantidade do Livro no aluguel");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public Rent searchByID(int id) {
		return null;
	}

	@Override
	public void update(Rent paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Rent> listAllAvaliableRents() {
		List<Rent> avaliableRentList = new ArrayList<>();
		String sql = "SELECT * FROM rent WHERE avaliable=true";
		try {
			conect(sql);
			ResultSet result = comand.executeQuery();
			while (result.next()) {
				int idRent = result.getInt("id");
				java.sql.Date dataSql = result.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idClient = result.getInt("id_client");
				int idBook = result.getInt("id_book");
				boolean status = result.getBoolean("avaliable");
				ClientDAO clientDao = new ClientDAOBd();
				BookDAO bookDao = new BookDaoBd();
				Client client1 = clientDao.searchById(idClient);
				Book book = bookDao.searchByID(idBook);

				Rent rent = new Rent(idRent, dataUtil, client1, book, status);
				avaliableRentList.add(rent);
			}
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao  listar os alugueis ativos");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
		return (avaliableRentList);
	}

}
