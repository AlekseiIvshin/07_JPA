package merchant.repository;

import java.util.List;

import javax.persistence.EntityManager;

import merchant.dao.Merchant;

public class MerchantRepositoryImpl implements MerchantRepository{

	private static final int CUSTOMER_IN_RESULT = 10;
	private EntityManager em;
	
	public Merchant create(Merchant merchant) {
		Merchant m = new Merchant();
		m.setName(merchant.getName());
		m.setSurname(merchant.getSurname());
		m.setPatronymic(merchant.getPatronymic());
		m.setDeleted(false);
		
		em.persist(m);
		
		return m;
	}

	public Merchant find(int id) {
		return em.find(Merchant.class, id);
	}

	public List<Merchant> findAll() {
		return em.createQuery("SELECT c FROM Merchant c")
				.setMaxResults(CUSTOMER_IN_RESULT)
				.getResultList();
	}

	public Merchant update(int id, Merchant newMerchantData) {
		Merchant m = em.find(Merchant.class, id);
		if (m != null) {
			m.setName(newMerchantData.getName());
			m.setSurname(newMerchantData.getSurname());
			m.setPatronymic(newMerchantData.getPatronymic());
			m.setDeleted(newMerchantData.getDeleted());
		}
		
		return m;
	}

	public void remove(int id) {
		Merchant m = em.find(Merchant.class, id);
		if (m != null) {
			em.refresh(m);
		}
		
	}

}
