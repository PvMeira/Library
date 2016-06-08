package br.library.domain.profile;

import java.util.Date;

public class Rent {

	private int id;
	private Client client;
	private Book booksRent;
	private Date rentData;
	private boolean avaliable;

	public Rent(Date dataRentRe, Client clientRe, Book booksRe,boolean status) {
		this.rentData = dataRentRe;
		this.client = clientRe;
		this.booksRent = booksRe;
		this.avaliable=status;

	}

	public Rent(int id, Date dataRentRe, Client clientRe, Book booksRe,boolean status) {
		this.id = id;
		this.rentData = dataRentRe;
		this.client = clientRe;
		this.booksRent = booksRe;
		this.avaliable=status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Book getBooksRent() {
		return booksRent;
	}

	public void setBooksRent(Book booksRent) {
		this.booksRent = booksRent;
	}

	public Date getRentData() {
		return rentData;
	}

	public void setRentData(Date rentData) {
		this.rentData = rentData;
	}
	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}

	@Override
	public String toString() {
		return "Rent [id=" + id + ", client=" + client + ", booksRent=" + booksRent + ", rentData=" + rentData
				+ ", avaliable=" + avaliable + "]";
	}

}
