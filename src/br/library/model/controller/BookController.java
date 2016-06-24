package br.library.model.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.library.dao.impl.BookDaoBd;
import br.library.dao.interf.BookDAO;
import br.library.domain.profile.Book;
import br.library.infra.util.messengerJFrame;
import br.library.model.view.book.BookCRUDWindow;
import br.library.model.view.book.BookPanel;
import br.library.model.view.book.BookTableModel;
import br.library.model.view.book.RegisterBookPanel;

public class BookController {

	private final static int TABLE = 0;
	private final static int REGISTERFORM = 1;
	private final static int EDITFORM = 2;
	private final static int VIEWFORM = 3;

	private int realTimeScrenn = 0;
	private int selectLine = -1;

	private BookCRUDWindow window;

	public BookController() {
		realTimeScrenn = TABLE;
	}

	public void setJanela(BookCRUDWindow window) {
		this.window = window;
	}

	public void insert() {
		RegisterBookPanel panelForm = this.window.getRegisterBookPanel();

		panelForm.clean();

		panelForm.getRegisterPanelLabel().setText("Cadastrar Livro");
		panelForm.getSaveButton().setVisible(true);
		panelForm.getSaveButton().setText("Cadastrar");
		panelForm.toggleBookFormEdit(true);

		realTimeScrenn = REGISTERFORM;
		this.window.showPanel(BookCRUDWindow.PANELFORM);
	}

