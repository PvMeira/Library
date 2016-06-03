package br.library.controller.register;

import java.util.List;

import br.library.controller.service.ClientService;
import br.library.domain.profile.Book;
import br.library.domain.profile.Client;
import br.library.infra.persistence.setup.UIUtil;
import br.library.infra.util.ConsoleReader;
import br.library.infra.util.CustomExeption;

public class ClientRegister {
	private ClientService clientService;

	public void registerNewClient() {
		clientService = new ClientService();
		String name = ConsoleReader.scanString("Nome: ");
		String phone = ConsoleReader.scanString("Telefone: ");
		int registration = ConsoleReader.scanInt("Codigo Funcionario: ");

		try {
			clientService.save(new Client(name, registration, phone));
			System.out.println("Cliente " + name + "Cadastrado com sucesso!");
		} catch (CustomExeption e) {

			System.out.println("Invalid format InPut :" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void listClient() {
		clientService = new ClientService();
		List<Client> listClients = ClientService.list();
		this.showClientList(listClients);
	}

	public void showClient(Client b) {
		clientService=new ClientService();
		System.out.println("--------------");
		System.out.println("Cliente");
		System.out.println("Nome: " + b.getName());
		System.out.println("Telefone: " + b.getPhone());
		System.out.println("Matricula " + b.getRegistration());
		System.out.println("---------------");
	}

	public void showClientList(List<Client> listClient) {
		clientService = new ClientService();
		if (listClient.isEmpty()) {
			System.out.println("Nenhum Cliente cadastrado");
		} else {
			System.out.println("------------------------");
			System.out.println(String.format("%-10s", "Nome") + "\t" + String.format("%-20s", "|Telefone") + "\t"
					+ String.format("%-20s", "|Matricula"));

			for (Client client : listClient) {
				System.out.println(
						String.format("%-10s", client.getName()) + "\t" + String.format("%-20s", client.getPhone())
								+ "\t" + String.format("%-20s", client.getRegistration()));
			}
		}

	}

	public void updateBook() {
		clientService = new ClientService();
		int registration = ConsoleReader.scanInt("Matricula do cliente a ser atualizado: ");
		try {
			Client client = clientService.SerachByRegister(registration);
			this.showClient(client);
			System.out.println("Digite as informações do Cliente que deseja alterar[Vazio caso nao queira]");
			String name = ConsoleReader.scanString("Nome:");
			String phone = ConsoleReader.scanString("Telefone:");
			int registration1 = ConsoleReader.scanInt("Matricula:");
			if (!name.isEmpty()) {
				client.setName(name);
				;
			}
			if (!phone.isEmpty()) {
				client.setPhone(phone);
			}
			if (registration1 != 0) {
				client.setRegistration(registration1);
			}

			clientService.update(client);
			System.out.println("Cliente " + name + " atualizado com sucesso");

		} catch (CustomExeption e) {
			UIUtil.showError(e);
		}
	}

	public void searchClientByName() {
		clientService = new ClientService();
		String name = ConsoleReader.scanString("Nome :");
		try {
			List<Client> listClient = clientService.SerachByName(name);
			this.showClientList(listClient);
		} catch (CustomExeption e) {
			UIUtil.showError(e.getMessage());
		}
	}

	public void deleteClient() {
		clientService = new ClientService();
		int registration = ConsoleReader.scanInt("Codigo Isbc do livro a ser deletado:");
		try {
			Client client = clientService.SerachByRegistration(registration);
			this.showClient(client);
			if (UIUtil.getConfirmation("Realmente deseja deleter este registro?")) {
				clientService.delete(client);
				System.out.println("Cadastro de Cliente deletado com sucesso");
			} else {
				System.out.println("Operação cancelada");
			}

		} catch (CustomExeption e) {
			UIUtil.showError(e.getMessage());
		}
	}
}
