package car.dao.model;

import java.util.List;

import common.dao.GenericDAO;

public interface ModelDAO extends GenericDAO<Model, Integer>{

	List<Model> find(String modelName, String markName);
}
