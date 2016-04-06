package menu;

import menuLayOut.MainMenuLayOut;
import register.DevolutionRegister;
import register.RentRegister;
import util.ConsoleReader;

public class MainMenu {
	MainMenuLayOut menu = new MainMenuLayOut();
	BookMenu bmenu = new BookMenu();
	ClientMenu Clientmenu = new ClientMenu();
	SearchMenu sMenu = new SearchMenu();
	RentRegister rent = new RentRegister();
	DevolutionRegister devo = new DevolutionRegister();

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

				Clientmenu.clientMenu();

				break;
			case 2:
				System.out.println("Going to Books menu");

				bmenu.bookMenu();

				break;
			case 3:
				System.out.println("Going to Search menu");

				sMenu.Search();

				break;
			case 4:
				rent.addNew();
				break;
			case 5:
				devo.addNew();

				break;

			case 6:
				System.out.println("Exit Aplication");

				break;

			}
		} while (option != 6);
	}
}
