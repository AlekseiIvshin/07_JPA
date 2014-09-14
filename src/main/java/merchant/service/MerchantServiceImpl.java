package merchant.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import merchant.dao.Merchant;
import merchant.dao.MerchantDAO;
import merchant.dao.MerchantDAOImpl;
import merchant.domen.MerchantDomain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.mapper.MainMapper;
import common.mapper.Mapper;

public class MerchantServiceImpl implements MerchantService {
	
	static final Logger LOG = LoggerFactory.getLogger(MerchantServiceImpl.class);
	
	private EntityManager em;
	
	public MerchantServiceImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		em = emf.createEntityManager();
	}

	public List<MerchantDomain> get(int offset, int count) {
		MerchantDAO  merchantDAO = new MerchantDAOImpl(em);
		List<Merchant> merchants = merchantDAO.find(offset, count);
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(merchants, MerchantDomain.class);
	}

	public MerchantDomain change(MerchantDomain changedDomainMerchant) {
		Mapper mapper = new MainMapper();
		Merchant merchant = mapper.map(changedDomainMerchant, Merchant.class);
		MerchantDAO merchantDAO = new MerchantDAOImpl(em);
		Merchant changedMerchant = merchantDAO.update(merchant);
		return mapper.map(changedMerchant, MerchantDomain.class);
	}

	public MerchantDomain create(MerchantDomain newMerchant) {
		Mapper mapper = new MainMapper();
		Merchant merchant = mapper.map(newMerchant, Merchant.class);
		MerchantDAO merchantDAO = new MerchantDAOImpl(em);
		Merchant changedMerchant = merchantDAO.create(merchant);
		return mapper.map(changedMerchant, MerchantDomain.class);
	}

	
	

}
