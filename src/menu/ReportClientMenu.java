package menu;

import menuLayOut.ReportClientLayOut;
import report.ClientsReport;
import util.ConsoleReader;

public class ReportClientMenu {
	public void Search() {
		ClientsReport report = new ClientsReport();
		ReportClientLayOut menu = new ReportClientLayOut();
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
				report.clientsWhoMostRentBooks();

				break;
			case 2:
				report.clientsWhoLessRentBooks();

				break;
			case 3:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
				break;

			}
		} while (option != 3);
	}
}
