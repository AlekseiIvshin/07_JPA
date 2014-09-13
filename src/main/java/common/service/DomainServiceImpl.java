package common.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ch.qos.logback.core.util.DynamicClassLoadingException;
import common.dao.GenericDAO;
import common.mapper.MainMapper;
import common.mapper.Mapper;
import customer.dao.Customer;
import customer.domain.CustomerDomain;
import sales.dao.Sales;
import sales.dao.SalesDAOImpl;
import sales.domain.SalesDomain;

public class DomainServiceImpl<DomainClass, DomainId,Model, IdType, DAOClass extends GenericDAO<Model, IdType>> implements DomainService<DomainClass, IdType> {

	protected EntityManager entityManager;
	protected DAOClass dao;
	protected Class<DomainClass> domainType;
	protected Class<Model> modelType;
	protected Mapper mapper;
	
	public DomainServiceImpl(){
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("07_JPA");
		entityManager = entityManagerFactory.createEntityManager();
		this.domainType = (Class<DomainClass>) 
				((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.modelType = (Class<Model>) 
				((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[3];
		mapper = new MainMapper();
	}
	
	public List<DomainClass> getAll() {
		List<Model> cusomers = dao.findAll();
		return mapper.mapAsList(cusomers, domainType);
	}

	public DomainClass change(DomainClass changedData) {
		Model modelClass = mapper.map(changedData, modelType);
		DomainClass result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Model changedCustomer = dao.update(modelClass);
			transaction.commit();
			result = mapper.map(changedCustomer, domainType);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

	public DomainClass create(DomainClass newData) {
		Model customer = mapper.map(newData, modelType);
		
		DomainClass result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Model persistedData = dao.create(customer);
			transaction.commit();
			result = mapper.map(persistedData, domainType);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

	public DomainClass get(IdType id) {
		Model data = dao.find(id);
		return mapper.map(data, domainType);
	}

	public List<DomainClass> get(int offset, int limit) {
		List<Model> cusomers = dao.find(offset, limit);
		return mapper.mapAsList(cusomers, domainType);
	}

}
