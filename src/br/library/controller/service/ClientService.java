package br.library.controller.service;

import java.util.List;


import br.library.dao.ClientDAO;
import br.library.dao.ClientDAOBd;
import br.library.domain.profile.Client;

public class ClientService {
	private ClientDAO clientDAO;

	public ClientService() {

		clientDAO = new ClientDAOBd();
	}

	public void save(Client client) throws Exception {
		this.validateObliguefields(client);
		this.validateRegistration(client);
		clientDAO.save(client);

	}

	public Client SerachByRegistration(int register) throws Exception {
		if (register == 0) {
			throw new Exception("Campo Registro nao informado");
		}
		Client b = clientDAO.searchByRegistration(register);
		if (b == null) {
			throw new Exception("Livro nao encontrando");
		}
		return (b);
	}

	public List<Client> list() {

		return (clientDAO.list());
	}

	public void delete(Client client) throws Exception {
		if (client == null || client.getRegistration() == 0) {
			throw new Exception("Livro não existe");
		}
		clientDAO.delete(client);
	}

	public void update(Client client) throws Exception {
		if (client == null || client.getRegistration() == 0) {
			throw new Exception("Cliente não existe");
		}
		this.validateObliguefields(client);
		clientDAO.update(client);

	}

	public List<Client> SerachByName(String name) throws Exception {
		if (name == null || name.isEmpty()) {
			throw new Exception("campo nome nao informado");
		}

		return (clientDAO.searchByName(name));
	}

	public boolean clientExist(int register) {
		Client b = clientDAO.searchByRegistration(register);
		return (b != null);
	}

	private void validateObliguefields(Client b) throws Exception {
		if (b.getName() == null || b.getName().isEmpty()) {
			throw new Exception("Campo nome nao preenchido");
		}

		if (b.getRegistration() == 0) {
			throw new Exception("Campo Registro nao preenchido");
		}
		if (b.getPhone() == null || b.getPhone().isEmpty()) {
			throw new Exception("Campo telefone  nao preenchido");
		}

	}

	private void validateRegistration(Client b) throws Exception {
		if (clientExist(b.getRegistration())) {
			throw new Exception("Registro ja existente");
		}

	}
}
