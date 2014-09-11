package customer.repository;

import java.util.List;

import javax.persistence.EntityManager;

import customer.dao.CustomerDAO;

public class CustomerRepositoryImpl implements CustomerRepository{

	private static final int CUSTOMER_IN_RESULT = 10;
	private EntityManager em;
	
	public CustomerRepositoryImpl(EntityManager em){
		this.em = em;
	}
	
	public CustomerDAO create(CustomerDAO customer) {
		CustomerDAO c = new CustomerDAO();
		c.setName(customer.getName());
		c.setSurname(customer.getSurname());
		c.setPatronymic(customer.getPatronymic());
		c.setPassportNumber(customer.getPassportNumber());
		c.setPassportSeries(customer.getPassportSeries());
		c.setBirthDate(customer.getBirthDate());
		
		em.persist(c);
		
		return c;
	}

	public CustomerDAO find(int id) {
		return em.find(CustomerDAO.class, id);
	}

	public List<CustomerDAO> findAll() {
		return em.createQuery("SELECT c FROM CustomerDAO c")
				.setMaxResults(CUSTOMER_IN_RESULT)
				.getResultList();
	}

	public CustomerDAO update(int id, CustomerDAO newCustomerData) {
		CustomerDAO c = em.find(CustomerDAO.class, id);
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
		CustomerDAO c = em.find(CustomerDAO.class, id);
		if (c != null) {
			em.refresh(c);
		}
		
	}

}
