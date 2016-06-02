package main;

import menu.MainMenu;
import util.ConexaoDAO;

public class Main_class {
	public static void main(String[] args) {
		 MainMenu menu = new MainMenu();
		 menu.mainSearch();
		ConexaoDAO.createConnection();
	}

}
	