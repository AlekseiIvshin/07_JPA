package store.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import common.dao.GenericDAOImpl;
import car.dao.modifiacation.Modification;

public class StoreDAOImpl 
		extends GenericDAOImpl<Store, Integer>
		implements StoreDAO{

	public StoreDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Store find(Modification modification) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Store> query = builder.createQuery(Store.class);
		Root<Store> rootStore = query.from(Store.class);
		query.where(builder.equal(rootStore.get(Store_.modification), modification))
			.select(rootStore);
		return entityManager.createQuery(query).getSingleResult();
	}
}
