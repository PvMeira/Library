package menu;

import menuLayOut.BookMenuLayOut;
import register.BookRegister;
import util.ConsoleReader;

public class BookMenu {
	BookMenuLayOut menu = new BookMenuLayOut();
	BookRegister b = new BookRegister();

	public void bookMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Type the Option :");
			} catch (Exception e) {

				System.out.println("Format error, only number accept" + e);
			}

			switch (op) {
			case 1:

				b.addNew();
				System.out.println("New book client add !");
				break;
			case 2:
				System.out.println("Going to the Search Menu");
				SearchMenu sMenu = new SearchMenu();
				sMenu.Search();
				break;
			case 3:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
				break;
			}

		} while (op != 4);

	}
}
