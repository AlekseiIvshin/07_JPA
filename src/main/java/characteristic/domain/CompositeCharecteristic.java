package characteristic.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CompositeCharecteristic implements CharacteristicDomainComposite{

	private Map<Integer, CharacteristicDomainComposite> innerUnits;
	private String name;
	private int id;
	private String value;
	private String valueUnit;
	
	CompositeCharecteristic() {
		innerUnits = new HashMap<Integer, CharacteristicDomainComposite>();
	}
	
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

	public void addUnit(CharacteristicDomainComposite unit) {
		if(!innerUnits.containsValue(unit)){
			innerUnits.put(unit.getId(), unit);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CharacteristicDomainComposite getUnit(int id) {
		if(this.id == id){
			return this;
		}
		Integer wrappedId = new Integer(id);
		if(innerUnits.containsKey(wrappedId)) {
			return innerUnits.get(wrappedId);
		}
		
		for(CharacteristicDomainComposite u: innerUnits.values()){
			CharacteristicDomainComposite res = u.getUnit(id);
			if(res != null) {
				return res;
			}
		}
		
		return null;
	}

}
