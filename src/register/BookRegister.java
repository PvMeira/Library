package register;

import profile.Book;
import repository.BookRepository;
import util.ConsoleReader;

public class BookRegister implements register<Book> {

	@Override
	public void addNew() {
		String code = ConsoleReader.scanString("Type the book's code");
		String name = ConsoleReader.scanString("Type the book's name");
		String writer = ConsoleReader.scanString("Type the book's writer");
		String publisher = ConsoleReader.scanString("Type the book's Publisher");
		int year = ConsoleReader.scanInt("Type the year of publish of the book");
		Book book = new Book(code, name, writer, publisher, year);
		BookRepository.getInstance().add(book);

	}

}
