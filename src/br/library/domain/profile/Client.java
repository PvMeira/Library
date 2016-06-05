package br.library.domain.profile;

public class Client {

	private int id, booksRent, quantityOfBooksRent, late;
	private String name, phone;
	private Long register, cpf;

	public Client(String nameRe, long cpfRe, String phoneRe, Long registerRe) {
		this.name = nameRe;
		this.cpf = cpfRe;
		this.phone = phoneRe;
		this.register = registerRe;
		this.booksRent = 0;
		this.quantityOfBooksRent = 0;
		this.late = 0;
	}

	public Client(int idIn, String nomeIn, long rgIn, String telefoneIn, long matriculaIn) {
		this.id = idIn;
		this.name = nomeIn;
		this.cpf = rgIn;
		this.phone = telefoneIn;
		this.register = matriculaIn;
		this.booksRent = 0;
		this.quantityOfBooksRent = 0;
		this.late = 0;
	}

	public Client(int idIn, String nomeIn, long rgIn, String telefoneIn, long matriculaIn, int livrosAlugadosIn,
			int qntdelivrosalugadosIn, int qntdeatrasoIn) {
		this.id = idIn;
		this.name = nomeIn;
		this.cpf = rgIn;
		this.phone = telefoneIn;
		this.register = matriculaIn;
		this.booksRent = livrosAlugadosIn;
		this.quantityOfBooksRent = qntdelivrosalugadosIn;
		this.late = qntdeatrasoIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBooksRent() {
		return booksRent;
	}

	public void setBooksRent(int booksRent) {
		this.booksRent = booksRent;
	}

	public int getQuantityOfBooksRent() {
		return quantityOfBooksRent;
	}

	public void setQuantityOfBooksRent(int quantityOfBooksRent) {
		this.quantityOfBooksRent = quantityOfBooksRent;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getRegister() {
		return register;
	}

	public void setRegister(Long register) {
		this.register = register;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "livros alugados=" + booksRent + "\nQuantidade de livros alugados" + quantityOfBooksRent + "\nEm atraso"
				+ late + "\nNome" + name + "\nTelefoen" + phone + "\nRegistro" + register + "\nCPF=" + cpf;
	}

}