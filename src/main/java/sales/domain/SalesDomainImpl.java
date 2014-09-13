package sales.domain;

import java.util.Date;

import merchant.domen.MerchantDomain;
import car.domain.CarDomain;
import customer.domain.CustomerDomain;

public class SalesDomainImpl implements SalesDomain {

	private int id;
	private CarDomain car;
	private MerchantDomain merchant;
	private CustomerDomain customer;
	private float price;
	private Date saleDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarDomain getCar() {
		return car;
	}

	public void setCar(CarDomain car) {
		this.car = car;
	}

	public MerchantDomain getMerchant() {
		return merchant;
	}

	public void setMerchant(MerchantDomain merchant) {
		this.merchant = merchant;
	}

	public CustomerDomain getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDomain customer) {
		this.customer = customer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

}
