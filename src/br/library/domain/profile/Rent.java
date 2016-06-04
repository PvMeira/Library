package br.library.domain.profile;

import java.text.DateFormat;

public class Rent {
	private int id;
	private Client client;
	private DateFormat deadLine;
	private Book bookRent;
	private Integer codRent;

	public Rent(int id, Client client, DateFormat deadLine, Book bookRent, Integer codRent) {	
		this.id = id;
		this.client = client;
		this.deadLine = deadLine;
		this.bookRent = bookRent;
		this.codRent = codRent;
	}

	public Rent(Client client, DateFormat deadLine, Book bookRent, Integer codRent) {
		this.client = client;
		this.deadLine = deadLine;
		this.bookRent = bookRent;
		this.codRent = codRent;
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

	public DateFormat getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(DateFormat deadLine) {
		this.deadLine = deadLine;
	}

	public Book getBookRent() {
		return bookRent;
	}

	public void setBookRent(Book bookRent) {
		this.bookRent = bookRent;
	}

	public Integer getCodRent() {
		return codRent;
	}

	public void setCodRent(Integer codRent) {
		this.codRent = codRent;
	}

}
