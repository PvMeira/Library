package util;

import java.util.List;

public interface dao<T> {
	public void salvar(T dominio);

	public void deletar(T paciente);

	public void atualizar(T paciente);

	public List<T> listar();

	public T procurarPorId(int id);
}
