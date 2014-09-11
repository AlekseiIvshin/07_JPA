package dao.customer;

import javax.persistence.EntityManager;

import dao.GenericDAOImpl;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {

	public CustomerDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
