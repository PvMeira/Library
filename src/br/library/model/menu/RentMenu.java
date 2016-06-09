package br.library.model.menu;
/**
 * @author Pedro
 *
 */
import br.library.controller.register.RentRegister;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.RentMenuLayOut;

public class RentMenu {
	RentMenuLayOut menu = new RentMenuLayOut();
	RentRegister b = new RentRegister();

	public void rentMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Digite a opção :");

				switch (op) {
				case 1:
					b.addNewRent();
					break;
				case 2:

					MainMenu mainMenu = new MainMenu();
					mainMenu.mainSearch();
				default:
					System.out.println("opção Inválida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inválido, apenas numeros aceitos!");
			}
		} while (op != 6);

	}
}
