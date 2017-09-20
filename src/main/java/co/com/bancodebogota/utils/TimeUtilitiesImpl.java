package co.com.bancodebogota.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

@Service
public class TimeUtilitiesImpl implements TimeUtilities {

	private static final String BACK_FORMAT = "yyyy-MM-dd";
	private static final String FRONT_FORMAT = "dd/MM/yyyy";

	@Override
	public String timestampToFormat(Timestamp fecha, String formato) {
		String fechaFormat;
		if (fecha == null)
			return "";
		try {
			fechaFormat = new SimpleDateFormat(formato).format(fecha);
		} catch (Exception e) {
			fechaFormat = null;
		}
		return fechaFormat;
	}

	@Override
	public Timestamp stringToTimestamp(String fecha, String formatDate) {
		java.sql.Timestamp fechaTs = null;
		if (formatDate != null && fecha != null) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
				java.util.Date date = formatter.parse(fecha);
				fechaTs = new Timestamp(date.getTime());
			} catch (Exception e) {
				return null;
			}
		}

		return fechaTs;
	}

	@Override
	public String changeFormat(String frontEndDate) {
		Timestamp timestamp = stringToTimestamp(frontEndDate, FRONT_FORMAT);
		return this.timestampToFormat(timestamp, BACK_FORMAT);
		
	}

}
