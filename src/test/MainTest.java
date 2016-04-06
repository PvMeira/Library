package test;

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

		System.out.println("--TEST--");
		System.out.println("--ADD new Rent--");
		rentR.addNew();

		DevolutionRegister devo = new DevolutionRegister();
		devo.addNew();

	}

}
