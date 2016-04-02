package register;

import profile.Client;
import repository.ClientRepository;
import util.ConsoleReader;
import util.TokenCreation;

public class ClientRegister implements register<Client> {

	@Override
	public void addNew() {
		TokenCreation token = new TokenCreation();
		String nameClient = ConsoleReader.scanString("Type the Client name:");
		String TelephoneClient = ConsoleReader.scanString("Type the client phone Number (xx)xxxxxxxx <-exemple:");
		Client client = new Client(token.nextSessionId(), nameClient, TelephoneClient);
		ClientRepository.getInstance().add(client);
	}

}