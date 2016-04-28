package menuLayOut;
/**
 * @author Pedro
 *
 */
public class BookMenuLayOut implements layOut{

	
	public String getOptionLayOut() {
		return ("\n----------------------------------------\n" 
	            + "1-Add new BOOK                          :\n"
				+ "2-Search BOOK (Go to Search Menu)       :\n" 	           
				+ "3-Go to Books report menu               :\n" 
				+ "4-Back to the menu                      :\n" 
	            + "\n--------------------------------------\n");
	}
}
