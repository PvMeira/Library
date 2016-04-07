package menuLayOut;

public class BookMenuLayOut implements layOut{
	public final int OP_ADD_NEW_BOOK = 1;
	public final int OP_SEARCH_BOOK = 2;
	public final int OP_GO_TO_REPORT_BOOK = 3;
	public final int OP_BACK_TO_MENU = 4;
	
	public String getOptionLayOut() {
		return ("\n----------------------------------------\n" 
	            + "1-Add new BOOK                          :\n"
				+ "2-Search BOOK (Go to Search Menu)       :\n" 	           
				+ "3-Go to Books report menu               :\n" 
				+ "4-Back to the menu                      :\n" 
	            + "\n--------------------------------------\n");
	}
}
