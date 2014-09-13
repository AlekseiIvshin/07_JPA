package customer.dao;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel (Customer.class)
public class Customer_ {

	public static SingularAttribute<Customer, Integer> id;
	public static SingularAttribute<Customer, String> name;
	public static SingularAttribute<Customer, String> surname;
	public static SingularAttribute<Customer, String> patronymic;
	public static SingularAttribute<Customer, String> passportNumber;
	public static SingularAttribute<Customer, String> passportSeries;
	public static SingularAttribute<Customer, Date> birthDate;
}
