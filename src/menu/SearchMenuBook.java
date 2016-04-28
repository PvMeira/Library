package menu;

import menuLayOut.SearchBookMenuLayOut;
import repository.BookRepository;
import util.ConsoleReader;
/**
 * @author Pedro
 *
 */
public class SearchMenuBook {

	public void Search() {
		SearchBookMenuLayOut menu = new SearchBookMenuLayOut();
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
					String name = ConsoleReader.scanString("Type the Name of the Book:");
					System.out.println(BookRepository.getInstance().searchByName(name));
				} catch (Exception e) {
					System.out.println("Error on format" + e);
				}
				break;
			case 2:
				try {
					String writer = ConsoleReader.scanString("Type the Name of the Book´s Author:");
					System.out.println(BookRepository.getInstance().searchByWriter(writer));
				} catch (Exception e) {

					System.out.println("Error on format" + e);
				}
				break;
			case 3:
				try {
					String company = ConsoleReader.scanString("Type the Name of the Book´s Publishing Company:");
					System.out.println(BookRepository.getInstance().searchByPublisher(company));
				} catch (Exception e) {

					System.out.println("Error on format" + e);
				}
				break;
		    case 4:
					try {
						int year = ConsoleReader.scanInt("Type the year of the Book´s Release Year:");
						System.out.println(BookRepository.getInstance().searchByYear(year));
					} catch (Exception e) {

						System.out.println("Error on format" + e);
					}
					break;
			case 5:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
			}
		} while (option != 6);
	}
}
