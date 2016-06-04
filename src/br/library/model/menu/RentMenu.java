package br.library.model.menu;

import br.library.controller.register.RentRegister;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.RentMenuLayOut;

public class RentMenu {
	RentMenuLayOut menu = new RentMenuLayOut();
	RentRegister b = new RentRegister();

	public void rentMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Digite a opção :");

				switch (op) {
				case 1:

					System.out.println("Livro Alugado");
					break;
				case 2:

					System.out.println("Livro Devolvido");
					break;
				case 3:

					System.out.println("Livro renovado");
					break;
				case 4:
					System.out.println("Listar todos os alugueis existentes...");

					break;

				case 5:
					System.out.println("Consultar livro pelo codigo do aluguel");

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
