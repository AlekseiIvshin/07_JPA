package customer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.dao.GenericDAO;
import common.mapper.MainMapper;
import common.mapper.Mapper;
import customer.dao.Customer;
import customer.dao.CustomerDAOImpl;
import customer.domain.CustomerDomain;

public class CustomerServiceImpl implements CustomerService {

	static final Logger LOG = LoggerFactory
			.getLogger(CustomerServiceImpl.class);

	private EntityManager entityManager;
	private GenericDAO<Customer, Integer> customerDAO;

	public CustomerServiceImpl() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("07_JPA");
		entityManager = entityManagerFactory.createEntityManager();
		customerDAO = new CustomerDAOImpl(entityManager);
	}

	public List<CustomerDomain> getAll() {
		List<Customer> cusomers = customerDAO.findAll();
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(cusomers, CustomerDomain.class);
	}

	public CustomerDomain change(CustomerDomain changedDomainCustomer) {
		Mapper mapper = new MainMapper();
		Customer customer = mapper.map(changedDomainCustomer, Customer.class);
				
		CustomerDomain result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Customer changedCustomer = customerDAO.update(customer);
			transaction.commit();
			result = mapper.map(changedCustomer, CustomerDomain.class);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

	public CustomerDomain create(CustomerDomain newCustomer) {
		Mapper mapper = new MainMapper();
		Customer customer = mapper.map(newCustomer, Customer.class);
		LOG.info(customer.toString());
		
		CustomerDomain result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Customer changedCustomer = customerDAO.create(customer);
			transaction.commit();
			result = mapper.map(changedCustomer, CustomerDomain.class);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

}
