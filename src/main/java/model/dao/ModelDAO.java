package model.dao;

import java.util.List;

import mark.dao.Mark;

/**
 * Model service layer.
 * @author Aleksei_Ivshin
 *
 */
public interface ModelDAO {

	/**
	 * Create new model in data store.
	 * @param name new model name
	 * @param mark new model mark
	 * @return created model
	 */
	Model create(String name, Mark mark);
	
	
	/**
	 * Remove model from data store.
	 * @param id model id
	 */
	void remove(int id);
	
	/**
	 * Update model value in data store.
	 * @param id model id
	 * @param newModel new model name
	 * @return changed model
	 */
	Model update(int id, Model newModel);
	
	/**
	 * Find model in data store.
	 * @param id model id
	 * @return founded model
	 */
	Model find(int id);
	
	/**
	 * Find model in data store
	 * @param modelName name of model 
	 * @param markName mark of model
	 * @return list founded models
	 */
	List<Model> find(String modelName, String markName);
}
