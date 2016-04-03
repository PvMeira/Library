package test;

import profile.Client;
import register.BookRegister;
import register.ClientRegister;
import register.RentRegister;

public class MainTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    BookRegister bookR=new BookRegister();
    ClientRegister clientR=new ClientRegister();
    RentRegister rentR=new RentRegister();
    
    bookR.addNew();
    clientR.addNew();  
    rentR.addNewRent();
    
	}

}
