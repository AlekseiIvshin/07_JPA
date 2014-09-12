package sales.service;

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
import sales.dao.Sales;
import sales.dao.SalesDAOImpl;
import sales.domain.SalesDomain;

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
		Mapper mapper = new MainMapper();
		Sales sales = mapper.map(newSales, Sales.class);
		LOG.info(sales.toString());
		
		SalesDomain result = null;
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			Sales changedSales = salesDAO.create(sales);
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

}
