package br.library.model.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.library.dao.impl.ClientDAOBd;
import br.library.dao.interf.ClientDAO;
import br.library.domain.profile.Client;
import br.library.infra.util.messengerJFrame;
import br.library.model.view.client.ClientCRUDWindow;
import br.library.model.view.client.ClientPanel;
import br.library.model.view.client.ClientTableModel;
import br.library.model.view.client.RegisterClientPanel;

public class ClientController {

	private final static int TABLE = 0;
	private final static int REGISTERFORM = 1;
	private final static int EDITFORM = 2;
	private final static int VIEWFORM = 3;

	private int realTimeScrenn = 0;
	private int selectLine = -1;

	private ClientCRUDWindow window;

	public ClientController() {
		realTimeScrenn = TABLE;
	}

	public void setWindow(ClientCRUDWindow window) {
		this.window = window;
	}

	public void insert() {
		RegisterClientPanel form = this.window.getPanelForm();

		form.clean();

		form.getLabelRegisterPanel().setText("Cadastrar Cliente");
		form.getSaveButton().setVisible(true);
		form.getSaveButton().setText("Cadastrar");
		form.toggleClientFormEdit(true);

		realTimeScrenn = REGISTERFORM;
		this.window.showPanel(ClientCRUDWindow.PANELFORM);
	}

