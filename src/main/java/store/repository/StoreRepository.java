package store.repository;

import java.math.BigDecimal;
import java.util.List;
import store.dao.Store;
import modifications.dao.Modification;

/**
 * Store repository.
 * @author Aleksei_Ivshin
 *
 */
public interface StoreRepository {
	
	/** 
	 * Create new store item.
	 * @param modification store modification
	 * @param count count item in store
	 * @param price price of store item
	 * @param testDriveAvaible can use for test drive
	 * @return created store item
	 */
	Store create(Modification modification, 
			int count, BigDecimal price, boolean testDriveAvaible);
	
	/**
	 * Change count of store item.
	 * @param id store item id
	 * @param newCount new count
	 * @return changed item
	 */
	Store update(int id, int newCount);
	
	/**
	 * Change price of store item.
	 * @param id store item id
	 * @param newPrice new item price
	 * @return changed item
	 */
	Store update(int id, BigDecimal newPrice);
	
	/**
	 * Change test drive attribute.
	 * @param id store item id
	 * @param newTestDriveAvaible new test drive value
	 * @return changed item
	 */
	Store update(int id, boolean newTestDriveAvaible);
	
	/**
	 * Find store item by id.
	 * @param id id of store item
	 * @return founded item
	 */
	Store find(int id);
	
	/**
	 * Find store items by modification.
	 * @param modification modification
	 * @return founded items
	 */
	List<Store> find(Modification modification);
	
	/**
	 * Remove stores item from data store.
	 * @param id store item id
	 */
	void remove(int id);
}
