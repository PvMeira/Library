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

public class RentRegister {

	TokenCreation t = new TokenCreation();

	public void addNewRent(Client c, Book b) {
		try {

			Integer cod = ConsoleReader.scanInt("Type the ISBN of the book :");
			Book book = BookRepository.getInstance().searchByCode(cod);
			if (b.isAvaliable() == true) {

				String name = ConsoleReader.scanString("Type the Full name of the client ");
				Client client = ClientRepository.getInstance().searchByName(name);
				if (client.getToken() != null) {

					if (c.getCountClientBooksRent() <= 3) {

						int cod1 = t.codRentCreation();
						DeadLineCreation dead = new DeadLineCreation();
						Rent r = new Rent(c, b, cod1, dead.getDateFormatter());
						RentRepository.getInstance().add(r);
						b.setAvaliable(false);
						b.countUP();
						c.countUP();
						c.countUPForReport();

						System.out.println("Client " + client.getClientName() + "\nRent  was successful\n"
								+ "Book Name :" + book.getBookName() + "The Date for the Client to return is :"
								+ dead.createNewData());

					} else {
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

}
