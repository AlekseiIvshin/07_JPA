package customer.dao;

import java.util.List;

import dao.customer.Customer;

/**
 * Customer repository.
 * @author Aleksei_Ivshin
 *
 */
public interface CustomerDAO {

	/**
	 * Create customer to data store.
	 * @param customer customer data
	 * @return created customer
	 */
	Customer create(Customer customer);
	
	/**
	 * Find customer by id.
	 * @param id customer id
	 * @return founded customer
	 */
	Customer find(int id);
	
	/**
	 * Find all customers.
	 * @return list of customer
	 */
	List<Customer> findAll();
	
	/**
	 * Update customer data in data store. 
	 * @param newCustomerData new data
	 * @return return changed customer
	 */
	Customer update(Customer newCustomerData);
	
	/**
	 * Remove customer from data store.
	 * @param id customer id
	 */
	void remove(int id);
}
