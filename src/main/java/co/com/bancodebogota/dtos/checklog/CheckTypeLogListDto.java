package co.com.bancodebogota.dtos.checklog;

import java.util.List;

public class CheckTypeLogListDto {
	private List<CheckTypeLogItemDto> checkTypeLogList;
	private String identityNumber;

	public List<CheckTypeLogItemDto> getCheckTypeLogList() {
		return checkTypeLogList;
	}

	public void setCheckTypeLogList(List<CheckTypeLogItemDto> listCheckTypeLog) {
		this.checkTypeLogList = listCheckTypeLog;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

}
