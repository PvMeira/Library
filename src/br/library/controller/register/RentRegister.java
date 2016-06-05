package br.library.controller.register;

import java.util.Date;
import java.util.InputMismatchException;

import br.library.controller.service.BookService;
import br.library.controller.service.ClientService;
import br.library.controller.service.RentService;
import br.library.domain.profile.Book;
import br.library.domain.profile.Client;
import br.library.domain.profile.Rent;
import br.library.infra.util.ConsoleReader;

public class RentRegister {
	private RentService serviceA;
	private ClientService serviceB;
	private BookService serviceC;

	public RentRegister() {
		serviceA = new RentService();
		serviceB = new ClientService();
		serviceC = new BookService();
	}

	public void addNewRent() {
		try {
			long cpf = ConsoleReader.scanLong("Digite seu Cpf para continuar: ");
			serviceB.clientExist(cpf);
			if (serviceB.clientExist(cpf) == false) {
				System.out.println("Cadastro nao encontrado");
				return;
			}
			Client client = serviceB.searchByCpf(cpf);
			if (client.getBooksRent() == 3) {
				System.err.println(client.getName() + "Esse cliente ja chegou ao limite de alugueis");
				return;
			}
			String op = ConsoleReader.scanString(
					"Busca dos alugueis, opções: \n1- Procurar por Isbn \n2- Procurar por Titulo \n3- Voltar \n");
			switch (op) {
			case "1": {
				long newIsbn = ConsoleReader.scanLong("Digite o Isbn do livro: ");
				if (serviceC.bookExist(newIsbn) == false) {
					System.err.println("Livro não Existe!");
					return;
				}
				Book book = serviceC.searchBookByIsbn(newIsbn);
				System.out.println(book);
				String comfirmation = ConsoleReader
						.scanString("Deseja realmente alugar o livro " + book.getName() + "? (Sim/Não)");
				if (comfirmation.equalsIgnoreCase("sim")) {
					if (book.isAvaliable() == false) {
						System.err.println("Livro está alugado");
					} else {
						Date dateFormat = new Date();
						java.sql.Date dataSql;
						dateFormat = new java.sql.Date(dateFormat.getTime());
						dataSql = (java.sql.Date) dateFormat;

						serviceA.addNewRent(new Rent(dateFormat, client, book));
						System.out.println("Livro " + book.getName() + " alugado com sucesso! ");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
				break;
			}
			case "2": {
				String newName = ConsoleReader.scanString("Digite o Nome do livro: ");
				if (serviceC.bookExist(newName) == false) {
					System.err.println("Livro não cadastrado!");
					return;
				}
				Book book = serviceC.searchByName(newName);
				System.out.println(book);
				String confirmation = ConsoleReader
						.scanString("Deseja realmente alugar o livro " + book.getName() + "? (Sim/Não)");
				if (confirmation.equalsIgnoreCase("sim")) {
					if (book.isAvaliable() == false) {
						System.out.println("Livro está alugado");
					} else {
						Date dateFormat = new Date();
						java.sql.Date dataSql;
						dateFormat = new java.sql.Date(dateFormat.getTime());
						dataSql = (java.sql.Date) dateFormat;

						serviceA.addNewRent(new Rent(dateFormat, client, book));
						System.out.println("Livro " + book.getName() + " alugado com sucesso! ");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
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
			System.out.println("Entrada inválida");
		}
	}
}
