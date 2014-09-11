package customer.service;

import customer.domain.CustomerDomain;
import java.util.List;

public interface CustomerService {

	List<CustomerDomain> getAllCustomers();
	CustomerDomain getCustomer(int id);
	CustomerDomain changeCustomer(int id, CustomerDomain newCustomer);
}
