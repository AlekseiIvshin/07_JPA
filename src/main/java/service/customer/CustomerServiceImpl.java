package service.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.mapper.Mapper;
import service.mapper.MyMapperFactory;
import service.mapper.customer.CustomerMapper;
import service.mapper.customer.CustomerMapperFactory;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import dao.customer.Customer;
import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;

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
		Mapper mapper = new CustomerMapper<Customer, CustomerDomainImpl>(Customer.class, CustomerDomainImpl.class);
		
		return mapper.mapAsList(cusomers, CustomerDomain.class);
	}
	
	

}
