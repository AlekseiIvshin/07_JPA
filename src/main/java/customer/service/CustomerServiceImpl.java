package customer.service;

import java.util.List;

import customer.domain.CustomerDomain;
import customer.mediator.CustomerMediator;

public class CustomerServiceImpl implements CustomerService {

	private CustomerMediator customerMediator;
	
	public CustomerServiceImpl(CustomerMediator customerMediator){
		this.customerMediator = customerMediator;
	}
	

	public List<CustomerDomain> getAllCustomers() {
		return customerMediator.getAllCustomers();
	}

}
