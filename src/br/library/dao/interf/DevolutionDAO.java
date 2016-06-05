package br.library.dao.interf;

import java.util.List;

import br.library.domain.profile.Devolution;

public interface DevolutionDAO {
	public void insert(Devolution devolution, boolean late);

	public void updateClient(Devolution devolution);

	public void updateBook(Devolution devolution);

	public List<Devolution> list();

	public Devolution procurarPorId(int id);

	public void atualizarAtrasoCliente(Devolution devolution);
}
