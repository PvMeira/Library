package br.library.controller.service;

import java.util.Date;
import java.util.List;

import br.library.dao.impl.DevolutionDaoBd;
import br.library.dao.interf.DevolutionDAO;
import br.library.domain.profile.Devolution;
import br.library.domain.profile.Rent;

public class DevolutionService {
	private DevolutionDAO dao;

	public DevolutionService() {
		dao = new DevolutionDaoBd();
	}
	public void addNewDevolution(Devolution d, boolean late) {
        dao.insert(d, late);
    }

    public List<Devolution> listDevolution() {
        return dao.list();
    }

    public Devolution searchById(int id) {
       
        Devolution devolution = dao.searchById(id);
        return devolution;
    }
 
    public int diferenceOfTime(Rent rent, Date date) {
        long time1 = rent.getRentData().getTime();
        long time2 = date.getTime();
		long timeBetwen = time2 - time1;
        return (int) ((timeBetwen + 60L * 60 * 1000) / (24L * 60 * 60 * 1000)) + 1;
    }
}
