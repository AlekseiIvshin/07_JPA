package customer.service;

import car.domain.CarDomain;
import common.service.DomainService;
import customer.domain.CustomerDomain;

public interface CustomerService extends DomainService<CustomerDomain, Integer>{

	CustomerDomain contains(CustomerDomain customer);
}
