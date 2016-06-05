package br.library.controller.register;

import java.util.InputMismatchException;

import br.library.controller.service.BookService;
import br.library.domain.profile.Book;
import br.library.infra.util.ConsoleReader;

public class BookRegister {
	private BookService service;

	public BookRegister() {
		service = new BookService();
	}

	public void registerNewBook() {
		try {
			long isbn = ConsoleReader.scanLong("Isbn: ");
			service.bookExist(isbn);
			if (service.bookExist(isbn) == true) {
				System.out.println("Isbn já está cadastrado");
				return;
			}
			String name = ConsoleReader.scanString("Nome do livro: ");
			while (name == null || name.trim().length() == 0) {
				name = ConsoleReader.scanString("Titulo inválido, digite novamente: ");
			}
			String publishingCompany = ConsoleReader.scanString("Editora: ");
			while (publishingCompany == null || publishingCompany.trim().length() == 0) {
				publishingCompany = ConsoleReader.scanString("Editora inválida, digite novamente: ");
			}
			String writer = ConsoleReader.scanString("Autor(es): ");
			while (writer == null || writer.trim().length() == 0) {
				writer = ConsoleReader.scanString("Autor(es) inválido, digite novamente: ");
			}
			String year = ConsoleReader.scanString("Ano de Publicação ex: xxxx: ");
			while (service.validateYearOfTheBook(year) != true || year == null) {
				year = ConsoleReader.scanString("Ano de publicação inválido, digite novamente: ");
			}

			service.addNewBook(new Book(isbn, name, publishingCompany, writer, year));
			System.out.println("Livro " + name + " cadastrado com sucesso!");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!");
		}
	}

	public void showBook() {
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-10s", "Isbn: ") + "\t" + String.format("%-20s", "|Nome: ") + "\t"
				+ String.format("%-20s", "|Editora: ") + "\t" + String.format("%-20s", "|Autor: ") + "\t"
				+ String.format("%-20s", "|Ano de Publicação: ") + "\t"
				+ String.format("%-20s", "|Quantidade de vezes que foi alugado: "));
		for (Book livro : service.listBooks()) {
			System.out.println(
					String.format("%-10s", livro.getIsbn()) + "\t" + String.format("%-20s", "|" + livro.getName())
							+ "\t" + String.format("%-20s", "|" + livro.getPublishingCompany()) + "\t"
							+ String.format("%-20s", "|" + livro.getWriter()) + "\t"
							+ String.format("%-20s", "|" + livro.getYear()) + "\t"
							+ String.format("%-20s", "|" + livro.getTotalRentQuantity()));
		}

	}

	public void editBook() {
		try {
			long isbn = ConsoleReader.scanLong("Isbn do livro a ser editado: ");
			if (service.bookExist(isbn) == false) {
				System.out.println("Livro não existe no cadastro");
				return;
			}
			Book book = service.searchBookByIsbn(isbn);
			System.out.println(book);
			String op = ConsoleReader.scanString(
					"O que deseja alterar? \n1- Isbn: \n2- Titulo: \n3- Editora: \n4- Autor(es): \n5- Ano de Publicação: \n6- Voltar: \n");
			switch (op) {
			case "1": {
				long newIsbn = ConsoleReader.scanLong("Digite o novo Isbn: ");
				while (service.bookExist(newIsbn) == true) {
					newIsbn = ConsoleReader
							.scanLong("Isbn já existe em nosso sistema, favor verifique e digite novamente: ");
				}
				service.editBook(op, newIsbn, book);
				System.out.println("Isbn alterado com sucesso!");
				break;
			}
			case "2": {
				String newName = ConsoleReader.scanString("Digite o novo Nome: ");
				while (newName == null || newName.trim().length() == 0) {
					newName = ConsoleReader.scanString("Nome inválido, digite novamente: ");
				}
				service.editBook(op, newName, book);
				System.out.println("Nome alterado com sucesso!");
				break;
			}
			case "3": {
				String newPublishingCompany = ConsoleReader.scanString("Digite a nova editora: ");
				while (newPublishingCompany == null || newPublishingCompany.trim().length() == 0) {
					newPublishingCompany = ConsoleReader.scanString("Editora inválida, digite novamente: ");
				}
				service.editBook(op, newPublishingCompany, book);
				System.out.println("Editora alterada com sucesso!");
				break;
			}
			case "4": {
				String newWriter = ConsoleReader.scanString("Digite o novo Autor: ");
				while (newWriter == null || newWriter.trim().length() == 0) {
					newWriter = ConsoleReader.scanString("Autor(es) inválido, digite novamente: ");
				}
				service.editBook(op, newWriter, book);
				System.out.println("Autor(es) alterado com sucesso!");
				break;
			}
			case "5": {
				String newyear = ConsoleReader.scanString("Digite o novo ano de publicação xxxx: ");
				while (service.validateYearOfTheBook(newyear) != true || newyear == null) {
					newyear = ConsoleReader.scanString("Ano de publicação inválido, digite novamente: ");
				}
				service.editBook(op, newyear, book);
				System.out.println("Ano de publicação alterado com sucesso!");
				break;
			}
			case "6": {
				return;
			}
			default: {
				System.out.println("Opção inválida!");
				break;
			}
			}
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!");
		}
	}

	public void deleteBook() {
		try {
			long isbn = ConsoleReader.scanLong("Isbn do livro a ser deletado: ");
			if (!service.bookExist(isbn)) {
				System.out.println("Livro não existe no cadastro");
			} else {
				Book book = service.searchBookByIsbn(isbn);
				System.out.println("Informações do Livro:");
				System.out.println("Código: " + book.getId());
				System.out.println("Isbn: " + book.getIsbn());
				System.out.println("Nome: " + book.getName());
				System.out.println("Editora: " + book.getPublishingCompany());
				System.out.println("Autor: " + book.getWriter());
				System.out.println("Ano de Publicação: " + book.getYear());
				System.out.println("Quantidade de vezes que foi alugado: " + book.getTotalRentQuantity());

				String confirmacao = ConsoleReader
						.scanString("Deseja realmente remover o livro " + book.getName() + "? (Sim/Não)");
				if (confirmacao.equalsIgnoreCase("sim")) {
					if (book.isAvaliable() == false) {
						System.out.println(
								"Livro está alugado,Para poder remover este livro é necessario que seu status seja Disponivel");
					} else {
						service.deletarLivro(book);
						System.out.println("Livro " + book.getName() + " deletado com sucesso!");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!");
		}
	}

	public void searchBook() {
		String op = ConsoleReader
				.scanString("Busca do livro, opçoes: \n1- Procurar por Isbn \n2- Procurar por Nome \n3- Voltar \n");
		try {
			switch (op) {
			case "1": {
				long newIsbn = ConsoleReader.scanLong("Digite o Isbn do livro: ");
				if (service.bookExist(newIsbn) == false) {
					System.out.println("Livro não cadastrado!");
					return;
				}
				Book livro = service.searchBookByIsbn(newIsbn);
				System.out.println(livro);
				break;
			}
			case "2": {
				String newName = ConsoleReader.scanString("Digite o Nome do livro: ");
				if (service.bookExist(newName) == false) {
					System.out.println("Livro não cadastrado!");
					return;
				}
				Book book = service.searchByName(newName);
				System.out.println(book);
				break;
			}
			case "3": {
				return;
			}
			default: {
				System.out.println("Opção inválida!");
				break;
			}
			}
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!");
		}
	}
}
