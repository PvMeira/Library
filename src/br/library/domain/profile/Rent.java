package br.library.domain.profile;

import java.util.Date;

public class Rent {

	private int id;
	private Client client;
	private Book booksRent;
	private Date rentData;

	public Rent(Date dataRentRe, Client clientRe, Book booksRe) {
		this.rentData = dataRentRe;
		this.client = clientRe;
		this.booksRent = booksRe;

	}

	public Rent(int id, Date dataRentRe, Client clientRe, Book booksRe) {
		this.id = id;
		this.rentData = dataRentRe;
		this.client = clientRe;
		this.booksRent = booksRe;

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

	@Override
	public String toString() {
		return "Rent [id=" + id + ", client=" + client + ", booksRent=" + booksRent + ", rentData=" + rentData + "]";
	}

}
