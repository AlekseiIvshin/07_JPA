package sales.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import merchant.dao.Merchant;
import merchant.dao.MerchantDAO;
import merchant.dao.MerchantDAOImpl;
import merchant.domen.MerchantDomain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.dao.mark.MarkDAOImpl;
import car.dao.modifiacation.Modification;
import car.dao.modifiacation.ModificationDAO;
import car.dao.modifiacation.ModificationDAOImpl;
import car.domain.CarDomain;
import common.dao.GenericDAO;
import common.mapper.MainMapper;
import common.mapper.Mapper;
import customer.dao.Customer;
import customer.dao.CustomerDAO;
import customer.dao.CustomerDAOImpl;
import customer.domain.CustomerDomain;
import sales.dao.Sales;
import sales.dao.SalesDAOImpl;
import sales.domain.SalesDomain;
import sales.domain.SalesDomainImpl;
import store.dao.Store;
import store.dao.StoreDAO;
import store.dao.StoreDAOImpl;

public class SalesServiceImpl implements SalesService {

	static final Logger LOG = LoggerFactory
			.getLogger(SalesServiceImpl.class);

	private EntityManager entityManager;
	private GenericDAO<Sales, Integer> salesDAO;

	public SalesServiceImpl() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("07_JPA");
		entityManager = entityManagerFactory.createEntityManager();
		salesDAO = new SalesDAOImpl(entityManager);
	}

	public List<SalesDomain> getAll() {
		List<Sales> cusomers = salesDAO.findAll();
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(cusomers, SalesDomain.class);
	}

	public SalesDomain change(SalesDomain changedDomainSales) {
		Mapper mapper = new MainMapper();
		Sales sales = mapper.map(changedDomainSales, Sales.class);
				
		SalesDomain result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Sales changedSales = salesDAO.update(sales);
			transaction.commit();
			result = mapper.map(changedSales, SalesDomain.class);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		return result;
	}

	public SalesDomain create(SalesDomain newSales) {
		StoreDAO storeDAO = new StoreDAOImpl(entityManager);
		Mapper mapper = new MainMapper();
		Sales sales = mapper.map(newSales, Sales.class);
		SalesDomain result = null;
		try {
			entityManager.getTransaction().begin();
			Store store = storeDAO.find(sales.getModification());
			entityManager.lock(store, LockModeType.PESSIMISTIC_READ);
			if(store.getCount()>0){
				sales.setPrice(store.getPrice());
				Sales changedSales = salesDAO.create(sales);
				result = mapper.map(changedSales, SalesDomain.class);
				store.setCount(store.getCount()-1);
				storeDAO.update(store);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return result;
	}

	public SalesDomain create(CustomerDomain customer, MerchantDomain merchant,
			CarDomain car) {
		StoreDAO storeDAO = new StoreDAOImpl(entityManager);
		Mapper mapper = new MainMapper();
		Customer cust = mapper.map(customer, Customer.class);
		Merchant merch = mapper.map(merchant, Merchant.class);
		Modification modif = mapper.map(car, Modification.class);
		Sales sales = new Sales();
		sales.setCustomer(cust);
		sales.setMerchant(merch);
		sales.setModification(modif);
		
		SalesDomain result = null;
		try {
			entityManager.getTransaction().begin();
			Store store = storeDAO.find(modif);
			entityManager.lock(store, LockModeType.PESSIMISTIC_READ);
			if(store.getCount()>0){
				sales.setPrice(store.getPrice());
				Sales changedSales = salesDAO.create(sales);
				result = mapper.map(changedSales, SalesDomain.class);
				store.setCount(store.getCount()-1);
				storeDAO.update(store);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return result;
	}


}
