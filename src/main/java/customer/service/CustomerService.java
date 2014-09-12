package customer.service;

import customer.domain.CustomerDomain;
import java.util.List;

public interface CustomerService {

	List<CustomerDomain> getAll();
	CustomerDomain change(CustomerDomain changedDomainCustomer);
	CustomerDomain create(CustomerDomain newCustomer);
}
