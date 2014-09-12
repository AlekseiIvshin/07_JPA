package characteristic.values.dao;

import java.util.List;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

import characteristic.dao.Characteristic;
import car.dao.modifiacation.Modification;

public class CharacteristicValueDAOImpl 
		extends GenericDAOImpl<CharacteristicValue, Long>
		implements CharacteristicValueDAO{

	public CharacteristicValueDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	

	public List<CharacteristicValue> find(Modification modification) {
		return entityManager
				.createQuery("SELECT cv FROM CharacteristicValue cv "
						+ " WHERE c.modification = :mod")
						.setParameter("mod", modification)
						.getResultList();
	}

	public List<CharacteristicValue> find(Characteristic characteristic) {
		return entityManager
				.createQuery("SELECT cv FROM CharacteristicValue cv "
						+ " WHERE c.characteristic = :ch")
						.setParameter("ch", characteristic)
						.getResultList();
	}
}
