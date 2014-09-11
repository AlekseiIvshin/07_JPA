package sales.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import merchant.dao.Merchant;
import modification.dao.Modification;
import sales.dao.Sales;
import customer.dao.Customer;

public class SaleRepositoryImpl implements SaleRepository {

	private static final int SALES_IN_RESULT = 10;
	
	private EntityManager em;
	
	public SaleRepositoryImpl(EntityManager em){
		this.em = em;
	}
	public Sales create(Modification modification, Customer customer,
			Merchant merchant,  BigDecimal price) {
		Sales s = new Sales();
		s.setCustomer(customer);
		s.setMerchant(merchant);
		s.setModification(modification);
		s.setPrice(price);

		em.persist(s);
		return s;
	}

	public Sales find(int id) {
		return em.find(Sales.class, id);
	}

	public List<Sales> find(Modification modification) {
		return em
				.createQuery("SELECT s FROM Sales s "
						+ "WHERE s.modification=:modif")
				.setParameter("modif", modification)
				.setMaxResults(SALES_IN_RESULT)
				.getResultList();
	}

	public List<Sales> find(Customer customer) {
		return em
				.createQuery("SELECT s FROM Sales s "
						+ "WHERE s.customer=:customer")
				.setParameter("customer", customer)
				.setMaxResults(SALES_IN_RESULT)
				.getResultList();
	}

	public List<Sales> find(Merchant merchant) {
		return em
				.createQuery("SELECT s FROM Sales s "
						+ "WHERE s.merchant=:merchant")
				.setParameter("merchant", merchant)
				.setMaxResults(SALES_IN_RESULT)
				.getResultList();
	}

	public void remove(int id) {
		Sales s = em.find(Sales.class, id);
		if (s != null) {
			em.remove(s);
		}
	}

}
