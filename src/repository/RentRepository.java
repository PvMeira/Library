package repository;

import java.util.List;

import profile.Rent;

public class RentRepository extends AbstractRepository<Rent> {
	private static final RentRepository instance = new RentRepository();

	private RentRepository() {

	}

	public static RentRepository getInstance() {
		return instance;
	}

	public List<Rent> getRent() {
		return getData();
	}

	public Rent searchByID(int idToken) {
		return getRent().stream().filter(id -> id.getCodRent().equals(idToken)).findFirst().get();
	}

}
