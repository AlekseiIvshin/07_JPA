package customer.domain;

import java.util.Date;

public interface CustomerDomain {

	int getId();
	String getName();
	void setName(String name);
	String getSurname();
	void setSurname(String surname);
	String getPatronymic();
	void setPatronymic(String patronymic);
	String getPassportNumber();
	void setPassportNumber(String passportNumber);
	String getPassportSeries();
	void setPassportSeries(String passportSeries);
	Date getBirthDate();
	void setBirthDate(Date birthDate);
}
