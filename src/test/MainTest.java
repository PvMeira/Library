package test;

import profile.Book;
import profile.Client;
import profile.Rent;
import register.BookRegister;
import register.ClientRegister;
import register.DevolutionRegister;
import register.RentRegister;

public class MainTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		BookRegister bookR = new BookRegister();
		ClientRegister clientR = new ClientRegister();
		RentRegister rentR = new RentRegister();
		System.out.println("--TEST--");
		System.out.println("--ADD new Book--");

		bookR.addNew();
		System.out.println("--TEST--");
		System.out.println("--ADD new Client--");
		clientR.addNew();
		Client c = new Client("test", "test", "tets");
		Book b = new Book(1, "test", "test", "test", 9000);
		System.out.println("--TEST--");
		System.out.println("--ADD new Rent--");
		rentR.addNewRent(c, b);
		Rent r = new Rent(c, b, 12, null);
		DevolutionRegister devo = new DevolutionRegister();
		devo.addNewDevolution(r);

	}

}
