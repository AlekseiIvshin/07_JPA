package common;

import java.util.List;

import merchant.domen.MerchantDomain;
import merchant.service.MerchantService;
import merchant.service.MerchantServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.domain.CarDomain;
import car.service.CarService;
import car.service.CarServiceImpl;
import customer.domain.CustomerDomain;
import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;

/** 
 * Main. 
 * @author AlekseiIvshin
 *
 */
public class App {

	static final Logger LOG = LoggerFactory.getLogger(App.class);
	/**
	 * Main.
	 * @param args in arguments
	 */
	public static void main(String[] args) {
		showAllCars();
	}
	
	private static void showAllCars(){
		CarService carService = new CarServiceImpl();
		List<CarDomain> cars = carService.getAll();
		LOG.info("Founded "+cars.size());
		for(CarDomain car: cars){
			LOG.info(car.toString());
		}
	}
	

	private static void showAllCustomers(){
		CustomerService customerService = new CustomerServiceImpl();
		List<CustomerDomain> customers = customerService.getAll();
		LOG.info("Founded "+customers.size());
		for(CustomerDomain customer: customers){
			LOG.info(customer.toString());
		}
	}

	private static void showAllMerchant(){
		MerchantService merchantService = new MerchantServiceImpl();
		List<MerchantDomain> merchants = merchantService.getAll();
		LOG.info("Founded "+ merchants.size());
		for(MerchantDomain merch: merchants){
			LOG.info(merch.toString());
		}
	}

}
