package car.service;

import java.util.List;

import car.domain.CarDomain;

/**
 * Car service interface.
 * @author AlekseiIvshin
 *
 */
public interface CarService {

	List<CarDomain> get(int offset, int count);
	CarDomain addCar(String mark, String model, String modification);
	void removeCar(String mark, String model, String modification);
	CarDomain addCar(CarDomain car);
	void removeCar(CarDomain car);
	CarDomain findOne(String mark, String model, String modification);
	
}
