package register;

import profile.Rent;
import util.ConsoleReader;
import util.DeadLineCreation;

public class DevolutionRegister {
	DeadLineCreation dead = new DeadLineCreation();

	public void addNewDevolution(Rent r) {
		try {
			Integer codeDevolution = ConsoleReader.scanInt("Type the rent code");
			if (codeDevolution == r.getCodRent()) {
				char op = ConsoleReader.scanChar("Renew the DeadLine fot the book (Y/N)");
				if (op == 'N') {
					r.getBookRent().setAvaliable(true);
					System.out.println("\nBook was sucessfull return\n");
					dead.hasExpired();
				} else if (op == 'Y') {
					dead.renewRent();
					System.out.println("\nDead Line Was extend to : " + dead.createNewData() + "\n");
				}

			} else
				System.out.println("Wrong code !");
		} catch (Exception e) {
			System.out.println("Code not Found " + e);

		}

	}

}
