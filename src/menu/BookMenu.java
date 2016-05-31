package menu;

/**
 * @author Pedro
 *
 */
import menuLayOut.BookMenuLayOut;
import register.BookRegister;
import util.ConsoleReader;

public class BookMenu {
	BookMenuLayOut menu = new BookMenuLayOut();
	BookRegister b = new BookRegister();

	public void bookMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Type the Option :");

				switch (op) {
				case 1:
					b.registerNewBook();
					System.out.println("Livro adicionado");
					break;
				case 2:
					System.out.println("Deletar livro existente");
					SearchMenuBook sMenu = new SearchMenuBook();
					sMenu.Search();
					break;
				case 3:
					System.out.println("Atualizar livro existente");
					ReportBookMenu menu1 = new ReportBookMenu();
					menu1.SearchBook();
					break;
				case 4:
					System.out.println("Listar todos livros existentes");
					MainMenu menuMain = new MainMenu();
					menuMain.mainSearch();
					break;

				case 5:
					System.out.println("Consultar livro pelo nome");
					MainMenu menuMain = new MainMenu();
					menuMain.mainSearch();
					break;

				case 6:
					System.out.println("Sair");
					MainMenu menuMain = new MainMenu();
					menuMain.mainSearch();

				default:
					System.out.println("opção Inválida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inválido, apenas numeros aceitos!");
			}
		} while (op != 6);

	}
}
