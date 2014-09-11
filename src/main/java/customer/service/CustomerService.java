package customer.service;

import customer.domain.CustomerDomain;
import java.util.List;

public interface CustomerService {

	List<CustomerDomain> getAllCustomers();
}
