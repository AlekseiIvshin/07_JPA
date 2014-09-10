package characteristic.repository;

import java.util.List;

import characteristics.dao.Characteristic;

/**
 * Characteristic service layer.
 * @author Aleksei_Ivshin
 *
 */
public interface CharacteristicRepository {

	/**
	 * Find characteristic by id.
	 * @param id id
	 * @return characteristic
	 */
	Characteristic find(int id);
	
	/**
	 * Create new characteristic.
	 * @param name name for new characteristic
	 * @param parent parent of new characteristic
	 * @return created characteristic
	 */
	Characteristic create(String name, Characteristic parent);
	
	/**
	 * Remove characteristic from data store.
	 * @param id characteristic id
	 */
	void remove(int id);
	
	/**
	 * Update characteristic in data store.
	 * @param id characteristic id
	 * @param newName new characteristic name
	 * @return updated characteristic
	 */
	Characteristic update(int id, String newName);
	
	/**
	 * Update  characteristic in data store.
	 * @param id characteristic id
	 * @param newParent new characteristic parent
	 * @return updated characteristic
	 */
	Characteristic update(int id, Characteristic newParent);
	
	/**
	 * Find characteristic by name.
	 * @param name characteristic name
	 * @return founded characteristics
	 */
	List<Characteristic> find(String name);
	

	/**
	 * Find characteristic by parent.
	 * @param parent characteristic parent
	 * @return founded characteristics
	 */
	List<Characteristic> find(Characteristic parent);
}
