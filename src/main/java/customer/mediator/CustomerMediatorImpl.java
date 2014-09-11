package customer.mediator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.App;

import org.hibernate.jpa.event.internal.jpa.CallbackRegistryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customer.dao.CustomerDAO;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import customer.mediator.mapper.CustomerDaoToDomain;
import customer.repository.CustomerRepository;
import customer.repository.CustomerRepositoryImpl;

public class CustomerMediatorImpl implements CustomerMediator {

	static final Logger LOG = LoggerFactory.getLogger(CustomerMediatorImpl.class);
	
	public List<CustomerDomain> getAllCustomers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		EntityManager em = emf.createEntityManager();
		CustomerDaoToDomain<CustomerDAO, CustomerDomain> mapper = 
				new CustomerDaoToDomain<CustomerDAO, CustomerDomain>(CustomerDAO.class,CustomerDomainImpl.class);
		CustomerRepository customerRepository = 
				new CustomerRepositoryImpl(em);
		List<CustomerDAO> customersDao = customerRepository.findAll();
		LOG.info("Find {} cusomers in data store.",customersDao.size());
		return mapper.map(customersDao);
	}

}
