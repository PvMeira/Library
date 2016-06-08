package br.library.controller.register;

import java.time.Instant;
import java.util.Date;
import java.util.InputMismatchException;

import br.library.controller.service.DevolutionService;
import br.library.controller.service.RentService;
import br.library.domain.profile.Devolution;
import br.library.domain.profile.Rent;
import br.library.infra.util.ConsoleReader;

public class DevolutionRegister {
	private DevolutionService serviceA;
	private RentService serviceB;

	public DevolutionRegister() {
		serviceB = new RentService();
		serviceA = new DevolutionService();
	}

	public void addNewDevolution() {
		boolean late = false;
		try {
			int id = ConsoleReader.scanInt("Digite o ID do aluguel do livro que deseja devolver: ");
			if (serviceB.IdExist(id) == false) {
				System.err.println("Não existe livro alugado com este código ");
				return;
			}
			Rent rent = serviceB.searchByCode(id);
			if(!rent.isAvaliable()){
				System.out.println("Desculpe mas este venda, ja foi fechada");
				return;
			}
			Date data = new Date();
			data = Date.from(Instant.now());
			int numberOfDays = serviceA.diferenceOfTime(rent, data);
			if (numberOfDays > 7) {
				double charge = 1.00 * numberOfDays;
				System.out.println("Cliente está com livro atrasado, quitar multa no valor de  " + charge
						+ " com a administração!");
				late = true;
			}
			serviceA.addNewDevolution(new Devolution(rent, data), late);
			serviceB.changeStatusOnRent(rent);
			System.out.println("Livro devolvido com sucesso!");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!");
		}
	}

	public void showDevolution() {
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-20s", "|Código da devolução") + "\t"
				+ String.format("%-20s", "|Nome do cliente") + String.format("%-20s", "  |Titulo do livro alugado")
				+ String.format("%-20s", "    |Data da devolução"));
		for (Devolution devolution : serviceA.listDevolution()) {
			System.out.println(String.format("%-10s", devolution.getId()) + "\t"
					+ String.format("%-20s", "        |" + devolution.getRent().getClient().getName()) + "\t"
					+ String.format("%-20s", "      |" + devolution.getRent().getBooksRent().getName() + "\t")
					+ String.format("%-20s", "      |" + devolution.getDevolutionDate() + "\t"));
		}
	}
	public void listAllAvaliableRents(){
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-20s", "|Código da venda") + "\t"
				+ String.format("%-20s", "|Nome do cliente") + String.format("%-20s", "  |Titulo do livro alugado")
				+ String.format("%-20s", "    |Data do aluguel"));
		for (Rent rent : serviceB.listAllAvaliableRents()) {
			System.out.println(String.format("%-10s", rent.getId()) + "\t"
					+ String.format("%-20s", "        |" + rent.getClient().getName()) + "\t"
					+ String.format("%-20s", "      |" + rent.getBooksRent().getName() + "\t")
					+ String.format("%-20s", "      |" + rent.getRentData() + "\t"));
		}
	}
}
