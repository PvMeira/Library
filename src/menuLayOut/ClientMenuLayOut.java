package menuLayOut;

public class ClientMenuLayOut implements layOut {
	public final int OP_ADD_NEW_CLIENT = 1;
	public final int OP_SEARCH_CLIENT = 2;
	public final int OP_REPORT_CLIENT = 3;
	public final int OP_BACK_TO_MENU = 4;

	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" + "1-Add new client                   :\n"
				+ "2-Search Client (Go to Search Menu):\n" + "3-Go to the Clients menu report    :\n"
				+ "4-Back to main menu                :\n" + "\n--------------------------------------\n");
	}
}
