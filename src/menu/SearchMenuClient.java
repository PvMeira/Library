package menu;

import menuLayOut.SearchMenuClientLayOut;
import repository.ClientRepository;
import util.ConsoleReader;
/**
 * @author Pedro
 *
 */
public class SearchMenuClient {

	public void Search() {
		SearchMenuClientLayOut menu = new SearchMenuClientLayOut();
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
				try {
					String name = ConsoleReader.scanString("Type the Name:");
					System.out.println(ClientRepository.getInstance().searchByName(name));
				} catch (Exception e) {
					System.out.println("Error on format" + e);
				}
				break;
			case 2:
				try {
					String token = ConsoleReader.scanString("Type the token:");
					System.out.println(ClientRepository.getInstance().searchByToken(token));
				} catch (Exception e) {

					System.out.println("Error on format" + e);
				}
				break;
			case 3:
				// not done yet
				break;
			case 4:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
			}
		} while (option != 5);
	}
}
