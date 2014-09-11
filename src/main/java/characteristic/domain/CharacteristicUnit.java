package characteristic.domain;

public class CharacteristicUnit implements CharacteristicDomainComposite {

	private String name;
	private int id;
	private String value;
	private String valueUnit;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;	
	}

	public String getValueUnit() {
		return valueUnit;
	}

	public void setValueUnit(String valueUnit) {
		this.valueUnit = valueUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addUnit(CharacteristicDomainComposite unit) { }

	public CharacteristicDomainComposite getUnit(int id) {
		return null;
	}

}
