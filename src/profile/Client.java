package profile;

import data.Telephone;
import util.TokenCreation;

public class Client {
	private TokenCreation token;
	private String clientName;
	private Telephone clientPhone;
	
	public Client(TokenCreation token, String clientName, Telephone clientPhone) {
		
		this.token = token;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
	}
	public TokenCreation getToken() {
		return token;
	}
	public void setToken(TokenCreation token) {
		this.token = token;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Telephone getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(Telephone clientPhone) {
		this.clientPhone = clientPhone;
	}
	@Override
	public String toString() {
		return "Client token" + token + "\nclientName" + clientName + "\nclientPhone=" + clientPhone;
	}
	
	
	
//- Cadastro de clientes: cliente contém como informação a
//	matrícula, o nome e telefone.

}
