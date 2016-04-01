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
	public List<Client>getClient(){
		return getData();
	}
}
