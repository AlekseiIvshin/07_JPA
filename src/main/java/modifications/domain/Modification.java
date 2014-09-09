package modifications.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import characteristicvalue.domain.CharacteristicValue;
import models.domain.Model;

/**
 * Entity of table 'modification'.
 * @author AlekseiIvshin
 *
 */
@Entity
@Table(name = "car_modification")
public class Modification {
	
	/**
	 * Modification id.
	 */
	@Id
	@Column(name = "id_car_modification")
	private long id;
	
	/**
	 * Modification name.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Modification is deleted.
	 */
	@Column(name = "deleted", columnDefinition = "BIT", length = 1)
	private boolean deleted;
	
	/**
	 * Modification model.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_car_model")
	private Model model;
	
	/**
	 * Characteristics of modification.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modification")
	private List<CharacteristicValue> charactericticValues;
	
	/**
	 * Default constructor.
	 */
	public Modification() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public List<CharacteristicValue> getCharactericticValues() {
		return charactericticValues;
	}

	public void setCharactericticValues(
			List<CharacteristicValue> charactericticValues) {
		this.charactericticValues = charactericticValues;
	}
}
