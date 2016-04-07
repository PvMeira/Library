package report;

import profile.Book;
import repository.BookRepository;

public class BooksReport {
	Book book;

	public String mostRentBook() {
		book = BookRepository.getInstance().getBook().stream()
				.max((book1, book2) -> book1.getCountBookRent().compareTo(book2.getCountBookRent())).get();

		return "\nThe most Rent book was :" + book.getBookName() + "by the author" + book.getWriters();

	}

	public String lessRentBook() {
		book = BookRepository.getInstance().getBook().stream()
				.min((book1, book2) -> book1.getCountBookRent().compareTo(book2.getCountBookRent())).get();

		return "\nThe less Rent book was :" + book.getBookName() + "by the author" + book.getWriters();

	}

	// public String avaliableBooks() {
	//
	// return "";
	// }

	public String showAllBooks() {
		String n = BookRepository.getInstance().getBook().toString();
		return "\nAll books avaliable register are :" + n;
	}
//	public String showAllBooksAvaliable() {
//		String n = BookRepository.getInstance().getBook().stream().filter(book.isAvaliable().toString();
//		return "\nAll books avaliable register are :" + n;
//	}
}
