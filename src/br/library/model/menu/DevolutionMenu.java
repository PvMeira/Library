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
				op = ConsoleReader.scanInt("Digite a op��o :");

				switch (op) {
				case 1:
					d.addNewDevolution();
					break;
				case 2:
					MainMenu mainMenu = new MainMenu();
					mainMenu.mainSearch();
				default:
					System.out.println("op��o Inv�lida");
				}
			} catch (Exception e) {

				System.err.println("Formato Inv�lido, apenas numeros aceitos!");
			}
		} while (op != 2);

	}
}
