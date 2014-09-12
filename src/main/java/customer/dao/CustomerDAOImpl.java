package customer.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.dao.GenericDAOImpl;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {
	static final Logger LOG = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	public CustomerDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
