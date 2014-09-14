package sales.service;

import sales.domain.SalesDomain;

import java.util.List;

import customer.domain.CustomerDomain;
import merchant.domen.MerchantDomain;
import car.domain.CarDomain;

public interface SalesService {

	List<SalesDomain> get(int offset, int count);
	SalesDomain change(SalesDomain changedDomainSales);
	SalesDomain newSale(SalesDomain newSales) throws Exception;
	SalesDomain newSale(CustomerDomain customer, MerchantDomain merchant, CarDomain car) throws Exception;
}
