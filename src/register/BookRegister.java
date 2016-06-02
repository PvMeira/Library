package register;

import java.util.List;

import Service.BookService;

/**
 * @author Pedro
 *
 */
import profile.Book;
import util.ConsoleReader;
import util.UIUtil;

public class BookRegister {
	private BookService bookService;

	public void registerNewBook() {

		String name = ConsoleReader.scanString("Nome: ");
		String writer = ConsoleReader.scanString("Autor: ");
		int ISBC = ConsoleReader.scanInt("Codigo ISbc: ");
		String publishCompany = ConsoleReader.scanString("Editora: ");
		int releaseYear = ConsoleReader.scanInt("Ano de lançamento: ");
		try {
			bookService.save(new Book(ISBC, writer, name, publishCompany, releaseYear,true));
			System.out.println("Livro " + name + "Cadastrado com sucesso!");
		} catch (Exception e) {

			System.out.println("Invalid format InPut :");
		}

	}

	public void listBooks() {
		List<Book> listBooks = bookService.list();
		this.showBookList(listBooks);
	}

	public void showBook(Book b) {
		System.out.println("--------------");
		System.out.println("Book");
		System.out.println("Nome: " + b.getBookName());
		System.out.println("Autor: " + b.getWriters());
		System.out.println("ISBC " + b.getIsbnCode());
		System.out.println("---------------");
	}

	public void showBookList(List<Book> listBooks) {
		if (listBooks.isEmpty()) {
			System.out.println("Nenhum livro cadastrado");
		} else {
			System.out.println("------------------------");
			System.out.println(String.format("%-10s", "Nome") + "\t" + String.format("%-20s", "|Autor") + "\t"
					+ String.format("%-20s", "|ISBC"));

			for (Book book : listBooks) {
				System.out.println(
						String.format("%-10s", book.getBookName()) + "\t" + String.format("%-20s", book.getWriters())
								+ "\t" + String.format("%-20s", book.getIsbnCode()));
			}
		}

	}

	public void updateBook() {
		int ISBC = ConsoleReader.scanInt("Codigo do livro a ser alterado: ");
		try {
			Book book = bookService.SerachByCode(ISBC);
			this.showBook(book);
			System.out.println("Digite as informações do livro que deseja alterar[Vazio caso nao queira]");
			String name = ConsoleReader.scanString("Nome:");
			String writer = ConsoleReader.scanString("Autor:");
			String publishingCompany = ConsoleReader.scanString("Editora:");
			int releaseyear = ConsoleReader.scanInt("Autor:");
			if (!name.isEmpty()) {
				book.setBookName(name);
			}
			if (!writer.isEmpty()) {
				book.setWriters(writer);
			}
			if (!publishingCompany.isEmpty()) {
				book.setPublishingCompany(publishingCompany);
			}
			if (releaseyear!=0) {
				book.setReleaseyear(releaseyear);
			}
			bookService.update(book);
			System.out.println("Livro "+name+" atualizado com sucesso");

		} catch (Exception e) {
			UIUtil.showError(e);
		} 
	}
	public void searchBookByName(){
		String name = ConsoleReader.scanString("Nome :");
		try {
			List<Book> listBook= bookService.SerachByName(name);
			this.showBookList(listBook);
		} catch (Exception e) {
			UIUtil.showError(e.getMessage());
		}
	}
	public void deleteBook() {
		int ISBC = ConsoleReader.scanInt("Codigo Isbc do livro a ser deletado:");
		try {
			Book book = bookService.SerachByCode(ISBC);
			this.showBook(book);
			if (UIUtil.getConfirmation("Realmente deseja deleter este registro?")) {
				bookService.delete(book);
				System.out.println("Cadastro de livro deletado com sucesso");
			} else {
				System.out.println("Operação cancelada");
			}

		} catch (Exception e) {
			UIUtil.showError(e.getMessage());
		}
	}
}
