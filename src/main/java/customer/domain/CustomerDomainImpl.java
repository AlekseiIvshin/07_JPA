package customer.domain;

import java.util.Date;

public class CustomerDomainImpl implements CustomerDomain {

	private final int id;
	private String name;
	private String surname;
	private String patronymic;
	private String passportNumber;
	private String passportSeries;
	private Date birthDate;
	
	
	public CustomerDomainImpl(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPassportSeries() {
		return passportSeries;
	}
	public void setPassportSeries(String passportSeries) {
		this.passportSeries = passportSeries;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

	@Override
	public String toString() {
		return "CustomerDomain [id="+id+", surname="+surname+", name="+name
				+ ", patronymic="+patronymic
				+ ", passport="+passportSeries+" "+passportNumber+"]";
	}
}
