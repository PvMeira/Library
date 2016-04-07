package register;

import profile.Book;
import profile.Client;
import profile.Rent;
import repository.BookRepository;
import repository.ClientRepository;
import repository.RentRepository;
import util.ConsoleReader;
import util.DeadLineCreation;
import util.TokenCreation;

public class RentRegister implements register<Rent> {

	TokenCreation t = new TokenCreation();
	// FileWriter file = new FileWriter();
	Client client;
	Book book;
	int cod1;

	@Override
	public void addNew() {
		try {

			Integer cod = ConsoleReader.scanInt("Type the ISBN of the book :");
			book = BookRepository.getInstance().searchByCode(cod);
			if (book.isAvaliable() == true) {

				String name = ConsoleReader.scanString("Type the Full name of the client ");
				client = ClientRepository.getInstance().searchByName(name);
				if (client.getToken() != null) {

					if (client.getMaxCountRent() < 3) {

						cod1 = t.codRentCreation();
						DeadLineCreation dead = new DeadLineCreation();
						Rent rent = new Rent(client, book, cod1, dead.getDateFormatter());
						RentRepository.getInstance().add(rent);
						cod1 = rent.getCodRent();
						book.setAvaliable();
						book.countUP();
						client.countMaxRentUP();
						client.countUPForReport();

						System.out.println("Client " + client.getClientName() + "\nRent  was successful\n"
								+ "Book Name :" + book.getBookName() + "\nRent code :" + cod1
								+ "\nThe Date to return the book is :" + dead.createNewData());
						return;
						// char op1 = ConsoleReader.scanChar("Print the note
						// ?(y/n)");
						// if (op1 == 'y') {
						// file.FileWriter();
						// } else {
						// System.out.println("rent finish");
						// }

					} 
					else {
						System.out.println("Sorry, but this Client already has 3 books rent");
					}
				} else {
					System.out.println("Client wasnt found ");
				}

			} else {
				System.out.println("Sorry, but this book is already rent");
			}
		} catch (Exception e) {
			System.out.println("TheISBN code wasn´t not found " + e);
		}

	}

	// public StringBuilder printNote() {
	// StringBuilder builder = new StringBuilder();
	//
	// builder.append("\nClient Name: " + client.getClientName());
	// builder.append("\nBook Name: " + book.getBookName());
	// builder.append("\nRent Code: " + cod1);
	//
	// return builder;
	// }

}
