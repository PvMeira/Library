package br.library.dao.interf;
/**
 * @author Pedro
 *
 */
import java.util.List;

import br.library.domain.profile.Client;

public interface ClientDAO extends dao<Client> {
	public void insert(Client client);

	public void delete(Client client);

	public void update(Client client, String newX, String colum);

	public void update(Client client, long newX, String colum);
	
	

	public List<Client> list();

	public Client searchById(int id);

	public Client searchByName(String name);
	public Client searchByCpf(long cpf);

	public Client searchByRegister(long register);

	public List<Client> listByName(String name);

	void updateClientWithID(Client client, int id);
}
