package service.merchant;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import merchant.domen.MerchantDomain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.customer.CustomerServiceImpl;
import service.mapper.Mapper;
import service.mapper.factory.CustomerMapperFactory;
import service.mapper.factory.MyMapperFactory;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import dao.customer.Customer;
import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;
import dao.merchant.Merchant;
import dao.merchant.MerchantDAO;
import dao.merchant.MerchantDAOImpl;

public class MerchantServceImpl implements MerchantService {

	static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private EntityManager em;
	
	public MerchantServceImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		em = emf.createEntityManager();
	}
	
	public List<CustomerDomain> findAll() {
		MerchantDAO  merchantDAO = new MerchantDAOImpl(em);
		List<Merchant> merchants = merchantDAO.findAll();
		MyMapperFactory mapperFactory = new CustomerMapperFactory();
		Mapper mapper = mapperFactory.createDaoToDomainMapper(Merchant.class, MerchantDAOImpl.class);
		
		return mapper.mapAsList(merchants, MerchantDomain.class);
	}

}
