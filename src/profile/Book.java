package profile;

/**
 * @author Pedro
 *
 */
public class Book {
	private String bookName, writers, publishingCompany;
	private Integer releaseyear, countBookRent, IsbnCode;
	private boolean avaliable;
	private int id;

	public Book(Integer isbnCode, String bookName, String writers, String publishingCompany, int releaseyear) {

		this.IsbnCode = isbnCode;
		this.bookName = bookName;
		this.writers = writers;
		this.publishingCompany = publishingCompany;
		this.releaseyear = releaseyear;
		this.countBookRent = 0;
		this.avaliable = true;
	}

	public Book(String bookName, String writers, String publishingCompany, Integer releaseyear, Integer countBookRent,
			Integer isbnCode, boolean avaliable, int id) {

		this.bookName = bookName;
		this.writers = writers;
		this.publishingCompany = publishingCompany;
		this.releaseyear = releaseyear;
		this.countBookRent = countBookRent;
		IsbnCode = isbnCode;
		this.avaliable = avaliable;
		this.id = id;
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
		this.countBookRent = this.countBookRent + 1;
	}

	public void countDOWN() {
		this.countBookRent = this.countBookRent - 1;
	}

	public void setAvaliableDevolution() {
		this.avaliable = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
