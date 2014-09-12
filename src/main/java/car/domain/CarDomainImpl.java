package car.domain;

import car.dao.modifiacation.Modification;
import characteristic.domain.CharacteristicDomainComposite;

public class CarDomainImpl implements CarDomain {

	private final long id;
	private String mark;
	private String model;
	private String modification;
	private CharacteristicDomainComposite characteristics;

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

	public void setCharacteristic(CharacteristicDomainComposite characteristics) {
		this.characteristics = characteristics;
	}

	public CharacteristicDomainComposite getCharacteristics() {
		return characteristics;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", model=" + model
				+ ", modification=" + modification + "]";
	}

}
