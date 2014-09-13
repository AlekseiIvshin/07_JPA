package common;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	static final CarService carService = new CarServiceImpl();
	static final MerchantService merchantService = new MerchantServiceImpl();
	static final StoreService storeService = new StoreServiceImpl();
	static final SalesService salesService = new SalesServiceImpl();
	
	static final CustomerService customerService = new CustomerServiceImpl();
	/**
	 * Main.
	 * @param args in arguments
	 */
	public static void main(String[] args) {
		List<CarDomain> cars = carService.getAll();
		List<MerchantDomain> merchants = merchantService.getAll();
		List<CustomerDomain> customers = customerService.getAll();
		
		CustomerService cds = new CustomerServiceImpl();
		
		saleCar(cars.get(0), customers.get(0), merchants.get(0));
	}
	
	
	private <T> void showCollection(List<T> collection){
		for(T obj: collection){
			LOG.info(obj.toString());
		}
	}
	
	private static void saleCar(CarDomain car, CustomerDomain customer, MerchantDomain merchant){
		CustomerDomain actualCustomer = customerService.contains(customer);
		if( actualCustomer == null ){
			actualCustomer = customerService.create(customer);
		}
		
		
		salesService.create(customer, merchant, car);
	}

}
