package br.library.domain.profile;

import java.util.Date;

public class Devolution {

	private int id;
	private Date devolutionDate;
	private Rent rent;

	public Devolution() {
		Date data = new Date();
		this.devolutionDate = data;
	}

	public Devolution(Rent rentRe, Date devolutionDate) {
		this.rent = rentRe;
		Date data = new Date();
		this.devolutionDate = data;
	}

	public Devolution(int id, Rent rentRe, Date devolutionDate) {
		this.id = id;
		this.rent = rentRe;
		Date data = new Date();
		this.devolutionDate = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Date de devolução=" + devolutionDate + "\nAluguel" + rent;
	}

}
