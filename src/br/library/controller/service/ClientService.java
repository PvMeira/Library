package br.library.controller.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.library.dao.impl.ClientDAOBd;
import br.library.dao.interf.ClientDAO;
import br.library.domain.profile.Client;

public class ClientService {
	private ClientDAO dao;

	public ClientService() {

		dao = new ClientDAOBd();
	}

	public boolean clientExist(long cpf) {
		Client client = dao.searchByCpf(cpf);
		if (client != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean registerExist(long register) {
		Client client = dao.searchByRegister(register);
		if (client != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean nameExist(String name) {
		Client client = dao.searchByName(name);
		if (client != null) {
			return true;
		} else {
			return false;
		}
	}

	public long registerRandom() {
		Date n = new Date();
		long registerNumber = n.getTime();
		return registerNumber;
	}

	public long registerGenerator() {
		long register = registerRandom();
		return register;
	}

	public void addClient(Client c) {
		new ClientDAOBd().insert(c);
	}

	public List<Client> listClients() {
		return (new ClientDAOBd().list());
	}

	public Client searchByCpf(long cpf) {

		Client client = dao.searchByCpf(cpf);
		return (client);
	}

	public Client searchClientByName(String name) {

		Client client = dao.searchByName(name);
		return (client);
	}

	public void editClient(String op, String newValue, Client c) {
		if (op.equals("1")) {
			dao.update(c, newValue, "name");
		}
		if (op.equals("2")) {
			dao.update(c, newValue, "phone");
		}
	}

	public void editClient(String op, long newValue, Client c) {
		if (op.equals("3")) {
			dao.update(c, newValue, "cpf");
		}
	}

	public void deleteClient(Client c) {
		dao.delete(c);
	}

	public boolean nameValidation(String name) {
		// usei para remover os espaço que existem na string
		name = name.trim();
		boolean blank = false;

		for (int i = 0; i < name.length(); i++) {
			char carac = name.charAt(i);
			// vai determinar se o caracter é uma letra e ooutro e para
			// determinar os espaços em branco
			if (Character.isLetter(carac) || Character.isWhitespace(carac)) {
				if (Character.isWhitespace(carac)) {
					blank = true;
				}
			} else {
				return false;
			}
		}
		return blank == true;
	}

	public boolean isPhone(String phone) {
		// vai validar se o telefone digitado contem numero
		return phone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
				|| phone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
	}

	public void clientsWhoMostRent() {
		List<Client> clientListRank = new ClientDAOBd().list();
		Collections.sort(clientListRank, new clientCompareRents());
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-10s", "CPF") + "\t" + String.format("%-20s", "|Nome") + "\t"
				+ String.format("%-20s", "|Telefone") + String.format("%-20s", "|Matrícula")
				+ String.format("%-20s", "|Livros em Alugados no momento")
				+ String.format("%-20s", "|Quantidade de livros alugados")
				+ String.format("%-20s", "    |Quantidade de atrasos"));
		for (Client listOfClient : clientListRank) {
			System.out.println(String.format("%-10s", listOfClient.getCpf()) + "\t"
					+ String.format("%-20s", "|" + listOfClient.getName()) + "\t"
					+ String.format("%-20s", "|" + listOfClient.getPhone() + "\t" + String.format("%-20s",
							"    |" + listOfClient.getRegister() + "\t" + String.format("%-20s",
									"|" + listOfClient.getBooksRent() + "\t" + String.format("%-20s",
											"            |" + listOfClient.getQuantityOfBooksRent() + String.format(
													"%-20s", "                                |"
															+ listOfClient.getLate()))))));
		}
	}

	public void clientsWhoMostDelayed() {
		List<Client> clistListRank = new ClientDAOBd().list();
		Collections.sort(clistListRank, new clientCompareLate());
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-10s", "CPF") + "\t" + String.format("%-20s", "|Nome") + "\t"
				+ String.format("%-20s", "|Telefone") + String.format("%-20s", "|Matrícula")
				+ String.format("%-20s", "|Livros em Alugados no momento")
				+ String.format("%-20s", "|Quantidade de livros alugados")
				+ String.format("%-20s", "    |Quantidade de atrasos"));
		for (Client listOfClients : clistListRank) {
			System.out.println(String.format("%-10s", listOfClients.getCpf()) + "\t"
					+ String.format("%-20s", "|" + listOfClients.getName()) + "\t"
					+ String.format("%-20s", "|" + listOfClients.getPhone() + "\t"
							+ String.format("%-20s", "    |" + listOfClients.getRegister()) + "\t"
							+ String.format("%-20s",
									"|" + listOfClients.getBooksRent() + "\t" + String.format("%-20s",
											"            |" + listOfClients.getQuantityOfBooksRent() + String.format(
													"%-20s", "                                |"
															+ listOfClients.getLate())))));
		}
	}

	public class clientCompareRents implements Comparator<Client> {

		@Override
		public int compare(Client c1, Client c2) {
			return c2.getQuantityOfBooksRent() - c1.getQuantityOfBooksRent();
		}
	}

	public class clientCompareLate implements Comparator<Client> {

		@Override
		public int compare(Client c1, Client c2) {
			return c2.getLate() - c1.getLate();
		}
	}
}
