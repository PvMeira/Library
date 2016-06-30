package br.library.model.controller;

import java.util.Date;
import java.util.List;

import br.library.dao.impl.BookDaoBd;
import br.library.dao.impl.RentDaoBd;
import br.library.dao.interf.BookDAO;
import br.library.dao.interf.RentDAO;
import br.library.domain.profile.Book;
import br.library.domain.profile.Client;
import br.library.domain.profile.Rent;
import br.library.infra.util.DateUtil;
import br.library.infra.util.messengerJFrame;
import br.library.model.view.rent.RentCRUDWindow;
import br.library.model.view.rent.RentPanel;
import br.library.model.view.rent.RentRegisterPanel;
import br.library.model.view.rent.RentTableModel;
@SuppressWarnings("all")
public class RentController {

	private final static int TABLE = 0;
	private final static int REGISTERFORM = 1;
	private final static int EDITFORM = 2;
	private final static int VIEWFORM = 3;

	private int realTimeScreen = 0;
	private int selectLine = -1;

	private RentCRUDWindow window;
	private ClientController clientController;
	private BookController bookController;

	public RentController() {
		realTimeScreen = TABLE;
	}

	public void setWindow(RentCRUDWindow window) {
		this.window = window;

	}

	public void view() {
		RentPanel panelTable = this.window.getRentPanel();
		RentRegisterPanel form = window.getRegisterPanel();
		RentTableModel tableModel = (RentTableModel) panelTable.getRentTable().getModel();

		selectLine = panelTable.getRentTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "Não há nenhum elemento selecionado na tabela");
			return;
		}
		Book bookTemp = tableModel.getBook(selectLine);
		form.loadData(Long.toString(bookTemp.getIsbn()), bookTemp.getName(), bookTemp.getPublishingCompany(),
				bookTemp.getWriter(), bookTemp.getYear());
		form.getRegisterPanelLabel().setText("Visualizar Livro");
		form.getSaveButton().setVisible(true);
		form.getSaveButton().setText("Alugar");

		realTimeScreen = VIEWFORM;
		this.window.showPanel(RentCRUDWindow.PANELFORM);
	}

	public void save(long cpf) {
		RentPanel panelTable = this.window.getRentPanel();
		RentTableModel tableModel = (RentTableModel) panelTable.getRentTable().getModel();
		try {
			clientController = new ClientController();
			Client client = clientController.searchByCpf(cpf);
			if (client.getBooksRent() == 3) {
				messengerJFrame.printErrorMessage(window, "Cliente já possui maximo de livros alugados!");
				return;
			} else {
				Date dateFormat = new Date();
				java.sql.Date dataSql;
				dateFormat = new java.sql.Date(dateFormat.getTime());
				dataSql = (java.sql.Date) dateFormat;
				selectLine = panelTable.getRentTable().getSelectedRow();
				int id = tableModel.getBook(selectLine).getId();
				bookController = new BookController();
				Book bookTemp = bookController.searchBookById(id);
				if (bookTemp.isAvaliable() == false) {
					messengerJFrame.printErrorMessage(window, "Livro já está alugado!");
					return;
				} else {
					RentDAO dao = new RentDaoBd();
					dao.save(new Rent(dateFormat, client, bookTemp));
					messengerJFrame.printSucessMesenge(window, "Livro alugado com sucesso!");

				}
			}
		} catch (Exception e) {
			messengerJFrame.printErrorMessage(window, "Campo inválido!");
		}
	}

	public void backToMainScreen() {
		realTimeScreen = TABLE;
		this.updateTable();
		this.window.showPanel(RentCRUDWindow.PANELTABLE);
	}

	public void updateTable() {
		RentPanel rentPanel = this.window.getRentPanel();
		RentTableModel tableModel = (RentTableModel) rentPanel.getRentTable().getModel();

		BookDAO dao = new BookDaoBd();
		tableModel.setBook(dao.list());

		rentPanel.getRentTable().updateUI();
	}

	public boolean codeExist(int id) {
		RentDAO dao = new RentDaoBd();
		Rent rent = dao.searchById(id);
		if (rent != null) {
			return true;
		} else {
			return false;
		}
	}

	public void addRent(Rent rent) {
		new RentDaoBd().save(rent);
	}

	public List<Rent> listRent() {
		return (new RentDaoBd().list());
	}

	public Rent searchById(int id) {
		RentDAO dao = new RentDaoBd();
		Rent rent = dao.searchById(id);
		return rent;
	}

	public void showRent() {
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-20s", "|Código do Aluguel") + "\t"
				+ String.format("%-20s", "|Nome do cliente") + String.format("%-20s", "  |Titulo do livro alugado")
				+ String.format("%-20s", "    |Data do aluguel:"));
		for (Rent rent : listRent()) {
			System.out.println(String.format("%-10s", rent.getId()) + "\t"
					+ String.format("%-20s", "        |" + rent.getClient().getName()) + "\t"
					+ String.format("%-20s", "      |" + rent.getBooksRent().getName() + "\t" + String.format("%-20s",
							"                  |" + DateUtil.dateToString(rent.getRentData()))));
		}
	};

}