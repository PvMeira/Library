package profile;

import util.DeadLineCreation;

public class Devolution {
	private Rent data;
	private DeadLineCreation deadLine;

	public Devolution(Rent data, DeadLineCreation deadLine) {

		this.data = data;
		this.deadLine = deadLine;
	}

	public Rent getData() {
		return data;
	}

	public void setData(Rent data) {
		this.data = data;
	}

	public DeadLineCreation getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(DeadLineCreation deadLine) {
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "Profile Rent   :" + data + "Dead Line   :" + deadLine;
	}

}
