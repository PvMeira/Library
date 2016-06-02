package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import profile.Book;
import util.AbstractDao;
import util.BDExeption;

public class BookDaoBd extends AbstractDao<Book> implements BookDAO {

	@Override
	public void save(Book book) {
		int id = 0;
		try {
			String sql = "INSERT INTO book (name,ISBC,writer,publishingCompany,releaseyear,avaliable)"
					+ "VALUES (?,?,?,?,?,?)";
			conectUsingId(sql);
			comand.setString(1, book.getBookName());
			comand.setLong(2, book.getIsbnCode());
			comand.setString(3, book.getWriters());
			comand.setString(4, book.getPublishingCompany());
			comand.setLong(5, book.getReleaseyear());
			comand.setBoolean(6, true);
			comand.executeUpdate();
			ResultSet result = comand.getGeneratedKeys();
			if (result.next()) {
				id = result.getInt(1);
				book.setId(id);
			} else {
				System.err.println("Erro de Sistema - N�o foi possivel gerar o id comforme o esperado");
				throw new BDExeption("N�o gerou o id conforme o esperado");
			}
		} catch (Exception e) {
			System.err.println("Erro de Sistema - Problema ao Salvar Livro");
			throw new RuntimeException(e);
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
		} catch (Exception e) {
			System.err.println("Erro de Sistema - Problema ao deletar Livro");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}

	}

	@Override
	public void update(Book book) {
		try {
			String sql = "UPDATE book SET name=?, ISBC=?, writer=?, publishingCompany=?, releasyear=?, avaliable=?"
					+ "WHERE id=?";
			conect(sql);
			comand.setString(1, book.getBookName());
			comand.setLong(2, book.getIsbnCode());
			comand.setString(3, book.getWriters());
			comand.setString(4, book.getPublishingCompany());
			comand.setLong(5, book.getReleaseyear());
			comand.setBoolean(6, book.isAvaliable());
			comand.setInt(7, book.getId());
		} catch (SQLException ex) {
			System.err.println("Erro de Systema - Problema ao atualizar Livro");
			throw new RuntimeException(ex);
		} finally {
			closeConection();
		}

	}

	@Override
	public List<Book> list() {
		List<Book> listOfBooks = new ArrayList<>();
		String sql = "SELECT * FROM book";
		try {
			conect(sql);
			ResultSet result = comand.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("Nome");
				int isbc = result.getInt("ISBC");
				String writer = result.getString("Escritor");
				String publishingCompany = result.getString("editora");
				int releaseYear = result.getInt("Ano");
				boolean status = result.getBoolean("Estado");
				Book book = new Book(isbc, name, writer, publishingCompany, releaseYear, status,id);
				listOfBooks.add(book);
			}
		} catch (Exception e) {
			System.err.println("Erro de Sistema - Problema ao bsucar os livros ");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (listOfBooks);
	}

	@Override
	public Book searchByID(int id) {
		String sql = "SELECT * FROM book WHERE id = ?";
		try {
			conect(sql);
			comand.setInt(1, id);
			ResultSet result = comand.executeQuery();
			if (result.next()) {
				String name = result.getString("Nome");
				int isbc = result.getInt("ISBC");
				String writer = result.getString("Escritor");
				String publishingCompany = result.getString("editora");
				int releaseYear = result.getInt("Ano");
				boolean status = result.getBoolean("Estado");
				Book book = new Book(isbc, name, writer, publishingCompany, releaseYear, status);
				return book;
			}
		} catch (Exception e) {
			System.err.println("Erro de Sistema - Problema ao buscar o livro pelo ID");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (null);
	}

	@Override
	public Book searchByIsbc(int isbc) {
		String sql = "SELECT * FROM book WHERE ISBC = ?";
		try {
			conect(sql);
			comand.setInt(1, isbc);
			ResultSet result = comand.executeQuery();
			if (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("Nome");
				int ISBC = result.getInt("ISBC");
				String writer = result.getString("Escritor");
				String publishingCompany = result.getString("editora");
				int releaseYear = result.getInt("Ano");
				boolean status = result.getBoolean("Estado");
				Book book = new Book(ISBC, name, writer, publishingCompany, releaseYear, status, id);
				return book;
			}
		} catch (Exception e) {
			System.err.println("Erro de Sistema  - Problema ao buscar livro pelo ISBC");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (null);
	}

	@Override
	public List<Book> searchByName(String name) {
		List<Book> listOfbooks = new ArrayList<>();
		String sql = "SELECT * FROM book WHERE name ?";
		try {
			conect(sql);
			comand.setString(1, "%" + name + "%");
			ResultSet result = comand.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String nameZ = result.getString("Nome");
				int ISBC = result.getInt("ISBC");
				String writer = result.getString("Escritor");
				String publishingCompany = result.getString("editora");
				int releaseYear = result.getInt("Ano");
				boolean status = result.getBoolean("Estado");
				Book book = new Book(ISBC, nameZ, writer, publishingCompany, releaseYear, status, id);
				listOfbooks.add(book);
			}
		} catch (Exception e) {
			System.err.println("Erro de Sistema - Problema ao buscar livro pelo nome ");
			throw new RuntimeException(e);
		} finally {
			closeConection();
		}
		return (listOfbooks);
	}

}