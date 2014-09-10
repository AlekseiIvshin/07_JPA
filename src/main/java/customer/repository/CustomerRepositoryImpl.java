package customer.repository;

import java.util.List;

import javax.persistence.EntityManager;

import customers.dao.Customer;

public class CustomerRepositoryImpl implements CustomerRepository{

	private static final int CUSTOMER_IN_RESULT = 10;
	private EntityManager em;
	
	public CustomerRepositoryImpl(EntityManager em){
		this.em = em;
	}
	
	public Customer create(Customer customer) {
		Customer c = new Customer();
		c.setName(customer.getName());
		c.setSurname(customer.getSurname());
		c.setPatronymic(customer.getPatronymic());
		c.setPassportNumber(customer.getPassportNumber());
		c.setPassportSeries(customer.getPassportSeries());
		c.setBirthDate(customer.getBirthDate());
		
		em.persist(c);
		
		return c;
	}

	public Customer find(int id) {
		return em.find(Customer.class, id);
	}

	public List<Customer> findAll() {
		return em.createQuery("SELECT c FROM Customer c")
				.setMaxResults(CUSTOMER_IN_RESULT)
				.getResultList();
	}

	public Customer update(int id, Customer newCustomerData) {
		Customer c = em.find(Customer.class, id);
		if (c != null) {
			c.setName(newCustomerData.getName());
			c.setSurname(newCustomerData.getSurname());
			c.setPatronymic(newCustomerData.getPatronymic());
			c.setPassportNumber(newCustomerData.getPassportNumber());
			c.setPassportSeries(newCustomerData.getPassportSeries());
			c.setBirthDate(newCustomerData.getBirthDate());
		}
		
		return c;
	}

	public void remove(int id) {
		Customer c = em.find(Customer.class, id);
		if (c != null) {
			em.refresh(c);
		}
		
	}

}
