package jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import customer.domain.CustomerDomain;

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
		for(CustomerDomain cd: customers){
			LOG.info(cd.toString());
		}
		
	}

}
