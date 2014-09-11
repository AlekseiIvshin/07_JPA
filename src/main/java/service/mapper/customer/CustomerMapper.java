package service.mapper.customer;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import service.mapper.Mapper;
import customer.domain.CustomerDomain;
import dao.customer.Customer;

public class CustomerMapper<FromClass, ToClass> 
		implements Mapper<FromClass, ToClass>{

	private MapperFactory mapperFactory;
	
	public CustomerMapper(Class<? extends Customer> fromClass, Class<? extends CustomerDomain> toClass){
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
	
	public ToClass map(FromClass object, Class<ToClass> toClass) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return (ToClass) mapperFacade.map(object, toClass);
	}

	public List<ToClass> mapAsList(List<FromClass> object,
			Class<ToClass> toClass) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return  (List<ToClass>) mapperFacade.mapAsList(object, toClass);
	}

	
}
