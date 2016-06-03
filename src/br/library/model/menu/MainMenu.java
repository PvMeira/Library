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

				System.out.println("Format error, only number accept" + e);
			}

			switch (option) {
			case 1:
				System.out.println("Indo para o menu de Livro");
				BookMenu b = new BookMenu();
				b.bookMenu();

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			case 6:
				System.out.println("Exit Aplication");

				break;

			}
		} while (option != 6);
	}
}
