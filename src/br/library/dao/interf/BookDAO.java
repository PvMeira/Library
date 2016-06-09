package br.library.dao.interf;
/**
 * @author Pedro
 *
 */
import java.util.List;

import br.library.domain.profile.Book;

public interface BookDAO extends dao<Book> {
	public void insert(Book book);

	public void delete(Book book);

	public void edit(Book book, long code, String colum);

	public void edit(Book book, String code, String colum);

	public List<Book> list();

	public Book searchByIsbn(long isbn);

	public Book searchById(int id);

	public Book searchByName(String name);

	public List<Book> listByName(String name);
}
