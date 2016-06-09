package br.library.dao.interf;
/**
 * @author Pedro
 *
 */
import java.util.List;

public interface dao<T> {
	public void save(T dominio);

	public void delete(T paciente);

	public void update(T paciente);

	public List<T> list();

	public T searchByID(int id);
}
