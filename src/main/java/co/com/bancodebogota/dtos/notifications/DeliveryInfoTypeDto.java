package co.com.bancodebogota.dtos.notifications;

import java.util.List;

public class DeliveryInfoTypeDto {
	
	private String phone;
	private String emailAddr;
	private String label;
	private String message;
	private String subject;
	private String contract;	
	private String business;
	private String template;
	private List<ParameterTypeDto> parameters;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<ParameterTypeDto> getParameters() {
		return parameters;
	}

	public void setParameters(List<ParameterTypeDto> parameter) {
		this.parameters = parameter;
	}

}
