package menu;

//import menuLayOut.ReportClientLayOut;
//import report.ClientsReport;
//import util.ConsoleReader;
///**
// * @author Pedro
// *
// */
//public class ReportClientMenu {
//	public void Search() {
//		ClientsReport report = new ClientsReport();
//		ReportClientLayOut menu = new ReportClientLayOut();
//		int option = 0;
//
//		do {
//			try {
//				System.out.println(menu.getOptionLayOut());
//				option = ConsoleReader.scanInt("Type the Option :");
//			} catch (Exception e) {
//
//				System.out.println("Format error, only number accept" + e);
//			}
//
//			switch (option) {
//			case 1:
//				try {
//					System.out.println(report.clientsWhoMostRentBooks());
//				} catch (Exception e) {
//
//					System.out.println("No client add" + e);
//				}
//
//				break;
//			case 2:
//				try {
//					System.out.println(report.clientsWhoLessRentBooks());
//				} catch (Exception e) {
//
//					System.out.println("No client add" + e);
//				}
//
//				break;
//			case 3:
//				try {
//					System.out.println(report.showAllClients());
//				} catch (Exception e) {
//
//					System.out.println("No client add" + e);
//				}
//
//				break;
//			case 4:
//				System.out.println("Going back to the main menu");
//				MainMenu menuMain = new MainMenu();
//				menuMain.mainSearch();
//				break;
//
//			}
//		} while (option != 3);
//	}
//}
