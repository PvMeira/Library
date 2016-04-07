package menuLayOut;

public class ReportBookLayOut implements layOut{
	
	public final int OP_REPORT_TYPE_A_BOOK = 1;
	public final int OP_REPROT_TYPE_B_BOOK = 2;
	public final int OP_REPROT_TYPE_C_BOOK = 3;
	public final int OP_BACK_TO_MENU = 4;

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
