package characteristic.domain;

/**
 * Characteristic domain.
 * @author AlekseiIvshin
 *
 */
public interface CharacteristicDomain {

	/** 
	 * Get name of characteristic.
	 * @return name
	 */
	String getName();
	
	/**
	 * Set characteristic name.
	 * @param name name
	 */
	void setName(String name);
	
	/**
	 * Get characteristic value.
	 * @return value
	 */
	String getValue();
	
	/**
	 * Set characteristic value.
	 * @param value value
	 */
	void setValue(String value);
	/** 
	 * Get characteristic unit.
	 * @return unit
	 */
	String getUnit();
	
	/**
	 * Set characteristic unit.
	 * @param unit unit
	 */
	void setUnit(String unit);
}
