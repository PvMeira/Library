package menu;

import menuLayOut.MainMenuLayOut;
import register.DevolutionRegister;
import register.RentRegister;
import util.ConsoleReader;
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
				option = ConsoleReader.scanInt("Type the Option :");
			} catch (Exception e) {

				System.out.println("Format error, only number accept" + e);
			}

			switch (option) {
			case 1:
				System.out.println("Going to Clients menu");
				ClientMenu Clientmenu = new ClientMenu();
				Clientmenu.clientMenu();

				break;
			case 2:
				System.out.println("Going to Books menu");
				BookMenu bmenu = new BookMenu();
				bmenu.bookMenu();

				break;
			case 3:
				System.out.println("Going to Search menu");
				SearchMenu sMenu = new SearchMenu();
				sMenu.Search();

				break;
			case 4:
				RentRegister rent = new RentRegister();
				rent.addNew();
				break;
			case 5:
				DevolutionRegister devo = new DevolutionRegister();
				devo.addNew();

				break;

			case 6:
				System.out.println("Exit Aplication");

				break;

			}
		} while (option != 6);
	}
}