	public void edit() {
		ClientPanel tablePanel = this.window.getPanelTable();
		RegisterClientPanel painelForm = this.window.getPanelForm();
		ClientTableModel tableModel = (ClientTableModel) tablePanel.getClientsTable().getModel();

		selectLine = tablePanel.getClientsTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "não há nenhum elemento selecionado na tabela");
			return;
		}
		Client cli = tableModel.getClient(selectLine);
		painelForm.loadData(Long.toString(cli.getCpf()), cli.getName(), cli.getPhone());

		painelForm.getLabelRegisterPanel().setText("Editar Cliente");
		painelForm.getSaveButton().setVisible(true);
		painelForm.getSaveButton().setText("Editar");
		painelForm.toggleClientFormEdit(true);

		realTimeScrenn = EDITFORM;
		this.window.showPanel(ClientCRUDWindow.PANELFORM);
	}

	public void view() {
		ClientPanel tablePanel = this.window.getPanelTable();
		RegisterClientPanel painelForm = this.window.getPanelForm();
		ClientTableModel tableModel = (ClientTableModel) tablePanel.getClientsTable().getModel();

		selectLine = tablePanel.getClientsTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "n�o h� nenhum elemento selecionado na tabela");
			return;
		}
		Client cli = tableModel.getClient(selectLine);
		painelForm.loadData(Long.toString(cli.getCpf()), cli.getName(), cli.getPhone());

		painelForm.getLabelRegisterPanel().setText("Visualizar Cliente");
		painelForm.getSaveButton().setVisible(false);
		painelForm.getSaveButton().setText("");
		painelForm.toggleClientFormEdit(false);

		realTimeScrenn = VIEWFORM;
		this.window.showPanel(ClientCRUDWindow.PANELFORM);
	}

	public void remove() {
		ClientPanel panelTable = this.window.getPanelTable();
		ClientTableModel tableModel = (ClientTableModel) panelTable.getClientsTable().getModel();
		selectLine = panelTable.getClientsTable().getSelectedRow();
		if (selectLine < 0) {
			messengerJFrame.printErrorMessage(window, "n�o h� nenhum elemento selecionado na tabela");
			return;
		}
		Client cli = tableModel.getClient(selectLine);
		if (cli.getBooksRent() > 0) {
			messengerJFrame.printErrorMessage(window,
					"Cliente possui livros alugados, para cancelar cadastro � necessario devolver todos os livros antes");
			return;
		} else {
			ClientDAO dao = new ClientDAOBd();
			dao.delete(cli);
			messengerJFrame.printSucessMesenge(window, "Cadastro Removido com  sucesso!");

			this.updateTable();
		}
	}

	public void save(String cpf, String name, String phone) {
		RegisterClientPanel panelFORM = this.window.getPanelForm();
		ClientPanel panelTable = this.window.getPanelTable();
		ClientTableModel tableModel = (ClientTableModel) panelTable.getClientsTable().getModel();
		try {
			long cpfTemp = Long.parseLong(cpf);
			String nameTemp = name, phoneTemp = phone;
			if (realTimeScrenn == REGISTERFORM) {
				if (clientExist(cpfTemp)) {
					messengerJFrame.printErrorMessage(window, "CPF j� existe");
				} else if (cpfValidator(cpfTemp) == false) {
					messengerJFrame.printErrorMessage(window, "CPF � inv�lido");
				} else {
					if (!nameValidator(nameTemp) || name == null) {
						messengerJFrame.printErrorMessage(window, "Nome � inv�lido");
					} else {
						if (isPhone(phoneTemp) != true || phone == null) {
							messengerJFrame.printErrorMessage(window,
									"Numero de telefone inv�lido Digite no formato (xx) xxxx-xxxx: ");
							return;
						}
						long register;
						do {
							register = generateRegister();
						} while (registerExist(register) == true);
						Client client = new Client(nameTemp, cpfTemp, phoneTemp, register);
						ClientDAO dao = new ClientDAOBd();
						dao.insert(client);
						messengerJFrame.printSucessMesenge(window, "Cadastro realizado com sucesso!");
						panelFORM.clean();
					}
				}
			} else if (realTimeScrenn == EDITFORM) {
				if (clientExist(cpfTemp)) {
					messengerJFrame.printErrorMessage(window, "RG já existe.");
				} else if (cpfValidator(cpfTemp) == false) {
					messengerJFrame.printErrorMessage(window, "RG é inválido!");
				} else {
					if (!nameValidator(nameTemp) || name == null) {
						messengerJFrame.printErrorMessage(window, "Nome é inválido!");
					} else {
						if (isPhone(phoneTemp) != true || phone == null) {
							messengerJFrame.printErrorMessage(window,
									"Numero de telefone inválido Digite no formato (xx) xxxx-xxxx: ");
							return;
						}
						selectLine = panelTable.getClientsTable().getSelectedRow();
						int idCli = tableModel.getClient(selectLine).getId();
						Client client = new Client(nameTemp, cpfTemp, phoneTemp);
						ClientDAO dao = new ClientDAOBd();
						dao.updateClientWithID(client, idCli);
						;
						messengerJFrame.printSucessMesenge(window, "Edição realizada com sucesso!");
					}
				}
			}
		} catch (Exception e) {
			messengerJFrame.printErrorMessage(window, "CPF inválido!");
		}
	}

	public void goBackToMainScrenn() {
		realTimeScrenn = TABLE;
		this.updateTable();
		this.window.showPanel(ClientCRUDWindow.PANELTABLE);
	}

	public void updateTable() {
		ClientPanel panelTable = this.window.getPanelTable();
		ClientTableModel tableModel = (ClientTableModel) panelTable.getClientsTable().getModel();

		ClientDAO dao = new ClientDAOBd();
		tableModel.setClient(dao.list());

		panelTable.getClientsTable().updateUI();
	}

	public boolean clientExist(long cpf) {
		ClientDAO dao = new ClientDAOBd();
		Client client = dao.searchByCpf(cpf);
		if (client != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean registerExist(long register) {
		ClientDAO dao = new ClientDAOBd();
		Client client = dao.searchByRegister(register);
		if (client != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean nameExist(String name) {
		ClientDAO dao = new ClientDAOBd();
		Client client = dao.searchByName(name);
		if (client != null) {
			return true;
		} else {
			return false;
		}
	}

	public long generateRegister() {
		Date n = new Date();
		long registerNumber = n.getTime();
		return registerNumber;
	}

	public List<Client> listClients() {
		return (new ClientDAOBd().list());
	}

	public Client searchByCpf(long cpf) {
		ClientDAO dao = new ClientDAOBd();
		Client client = dao.searchByCpf(cpf);
		return (client);
	}

	public Client searchClientByName(String name) {
		ClientDAO dao = new ClientDAOBd();
		Client client = dao.searchByName(name);
		return (client);
	}

	public boolean nameValidator(String reciveName) {
		reciveName = reciveName.trim();
		boolean espaces = false;

		for (int i = 0; i < reciveName.length(); i++) {
			char carac = reciveName.charAt(i);
			if (Character.isLetter(carac) || Character.isWhitespace(carac)) {
				if (Character.isWhitespace(carac)) {
					espaces = true;
				}
			} else {
				return false;
			}
		}
		return espaces == true;
	}

	public boolean cpfValidator(long cpf) {
		if (cpf >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPhone(String newPhone) {
		return newPhone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
				|| newPhone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
	}

	public List<Client> clientsWhoMostRent() {
		List<Client> listaClienteTemp = new ClientDAOBd().list();
		Collections.sort(listaClienteTemp, new ClientCompateRent());
		return listaClienteTemp;
	}

	public List<Client> clientesQueMaisAtrasam() {
		List<Client> listaClienteTemp = new ClientDAOBd().list();
		Collections.sort(listaClienteTemp, new ClientCompateLate());
		return listaClienteTemp;
	}

	public class ClientCompateRent implements Comparator<Client> {

		@Override
		public int compare(Client c1, Client c2) {
			return c2.getQuantityOfBooksRent() - c1.getQuantityOfBooksRent();
		}
	}

	public class ClientCompateLate implements Comparator<Client> {

		@Override
		public int compare(Client c1, Client c2) {
			return c2.getLate() - c1.getLate();
		}
	}
}
