package br.library.model.menu;

import br.library.controller.register.DevolutionRegister;
import br.library.infra.util.ConsoleReader;
import br.library.model.menu.LayOut.DevolutionMenuLayOut;

public class DevolutionMenu {

	DevolutionMenuLayOut menu = new DevolutionMenuLayOut();
	DevolutionRegister d = new DevolutionRegister();

	public void devolutionMenu() {
		int op = 0;
		do {
			try {
				System.out.println(menu.getOptionLayOut());
				op = ConsoleReader.scanInt("Digite a opção :");

				switch (op) {
				case 1:
					d.addNewDevolution();
					break;
				case 2:
					MainMenu mainMenu = new MainMenu();
					mainMenu.mainSearch();
				default:
					System.out.println("opção Inválida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inválido, apenas numeros aceitos!");
			}
		} while (op != 2);

	}
}
