package menuLayOut;

public class SearchMenuLayOut implements layOut{


	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" 
	            + "1-Search Client                 :\n"
				+ "2-Search Book                   :\n" 	     
				+ "3-Back to the menu              :\n" 
	            + "\n--------------------------------------\n");
	}
}