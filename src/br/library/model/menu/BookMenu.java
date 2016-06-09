package br.library.model.menu;
/**
 * @author Pedro
 *
 */
import br.library.controller.register.BookRegister;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.BookMenuLayOut;

public class BookMenu {
	BookMenuLayOut menu = new BookMenuLayOut();
	BookRegister b = new BookRegister();

	public void bookMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Digite uma opção :");

				switch (op) {
				case 1:
					b.registerNewBook();

					break;
				case 2:
					b.deleteBook();

					break;
				case 3:
					b.editBook();
					System.out.println("Livro atualizado");
					break;
				case 4:

					b.showBook();
					break;

				case 5:

					b.searchBook();
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
