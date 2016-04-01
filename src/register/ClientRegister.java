package register;

import java.util.Scanner;

import profile.Client;
import repository.ClientRepository;
import util.TokenCreation;

public class ClientRegister implements register<Client>{
	Scanner read = new Scanner(System.in);
	@Override
	public void addNew() {
	TokenCreation token=new TokenCreation();
	String nameClient = read.nextLine();
	String TelephoneClient = read.nextLine();
	Client client=new Client(token.nextSessionId(), nameClient, TelephoneClient);
	ClientRepository.getInstance().add(client);	
	}

}
