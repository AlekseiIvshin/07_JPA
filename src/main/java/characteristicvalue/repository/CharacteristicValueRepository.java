package characteristicvalue.repository;

import java.util.List;

import modification.dao.Modification;
import characteristic.dao.Characteristic;
import characteristicvalue.dao.CharacteristicValue;

/** 
 * Characteristic value repository.
 * @author Aleksei_Ivshin
 *
 */
public interface CharacteristicValueRepository {

	/**
	 * Create new characteristic value in data store.
	 * @param modification modification 
	 * @param characteristic characteristic
	 * @param value characteristic value
	 * @param unit unit
	 * @return created characteristic value
	 */
	CharacteristicValue create(
			Modification modification, 
			Characteristic characteristic, 
			String value, String unit);
	
	/**
	 * Change characteristic value in data store.
	 * @param id characteristic value id
	 * @param newValue new value
	 * @param newUnit new unit
	 * @return changed characteristic value
	 */
	CharacteristicValue update(long id, String newValue, String newUnit);
	
	/**
	 * Find characteristic value by id.
	 * @param id characteristic value id
	 * @return founded characteristic value
	 */
	CharacteristicValue find(long id);
	
	/**
	 * Find characteristic values by modification.
	 * @param modification modification
	 * @return founded characteristic values
	 */
	List<CharacteristicValue> find(Modification modification);

	/**
	 * Find characteristic values by characteristic.
	 * @param characteristic characteristic
	 * @return founded characteristic values
	 */
	List<CharacteristicValue> find(Characteristic characteristic);
	
	/**
	 * Remove characteristic value from data store.
	 * @param id characteristic value id
	 */
	void remove(long id);
}
