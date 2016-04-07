package report;

import profile.Client;
import repository.ClientRepository;

public class ClientsReport {
	Client client;

	public String clientsWhoMostRentBooks() {
		client = ClientRepository.getInstance().getClient().stream()
				.max((client1, client2) -> client1.getClientBooksRent().compareTo(client2.getClientBooksRent())).get();
		return "The Client who, most rent books was :" + client.getClientName();
	}

	public String clientsWhoLessRentBooks() {
		client = ClientRepository.getInstance().getClient().stream()
				.min((client1, client2) -> client1.getClientBooksRent().compareTo(client2.getClientBooksRent())).get();
		return "The Client who, less rent books was :" + client.getClientName();
	}

	public String showAllClients() {
		String c = ClientRepository.getInstance().getClient().toString();
		return "\nAll Clients register  are :" + c;
	}

}
// public String mostRentBook() {
// book = BookRepository.getInstance().getBook().stream()
// .max((book1, book2) ->
// book1.getCountBookRent().compareTo(book.getCountBookRent())).get();
//
// return "The most Rent book was :" + book.getBookName() + "by the author" +
// book.getWriters();
//
// }
