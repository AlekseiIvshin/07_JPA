package car.domain;

import java.util.List;

import modification.dao.Modification;
import characteristic.domain.CharacteristicDomainComposite;

/**
 * Car interface.
 * @author AlekseiIvshin
 *
 */
public interface CarDomain {

	/** 
	 * Get car mark.
 	 * @return mark
	 */
	String getMark();
	
	/**
	 * Set car mark.
	 * @param mark mark
	 */
	void setMark(String mark);
	
	/**
	 * Get car model.
	 * @return model
	 */
	String getModel();
	
	/**
	 * Set car model.
	 * @param model model
	 */
	void setModel(String model);
	
	/**
	 * Get car modification.
	 * @return modification
	 */
	String getModification();
	
	/**
	 * Set modification.
	 * @param modification modification
	 */
	void setModification(Modification modification);
	
	/**
	 * Set car characteristic.
	 * @param characteristics characteristic list
	 */
	void setCharacteristic(CharacteristicDomainComposite characteristics);
	
	/**
	 * Get car characteristics.
	 * @return car characteristics
	 */
	CharacteristicDomainComposite getCharacteristics();
}
