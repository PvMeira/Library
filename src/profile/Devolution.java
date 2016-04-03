package profile;

import util.deadLineCreation;

public class Devolution {
	private Rent data;
	private deadLineCreation deadLine;

	public Devolution(Rent data, deadLineCreation deadLine) {

		this.data = data;
		this.deadLine = deadLine;
	}

	public Rent getData() {
		return data;
	}

	public void setData(Rent data) {
		this.data = data;
	}

	public deadLineCreation getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(deadLineCreation deadLine) {
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "Profile Rent   :" + data + "Dead Line   :" + deadLine;
	}

}
