package co.com.bancodebogota.utils;

import java.sql.Timestamp;

public interface TimeUtilities {

	String timestampToFormat(Timestamp fecha, String formato);

	Timestamp stringToTimestamp(String fecha, String formatDate);
	
	String changeFormat(String frontEndDate);


}
