package sales.domain;

import java.util.Date;

import customer.domain.CustomerDomain;
import merchant.domen.MerchantDomain;
import car.domain.CarDomain;

public interface SalesDomain {

	int getId();
	void setId(int id);
	CarDomain getCar();
	void setCar(CarDomain car);
	MerchantDomain getMerchant();
	void setMerchant(MerchantDomain merchant);
	CustomerDomain getCustomer();
	void setCustomer(CustomerDomain customer);
	float getPrice();
	void setPrice(float price);
	Date getSaleDate();
	void setSaleDate(Date saleDate);
}
