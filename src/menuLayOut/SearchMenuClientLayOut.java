package menuLayOut;
/**
 * @author Pedro
 *
 */
public class SearchMenuClientLayOut implements layOut{


	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" 
	            + "1-Search Client by name         :\n"
				+ "2-Search Client By Token        :\n" 
	            + "3-Search Client by Phone number :\n"
				+ "4-Back to the menu              :\n" 
	            + "\n--------------------------------------\n");
	}
}
