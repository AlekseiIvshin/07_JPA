package car.dao.modifiacation;

import java.util.List;

import car.dao.model.Model;
import common.dao.GenericDAO;

public interface ModificationDAO extends GenericDAO<Modification, Long>{

	List<Modification> findAny(Model model, String name);
	Modification findOne(Model model, String name);
	Modification addNewCar(String mark, String model, String modification);
}