	public void edit() {
		BookPanel bookPanel = this.window.getPanelTable();
		RegisterBookPanel panelForm = this.window.getRegisterBookPanel();
		BookTableModel tableModel = (BookTableModel) bookPanel.getBooksTable().getModel();

		selectLine = bookPanel.getBooksTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "n�o h� nenhum elemento selecionado na tabela");
			return;
		}
		Book bookTemp = tableModel.getBook(selectLine);
		panelForm.loadData(Long.toString(bookTemp.getIsbn()), bookTemp.getName(), bookTemp.getPublishingCompany(),
				bookTemp.getWriter(), bookTemp.getYear());

		panelForm.getRegisterPanelLabel().setText("Editar Livro");
		panelForm.getSaveButton().setVisible(true);
		panelForm.getSaveButton().setText("Editar");
		panelForm.toggleBookFormEdit(true);

		realTimeScrenn = EDITFORM;
		this.window.showPanel(BookCRUDWindow.PANELFORM);
	}

	public void view() {
		BookPanel bookPanel = this.window.getPanelTable();
		RegisterBookPanel panelForm = this.window.getRegisterBookPanel();
		BookTableModel tableModel = (BookTableModel) bookPanel.getBooksTable().getModel();

		selectLine = bookPanel.getBooksTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "n�o h� nenhum elemento selecionado na tabela");
			return;
		}
		Book bookTemp = tableModel.getBook(selectLine);
		panelForm.loadData(Long.toString(bookTemp.getIsbn()), bookTemp.getName(), bookTemp.getPublishingCompany(),
				bookTemp.getWriter(), bookTemp.getYear());

		panelForm.getRegisterPanelLabel().setText("Visualizar Livro");
		panelForm.getSaveButton().setVisible(false);
		panelForm.getSaveButton().setText("");
		panelForm.toggleBookFormEdit(false);

		realTimeScrenn = VIEWFORM;
		this.window.showPanel(BookCRUDWindow.PANELFORM);
	}

	public void remove() {
		BookPanel bookPanel = this.window.getPanelTable();
		BookTableModel tableModel = (BookTableModel) bookPanel.getBooksTable().getModel();
		selectLine = bookPanel.getBooksTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "n�o h� nenhum elemento selecionado na tabela");
			return;
		}
		Book bookTemp = tableModel.getBook(selectLine);
		if (bookTemp.isAvaliable() == false) {
			messengerJFrame.printErrorMessage(window, "Livro est� alugado");
			return;
		} else {
			BookDAO dao = new BookDaoBd();
			dao.delete(bookTemp);
			messengerJFrame.printSucessMesenge(window, "Registro Removido com Sucesso ");
		}
		this.updateTable();

	}

	public void save(String isbn, String name, String publishingCompany, String writer, String year) {
		RegisterBookPanel panelForm = this.window.getRegisterBookPanel();
		BookPanel bookPanel = this.window.getPanelTable();
		BookTableModel tableModel = (BookTableModel) bookPanel.getBooksTable().getModel();
		try {
			long isbnTemp = Long.parseLong(isbn);
			String nameTemp = name, publishingCompanyTemp = publishingCompany, writerTemp = writer, yearTemp = year;
			if (realTimeScrenn == REGISTERFORM) {
				if (BookExist(isbnTemp)) {
					messengerJFrame.printErrorMessage(window, "ISBN j� existe");
				} else if (isbnValidator(isbnTemp) == false) {
					messengerJFrame.printErrorMessage(window, "Campo ISBN � invalido");
				} else if (name == null || name.trim().length() == 0) {
					messengerJFrame.printErrorMessage(window, "Campo Nome � invalido");
				} else if (publishingCompany == null || publishingCompany.trim().length() == 0) {
					messengerJFrame.printErrorMessage(window, "Campo Editora � invalido");

				} else if (writer == null || writer.trim().length() == 0) {
					messengerJFrame.printErrorMessage(window, "Campo Autor(es) � invalido");

				} else if (yearValidator(year) != true || year == null) {
					messengerJFrame.printErrorMessage(window, "Campo Ano de Publica��o � invalido! Digite: xxxx");
				} else {
					Book book = new Book(isbnTemp, nameTemp, publishingCompanyTemp, writerTemp, yearTemp);
					BookDAO dao = new BookDaoBd();
					dao.insert(book);
					messengerJFrame.printSucessMesenge(window, "Cadastro realizado com sucesso!");
					panelForm.clean();
				}

			} else if (realTimeScrenn == EDITFORM) {
				if (BookExist(isbnTemp)) {
					messengerJFrame.printErrorMessage(window, "ISBN já existe");
				} else if (isbnValidator(isbnTemp) == false) {
					messengerJFrame.printErrorMessage(window, "Campo ISBN é inválido!");
				} else if (name == null || name.trim().length() == 0) {
					messengerJFrame.printErrorMessage(window, "Campo Titulo é inválido!");
				} else if (publishingCompany == null || publishingCompany.trim().length() == 0) {
					messengerJFrame.printErrorMessage(window, "Campo Editora é inválido");

				} else if (writer == null || writer.trim().length() == 0) {
					messengerJFrame.printErrorMessage(window, "Campo Autor(es) é inválido");
				} else if (yearValidator(year) != true || year == null) {
					messengerJFrame.printErrorMessage(window, "Campo Ano de Publição é inválido! Digite: xxxx");
				} else {
					selectLine = bookPanel.getBooksTable().getSelectedRow();
					int id = tableModel.getBook(selectLine).getId();
					Book book = new Book(isbnTemp, nameTemp, publishingCompanyTemp, writerTemp, yearTemp);
					BookDAO dao = new BookDaoBd();
					dao.editBook(book, id);
					messengerJFrame.printSucessMesenge(window, "Edi��o realizada com sucesso!");
				}
			}
		} catch (Exception e) {
			messengerJFrame.printErrorMessage(window, "Campo ISBN � invalido");
		}
	}

	public void backToMainScreen() {
		realTimeScrenn = TABLE;
		this.updateTable();
		this.window.showPanel(BookCRUDWindow.PANELTABLE);
	}

	public void updateTable() {
		BookPanel bookPanel = this.window.getPanelTable();
		BookTableModel tableModel = (BookTableModel) bookPanel.getBooksTable().getModel();

		BookDAO dao = new BookDaoBd();
		tableModel.setBook(dao.list());

		bookPanel.getBooksTable().updateUI();
	}

	public boolean BookExist(String name) {
		BookDAO dao = new BookDaoBd();
		Book book = dao.searchByName(name);
		return (book != null);
	}

	public boolean BookExist(long isbn) {
		BookDAO dao = new BookDaoBd();
		Book book = dao.searchByIsbn(isbn);
		if (book != null) {
			return true;
		} else {
			return false;
		}
	}

	public void addBook(Book bookTemp) {
		new BookDaoBd().insert(bookTemp);
	}

	public List<Book> listBooks() {
		return (new BookDaoBd().list());
	}

	public Book searchBookByIsbn(long isbn) {
		BookDAO dao = new BookDaoBd();
		Book book = dao.searchByIsbn(isbn);
		return (book);
	}

	public Book searchBookById(int id) {
		BookDAO dao = new BookDaoBd();
		Book book = dao.searchByID(id);
		return (book);
	}

	public Book searchBookByName(String name) {
		BookDAO dao = new BookDaoBd();
		Book book = dao.searchByName(name);
		return (book);
	}

	public void editBook(String option, long newX, Book bookTemp) {
		BookDAO dao = new BookDaoBd();
		if (option.equals("1")) {
			dao.edit(bookTemp, newX, "isbn");
		}
	}

	public void editBook(String op, String newX, Book bookAnotherTemp) {
		BookDAO dao = new BookDaoBd();
		if (op.equals("2")) {
			dao.edit(bookAnotherTemp, newX, "name");
		}
		if (op.equals("3")) {
			dao.edit(bookAnotherTemp, newX, "publishingCompany");
		}
		if (op.equals("4")) {
			dao.edit(bookAnotherTemp, newX, "writer");
		}
		if (op.equals("5")) {
			dao.edit(bookAnotherTemp, newX, "year");
		}
	}

	public void deleteBook(Book bookTemp) {
		BookDAO dao = new BookDaoBd();
		dao.delete(bookTemp);
	}

	public boolean checkIsbn(long isbn) {
		BookDAO dao = new BookDaoBd();
		Book book = dao.searchByIsbn(isbn);
		if (book != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isbnValidator(long isbnTemp) {
		if (isbnTemp >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void viewAvaliableBooks() {
		@SuppressWarnings("unused")
		List<Book> bookListTemp = new BookDaoBd().list();
	}

	public boolean yearValidator(String string) {
		return string.matches("[0-9]{4}+");
	}

	public List<Book> MostRentedBooks() {
		List<Book> bookListTemp = new BookDaoBd().list();
		Collections.sort(bookListTemp, new booksRetrives());
		return bookListTemp;
	}

	public class booksRetrives implements Comparator<Book> {

		@Override
		public int compare(Book bookONE, Book bookTWO) {
			return bookTWO.getTotalRentQuantity() - bookONE.getTotalRentQuantity();
		}
	}

}
