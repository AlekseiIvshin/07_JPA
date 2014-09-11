package customer.mapper;

import java.util.ArrayList;
import java.util.List;

import customer.domain.CustomerDomain;
import dao.customer.Customer;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class CustomerDomainToDao<F extends CustomerDomain, T extends Customer> {

	private Class<? extends Customer> toClass;
	private MapperFactory mapperFactory;
	public CustomerDomainToDao(Class<? extends CustomerDomain> fromClass, Class<? extends Customer> toClass){
		this.toClass = toClass;
		mapperFactory = new DefaultMapperFactory
				.Builder().build();
		mapperFactory.classMap(fromClass, toClass)
				.field("name", "name")
				.field("surname", "surname")
				.field("patronymic", "patronymic")
				.field("passportNumber", "passportNumber")
				.field("passportSeries", "passportSeries")
				.field("birthDate", "birthDate")
				.field("id", "id")
				.register();
	}
	public List<T> map(List<F> fromObject) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return (List<T>) mapperFacade.mapAsList(fromObject, toClass);
	}
	public T map(F fromObject) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return (T) mapperFacade.map(fromObject, toClass);
	}
	


}
