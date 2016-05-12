package register;

/**
 * @author Pedro
 *
 */
import profile.Devolution;
import profile.Rent;
import repository.RentRepository;
import util.ConsoleReader;
import util.DeadLineCreation;

public class DevolutionRegister implements register<Devolution> {
	DeadLineCreation dead = new DeadLineCreation();
	Rent rent;

	@Override
	public void addNew() {
		try {
			Integer codeDevolution = ConsoleReader.scanInt("Type the rent code");
			rent = RentRepository.getInstance().searchByID(codeDevolution);
			if (codeDevolution.equals(rent.getCodRent())) {
				char op = ConsoleReader.scanChar("Renew the DeadLine fot the book (Y/N)");
				if (op == 'N') {
					rent.getBookRent().setAvaliableDevolution();
					rent.getClientWhoRent().countMaxRentDOWN();
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
