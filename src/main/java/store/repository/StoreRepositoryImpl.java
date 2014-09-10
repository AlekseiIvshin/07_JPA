package store.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import modifications.dao.Modification;
import store.dao.Store;

public class StoreRepositoryImpl implements StoreRepository {

	private static final int STORE_IN_RESULT = 10;
	
	private EntityManager em;
	
	public StoreRepositoryImpl(EntityManager em){
		this.em = em;
	}
	
	public Store create(Modification modification, int count, BigDecimal price,
			boolean testDriveAvaible) {
		Store s = new Store();
		s.setModification(modification);
		s.setCount(count);
		s.setPrice(price);
		s.setTestDriveAvaible(testDriveAvaible);
		em.persist(s);
		return s;
	}

	public Store update(int id, int newCount) {
		Store s = em.find(Store.class, id);
		if (s != null ) {
			s.setCount(newCount);
		}
		return s;
	}

	public Store update(int id, BigDecimal newPrice) {
		Store s = em.find(Store.class, id);
		if (s != null ) {
			s.setPrice(newPrice);
		}
		return s;
	}

	public Store update(int id, boolean newTestDriveAvaible) {
		Store s = em.find(Store.class, id);
		if (s != null ) {
			s.setTestDriveAvaible(newTestDriveAvaible);
		}
		return s;
	}

	public Store find(int id) {
		return em.find(Store.class, id);
	}

	public List<Store> find(Modification modification) {
		return em
				.createQuery("SELECT s FROM Store s "
						+ "WHERE s.modification=:modif")
				.setParameter("modif", modification)
				.setMaxResults(STORE_IN_RESULT)
				.getResultList();
	}

	public void remove(int id) {
		Store s = em.find(Store.class, id);
		if (s != null ) {
			em.remove(s);
		}
	}

}
