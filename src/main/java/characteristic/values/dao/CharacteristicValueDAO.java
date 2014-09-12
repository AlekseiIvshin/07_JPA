package characteristic.values.dao;

import java.util.List;

import common.dao.GenericDAO;

import characteristic.dao.Characteristic;
import car.dao.modifiacation.Modification;

public interface CharacteristicValueDAO extends GenericDAO<CharacteristicValue, Long>{

	public List<CharacteristicValue> find(Modification modification);

	public List<CharacteristicValue> find(Characteristic characteristic);
}
