package characteristic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import common.dao.GenericDAOImpl;

public class CharacteristicDAOImpl 
		extends GenericDAOImpl<Characteristic, Long>
		implements CharacteristicDAO{

	public CharacteristicDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	

	public List<Characteristic> find(String name) {
		return entityManager
				.createQuery("SELECT c FROM Characteristic c WHERE c.name LIKE :name")
				.setParameter("name", name)
				.getResultList();
	}

	public List<Characteristic> find(Characteristic parent) {
		return entityManager
				.createQuery("SELECT c FROM Characteristic c, IN(c.parentCharacteristic) AS pc "
						+ " WHERE pc=:parent")
				.setParameter("parent", parent)
				.getResultList();
	}
}
