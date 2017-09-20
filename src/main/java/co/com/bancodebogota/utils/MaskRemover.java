package co.com.bancodebogota.utils;

public interface MaskRemover {

	String removeCellphoneMask(String field);

	String removeIdentificationMask(String field);

	String removeMoneyMask(String field);

	String dateFromBackendToFront(String maskedField);
}
