package car.dao.mark;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.dao.model.ModelDAOImpl;
import common.dao.GenericDAOImpl;
import customer.dao.Customer;
import customer.dao.Customer_;

public class MarkDAOImpl 
		extends GenericDAOImpl<Mark, Integer>
		implements MarkDAO{

	static final Logger LOG = LoggerFactory.getLogger(MarkDAOImpl.class);
	
	public MarkDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	public List<Mark> find(String name) {
		return entityManager
				.createQuery("SELECT m FROM Mark m WHERE m.name LIKE :markName")
				.setParameter("markName", name)
				.getResultList();
	}


	public List<Mark> findAny(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Mark> query = builder.createQuery(Mark.class);
		Root<Mark> root = query.from(Mark.class);
		query
			.where(
				builder.like(
						root.get(Mark_.name), 
						name))
			.select(root);
		TypedQuery<Mark>ctq = entityManager.createQuery(query);
		return ctq.getResultList();
	}


	public Mark findOne(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Mark> query = builder.createQuery(Mark.class);
		Root<Mark> root = query.from(Mark.class);
		query
			.where(
				builder.equal(
						root.get(Mark_.name), 
						name));
		TypedQuery<Mark> ctq = entityManager.createQuery(query);
		try{
			return ctq.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}

}
