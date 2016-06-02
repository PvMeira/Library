package menu;

/*import menuLayOut.ClientMenuLayOut;
import register.ClientRegister;
import report.ClientsReport;
import util.ConsoleReader;
*//**
 * @author Pedro
 *
 *//*
public class ClientMenu {
	ClientMenuLayOut menu = new ClientMenuLayOut();
	ClientRegister c = new ClientRegister();
	ClientsReport cr = new ClientsReport();

	public void clientMenu() {
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

				c.registerNewBook();
				System.out.println("New client add !");
				break;
			case 2:
				System.out.println("Going to the Search Menu");
				SearchMenu sMenu = new SearchMenu();
				sMenu.Search();
				break;
			case 3:
				System.out.println("Going to Client report menu");
				ReportClientMenu c = new ReportClientMenu();
				c.Search();
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
*/