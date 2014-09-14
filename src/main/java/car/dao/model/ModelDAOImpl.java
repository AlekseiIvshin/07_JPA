package car.dao.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.dao.mark.Mark;
import car.dao.mark.Mark_;
import car.dao.modifiacation.ModificationDAOImpl;
import common.dao.GenericDAOImpl;

public class ModelDAOImpl extends GenericDAOImpl<Model, Integer>
		implements ModelDAO {

	static final Logger LOG = LoggerFactory.getLogger(ModelDAOImpl.class);
	
	
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

	public List<Model> findAny(Mark mark, String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Model> query = builder.createQuery(Model.class);
		Root<Model> root = query.from(Model.class);
		query
			.where(
				builder.like(
						root.get(Model_.name), 
						name))
			.where(
				builder.equal(
						root.get(Model_.mark), 
						mark))
			.select(root);
		TypedQuery<Model>ctq = entityManager.createQuery(query);
		return ctq.getResultList();
	}

	public Model findOne(Mark mark, String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Model> query = builder.createQuery(Model.class);
		Root<Model> root = query.from(Model.class);
		query
			.where(
				builder.equal(
						root.get(Model_.name), 
						name))
		.where(
				builder.equal(
						root.get(Model_.mark), 
						mark))
			.select(root);
		TypedQuery<Model>ctq = entityManager.createQuery(query);
		try{
			return ctq.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
