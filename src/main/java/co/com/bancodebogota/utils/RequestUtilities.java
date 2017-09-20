package co.com.bancodebogota.utils;

import javax.xml.datatype.XMLGregorianCalendar;

public interface RequestUtilities {
	
	XMLGregorianCalendar getXMLGregorianCalendar();
	
	String getClientDt();
	
	String getRequestUIID();

}
