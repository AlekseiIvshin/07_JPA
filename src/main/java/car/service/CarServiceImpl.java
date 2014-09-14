package car.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.mapper.MainMapper;
import common.mapper.Mapper;
import car.dao.mark.Mark;
import car.dao.mark.MarkDAO;
import car.dao.mark.MarkDAOImpl;
import car.dao.model.Model;
import car.dao.model.ModelDAO;
import car.dao.model.ModelDAOImpl;
import car.dao.modifiacation.Modification;
import car.dao.modifiacation.ModificationDAO;
import car.dao.modifiacation.ModificationDAOImpl;
import car.domain.CarDomain;

public class CarServiceImpl implements CarService {

	static final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

	private EntityManager entityManager;

	public CarServiceImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("07_JPA");
		entityManager = emf.createEntityManager();
	}

	public CarDomain addCar(String mark, String model, String modification) {
		ModificationDAO modifDAO = new ModificationDAOImpl(entityManager);
		Modification modif = modifDAO.addNewCar(mark, model, modification);
		Mapper mapper = new MainMapper();
		return mapper.map(modif, CarDomain.class);
	}

	public void removeCar(String mark, String model, String modification) {
		MarkDAO markDAO = new MarkDAOImpl(entityManager);
		Mark markEntity = markDAO.findOne(mark);
		if (markEntity == null) {
			return;
		}

		ModelDAO modelDAO = new ModelDAOImpl(entityManager);
		Model modelEntity = modelDAO.findOne(markEntity, model);
		if (modelEntity == null) {
			return;
		}

		ModificationDAO modificationDAO = new ModificationDAOImpl(entityManager);
		Modification modifEntity = modificationDAO.findOne(modelEntity,
				modification);

		if (modifEntity == null) {
			return;
		}
		
		modificationDAO.delete(modifEntity.getId());
	}

	public CarDomain findOne(String mark, String model, String modification) {
		MarkDAO markDAO = new MarkDAOImpl(entityManager);
		Mark markEntity = markDAO.findOne(mark);
		if (markEntity == null) {
			throw new NoResultException("Mark with name " + mark
					+ " not founded");
		}

		ModelDAO modelDAO = new ModelDAOImpl(entityManager);
		Model modelEntity = modelDAO.findOne(markEntity, model);
		if (modelEntity == null) {
			throw new NoResultException("Model with name " + model
					+ " and mark " + mark + " not founded");
		}

		ModificationDAO modificationDAO = new ModificationDAOImpl(entityManager);
		Modification modifEntity = modificationDAO.findOne(modelEntity,
				modification);

		if (modifEntity == null) {
			throw new NoResultException("Modification " + modification
					+ " for " + mark + " " + model + " not founded");
		}
		
		Mapper mapper = new MainMapper();
		return mapper.map(modifEntity, CarDomain.class);
	}

	public void removeCar(CarDomain car) {
		removeCar(car.getMark(), car.getModel(), car.getModification());
	}

	public CarDomain addCar(CarDomain car) {
		return addCar(car.getMark(), car.getModel(), car.getModification());
	}

	
	public List<CarDomain> get(int offset, int count) {
		ModificationDAO modificationDAO = new ModificationDAOImpl(entityManager);
		List<Modification> modifications = modificationDAO.find(offset, count);
		Mapper mapper = new MainMapper();
		return mapper.mapAsList(modifications, CarDomain.class);
	}

}
