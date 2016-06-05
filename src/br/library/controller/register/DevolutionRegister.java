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
            int idRent = ConsoleReader.scanInt("Digite o c�digo do aluguel do livro que deseja devolver: ");
            if (serviceB.IdExist(idRent) == true) {
                System.out.println("N�o existe livro alugado com este c�digo ");
                return;
            }
            Rent rent = serviceB.searchByCode(idRent);
            Date data = new Date();
            data = Date.from(Instant.now());
            int numberOfDays = serviceA.diferenceOfTime(rent, data);
            if (numberOfDays > 7) {
                double charge = 1.00 * numberOfDays;
                System.out.println("Cliente est� com livro atrasado, quitar multa no valor de  " + charge + " com a administra��o!");
                late = true;
            }
            serviceA.addNewDevolution(new Devolution(rent, data),late);
            System.out.println("Livro devolvido com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inv�lida!");
        }
    }
}