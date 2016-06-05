package br.library.model.menu;

import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.MainMenuLayOut;

/**
 * @author Pedro
 *
 */
public class MainMenu {
	MainMenuLayOut menu = new MainMenuLayOut();

	int option = 0;

	public void mainSearch() {

		do {
			try {
				System.out.println(menu.getOptionLayOut());
				option = ConsoleReader.scanInt("Digite uma opção :");
			} catch (Exception e) {

				System.err.println("Formato não aceito, apenas Numeros" + e);
			}

			switch (option) {
			case 1:
				BookMenu b = new BookMenu();
				b.bookMenu();

				break;
			case 2:
				ClientMenu c = new ClientMenu();
				c.clientMenu();
				break;
			case 3:
				RentMenu r = new RentMenu();
				r.rentMenu();
				break;
			case 4:

				break;
			case 5:
				System.out.println("Exit Aplication");
				break;

			}
		} while (option != 5);
	}
}
