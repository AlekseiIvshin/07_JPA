package common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customer.domain.CustomerDomain;
import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;

/** 
 * Main. 
 * @author AlekseiIvshin
 *
 */
public class App {

	static final Logger LOG = LoggerFactory.getLogger(App.class);
	/**
	 * Main.
	 * @param args in arguments
	 */
	public static void main(String[] args) {
		CustomerService customerService = new CustomerServiceImpl();
		List<CustomerDomain> customers = customerService.getAll();
		if (customers.isEmpty()){
			LOG.info("Not found customers.");
		}
		CustomerDomain someCustomer = customers.get(0);
		LOG.info("Before: {}",someCustomer.toString());
		someCustomer.setName("New Suctomer name");
		someCustomer = customerService.change(someCustomer);
		LOG.info("After: {}",someCustomer.toString());
	}

}
