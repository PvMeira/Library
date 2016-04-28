package menuLayOut;
/**
 * @author Pedro
 *
 */
public class SearchBookMenuLayOut implements layOut {


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
