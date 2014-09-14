package customer.service;

import car.domain.CarDomain;
import common.service.DomainServiceImpl;
import customer.dao.Customer;
import customer.dao.CustomerDAO;
import customer.dao.CustomerDAOImpl;
import customer.domain.CustomerDomain;

public class CustomerServiceImpl 
		extends DomainServiceImpl<CustomerDomain, Integer, Customer, Integer, CustomerDAOImpl>
		implements CustomerService{

	public CustomerDomain contains(CustomerDomain customer) {
		Customer customerDao = mapper.map(customer, Customer.class);
		return mapper.map(dao.contains(customerDao),CustomerDomain.class);
	}

}
