package service.mapper;

import customer.domain.CustomerDomain;
import dao.customer.Customer;

public interface MyMapperFactory<FromClass, ToClass> {

	Mapper<FromClass, ToClass> createMapper();
}
