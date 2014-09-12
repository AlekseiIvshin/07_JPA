package merchant.service;

import java.util.List;

import merchant.domen.MerchantDomain;

public interface MerchantService {

	public List<MerchantDomain> getAll();

	public MerchantDomain change(MerchantDomain changedDomainMerchant);

	public MerchantDomain create(MerchantDomain newMerchant);
}
