package car.dao.model;

import java.util.List;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

public class ModelDAOImpl extends GenericDAOImpl<Model, Integer>
		implements ModelDAO {

	public ModelDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Model> find(String modelName, String markName) {
		return entityManager
				.createQuery("SELECT m FROM Model m, IN(m.mark) AS mark "
						+ "WHERE m.name LIKE :modelName "
						+ "and mark.name LIKE :markName")
				.setParameter("modelName", modelName)
				.setParameter("markName", markName)
				.getResultList();
	}
}
