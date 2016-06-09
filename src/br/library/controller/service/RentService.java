package br.library.controller.service;
/**
 * @author Pedro
 *
 */
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
		Rent rent = dao.searchById(id);
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
	  public void changeStatusOnRent(Rent rent){
	    	dao.updateRentStatus(rent);
	    }

	public Rent searchByCode(int id) {
		Rent rent = dao.searchById(id);
		return rent;
	}
	public void deleteRent(Rent rent){
		dao.delete(rent);
	}
	public List<Rent> listAllAvaliableRents(){
		return dao.listAllAvaliableRents();
	}

}
