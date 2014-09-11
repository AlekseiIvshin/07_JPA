package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customer.domain.CustomerDomain;
import customer.mediator.CustomerMediatorImpl;
import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;
import mark.dao.Mark;
import mark.repository.MarkRepository;
import mark.repository.MarkRepositoryImpl;
import model.dao.Model;
import model.repository.ModelRepository;
import model.repository.ModelRepositoryImpl;

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
		CustomerService customerService = new CustomerServiceImpl(new CustomerMediatorImpl());
		List<CustomerDomain> customers = customerService.getAllCustomers();
		for(CustomerDomain cd: customers){
			LOG.info(cd.toString());
		}
		
	}

}
