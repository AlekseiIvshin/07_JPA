package characteristic.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity of car characteristics.
 * @author dnss
 *
 */
@Entity
@Table(name = "car_characteristic")
public class Characteristic {
	
	/**
	 * Characteristic id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_characteristic")
	private int id;
	
	/** 
	 * Characteristic name.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Characteristic parent.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parent", referencedColumnName = "id_characteristic")
	private Characteristic parentCharacteristic;
	
	/**
	 * Categories of characteristics.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCharacteristic")
	private List<Characteristic> chacteristicCategories;

	/**
	 * Default constructor.
	 */
	public Characteristic() { }
	
	public Characteristic(String name, Characteristic parent) {
		this.name = name;
		this.parentCharacteristic = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Characteristic getParentCharacteristic() {
		return parentCharacteristic;
	}

	public void setParentCharacteristic(Characteristic parentCharacteristic) {
		this.parentCharacteristic = parentCharacteristic;
	}

	public List<Characteristic> getChacteristicCategories() {
		return chacteristicCategories;
	}

	public void setChacteristicCategories(
			List<Characteristic> chacteristicCategories) {
		this.chacteristicCategories = chacteristicCategories;
	}

}
