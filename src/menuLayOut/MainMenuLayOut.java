package menuLayOut;

public class MainMenuLayOut {
	public final int OP_ADD_CLIENT = 1;
	public final int OP_ADD_BOOK = 2;
	public final int OP_NEW_WITHDRAWAL_BOOK = 3;
	public final int OP_DEVOLUTION_BOOK = 4;
	public final int OP_Report = 5;
	public final int OP_Search_menu = 6;
	public final int OP_EXIT_APLICATION = 7;

	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" + "1-Add a new Client         :\n"
				+ "2-Add a new Book           :\n" + "3-Make a Withdrawal        :\n" + "4-Register a devolution    :\n"
				+ "5-Consult the reports      :\n" + "6-Go to the Search menu    :\n" + "7-Exit Aplication          :\n"
				+ "\n--------------------------------------\n");
	}
}
// Withdrawal