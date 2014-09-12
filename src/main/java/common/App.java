package common;

import java.util.Date;
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
import customer.domain.CustomerDomainImpl;
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
	}
	
	private static void saleSomeCar(){
		List<CarDomain> cars = new CarServiceImpl().getAll();
		List<CustomerDomain> customers = new CustomerServiceImpl().getAll();
		List<MerchantDomain> merchant = new MerchantServiceImpl().getAll();
		
		
	}

}
