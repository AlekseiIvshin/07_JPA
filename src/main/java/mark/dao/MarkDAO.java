package mark.dao;

import java.util.List;
/**
 * Mark service layer.
 * @author AlekseiIvshin
 *
 */
public interface MarkDAO {

	
	/**
	 * Create new mark in data store.
	 * @param name new mark name
	 * @return created mark
	 */
	Mark create(String name);
	
	/**
	 * Remove mark from data store.
	 * @param id mark id
	 */
	void remove(int id);
	
	/**
	 * Update mark value in data store.
	 * @param id mark id
	 * @param newMark new mark name
	 * @return changed mark
	 */
	Mark update(int id, Mark newMark);
	
	/**
	 * Find mark in data store.
	 * @param id mark id
	 * @return founded mark
	 */
	Mark find(int id);
	

	/**
	 * Find mark in data store.
	 * @param name mark name
	 * @return founded mark
	 */
	List<Mark> find(String name);
}
