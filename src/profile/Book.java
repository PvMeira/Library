package profile;

public class Book {
	// Funcionalidades:
	// - Cadastro de livros: anota-se para cada livro o ISBN, nome,
	// autor(es), editora e ano de publicação. Autor(es) e editora podem
	// ser relacionados como String.
	private String bookName, writers, publishingCompany;
	private Integer releaseyear, countBookRent, IsbnCode;
	private boolean avaliable;

	public Book(Integer isbnCode, String bookName, String writers, String publishingCompany, int releaseyear) {

		this.IsbnCode = isbnCode;
		this.bookName = bookName;
		this.writers = writers;
		this.publishingCompany = publishingCompany;
		this.releaseyear = releaseyear;
		this.countBookRent = 0;
		this.avaliable = true;
	}

	@Override
	public String toString() {
		return "\nISBN CODE   :" + IsbnCode + "\nBook Name   :" + bookName + "\nWriter(s)   :" + writers
				+ "\nPublishing Company   :" + publishingCompany + "\nRelease Year   :" + releaseyear;
	}

	public Integer getIsbnCode() {
		return IsbnCode;
	}

	public void setIsbnCode(Integer isbnCode) {
		IsbnCode = isbnCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String booksName) {
		bookName = booksName;
	}

	public String getWriters() {
		return writers;
	}

	public void setWriters(String writers) {
		this.writers = writers;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Integer getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(Integer releaseyear) {
		this.releaseyear = releaseyear;
	}

	public Integer getCountBookRent() {
		return countBookRent;
	}

	public void setCountBookRent(Integer countBookRent) {
		this.countBookRent = countBookRent;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable() {
		this.avaliable = false;
	}

	public void countUP() {
		this.countBookRent = +1;
	}

	public void countDOWN() {
		this.countBookRent = -1;
	}

	public void setAvaliableDevolution() {
		this.avaliable = true;
	}

}
