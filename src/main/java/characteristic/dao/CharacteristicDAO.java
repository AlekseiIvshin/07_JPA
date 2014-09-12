package characteristic.dao;

import java.util.List;

import common.dao.GenericDAO;

public interface CharacteristicDAO extends GenericDAO<Characteristic, Long>{


	public List<Characteristic> find(String name);

	public List<Characteristic> find(Characteristic parent);
}
