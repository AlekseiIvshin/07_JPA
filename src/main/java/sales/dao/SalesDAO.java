package sales.dao;

import java.util.List;

import common.dao.GenericDAO;

import merchant.dao.Merchant;
import customer.dao.Customer;
import car.dao.modifiacation.Modification;

/**
 * Sales DAO interface.
 * 
 * @author Aleksei_Ivshin
 *
 */
public interface SalesDAO extends GenericDAO<Sales, Integer> {

	/**
	 * Find sales by modification.
	 * 
	 * @param modification
	 *            modification
	 * @return list of sales
	 */
	List<Sales> find(Modification modification);

	/**
	 * Find sales by customer.
	 * 
	 * @param customer
	 *            customer
	 * @return list of sales
	 */
	List<Sales> find(Customer customer);

	/**
	 * Find sales by merchant.
	 * 
	 * @param merchant
	 *            merchant
	 * @return list of sales
	 */
	List<Sales> find(Merchant merchant);

	/**
	 * Create new sale and update store: decrement count of cars in store item.
	 * 
	 * @param customer
	 *            customer, who buy car
	 * @param merchant
	 *            merchant, who sale car
	 * @param modification
	 *            car that is sale
	 * @return created sales
	 */
	Sales newSaleAndUpdateStore(Customer customer, Merchant merchant,
			Modification modification);

}
