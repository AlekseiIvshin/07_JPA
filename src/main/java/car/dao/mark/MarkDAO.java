package car.dao.mark;

import java.util.List;

import common.dao.GenericDAO;

public interface MarkDAO extends GenericDAO<Mark, Integer>{

	List<Mark> find(String name);
}
