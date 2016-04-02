package profile;

public class Client {

	// - Cadastro de clientes: cliente contém como informação a
	// matrícula, o nome e telefone.
	private String token;
	private String clientName;
	private String clientPhone;

	public Client(String string, String clientName, String clientPhone) {

		this.token = string;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
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

	@Override
	public String toString() {
		return "Client token  : " + token + "\nClient Name   :" + clientName + "\nClient Phone  :" + clientPhone;
	}

}
