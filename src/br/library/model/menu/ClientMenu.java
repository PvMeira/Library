package br.library.model.menu;

import br.library.controller.register.ClientRegister;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.ClientMenuLayOut;

public class ClientMenu {
	ClientMenuLayOut menu = new ClientMenuLayOut();
	ClientRegister b = new ClientRegister();

	public void clientMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("digite a opção :");

				switch (op) {
				case 1:
					b.registerNewClient();
					System.out.println("Livro adicionado");
					break;
				case 2:
					b.deleteClient();
					System.out.println("Livro deletado");
					break;
				case 3:
					b.updateClient();
					System.out.println("Livro atualizado");
					break;
				case 4:
					b.listClient();
					System.out.println("Listar todos livros existentes...");				
					break;

				case 5:
					System.out.println("Consultar livro pelo nome");
					b.searchClientByName();
					break;

				case 6:
					System.out.println("Sair");
					

				default:
					System.out.println("opção Inválida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inválido, apenas numeros aceitos!");
			}
		} while (op != 6);

	}
}
