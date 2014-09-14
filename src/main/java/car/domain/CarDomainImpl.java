package car.domain;

import car.dao.modifiacation.Modification;

public class CarDomainImpl implements CarDomain {

	private final long id;
	private String mark;
	private String model;
	private String modification;

	public CarDomainImpl(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModification() {
		return modification;
	}

	public void setModification(String modification) {
		this.modification = modification;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", model=" + model
				+ ", modification=" + modification + "]";
	}

}
