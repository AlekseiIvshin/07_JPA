package customer.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.dao.GenericDAOImpl;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {
	static final Logger LOG = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	public CustomerDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public Customer contains(Customer customer) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
		Root<Customer> resultCustomer = query.from(Customer.class);
		query
			.where(
				builder.equal(
						resultCustomer.get(Customer_.passportSeries), 
						customer.getPassportSeries()))
			.where(builder.equal(
						resultCustomer.get(Customer_.passportNumber), 
						customer.getPassportNumber()))
			.select(resultCustomer);
		TypedQuery<Customer>ctq = entityManager.createQuery(query);
		return ctq.getSingleResult();
	}

}
