package co.com.bancodebogota.transformations;

public class ToFrontend {
	
	private ToFrontend (){}
	
    public static String asName(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else if (str.length() == 1) {
            return str.toUpperCase();
        } else {
            Character charAt = str.charAt(0);
			String firstChar = "" + charAt.toString();
            String lastChars = str.substring(1);
            return firstChar.toUpperCase() + lastChars.toLowerCase();
        }
    }
}
