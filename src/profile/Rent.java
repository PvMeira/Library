package profile;

import java.text.DateFormat;

public class Rent {
	private Client clientWhoRent;
	private DateFormat deadLine;
	private Book bookRent;
	private Integer codRent;

	public Rent(Client clientWhoRent, Book list, int codRent, DateFormat deadLine) {
		this.clientWhoRent = clientWhoRent;
		this.bookRent = list;
		this.codRent = codRent;
		this.deadLine = deadLine;
	}

	public Client getClientWhoRent() {
		return clientWhoRent;
	}

	public void setClientWhoRent(Client clientWhoRent) {
		this.clientWhoRent = clientWhoRent;
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

	public DateFormat getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(DateFormat deadLine) {
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "Client Who Rent   ;" + clientWhoRent + "Book Rent   ;" + bookRent + "Cod Rent   :" + codRent;
	}

}
