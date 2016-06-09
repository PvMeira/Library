package br.library.dao.interf;
/**
 * @author Pedro
 *
 */
import java.util.List;

import br.library.domain.profile.Devolution;

public interface DevolutionDAO {
	public void insert(Devolution devolution, boolean late);

	public void updateClient(Devolution devolution);

	public void updateBook(Devolution devolution);

	public List<Devolution> list();

	public Devolution searchById(int id);

	public void ClientUpdateDelay(Devolution devolution);
}
