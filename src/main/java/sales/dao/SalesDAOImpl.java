package sales.dao;

import java.util.List;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

import merchant.dao.Merchant;
import customer.dao.Customer;
import car.dao.modifiacation.Modification;

public class SalesDAOImpl 
		extends GenericDAOImpl<Sales, Integer>
		implements SalesDAO{

	public SalesDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Sales> find(Modification modification) {
		return entityManager
				.createQuery("SELECT s FROM Sales s "
						+ "WHERE s.modification=:modif")
				.setParameter("modif", modification)
				.getResultList();
	}

	public List<Sales> find(Customer customer) {
		return entityManager
				.createQuery("SELECT s FROM Sales s "
						+ "WHERE s.customer=:customer")
				.setParameter("customer", customer)
				.getResultList();
	}

	public List<Sales> find(Merchant merchant) {
		return entityManager
				.createQuery("SELECT s FROM Sales s "
						+ "WHERE s.merchant=:merchant")
				.setParameter("merchant", merchant)
				.getResultList();
	}
}
