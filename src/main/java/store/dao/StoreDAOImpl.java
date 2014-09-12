package store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

import car.dao.modifiacation.Modification;

public class StoreDAOImpl 
		extends GenericDAOImpl<Store, Integer>
		implements StoreDAO{

	public StoreDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Store> find(Modification modification) {
		return entityManager
				.createQuery("SELECT s FROM Store s "
						+ "WHERE s.modification=:modif")
				.setParameter("modif", modification)
				.getResultList();
	}
}
