package menuLayOut;

public class ReportClientLayOut implements layOut {
	public final int OP_REPORT_TYPE_A_CLIENT = 1;
	public final int OP_REPROT_TYPE_B_CLIENT = 2;
	public final int OP_REPROT_TYPE_C_CLIENT = 3;
	public final int OP_BACK_TO_MENU = 4;

	public String getOptionLayOut() {
		return ("\n------------------------------------------\n" 
	            + "1-View report clients Who Most Rent Books:\n"
	            + "2-View report clients Who Most Rent Books:\n" 
	            + "3-View report for all register clients   :\n" 
	            + "4-Back to the menu                       :\n"
				+ "\n----------------------------------------\n");

	}

}
