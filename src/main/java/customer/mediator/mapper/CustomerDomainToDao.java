package customer.mediator.mapper;

import java.util.ArrayList;
import java.util.List;

import customer.dao.CustomerDAO;
import customer.domain.CustomerDomain;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class CustomerDomainToDao<F extends CustomerDomain, T extends CustomerDAO> {

	private Class<F> fromClass;
	private MapperFactory mapperFactory;
	public CustomerDomainToDao(Class<F> fromClass, Class<T> toClass){
		this.fromClass = fromClass;
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
		return (List<T>) mapperFacade.mapAsList(fromObject, fromClass);
	}
	public T map(F fromObject) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return (T) mapperFacade.map(fromObject, fromClass);
	}
	


}
