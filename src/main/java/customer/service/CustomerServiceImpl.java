package customer.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customer.dao.CustomerDAO;
import customer.dao.CustomerDAOImpl;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import customer.mapper.CustomerDaoToDomain;
import customer.mapper.CustomerDomainToDao;
import dao.customer.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private EntityManager em;
	
	public CustomerServiceImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		em = emf.createEntityManager();
	}
	
	public List<CustomerDomain> getAllCustomers() {
		CustomerDAO customerDAO = new CustomerDAOImpl(em);
		List<Customer> customers = customerDAO.findAll();
		if (customers == null || customers.size() == 0) {
			return new ArrayList<CustomerDomain>();
		}
		
		CustomerDaoToDomain<Customer, CustomerDomain> mapper = 
				new CustomerDaoToDomain<Customer, CustomerDomain>(Customer.class,CustomerDomainImpl.class);
		
		return mapper.map(customers);
	}

	public CustomerDomain getCustomer(int id) {
		CustomerDAO customerDAO = new CustomerDAOImpl(em);
		Customer customer = customerDAO.find(id);
		if (customer != null) {
			CustomerDaoToDomain<Customer, CustomerDomain> mapper = 
					new CustomerDaoToDomain<Customer, CustomerDomain>(Customer.class,CustomerDomainImpl.class);
			
			return mapper.map(customer);
		}
		return null;
	}

	public CustomerDomain changeCustomer(int id, CustomerDomain newCustomer) {
		CustomerDomain customerDomain = getCustomer(id);
		if (customerDomain == null) {
			return null;
		}
		
		customerDomain.setName(newCustomer.getName());
		customerDomain.setSurname(newCustomer.getSurname());
		customerDomain.setPatronymic(newCustomer.getPatronymic());
		customerDomain.setBirthDate(newCustomer.getBirthDate());
		customerDomain.setPassportSeries(newCustomer.getPassportSeries());
		customerDomain.setPassportNumber(newCustomer.getPassportNumber());
		
		CustomerDomainToDao<CustomerDomain, Customer> mapper = 
				new CustomerDomainToDao<CustomerDomain, Customer>(CustomerDomainImpl.class,Customer.class);
		
		CustomerDAO customerDAO = new CustomerDAOImpl(em);
		return null;

		
		
	}

}
