package customer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import dao.customer.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private static final int CUSTOMER_IN_RESULT = 10;
	private EntityManager em;
	
	public CustomerDAOImpl(EntityManager em){
		this.em = em;
	}
	
	public Customer create(Customer customer) {
		em.persist(customer);
		return customer;
	}

	public Customer find(int id) {
		return em.find(Customer.class, id);
	}

	public List<Customer> findAll() {
		return em.createQuery("SELECT c FROM CustomerDAO c")
				.setMaxResults(CUSTOMER_IN_RESULT)
				.getResultList();
	}

	public Customer update(Customer newCustomerData) {
		em.merge(newCustomerData);
		return newCustomerData;
	}

	public void remove(int id) {
		Customer c = em.find(Customer.class, id);
		if (c != null) {
			em.refresh(c);
		}
		
	}

}
