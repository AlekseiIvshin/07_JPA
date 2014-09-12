package car.service;

import java.util.List;

import characteristic.domain.CharacteristicDomainComposite;
import car.domain.CarDomain;

/**
 * Car service interface.
 * @author AlekseiIvshin
 *
 */
public interface CarService {

	List<CarDomain> getAll();
	List<CarDomain> getCars(String mark, String model, String modification);
	CarDomain addCar(String mark, String model, 
			String modification, CharacteristicDomainComposite characteristics);
	CarDomain removeCar(String mark, String model, String modification);
	
	
}
