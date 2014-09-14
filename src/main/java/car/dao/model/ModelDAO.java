package car.dao.model;

import java.util.List;

import car.dao.mark.Mark;
import common.dao.GenericDAO;

public interface ModelDAO extends GenericDAO<Model, Integer>{

	List<Model> findAny(Mark mark, String name);
	Model findOne(Mark mark, String name);
}
