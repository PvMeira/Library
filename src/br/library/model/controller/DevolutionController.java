package br.library.model.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import br.library.dao.impl.BookDaoBd;
import br.library.dao.impl.DevolutionDaoBd;
import br.library.dao.interf.BookDAO;
import br.library.dao.interf.DevolutionDAO;
import br.library.domain.profile.Book;
import br.library.domain.profile.Devolution;
import br.library.domain.profile.Rent;
import br.library.infra.util.DateUtil;
import br.library.infra.util.messengerJFrame;
import br.library.model.view.devolution.DevolutionCRUDWindow;
import br.library.model.view.devolution.DevolutionPanel;
import br.library.model.view.devolution.DevolutionRegiterPanel;
import br.library.model.view.devolution.DevolutionTableModel;

@SuppressWarnings(value = { "all" })
public class DevolutionController {

	private final static int TABLE = 0;
	private final static int REGISTERFORM = 1;
	private final static int EDITFORM = 2;
	private final static int VIEWFORM = 3;

	private int realTimeScreen = 0;
	private int selectLine = -1;

	private DevolutionCRUDWindow devolutionWindow;
	private RentController rentController;
	private BookController bookController;

	public DevolutionController() {
		realTimeScreen = TABLE;
	}

	public void setWindow(DevolutionCRUDWindow window) {
		this.devolutionWindow = window;

	}

	public void view() {
		DevolutionPanel panelTable = this.devolutionWindow.getPanelTable();
		DevolutionRegiterPanel form = devolutionWindow.getRegisterPanel();
		DevolutionTableModel tableModel = (DevolutionTableModel) panelTable.getDevolutionTable().getModel();

		selectLine = panelTable.getDevolutionTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(devolutionWindow, "Não há nenhum elemento selecionado na tabela");
			return;
		}
		Book bookTemp = tableModel.getBook(selectLine);
		form.carregaDados(Long.toString(bookTemp.getIsbn()), bookTemp.getName(), bookTemp.getPublishingCompany(), bookTemp.getWriter(),
				bookTemp.getYear());
		form.getRegisterPanelLabel().setText("Visualizar Livro");
		form.getSaveButton().setVisible(true);
		form.getSaveButton().setText("Devolver");

		realTimeScreen = VIEWFORM;
		this.devolutionWindow.showPanel(DevolutionCRUDWindow.PANELFORM);
	}

	public void save(long cpf, int idRent) {
		boolean late = false;
		DevolutionPanel panelTable = this.devolutionWindow.getPanelTable();
		DevolutionTableModel tableModel = (DevolutionTableModel) panelTable.getDevolutionTable().getModel();
		try {
			rentController = new RentController();
			Rent rentTemp = rentController.searchById(idRent);
			selectLine = panelTable.getDevolutionTable().getSelectedRow();
			if (rentTemp.getClient().getCpf() != cpf) {
				messengerJFrame.printErrorMessage(devolutionWindow, "Você não possui livro alugado com este código!");
				return;
			} else if (rentTemp.getBooksRent().isAvaliable() == true) {
				messengerJFrame.printErrorMessage(devolutionWindow, "Este livro já foi devolvido!");
				return;
			} else {
				Date data = new Date();
				data = Date.from(Instant.now());
				int quantityOfDays = dateDif(rentTemp, data);
				if (quantityOfDays > 7) {
					double multa = 1.00 * quantityOfDays;
					messengerJFrame.printErrorMessage(devolutionWindow,
							"Este livro está atrasado, acerte a multa no valor de " + multa + " com a administração.");
					late = true;
				}
				DevolutionDAO dao = new DevolutionDaoBd();
				dao.insert(new Devolution(rentTemp, data), late);
				messengerJFrame.printSucessMesenge(devolutionWindow, "Livro devolvido com sucesso!");
			}
		} catch (Exception e) {
			messengerJFrame.printErrorMessage(devolutionWindow, "Campo Inválido!");
		}
	}

	public void backToMainMenu() {
		realTimeScreen = TABLE;
		this.updateWindow();
		this.devolutionWindow.showPanel(DevolutionCRUDWindow.PANELTABLE);
	}

	public void updateWindow() {
		DevolutionPanel painelTabela = this.devolutionWindow.getPanelTable();
		DevolutionTableModel tableModel = (DevolutionTableModel) painelTabela.getDevolutionTable().getModel();

		BookDAO dao = new BookDaoBd();
		tableModel.setBook(dao.list());

		painelTabela.getDevolutionTable().updateUI();
	}

	public void addDevolution(Devolution devolution, boolean late) {
		new DevolutionDaoBd().insert(devolution, late);
	}

	public List<Devolution> listDevolution() {
		return (new DevolutionDaoBd().list());
	}

	public Devolution searchById(int id) {
		DevolutionDAO dao = new DevolutionDaoBd();
		Devolution devolucao = dao.searchById(id);
		return devolucao;
	}

	public int dateDif(Rent rent, Date date) {
		long time1 = rent.getRentData().getTime();
		long time2 = date.getTime();
		long diferenceBetwen = time2 - time1;
		return (int) ((diferenceBetwen + 60L * 60 * 1000) / (24L * 60 * 60 * 1000)) + 1;
	}

	public void mostrarDevolucao() {
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-20s", "|Código da devolução") + "\t"
				+ String.format("%-20s", "|Nome do cliente") + String.format("%-20s", "  |Titulo do livro alugado")
				+ String.format("%-20s", "    |Data da devolução"));
		for (Devolution devolucao : listDevolution()) {
			System.out.println(String.format("%-10s", devolucao.getId()) + "\t"
					+ String.format("%-20s", "        |" + devolucao.getRent().getClient().getName()) + "\t"
					+ String.format("%-20s",
							"      |" + devolucao.getRent().getBooksRent().getName() + "\t" + String.format("%-20s",
									"                  |" + DateUtil.dateToString(devolucao.getDevolutionDate()))));
		}
	}

}
