package menuLayOut;
/**
 * @author Pedro
 *
 */
public class MainMenuLayOut implements layOut{


	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" 
	            + "1-Go to the Client Menu         :\n"
				+ "2-Go to the Book Menu           :\n" 
	            + "3-Go to the Search Menu         :\n" 
				+ "4-Inform a new Rent             :\n"
				+ "5-Register a new Devolution     :\n" 	           
				+ "6-Exit Aplication               :\n"
				+ "\n--------------------------------------\n");
	}
}
