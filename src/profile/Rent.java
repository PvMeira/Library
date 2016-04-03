package profile;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Rent {
	private Client clientWhoRent;
	private DateFormat deadLine;
	private List<Book>bookRent;
	private int codRent;

	public Rent(Client clientWhoRent, List<Book> list, int codRent, DateFormat deadLine) {
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

	public List<Book> getBookRent() {
		return bookRent;
	}

	public void setBookRent(List<Book> bookRent) {
		this.bookRent = bookRent;
	}

	public int getCodRent() {
		return codRent;
	}

	public void setCodRent(int codRent) {
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
