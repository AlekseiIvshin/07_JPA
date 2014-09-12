package car.dao.modifiacation;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.service.CarServiceImpl;
import common.dao.GenericDAOImpl;

public class ModificationDAOImpl 
		extends GenericDAOImpl<Modification, Long>
		implements ModificationDAO{

	static final Logger LOG = LoggerFactory.getLogger(ModificationDAOImpl.class);

	public ModificationDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Modification> find(String markName, String modelName,
			String name) {
		return entityManager
				.createQuery("SELECT m FROM Modification m "
						+ "WHERE m.model.mark LIKE :markName "
						+ "AND m.model.name LIKE :modelName "
						+ "AND m.name LIKE :modifName")
				.setParameter("markName", markName)
				.setParameter("modelName", modelName)
				.setParameter("modifName", name)
				.getResultList();
	}

}
