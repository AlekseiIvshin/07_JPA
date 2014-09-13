package sales.service;

import sales.domain.SalesDomain;

import java.util.List;

import customer.domain.CustomerDomain;
import merchant.domen.MerchantDomain;
import car.domain.CarDomain;

public interface SalesService {

	List<SalesDomain> getAll();
	SalesDomain change(SalesDomain changedDomainSales);
	SalesDomain create(SalesDomain newSales);
	SalesDomain create(CustomerDomain customer, MerchantDomain merchant, CarDomain car);
}
