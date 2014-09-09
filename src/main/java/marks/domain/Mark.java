package marks.domain;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity of table 'car_mark'.
 * @author AlekseiIvshin
 *
 */
@Entity
@Table(name = "car_mark")
public class Mark {
	
	/**
	 * Car mark id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_car_mark")
	private long id;
	
	/**
	 * Car mark name.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Default constructor.	
	 */
	public Mark() { }

	/**
	 * Constructor with parameters.
	 * @param name new mark name
	 */
	public Mark(String name) {
		this.name = name;
	}

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
}
