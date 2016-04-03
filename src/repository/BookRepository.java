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
	public Book searchByName(String clientBook) {
		return getBook().stream().filter(Book -> Book.getBookName().equalsIgnoreCase(clientBook)).findFirst()
				.get();
	}
	public Book searchByCode(Integer clientCode) {
		return getBook().stream().filter(Code -> Code.getIsbnCode().equals(clientCode)).findFirst()
				.get();
	}
	
	public Book searchByWriter(String writerName) {
		return getBook().stream().filter(writer -> writer.getWriters().equalsIgnoreCase(writerName)).findFirst()
				.get();
	}
	public Book searchByPublisher(String publisherName) {
		return getBook().stream().filter(publisher -> publisher.getPublishingCompany().equals(publisherName)).findFirst()
				.get();
	}
	public Book searchByYear(Integer releaseyear) {
		return getBook().stream().filter(year -> year.getReleaseyear().equals(releaseyear)).findFirst()
				.get();
	}
}