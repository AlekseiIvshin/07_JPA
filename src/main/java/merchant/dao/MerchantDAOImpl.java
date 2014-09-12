package merchant.dao;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

public class MerchantDAOImpl 
		extends GenericDAOImpl<Merchant, Integer>
		implements MerchantDAO{

	public MerchantDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
