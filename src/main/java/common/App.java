package common;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.NoResultException;

import merchant.domen.MerchantDomain;
import merchant.service.MerchantService;
import merchant.service.MerchantServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sales.domain.SalesDomain;
import sales.domain.SalesDomainImpl;
import sales.service.SalesService;
import sales.service.SalesServiceImpl;
import store.domain.StoreDomain;
import store.service.StoreService;
import store.service.StoreServiceImpl;
import car.domain.CarDomain;
import car.service.CarService;
import car.service.CarServiceImpl;
import customer.dao.Customer;
import customer.domain.CustomerDomain;
import customer.domain.CustomerDomainImpl;
import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;
import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;

/** 
 * Main. 
 * @author AlekseiIvshin
 *
 */
public class App {

	static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	private static final CarService CAR_SERVICE = new CarServiceImpl();
	private static final CustomerService CUSTOMER_SERVICE = new CustomerServiceImpl();
	private static final MerchantService MERCHANT_SERVICE = new MerchantServiceImpl();
	private static final SalesService SALES_SERVICE = new SalesServiceImpl();
	
	/**
	 * Main.
	 * @param args in arguments
	 */
	public static void main(String[] args) {
		CustomerDomain customer = null;
		try{
			customer = getAnyCustomer();
		} catch (NoResultException e){
			LOG.error(e.toString());
			customer = new CustomerDomainImpl();
			customer.setName("Name");
			customer.setSurname("SurName");
			customer.setPatronymic("Patronymic");
			customer.setPassportNumber("000000");
			customer.setPassportSeries("0000");
			LOG.info("Create new customer in data base: "+customer.toString());
			customer = CUSTOMER_SERVICE.create(customer);
		}
		LOG.info("Get customer: {}", customer.toString());
		MerchantDomain merchant = getAnyMerchant();
		LOG.info("Get merchant: {}", merchant.toString());
		CarDomain car = getAnyCar();
		LOG.info("Get car: {}", car.toString());
		SalesDomain sale = null;
		try {
			sale = createAnySale(customer, merchant, car);
		} catch (Exception e) {
			LOG.error("New sale error", e);
		}
		LOG.info(sale.toString());
		
	}
	
	private static CarDomain getAnyCar(){
		List<CarDomain> cars = CAR_SERVICE.get(0, 100);
		if(cars.isEmpty()){
			throw new NoResultException("Cars is not exist");
		}
		Random rnd = new Random();
		return cars.get(rnd.nextInt(cars.size()));
	}
	
	private static CustomerDomain getAnyCustomer(){
		List<CustomerDomain> customers = CUSTOMER_SERVICE.get(0, 100);
		if(customers.isEmpty()){
			throw new NoResultException("Customers is not exist");
		}
		Random rnd = new Random();
		return customers.get(rnd.nextInt(customers.size()));
	}
	
	private static MerchantDomain getAnyMerchant(){
		List<MerchantDomain> merchants = MERCHANT_SERVICE.get(0, 100);
		if(merchants.isEmpty()){
			throw new NoResultException("Merchants is not exist");
		}
		Random rnd = new Random();
		return merchants.get(rnd.nextInt(merchants.size()));
	}
	
	private static SalesDomain createAnySale(CustomerDomain customer, MerchantDomain merchant, CarDomain car) throws Exception{
		return SALES_SERVICE.newSale(customer, merchant, car);
	}
}
