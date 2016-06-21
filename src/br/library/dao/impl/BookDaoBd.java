package br.library.dao.impl;

/**
 * @author Pedro
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.library.dao.interf.BookDAO;
import br.library.domain.profile.Book;

public class BookDaoBd extends AbstractDao<Book> implements BookDAO {
	@Override
	public void insert(Book book) {
		int cod;
		try {
			String sql = "INSERT INTO book (isbn, name1, publishingCompany, writer, year, avaliable, totalRentQuantity) "
					+ "VALUES (?,?,?,?,?,?,?)";

			conectUsingId(sql);
			comand.setLong(1, book.getIsbn());
			comand.setString(2, book.getName());
			comand.setString(3, book.getPublishingCompany());
			comand.setString(4, book.getWriter());
			comand.setString(5, book.getYear());
			comand.setBoolean(6, book.isAvaliable());
			comand.setInt(7, book.getTotalRentQuantity());
			comand.executeUpdate();

			ResultSet result = comand.getGeneratedKeys();
			if (result.next()) {

				cod = result.getInt(1);
				book.setId(cod);
			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao Inserir novo Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

	}

	@Override
	public void delete(Book book) {
		try {
			String sql = "DELETE FROM book WHERE id = ?";

			conect(sql);
			comand.setInt(1, book.getId());
			comand.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao deletar cadastro de livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

	}

	@Override
	public void edit(Book l, String newX, String colum) {
		String sql = "UPDATE book SET " + colum + "=(?) WHERE id=(?)";
		try {
			conect(sql);
			comand.setString(1, newX);
			comand.setInt(2, l.getId());
			comand.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public void edit(Book l, long newX, String colum) {
		String sql = "UPDATE book SET " + colum + "=(?) WHERE id=(?)";
		try {
			conect(sql);
			comand.setLong(1, newX);
			comand.setInt(2, l.getId());
			comand.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public List<Book> list() {
		List<Book> listOfBooks = new ArrayList<>();

		String sql = "SELECT * FROM book ORDER BY name1";

		try {
			conect(sql);

			ResultSet result = comand.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				long isbn = result.getLong("isbn");
				String name = result.getString("name1");
				String publishingCompany = result.getString("publishingCompany");
				String writer = result.getString("writer");
				String year = result.getString("year");
				Boolean avaliable = result.getBoolean("avaliable");
				int totalRentQuantity = result.getInt("totalRentQuantity");

				Book book = new Book(id, isbn, name, publishingCompany, writer, year, avaliable, totalRentQuantity);

				listOfBooks.add(book);

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
		return (listOfBooks);
	}

	@Override
	public Book searchByIsbn(long isbn) {
		String sql = "SELECT * FROM book WHERE isbn = ?";

		try {
			conect(sql);
			comand.setLong(1, isbn);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");
				long isbnX = result.getLong("isbn");
				String name = result.getString("name1");
				String publishingCompany = result.getString("publishingCompany");
				String writer = result.getString("writer");
				String year = result.getString("year");
				Boolean avaliable = result.getBoolean("avaliable");
				int totalRentQuantity = result.getInt("totalRentQuantity");

				Book book = new Book(id, isbnX, name, publishingCompany, writer, year, avaliable, totalRentQuantity);

				return book;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (null);
	}

	@Override
	public Book searchByID(int id) {
		String sql = "SELECT * FROM book WHERE id = ?";

		try {
			conect(sql);
			comand.setInt(1, id);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int idX = result.getInt("id");
				long isbnX = result.getLong("isbn");
				String name = result.getString("name1");
				String publishingCompany = result.getString("publishingCompany");
				String writer = result.getString("writer");
				String year = result.getString("year");
				Boolean avaliable = result.getBoolean("avaliable");
				int totalRentQuantity = result.getInt("totalRentQuantity");

				Book book = new Book(idX, isbnX, name, publishingCompany, writer, year, avaliable, totalRentQuantity);

				return book;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (null);
	}

	@Override
	public Book searchByName(String name) {
		String sql = "SELECT * FROM book WHERE name1 = ?";

		try {
			conect(sql);
			comand.setString(1, name);

			ResultSet result = comand.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");
				long isbn = result.getLong("isbn");
				String nameX = result.getString("name1");
				String publishingCompany = result.getString("publishingCompany");
				String writer = result.getString("writer");
				String year = result.getString("year");
				Boolean avaliable = result.getBoolean("avaliable");
				int totalRentQuantity = result.getInt("totalRentQuantity");

				Book book = new Book(id, isbn, nameX, publishingCompany, writer, year, avaliable, totalRentQuantity);

				return book;

			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (null);
	}

	@Override
	public List<Book> listByName(String name) {
		List<Book> listOfBooks = new ArrayList<>();
		String sql = "SELECT * FROM book WHERE name LIKE ?";

		try {
			conect(sql);
			comand.setString(1, "%" + name + "%");
			ResultSet result = comand.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				long isbn = result.getLong("isbn");
				String nameX = result.getString("name1");
				String publishingCompany = result.getString("publishingCompany");
				String writer = result.getString("writer");
				String year = result.getString("year");
				Boolean avaliable = result.getBoolean("avaliable");
				int totalRentQuantity = result.getInt("totalRentQuantity");

				Book book = new Book(id, isbn, nameX, publishingCompany, writer, year, avaliable, totalRentQuantity);

				listOfBooks.add(book);
			}

		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

		return (listOfBooks);
	}

	@Override
	public void save(Book dominio) {

	}

	@Override
	public void editBook(Book book, int id) {
		String sql = "UPDATE book SET isbn=(?), name1=(?), publishingCompany=(?), writer=(?), year=(?) WHERE id=(?)";
		try {
			conect(sql);
			comand.setLong(1, book.getIsbn());
			comand.setString(2, book.getName());
			comand.setString(3, book.getPublishingCompany());
			comand.setString(4, book.getWriter());
			comand.setString(5, book.getYear());
			comand.setInt(6, id);
			comand.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Erro de Sistema - Problema ao editar  cadastro de Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}
	}

	@Override
	public Book searchById(int id) {

		return null;
	}

	@Override
	public void update(Book paciente) {
		// TODO Auto-generated method stub

	}
}
