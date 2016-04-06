package profile;

public class Client {

	// - Cadastro de clientes: cliente contém como informação a
	// matrícula, o nome e telefone.
	private String token, clientName, clientPhone;
	private Integer countClientBooksRent, clientBooksRent;

	public Client(String string, String clientName, String clientPhone) {

		this.token = string;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.countClientBooksRent = 0;
		this.clientBooksRent = 0;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Integer getCountClientBooksRent() {
		return countClientBooksRent;
	}

	public void setCountClientBooksRent(Integer countClientBooksRent) {
		this.countClientBooksRent = countClientBooksRent;
	}

	public Integer getClientBooksRent() {
		return clientBooksRent;
	}

	public void setClientBooksRent(Integer clientBooksRent) {
		this.clientBooksRent = clientBooksRent;
	}

	public void countUP() {
		this.countClientBooksRent = +1;
	}

	public void countDOWN() {
		this.countClientBooksRent = -1;
	}

	public void countUPForReport() {
		this.clientBooksRent = +1;
	}

	public void countDOWNForReport() {
		this.clientBooksRent = -1;
	}

	@Override
	public String toString() {
		return "Client token  : " + token + "\nClient Name   :" + clientName + "\nClient Phone  :" + clientPhone;
	}

}
