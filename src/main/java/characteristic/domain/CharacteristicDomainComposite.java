package characteristic.domain;

public interface CharacteristicDomainComposite {

	int getId();
	void setId(int id);
	String getName();
	void setName(String name);
	String getValue();
	void setValue(String value);
	String getValueUnit();
	void setValueUnit(String valueUnit);
	void addUnit(CharacteristicDomainComposite unit);
	CharacteristicDomainComposite getUnit(int id);
}
