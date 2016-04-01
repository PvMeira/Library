package repository;

import java.util.List;

import profile.Book;

public class BookRepository extends AbstractRepository<Book> {

	private static final BookRepository instance = new BookRepository();

	private BookRepository() {

	}

	public static BookRepository getInstance() {
		return instance;
	}
	public List<Book>getBook(){
		return getData();
	}

}