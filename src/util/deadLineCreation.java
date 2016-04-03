package util;

import java.text.DateFormat;
import java.util.Date;

public class deadLineCreation {
	private long deadLine;
	private DateFormat dateFormatter;

	public static final long SECOND = 1000;
	public static final long MINUTE = SECOND * 60;
	public static final long HOUR = MINUTE * 60;
	public static final long DAY = HOUR * 24;
	public static final long WEEK = DAY * 7;

	public deadLineCreation() {
		deadLine = now() + WEEK;
		dateFormatter = DateFormat.getDateInstance();
	}

	private long now() {
		return new Date().getTime();
	}

	public long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(long deadLine) {
		this.deadLine = deadLine;
	}

	public DateFormat getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(DateFormat dateFormatter) {
		this.dateFormatter = dateFormatter;
	}
	public boolean hasExpired(){
		return now()> deadLine;
	}

	

}
