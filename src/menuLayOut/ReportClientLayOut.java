package menuLayOut;

public class ReportClientLayOut implements layOut {
	public final int OP_REPORT_TYPE_A_CLIENT = 1;
	public final int OP_REPROT_TYPE_B_CLIENT = 2;
	public final int OP_BACK_TO_MENU = 3;

	public String getOptionLayOut() {
		return ("\n--------------------------------------\n" 
	            + "1-VIew report for most rentedbook      :\n"
	            + "1-VIew report for less rentedbook      :\n" 
	            + "3-Back to the menu                     :\n"
				+ "\n--------------------------------------\n");

	}

}
