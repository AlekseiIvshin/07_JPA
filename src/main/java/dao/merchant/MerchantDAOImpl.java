package dao.merchant;

import javax.persistence.EntityManager;

import dao.GenericDAOImpl;

public class MerchantDAOImpl 
		extends GenericDAOImpl<Merchant, Integer>
		implements MerchantDAO{

	public MerchantDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
