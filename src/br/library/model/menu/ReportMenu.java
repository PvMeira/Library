package br.library.model.menu;

import br.library.controller.register.BookRegister;
import br.library.controller.service.BookService;
import br.library.controller.service.ClientService;
import br.library.controller.service.RentService;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.ReportMenuLayOut;

public class ReportMenu {
	ReportMenuLayOut menu = new ReportMenuLayOut();
	private final RentService serviceA = new RentService();
	private final ClientService serviceB = new ClientService();
	private final BookService serviceC = new BookService();
	private final BookRegister serviceD = new BookRegister();

	public void bookMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Digite uma opção :");

				switch (op) {
				case 1:
					serviceD.showBook();

					break;
				case 2:
					serviceC.listAvaliableBooks();

					break;
				case 3:
					serviceC.booksWhoGotMostRent();
					break;
				case 4:

					serviceB.clientsWhoMostRent();
					break;

				case 5:

					serviceB.clientsWhoMostDelayed();
					break;

				case 6:
					System.out.println("Voltar para menu principal");
					MainMenu mainMenu = new MainMenu();
					mainMenu.mainSearch();

				default:
					System.out.println("opção Inválida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inválido, apenas numeros aceitos!");
			}
		} while (op != 6);

	}
}
