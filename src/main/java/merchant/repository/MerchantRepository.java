package merchant.repository;

import java.util.List;

import merchant.dao.Merchant;

/**
 * Merchant repository.
 * @author Aleksei_Ivshin
 *
 */
public interface MerchantRepository {

	/**
	 * Create merchant to data store.
	 * @param merchant merchant data
	 * @return created merchant
	 */
	Merchant create(Merchant merchant);
	
	/**
	 * Find merchant by id.
	 * @param id merchant id
	 * @return founded merchant
	 */
	Merchant find(int id);
	
	/**
	 * Find all merchants.
	 * @return list of merchant
	 */
	List<Merchant> findAll();
	
	/**
	 * Update merchant data in data store. 
	 * @param id merchant id
	 * @param newMerchantData new data
	 * @return return changed merchant
	 */
	Merchant update(int id, Merchant newMerchantData);
	
	/**
	 * Remove merchant from data store.
	 * @param id merchant id
	 */
	void remove(int id);
}
