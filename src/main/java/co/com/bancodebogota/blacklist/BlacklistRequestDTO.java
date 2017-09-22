package co.com.bancodebogota.blacklist;

public class BlacklistRequestDTO {

	private String documentNumber;

	private String surname;

	private String secondSurname;

	private String firstName;


	public BlacklistRequestDTO() {
		super();
	}

	public BlacklistRequestDTO(String documentNumber, String surname, String secondSurname, String firstName) {
		super();
		this.documentNumber = documentNumber;
		this.surname = surname;
		this.secondSurname = secondSurname;
		this.firstName = firstName;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentType) {
		this.documentNumber = documentType;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String documentNumber) {
		this.surname = documentNumber;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "BlacklistParticipanteRqDto [documentNumber=" + documentNumber + ", surname=" + surname
				+ ", secondSurname=" + secondSurname + ", firstName=" + firstName + "]";
	}

}

