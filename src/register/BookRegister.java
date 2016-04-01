package register;

import java.util.Scanner;

import profile.Book;
import repository.BookRepository;

public class BookRegister implements register<Book> {
	Scanner read = new Scanner(System.in);

	@Override
	public void addNew() {
		String code = read.nextLine();
		String name = read.nextLine();
		String writer = read.nextLine();
		String publisher = read.nextLine();
		int year = read.nextInt();
		Book book = new Book(code, name, writer, publisher, year);
		BookRepository.getInstance().add(book);
		
	}

	
}
