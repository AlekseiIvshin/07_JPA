package service.merchant;

import java.util.List;

import customer.domain.CustomerDomain;

public interface MerchantService {

	List<CustomerDomain> findAll();
}
