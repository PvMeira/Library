package menuLayOut;
/**
 * @author Pedro
 *
 */
public class ReportBookLayOut implements layOut{
	
	

	@Override
	public String getOptionLayOut() {
		
		return ("\n--------------------------------------\n" 
	            + "1-View report for most rented book      :\n"
	            + "2-View report for less rented book      :\n" 
	            + "3-View report for all books register    :\n" 
	            + "4-Back to the main menu                     :\n"
				+ "\n--------------------------------------\n");
	}

}
