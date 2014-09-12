package merchant.domen;

import java.util.Date;


public class MerchantDomainImpl implements MerchantDomain {

	private final int id;
	private String name;
	private String surname;
	private String patronymic;
	
	
	public MerchantDomainImpl(int id){
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
	

	@Override
	public String toString() {
		return "CustomerDomain [id="+id+", surname="+surname+", name="+name
				+ ", patronymic="+patronymic+"]";
	}
}