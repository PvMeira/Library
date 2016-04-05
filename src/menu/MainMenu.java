package menu;

import menuLayOut.MainMenuLayOut;
import profile.Book;
import profile.Client;
import profile.Rent;
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
	Client client = new Client(null, null, null);
	Book book = new Book(null, null, null, null, 0);
	Rent RENT = new Rent(client, book, 0, null);
	int option = 0;

	public void mainSearch() {

		do {
			System.out.println(menu.getOptionLayOut());
			option = ConsoleReader.scanInt("Type the Option :");

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
				rent.addNewRent(client, book);
				break;
			case 5:
				devo.addNewDevolution(RENT);

				break;
			case 6:
				// to do Report menu

				break;
			case 7:
				System.out.println("Exit Aplication");

				break;

			}
		} while (option != 7);
	}
}
