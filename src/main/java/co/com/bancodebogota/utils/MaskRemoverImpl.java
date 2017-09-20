package co.com.bancodebogota.utils;

import org.springframework.stereotype.Service;

@Service
public class MaskRemoverImpl implements MaskRemover {
	
	static final String REGEX_CELLPHONE = "[\\(\\) ]";
	static final String REGEX_IDENTIFICATION = "[\\.]";
	static final String REGEX_MONEY = "[\\.\\,\\$]";

	@Override
	public String removeCellphoneMask(String field) {
		return removeInField( field, REGEX_CELLPHONE);
	}

	@Override
	public String removeIdentificationMask(String field) {
		return removeInField( field, REGEX_IDENTIFICATION);
	}

	@Override
	public String removeMoneyMask(String field) {
		return removeInField( field, REGEX_MONEY);
	}

	@Override
	public String dateFromBackendToFront(String maskedField) {
		if (maskedField == null || maskedField.isEmpty()) return null;
		String[] dateSplited = maskedField.split("-");
		return String.format("%s/%s/%s", dateSplited[2], dateSplited[1], dateSplited[0]);
	}

	private String removeInField(String field, String regex) {
		String formattedField = field;
		if (field != null)
			formattedField = field.replaceAll(regex, "");
		return formattedField;
	}
	
}