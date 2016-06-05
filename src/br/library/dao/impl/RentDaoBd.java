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
			String sql = "INSERT INTO rent (rentDate, id_client, id_book) " + "VALUES (?,?,?)";

			conectUsingId(sql);

			java.sql.Date dataSql = new java.sql.Date(rent.getRentData().getTime());
			comand.setDate(1, dataSql);
			comand.setInt(2, rent.getClient().getId());
			comand.setInt(3, rent.getBooksRent().getId());
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
			String sql = "UPDATE book SET avaliable=false " + "WHERE cod=?";
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
			String sql = "UPDATE book SET totalRentQuantity=(totalRentQuantity+1) " + "WHERE cod=?";
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
			ResultSet resultado = comand.executeQuery();
			while (resultado.next()) {
				int idAluguel = resultado.getInt("id_rent");
				// Trabalhando com data: lembrando dataSql -> dataUtil
				java.sql.Date dataSql = resultado.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int id = resultado.getInt("id_client");
				int code = resultado.getInt("id_book");
				ClientDAO clientDao = new ClientDAOBd();
				BookDAO bookDao = new BookDaoBd();
				Client client1 = clientDao.searchById(id);
				Book book = bookDao.searchByIsbn(code);

				Rent aluguel = new Rent(idAluguel, dataUtil, client1, book);
				rentList.add(aluguel);
			}
		} catch (SQLException ex) {
			System.err.println(
					"Erro de Sistema - Problema ao  listar os alugueis ativos");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
		return (rentList);
	}

	@Override
	public Rent searchById(int id) {
		String sql = "SELECT * FROM rent WHERE id_rent = ?";

		try {
			conect(sql);
			comand.setLong(1, id);

			ResultSet resultado = comand.executeQuery();

			if (resultado.next()) {
				int idAluguel = resultado.getInt("id");
				// Trabalhando com data: lembrando dataSql -> dataUtil
				java.sql.Date dataSql = resultado.getDate("rentDate");
				java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idX = resultado.getInt("id_client");
				int code = resultado.getInt("id_book");
				ClientDAO clientDao = new ClientDAOBd();
				BookDAO bookDao = new BookDaoBd();
				Client client1 = clientDao.searchById(idX);
				Book book = bookDao.searchByIsbn(code);

				Rent aluguel = new Rent(idAluguel, dataUtil, client1, book);
				return aluguel;
			}
		} catch (SQLException ex) {
			System.err.println(
					"Erro de Sistema - Problema ao buscar alugueis pelo id ");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (null);
	}

	@Override
	public void delete(Rent paciente) {
	}

	@Override
	public void update(Rent paciente) {
	}

	@Override
	public Rent searchByID(int id) {
		return null;
	}

}
