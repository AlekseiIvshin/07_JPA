package store.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.dao.GenericDAO;
import common.mapper.MainMapper;
import common.mapper.Mapper;
import store.dao.Store;
import store.dao.StoreDAOImpl;
import store.domain.StoreDomain;

public class StoreServiceImpl implements StoreService {

	static final Logger LOG = LoggerFactory
			.getLogger(StoreServiceImpl.class);

	private EntityManager entityManager;
	private GenericDAO<Store, Integer> storeDAO;

	public StoreServiceImpl() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("07_JPA");
		entityManager = entityManagerFactory.createEntityManager();
		storeDAO = new StoreDAOImpl(entityManager);
	}

	public List<StoreDomain> getAll() {
		List<Store> cusomers = storeDAO.findAll();
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(cusomers, StoreDomain.class);
	}

	public StoreDomain change(StoreDomain changedDomainStore) {
		Mapper mapper = new MainMapper();
		Store store = mapper.map(changedDomainStore, Store.class);
				
		StoreDomain result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Store changedStore = storeDAO.update(store);
			transaction.commit();
			result = mapper.map(changedStore, StoreDomain.class);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

	public StoreDomain create(StoreDomain newStore) {
		Mapper mapper = new MainMapper();
		Store store = mapper.map(newStore, Store.class);
		LOG.info(store.toString());
		
		StoreDomain result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Store changedStore = storeDAO.create(store);
			transaction.commit();
			result = mapper.map(changedStore, StoreDomain.class);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

	public StoreDomain decrementQuanity(StoreDomain store) {
		if(!store.canSale()){
			return store;
		}
		store.setQuantity(store.getQuantity()-1);
		return change(store);
	}

}
