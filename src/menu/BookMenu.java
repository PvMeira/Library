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
					b.deleteBook();
					System.out.println("Livro deletado");
					break;
				case 3:
					b.updateBook();
					System.out.println("Livro atualizado");
					break;
				case 4:
					System.out.println("Listar todos livros existentes...");
					b.listBooks();
					break;

				case 5:
					System.out.println("Consultar livro pelo nome");
					b.searchBookByName();
					break;

				case 6:
					System.out.println("Sair");
					

				default:
					System.out.println("opção Inválida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inválido, apenas numeros aceitos!");
			}
		} while (op != 6);

	}
}
