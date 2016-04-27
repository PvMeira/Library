package report;

import profile.Client;
import repository.ClientRepository;

public class ClientsReport {
	Client client;

	public String clientsWhoMostRentBooks() {
		client = ClientRepository.getInstance().getClient().stream()
				.max((client1, client2) -> client1.getClientBooksRent().compareTo(client2.getClientBooksRent())).get();
		return "\nThe Client who, most rent books was :" + client.getClientName();
	}

	public String clientsWhoLessRentBooks() {
		client = ClientRepository.getInstance().getClient().stream()
				.min((client1, client2) -> client1.getClientBooksRent().compareTo(client2.getClientBooksRent())).get();
		return "\nThe Client who, less rent books was :" + client.getClientName();
	}

	public String showAllClients() {
		String c = ClientRepository.getInstance().getClient().toString();
		return "\nAll Clients register  are :" + c;
	}

}

