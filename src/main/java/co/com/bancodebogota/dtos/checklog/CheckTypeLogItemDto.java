package co.com.bancodebogota.dtos.checklog;

import java.sql.Timestamp;

public class CheckTypeLogItemDto {
	private Timestamp date;
	private int checkType;

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getCheckType() {
		return checkType;
	}

	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}

}
