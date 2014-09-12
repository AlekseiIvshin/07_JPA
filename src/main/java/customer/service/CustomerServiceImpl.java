package customer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.mapper.MainMapper;
import common.mapper.Mapper;

import customer.dao.Customer;
import customer.dao.CustomerDAO;
import customer.dao.CustomerDAOImpl;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;

public class CustomerServiceImpl implements CustomerService {
	
	static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private EntityManager em;
	
	public CustomerServiceImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		em = emf.createEntityManager();
	}

	public List<CustomerDomain> getAll() {
		CustomerDAO  customerDAO = new CustomerDAOImpl(em);
		List<Customer> cusomers = customerDAO.findAll();
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(cusomers, CustomerDomain.class);
	}

	public CustomerDomain change(CustomerDomain changedDomainCustomer) {
		Mapper mapper = new MainMapper();
		Customer customer = mapper.map(changedDomainCustomer, Customer.class);
		CustomerDAO customerDAO = new CustomerDAOImpl(em);
		Customer changedCustomer = customerDAO.update(customer);
		return mapper.map(changedCustomer, CustomerDomain.class);
	}

	public CustomerDomain create(CustomerDomain newCustomer) {
		Mapper mapper = new MainMapper();
		Customer customer = mapper.map(newCustomer, Customer.class);
		CustomerDAO customerDAO = new CustomerDAOImpl(em);
		Customer changedCustomer = customerDAO.create(customer);
		return mapper.map(changedCustomer, CustomerDomain.class);
	}
	
	

}
