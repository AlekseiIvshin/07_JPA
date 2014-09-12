package common.mapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.dao.mark.Mark;
import car.dao.mark.MarkDAOImpl;
import car.dao.modifiacation.Modification;
import car.domain.CarDomain;
import car.domain.CarDomainImpl;
import customer.dao.Customer;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import merchant.dao.Merchant;
import merchant.domen.MerchantDomain;
import merchant.domen.MerchantDomainImpl;

public class MainMapper implements Mapper {


	static final Logger LOG = LoggerFactory.getLogger(MainMapper.class);
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

		mapperFactory.classMap(MerchantDomainImpl.class, Merchant.class)
				.constructorA("id")
				.field("name", "name")
				.field("surname", "surname")
				.field("patronymic", "patronymic")
				.field("id", "id")
				.register();
		
		mapperFactory.classMap(CarDomainImpl.class, Modification.class)
				.constructorA("id")
				.field("id", "id")
				.field("mark", "model.mark.name")
				.field("model", "model.name")
				.field("modification", "name")
				.register();
		
		mapperFactory.classMap(CarDomainImpl.class, Modification.class)
				.constructorA("id")
				.field("id", "id")
				.field("mark", "model.mark.name")
				.field("model", "model.name")
				.field("modification", "name")
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
