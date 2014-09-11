package modification.repository;

import java.util.List;

import mark.dao.Mark;
import model.dao.Model;
import modification.dao.Modification;

/** 
 * Modification repository.
 * @author Aleksei_Ivshin
 *
 */
public interface ModificationRepository {

	/**
	 * Create new modification.
	 * @param model modification model
	 * @param name modification name
	 * @return created modification
	 */
	Modification create(Model model, String name);
	 
	/**
	 * Change modification name.
	 * @param id modification id
	 * @param newName new modification name 
	 * @return changed modification 
	 */
	Modification update(int id, String newName);
	

	/**
	 * Change modification model.
	 * @param id modification id
	 * @param newModel new modification model 
	 * @return changed modification 
	 */
	Modification update(int id, Model newModel);
	
	/**
	 * Find modification by id.
	 * @param id modification id
	 * @return founded modification 
	 */
	Modification find(int id);
	
	/**
	 * Find modification by name, mark and model names.
	 * @param markName mark modification name
	 * @param modelName model modification name
	 * @param name modification name
	 * @return founded modifications
	 */
	List<Modification> find(String markName, String modelName, String name);
	
	/**
	 * Remove modification from data store.
	 * @param id modification id
	 */
	void remove(int id);
}
