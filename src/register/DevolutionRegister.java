package register;

import profile.Rent;
import util.ConsoleReader;
import util.deadLineCreation;

public class DevolutionRegister {

	public void addNewDevolution(Rent r) {
		try {
			Integer codDevolution = ConsoleReader.scanInt("Type the rent code");
			if (codDevolution == r.getCodRent()) {
				r.getBookRent().setAvaliable(true);
				deadLineCreation dead = new deadLineCreation();
				if (dead.hasExpired() == true) {
					// do something()
				}

				System.out.println("YOur book was sucessfull return ");

			} else
				System.out.println("Wrong code !");
		} catch (Exception e) {
			System.out.println("Code not Found " + e);

		}

	}

}
