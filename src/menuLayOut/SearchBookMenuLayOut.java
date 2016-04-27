package menuLayOut;

public class SearchBookMenuLayOut implements layOut {

	public final int OP_SEARCH_BY_NAME = 1;
	public final int OP_SEARCH_BY_Author = 2;
	public final int OP_SEARCH_BY_publishingCompany = 3;
	public final int OP_SEARCH_BY_releaseyear = 4;
	public final int OP_BACK_TO_MENU = 5;

	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" 
	+ "1-Search Client by name               :\n"
    + "2-Search Client By Author             :\n" 
	+ "3-Search Client by Publishing Company :\n"
	+ "4-Search Client by Release year       :\n"
    + "5-Back to the menu                    :\n" 
	+ "\n--------------------------------------\n");
	}
}
