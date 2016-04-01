package profile;

public class Books {
	
	private String IsbnCode;
	private String BookName;
	private String writers;
	private String publishingCompany;
	private int releaseyear;
	public Books(String isbnCode, String bookName, String writers, String publishingCompany, int releaseyear) {
	
		IsbnCode = isbnCode;
		BookName = bookName;
		this.writers = writers;
		this.publishingCompany = publishingCompany;
		this.releaseyear = releaseyear;
	}
	@Override
	public String toString() {
		return "ISBN CODE:" + IsbnCode + "\nBookName" + BookName + "\nwriters" + writers
				+ "\npublishingCompany" + publishingCompany + "\nreleaseyear" + releaseyear;
	}
	public String getIsbnCode() {
		return IsbnCode;
	}
	public void setIsbnCode(String isbnCode) {
		IsbnCode = isbnCode;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
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
	public int getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}
	
//	Funcionalidades:
//		- Cadastro de livros: anota-se para cada livro o ISBN, nome,
//		autor(es), editora e ano de publica��o. Autor(es) e editora podem
//		ser relacionados como String.
//		- Cadastro de clientes: cliente cont�m como informa��o a
//		matr�cula, o nome e telefone.
//		- Retirada de livros: registra a retirada de livros de um cliente. Um
//		cliente pode retirar no m�ximo tr�s livros e o livro deve estar
//		dispon�vel na biblioteca. Essa funcionalidade calcula uma data
//		para entrega.
//		- Devolu��o de livros: registra a devolu��o de livros de um
//		cliente. Durante a devolu��o, o livro torna-se dispon�vel
//		novamente na biblioteca. Verifica se o livro est� com atraso e
//		calcula o n�mero de dias de atraso.
//		- Relat�rios: por livros, livros dispon�veis, livros mais retirados,
//		clientes que mais retiraram um livro, clientes que mais atrasaram,
//		etc.
}
