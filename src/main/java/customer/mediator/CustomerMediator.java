package customer.mediator;

import java.util.List;

import customer.domain.CustomerDomain;

public interface CustomerMediator {

	public List<CustomerDomain> getAllCustomers();
}
