package sales.repository;

import java.math.BigDecimal;
import java.util.List;

import customers.dao.Customer;
import sales.dao.Sales;
import merchant.dao.Merchant;
import modifications.dao.Modification;

/** 
 * Sales repository.
 * @author AlekseiIvshin
 *
 */
public interface SaleRepository {

	/** 
	 * Create new sale.
	 * @param modification sale modification
	 * @param customer customer
	 * @param merchant merchant
	 * @param price price of items
	 * @return created sale
	 */
	Sales create(Modification modification, 
			Customer customer, Merchant merchant, 
			BigDecimal price);
	
	/**
	 * Find sale by id.
	 * @param id sale id
	 * @return founded sale
	 */
	Sales find(int id);
	
	/**
	 * Find sale by modification.
	 * @param modification modification
	 * @return founded sales
	 */
	List<Sales> find(Modification modification);
	
	/**
	 * Find sale by customer.
	 * @param customer customer
	 * @return founded sales
	 */
	List<Sales> find(Customer customer);
	
	/**
	 * Find sale by merchant.
	 * @param merchant merchant
	 * @return founded sales
	 */
	List<Sales> find(Merchant merchant);
	
	/**
	 * Remove sales from data storage.
	 * @param id sale id
	 */
	void remove(int id);
	
}
