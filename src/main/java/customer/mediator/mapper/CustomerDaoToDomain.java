package customer.mediator.mapper;

import java.util.List;

import customer.dao.CustomerDAO;
import customer.domain.CustomerDomain;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class CustomerDaoToDomain<F extends CustomerDAO, T extends CustomerDomain>{
	private MapperFactory mapperFactory;
	private Class<? extends CustomerDomain> toClass;
	
	public CustomerDaoToDomain(Class<? extends CustomerDAO> fromClass, Class<? extends CustomerDomain> toClass){
		mapperFactory = new DefaultMapperFactory
				.Builder().build();
		this.toClass = toClass; 
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
		return  (List<T>) mapperFacade.mapAsList(fromObject, toClass);
	}
	public T map(F fromObject) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return (T) mapperFacade.map(fromObject, toClass);
	}
}
