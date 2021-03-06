package br.library.dao.interf;
/**
 * @author Pedro
 *
 */
import java.util.List;

import br.library.domain.profile.Rent;

public interface RentDAO extends dao<Rent> {
	public void save(Rent rent);

	public void updateClient(Rent rent);

	public void updateBook(Rent rent);

	public void updateQuntityOfBooks(Rent rent);

	public void updateQuantityOfRentBooksByClient(Rent rent);

	public List<Rent> list();
	public List<Rent> listAllAvaliableRents();

	public Rent searchById(int id);
	void updateRentStatus(Rent rent);
}