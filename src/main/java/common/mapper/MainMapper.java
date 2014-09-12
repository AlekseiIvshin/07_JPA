package common.mapper;

import java.util.List;

import customer.dao.Customer;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import merchant.dao.Merchant;
import merchant.domen.MerchantDomain;

public class MainMapper implements Mapper {

	MapperFactory mapperFactory;
	
	public MainMapper(){
		mapperFactory = new DefaultMapperFactory
				.Builder().build();
		mapperFactory.classMap(CustomerDomainImpl.class, Customer.class)
				.constructorA("id")
				.field("name", "name")
				.field("surname", "surname")
				.field("patronymic", "patronymic")
				.field("passportSeries", "passportSeries")
				.field("passportNumber", "passportNumber")
				.field("birthDate", "birthDate")
				.field("id", "id")
				.register();
		

		mapperFactory.classMap(MerchantDomain.class, Merchant.class)
				.constructorA("id")
				.field("name", "name")
				.field("surname", "surname")
				.field("patronymic", "patronymic")
				.field("id", "id")
				.register();
		
	}

	public <FromClass, ToClass> ToClass map(FromClass object,
			Class<ToClass> toClass) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return mapperFacade.map(object, toClass);
	}

	public <FromClass, ToClass> List<ToClass> mapAsList(List<FromClass> object,
			Class<ToClass> toClass) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return mapperFacade.mapAsList(object, toClass);
	}
}
