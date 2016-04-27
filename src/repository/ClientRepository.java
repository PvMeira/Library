package repository;

import java.util.List;

import profile.Client;

public class ClientRepository extends AbstractRepository<Client> {

	private static final ClientRepository instance = new ClientRepository();

	private ClientRepository() {

	}

	public static ClientRepository getInstance() {
		return instance;
	}

	public List<Client> getClient() {
		return getData();
	}

	public Client searchByName(String clientName) {
		return getClient().stream().filter(client -> client.getClientName().equalsIgnoreCase(clientName)).findFirst()
				.get();
	}

	public Client searchByToken(String clientToken) {
		return getClient().stream().filter(Token -> Token.getToken().equals(clientToken)).findFirst().get();
	}

}
