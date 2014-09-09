package marks.service;

import javax.persistence.EntityManager;

import marks.domain.Mark;
/**
 * Mark service layer.
 * @author AlekseiIvshin
 *
 */
public interface MarkService {

	
	/**
	 * Create new mark in data store.
	 * @param name new mark name
	 * @return created mark
	 */
	public Mark createMark(String name);
	
	/**
	 * Remove mark from data store
	 * @param id mark id
	 */
	public void removeMark(int id);
	
	/**
	 * Update mark value in data store.
	 * @param id mark id
	 * @param newName new mark name
	 * @return
	 */
	public Mark updateMark(int id, Mark newMark);
	
	/**
	 * Find mark in data store.
	 * @param id mark id
	 * @return founded mark
	 */
	public Mark findMark(int id);
}
