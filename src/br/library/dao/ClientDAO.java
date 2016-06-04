package br.library.dao;

import java.util.List;

import br.library.domain.profile.Client;

public interface ClientDAO extends dao<Client> {
	public Client searchByRegistration(int rg);

	public List<Client> searchByName(String nome);
}
