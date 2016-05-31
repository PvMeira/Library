package register;

import java.util.List;

import Service.BookService;
import br.com.senacrs.consultorio.dominio.Paciente;
import br.com.senacrs.consultorio.util.DateUtil;
/**
 * @author Pedro
 *
 */
import profile.Book;
import util.ConsoleReader;

public class BookRegister {
	private BookService bookService;

	public void registerNewBook() {

		String name = ConsoleReader.scanString("Nome: ");
		String writer = ConsoleReader.scanString("Autor: ");
		int ISBC = ConsoleReader.scanInt("Codigo ISbc: ");
		String publishCompany = ConsoleReader.scanString("Editora: ");
		int releaseYear = ConsoleReader.scanInt("Ano de lançamento: ");
		try {
			bookService.save(new Book(ISBC, writer, name, publishCompany, releaseYear));
			System.out.println("Livro " + name + "Cadastrado com sucesso!");
		} catch (Exception e) {

			System.out.println("Invalid format InPut :");
		}

	}

	private void deleteBook() {
		String ISBC = ConsoleReader.scanString("Codigo Isbc do livro a ser deletado:");
		try {
			Book book = bookService.SerachByCode();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listBooks() {
		List<Book> listBooks = bookService.list();
		this.showBookList(listBooks);
	}

	public void showBook(Book b) {
		System.out.println("--------------");
		System.out.println("Book");
		System.out.println("Nome: " + b.getBookName());
		System.out.println("Autor: " + b.getWriters());
		System.out.println("ISBC " + b.getIsbnCode());
		System.out.println("---------------");
	}

	private void showBookList(List<Book> listBooks) {
		if (listBooks.isEmpty()) {
			System.out.println("Nenhum livro cadastrado");
		} else {
			System.out.println("------------------------");
			System.out.println(String.format("%-10s", "Nome") + "\t" + String.format("%-20s", "|Autor") + "\t"
					+ String.format("%-20s", "|ISBC"));

			for (Book book : listBooks) {
				System.out.println(
						String.format("%-10s", book.getBookName()) + "\t" + String.format("%-20s", book.getWriters())
								+ "\t" + String.format("%-20s", book.getIsbnCode()));
			}
		}

	}

}
// private void deletarPaciente() {
// String rg = Console.scanString("RG do paciente a ser deletado: ");
// try {
// Paciente pac = pacienteNegocio.procurarPorRg(rg);
// this.mostrarPaciente(pac);
// if (UIUtil.getConfirmacao("Realmente deseja excluir esse paciente?")) {
// pacienteNegocio.deletar(pac);
// System.out.println("Paciente deletado com sucesso!");
// } else {
// System.out.println("Operacao cancelada!");
// }
// } catch (NegocioException ex) {
// UIUtil.mostrarErro(ex.getMessage());
// }
// }
