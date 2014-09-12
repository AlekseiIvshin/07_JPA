package car.dao.mark;

import java.util.List;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

public class MarkDAOImpl 
		extends GenericDAOImpl<Mark, Integer>
		implements MarkDAO{

	public MarkDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	public List<Mark> find(String name) {
		return entityManager
				.createQuery("SELECT m FROM Mark m WHERE m.name LIKE :markName")
				.setParameter("markName", name)
				.getResultList();
	}

}
