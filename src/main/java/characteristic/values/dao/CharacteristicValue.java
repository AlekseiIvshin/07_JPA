package characteristic.values.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import characteristic.dao.Characteristic;
import car.dao.modifiacation.Modification;

/**
 * Entity of table 'car_characteristic_value'.
 * @author AlekseiIvshin
 *
 */
@Entity
@Table(name = "car_characteristic_value")
public class CharacteristicValue {
	
	/**
	 * Characteristic value id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_car_characteristic_value")
	private long id;
	
	/**
	 * Characteristic value.
	 */
	@Column
	private String value;
	

	/**
	 * Characteristic unit.
	 */
	@Column
	private String unit;
	
	/**
	 * Characteristic name.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_characteristic")
	private Characteristic characteristic;
	
	/**
	 * Modifications characteristic value.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_car_modification")
	private Modification modification;

	/**
	 * Default constructor.
	 */
	public CharacteristicValue() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

	public Modification getModification() {
		return modification;
	}

	public void setModification(Modification modification) {
		this.modification = modification;
	}

}
