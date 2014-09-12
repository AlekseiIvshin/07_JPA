package customer.dao;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {

	public CustomerDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
