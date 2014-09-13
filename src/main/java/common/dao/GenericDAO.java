package common.dao;

import java.util.List;

public interface GenericDAO<Model, IdType> {

	Model create(Model entity);
	Model update(Model entity);
	Model find(IdType id);
	List<Model> findAll();
	void delete(IdType id);
	List<Model> find(int offset, int limit);
}
