package menu;

import menuLayOut.SearchMenuLayOut;
import repository.ClientRepository;
import util.ConsoleReader;

public class SearchMenu {

	public void Search() {
		SearchMenuLayOut menu = new SearchMenuLayOut();
		int option = 0;
		do {
			System.out.println(menu.getOptionLayOut());
			option = ConsoleReader.scanInt("Type the Option :");

			switch (option) {
			case 1:
				try {
					String name = ConsoleReader.scanString("Type the Name:");
					System.out.println(ClientRepository.getInstance().searchByName(name));
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			case 2:
				try {
					String token = ConsoleReader.scanString("Type the token:");
					System.out.println(ClientRepository.getInstance().searchByToken(token));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				//not done yet
				break;
			case 4:
            System.out.println("Going back to the main menu");
            MainMenu menuMain = new MainMenu();
			menuMain.mainSearch();
			}
		} while (option == 4);
	}
}
