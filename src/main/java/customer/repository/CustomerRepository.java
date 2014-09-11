package customer.repository;

import java.util.List;

import customer.dao.CustomerDAO;

/**
 * Customer repository.
 * @author Aleksei_Ivshin
 *
 */
public interface CustomerRepository {

	/**
	 * Create customer to data store.
	 * @param customer customer data
	 * @return created customer
	 */
	CustomerDAO create(CustomerDAO customer);
	
	/**
	 * Find customer by id.
	 * @param id customer id
	 * @return founded customer
	 */
	CustomerDAO find(int id);
	
	/**
	 * Find all customers.
	 * @return list of customer
	 */
	List<CustomerDAO> findAll();
	
	/**
	 * Update customer data in data store. 
	 * @param id customer id
	 * @param newCustomerData new data
	 * @return return changed customer
	 */
	CustomerDAO update(int id, CustomerDAO newCustomerData);
	
	/**
	 * Remove customer from data store.
	 * @param id customer id
	 */
	void remove(int id);
}
