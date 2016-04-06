package menuLayOut;

public class SearchMenuLayOut implements layOut{
	public final int OP_SEARCH_BY_NAME = 1;
	public final int OP_SEARCH_BY_Token = 2;
	public final int OP_SEARCH_BY_PHONE = 3;
	public final int OP_BACK_TO_MENU = 4;

	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" + "1-Search Client by name         :\n"
				+ "2-Search Client By Token        :\n" + "3-Search Client by Phone number :\n"
				+ "4-Back to the menu              :\n" + "\n--------------------------------------\n");
	}
}
