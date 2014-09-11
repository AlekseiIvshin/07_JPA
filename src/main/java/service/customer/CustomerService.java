package service.customer;

import customer.domain.CustomerDomain;
import java.util.List;

public interface CustomerService {

	List<CustomerDomain> getAll();
}
