package models.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import marks.domain.Mark;

/**
 * Entity of table 'car_model'.
 * @author AlekseiIvshin
 *
 */
@Entity
@Table(name = "car_model")
public class Model {

	/**
	 * Car model id.
	 */
	@Id
	@Column(name = "id_car_model")
	private int id;
	
	/**
	 * Car model name.
	 */
	@Column(name = "name")
	private String name;
	
	/** 
	 * Car mark.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_car_mark")
	private Mark mark;

	/**
	 * Default constructor.
	 */
	public Model() { }
	/**
	 * Get model id.
	 * @return id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * Set model id.
	 * @param id new id
	 */
	public final void setId(final int id) {
		this.id = id;
	}

	/**
	 * Get model name.
	 * @return name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Set model name.
	 * @param name new name
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * Get model mark.
	 * @return current mark
	 */
	public final Mark getMark() {
		return mark;
	}

	/**
	 * Set model mark.
	 * @param mark model mark
	 */
	public final void setMark(final Mark mark) {
		this.mark = mark;
	}
}
