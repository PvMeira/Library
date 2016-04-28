package menu;
/**
 * @author Pedro
 *
 */
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
				System.out.println("New book  add !");
				break;
			case 2:
				System.out.println("Going to the Search Menu");
				SearchMenuBook sMenu = new SearchMenuBook();
				sMenu.Search();
				break;
			case 3:
				System.out.println("Going to Report book menu");
				ReportBookMenu menu1 = new ReportBookMenu();
				menu1.SearchBook();
				break;
			case 4:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
				break;
			}

		} while (op != 4);

	}
}
