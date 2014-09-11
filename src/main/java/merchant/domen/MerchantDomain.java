package merchant.domen;

import java.util.Date;

public interface MerchantDomain {

	int getId();
	void setId();
	String getName();
	void setName(String name);
	String getSurname();
	void setSurname(String surname);
	String getPatronymic();
	void setPatronymic(String patronymic);
}
