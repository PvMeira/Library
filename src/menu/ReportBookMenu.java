package menu;

import menuLayOut.ReportBookLayOut;
import report.BooksReport;
import util.ConsoleReader;

public class ReportBookMenu {
	public void SearchBook() {
		BooksReport report = new BooksReport();
		ReportBookLayOut menu = new ReportBookLayOut();
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
					System.out.println(report.mostRentBook());
				} catch (Exception e) {

					System.out.println("No book add" + e);
				}

				break;
			case 2:
				try {
					System.out.println(report.lessRentBook());
				} catch (Exception e) {

					System.out.println("No Book add" + e);
				}

				break;
			case 3:
				try {
					System.out.println(report.showAllBooks());
				} catch (Exception e) {

					System.out.println("No Book add" + e);
				}
				break;
			case 4:
				System.out.println("Going back to the main menu");
				MainMenu menuMain = new MainMenu();
				menuMain.mainSearch();
				break;

			}
		} while (option != 3);
	}
}
