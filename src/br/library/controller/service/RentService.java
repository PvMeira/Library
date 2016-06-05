package br.library.controller.service;

import java.util.List;

import br.library.dao.impl.RentDaoBd;
import br.library.dao.interf.RentDAO;
import br.library.domain.profile.Rent;

public class RentService {
	private RentDAO dao;

	public RentService() {
		dao = new RentDaoBd();
	}

	public boolean IdExist(int id) {
		Rent rent = dao.searchByID(id);
		if (rent != null) {
			return true;
		} else {
			return false;
		}
	}

	public void addNewRent(Rent a) {
		dao.save(a);
	}

	public List<Rent> ListRent() {
		return dao.list();
	}

	public Rent searchByCode(int id) {

		Rent rent = dao.searchByID(id);
		return rent;
	}

}
