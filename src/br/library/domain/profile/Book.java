package br.library.domain.profile;

/**
 * @author Pedro
 *
 */
public class Book {
	private Long isbn;
	private String name, publishingCompany, writer, year;
	private boolean avaliable = true;
	private int id, totalRentQuantity = 0;

	public Book(Long isbnRe, String name, String publishingCompany, String writer, String year) {
		this.isbn = isbnRe;
		this.name = name;
		this.publishingCompany = publishingCompany;
		this.writer = writer;
		this.year = year;
		this.avaliable = true;
		this.totalRentQuantity = 0;
	}

	public Book(int id, Long isbnRe, String name, String publishingCompany, String writer, String year,
			boolean avaliableRe, int totalRentQuantityRe) {
		this.id = id;
		this.isbn = isbnRe;
		this.name = name;
		this.publishingCompany = publishingCompany;
		this.writer = writer;
		this.year = year;
		this.avaliable = avaliableRe;
		this.totalRentQuantity = totalRentQuantityRe;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalRentQuantity() {
		return totalRentQuantity;
	}

	public void setTotalRentQuantity(int totalRentQuantity) {
		this.totalRentQuantity = totalRentQuantity;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", publishingCompany=" + publishingCompany + ", writer="
				+ writer + ", year=" + year + ", avaliable=" + avaliable + ", id=" + id + ", totalRentQuantity="
				+ totalRentQuantity + "]";
	}

}
