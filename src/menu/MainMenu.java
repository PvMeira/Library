package menu;

import menuLayOut.MainMenuLayOut;
import register.BookRegister;
import register.ClientRegister;
import util.ConsoleReader;

public class MainMenu {
	public void mainSearch() {

		MainMenuLayOut menu = new MainMenuLayOut();
		int option = 0;

		do {
			System.out.println(menu.getOptionLayOut());
			option = ConsoleReader.scanInt("Type the Option :");

			switch (option) {
			case 1:
				ClientRegister c = new ClientRegister();
				c.addNew();
				System.out.println("New client add !");

				break;
			case 2:
				BookRegister b = new BookRegister();
				b.addNew();
				System.out.println("New book client add !");

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				SearchMenu sMenu = new SearchMenu();
				sMenu.Search();

				break;
			case 7:
				System.out.println("Exit Aplication");

				break;

			}
		} while (option == 7);
	}
}
