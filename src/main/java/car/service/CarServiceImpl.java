package car.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.mapper.MainMapper;
import common.mapper.Mapper;
import customer.service.CustomerServiceImpl;
import car.dao.modifiacation.Modification;
import car.dao.modifiacation.ModificationDAO;
import car.dao.modifiacation.ModificationDAOImpl;
import car.domain.CarDomain;
import car.domain.CarDomainImpl;
import characteristic.domain.CharacteristicDomainComposite;

public class CarServiceImpl implements CarService {

	static final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);
	
	private EntityManager entityManager;
	
	public CarServiceImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		entityManager = emf.createEntityManager();
	}
	
	public List<CarDomain> getCars(String mark, String model,
			String modification) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarDomain addCar(String mark, String model, String modification,
			CharacteristicDomainComposite characteristics) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarDomain removeCar(String mark, String model, String modification) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CarDomain> getAll() {
		ModificationDAO modificationDAO = new ModificationDAOImpl(entityManager);
		List<Modification> modifications = modificationDAO.findAll();
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(modifications, CarDomain.class);
		
	}

}
