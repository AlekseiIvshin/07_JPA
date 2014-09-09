package characteristicvalue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modifications.domain.Modification;

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
	@Column(name = "id_car_characteristic_value")
	private long id;
	
	/**
	 * Characteristic value.
	 */
	@Column
	private String value;
	
	/**
	 * Characteristic name.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_characteristic")
	private int characteristicId;
	
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

	public int getCharacteristicId() {
		return characteristicId;
	}

	public void setCharacteristicId(int characteristicId) {
		this.characteristicId = characteristicId;
	}

	public Modification getModification() {
		return modification;
	}

	public void setModification(Modification modification) {
		this.modification = modification;
	}

}
