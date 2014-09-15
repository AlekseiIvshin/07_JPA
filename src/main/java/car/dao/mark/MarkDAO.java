package car.dao.mark;

import java.util.List;

import common.dao.GenericDAO;

/**
 * Mark DAO interface.
 * 
 * @author Aleksei_Ivshin
 *
 */
public interface MarkDAO extends GenericDAO<Mark, Integer> {

	/**
	 * Find marks with name like parameter.
	 * 
	 * @param name
	 *            part or full car mark name
	 * @return founded marks
	 */
	List<Mark> findAny(String name);

	/**
	 * Find marks with name equal parameter.
	 * 
	 * @param name
	 *            full mark name
	 * @return founded mark or null (if not found)
	 */
	Mark findOne(String name);
}
