package car.dao.modifiacation;

import java.util.List;

import common.dao.GenericDAO;

public interface ModificationDAO extends GenericDAO<Modification, Long>{

	List<Modification> find(String markName, String modelName, String name);
}
