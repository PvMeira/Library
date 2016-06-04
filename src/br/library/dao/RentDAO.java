package br.library.dao;

import br.library.domain.profile.Rent;

public interface RentDAO extends dao<Rent> {
	public Rent searchByRentCode(int rg);
}