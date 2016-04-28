package menu;

import menuLayOut.SearchMenuLayOut;
import util.ConsoleReader;

public class SearchMenu {

	public void Search() {
		SearchMenuLayOut menu = new SearchMenuLayOut();
		int option = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				option = ConsoleReader.scanInt("Type the Option :");
			} catch (Exception e) {

				System.out.println("Format error, only number accept" + e);
			}

			switch (option) {
			case 1:
				System.out.println("Going  to the Client Search menu");
				SearchMenuClient menuC = new SearchMenuClient();
				menuC.Search();
				break;
			case 2:
				System.out.println("Going  to the Book Search menu");
				SearchMenuBook menuB = new SearchMenuBook();
				menuB.Search();
				break;
			case 3:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
			}
		} while (option != 5);
	}
}
