package br.library.model.menu;
/**
 * @author Pedro
 *
 */
import br.library.controller.register.ClientRegister;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.ClientMenuLayOut;

public class ClientMenu {
	ClientMenuLayOut menu = new ClientMenuLayOut();
	ClientRegister b = new ClientRegister();

	public void clientMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("digite a opção :");

				switch (op) {
				case 1:
					b.registerNewClient();

					break;
				case 2:
					b.deleteClient();

					break;
				case 3:
					b.editClient();

					break;
				case 4:
					b.showClient();

					break;

				case 5:

					b.searchClient();
					break;

				case 6:
					System.out.println("Voltar para menu principal");
					MainMenu mainMenu= new MainMenu();
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
