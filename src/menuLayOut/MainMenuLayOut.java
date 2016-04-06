package menuLayOut;

public class MainMenuLayOut implements layOut{
	public final int GO_TO_CLIENT_MENU = 1;
	public final int GO_TO_BOOK_MENU = 2;
	public final int GO_TO_SEARCH_MENU = 3;
	public final int INFORM_A_NEW_RENT = 4;
	public final int REGISTER_A_NEW_DEVOLUTION = 5;
	public final int OP_EXIT_APLICATION = 6;

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
