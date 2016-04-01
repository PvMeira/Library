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
//		autor(es), editora e ano de publicação. Autor(es) e editora podem
//		ser relacionados como String.
//		- Cadastro de clientes: cliente contém como informação a
//		matrícula, o nome e telefone.
//		- Retirada de livros: registra a retirada de livros de um cliente. Um
//		cliente pode retirar no máximo três livros e o livro deve estar
//		disponível na biblioteca. Essa funcionalidade calcula uma data
//		para entrega.
//		- Devolução de livros: registra a devolução de livros de um
//		cliente. Durante a devolução, o livro torna-se disponível
//		novamente na biblioteca. Verifica se o livro está com atraso e
//		calcula o número de dias de atraso.
//		- Relatórios: por livros, livros disponíveis, livros mais retirados,
//		clientes que mais retiraram um livro, clientes que mais atrasaram,
//		etc.
}
