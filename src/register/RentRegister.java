package register;

import profile.Book;
import profile.Client;
import profile.Rent;
import repository.BookRepository;
import repository.RentRepository;
import util.ConsoleReader;
import util.TokenCreation;
import util.deadLineCreation;

public class RentRegister {
	Book b = new Book();
	Client c = new Client();

	TokenCreation t = new TokenCreation();

	public void addNewRent() {
		try {
			Integer cod = ConsoleReader.scanInt("Type the ISBN of the book :");
			BookRepository.getInstance().searchByCode(cod);
			if (b.isAvaliable()) {
				if (c.getCountClientBooksRent() > 3) {
					int cod1 = t.codRentCreation();
					deadLineCreation dead = new deadLineCreation();
					dead.getDeadLine();
					Rent r = new Rent(c, BookRepository.getInstance().getBook(), cod1, dead.getDateFormatter());
					RentRepository.getInstance().add(r);
					b.setAvaliable(false);
					b.countUP();
					c.countUP();
					c.countUPForReport();
					System.out.println("You rent was successful ! ");

				} else {
					System.out.println("Sorry, but this Client already has 3 books rent");
				}
			} else {
				System.out.println("Sorry, but this book is already rent");
			}
		} catch (Exception e) {
			System.out.println("TheISBN code wasn´t not found " + e);
		}

	}

}
