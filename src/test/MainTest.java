package test;

import profile.Book;
import profile.Client;
import register.BookRegister;
import register.ClientRegister;
import register.RentRegister;

public class MainTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		BookRegister bookR = new BookRegister();
		ClientRegister clientR = new ClientRegister();
		RentRegister rentR = new RentRegister();

		bookR.addNew();
		clientR.addNew();
		Client c = new Client("test", "test", "tets");
		Book b = new Book(1, "test", "test", "test", 9000);
		rentR.addNewRent(c, b);
		// add devolution

	}

}
