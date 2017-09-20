package co.com.bancodebogota.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.bancodebogota.digital.utilities.log.LoggerUtils;

@Service
public class RequestUtilitiesImpl implements RequestUtilities {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	@Override
	public XMLGregorianCalendar getXMLGregorianCalendar() {
		String fecha = new SimpleDateFormat(DEFAULT_FORMAT).format(new Date());
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha);
		} catch (DatatypeConfigurationException e) {

			LoggerUtils.error("getXMLGregorianCalendar", e);
			xgcal = null;
		}
		return xgcal;
	}

	@Override
	public String getClientDt() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
		return dtf.format(now);
	}

	@Override
	public String getRequestUIID() {
		UUID rq = UUID.randomUUID();
		return rq.toString();
	}

}
