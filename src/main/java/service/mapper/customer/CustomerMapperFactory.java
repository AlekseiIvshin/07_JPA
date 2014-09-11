package service.mapper.customer;

import customer.domain.CustomerDomain;
import dao.customer.Customer;
import service.mapper.Mapper;
import service.mapper.MyMapperFactory;

public class CustomerMapperFactory<FromClass, ToClass> implements MyMapperFactory<FromClass, ToClass> {

	public Mapper<FromClass, ToClass> createMapper() {
		return new CustomerMapper<FromClass, ToClass>(Customer.class, CustomerDomain.class);
	}

}
