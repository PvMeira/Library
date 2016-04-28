package profile;
/**
 * @author Pedro
 *
 */
public class Client {

	// - Cadastro de clientes: cliente contém como informação a
	// matrícula, o nome e telefone.
	private String token, clientName, clientPhone;
	private Integer counterMaxRent, clientTotalRent;

	public Client(String string, String clientName, String clientPhone) {

		this.token = string;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.counterMaxRent = 0;
		this.clientTotalRent = 0;
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

	public Integer getMaxCountRent() {
		return counterMaxRent;
	}

	public void setMaxCountRent(Integer countClientBooksRent) {
		this.counterMaxRent = countClientBooksRent;
	}

	public Integer getClientBooksRent() {
		return clientTotalRent;
	}

	public void setClientBooksRent(Integer clientBooksRent) {
		this.clientTotalRent = clientBooksRent;
	}

	public void countMaxRentUP() {
		this.counterMaxRent = this.counterMaxRent + 1;
	}

	public void countMaxRentDOWN() {
		this.counterMaxRent = this.counterMaxRent - 1;
	}

	public void countUPForReport() {
		this.clientTotalRent = this.clientTotalRent + 1;
	}

	public void countDOWNForReport() {
		this.clientTotalRent = this.clientTotalRent - 1;
	}

	@Override
	public String toString() {
		return "\n Client token  : " + token + "\nClient Name   :" + clientName + "\nClient Phone  :" + clientPhone;
	}

}
