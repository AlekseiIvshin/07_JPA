package characteristicvalue.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modification.dao.Modification;
import characteristic.dao.Characteristic;

public class CharacteristicValueDAOImpl implements
		CharacteristicValueDAO {

	
	private static final int CHARACTER_VALUE_IN_RESULT = 10;
	
	private EntityManager em;
	
	public CharacteristicValueDAOImpl(EntityManager em){
		this.em = em;
	}
	
	public CharacteristicValue create(Modification modification,
			Characteristic characteristic, String value, String unit) {
		CharacteristicValue cv = new CharacteristicValue();
		cv.setCharacteristic(characteristic);
		cv.setModification(modification);
		cv.setValue(value);
		cv.setUnit(unit);
		em.persist(cv);
		return cv;		
	}

	public CharacteristicValue update(long id, String newValue, String newUnit) {
		CharacteristicValue cv = em.find(CharacteristicValue.class, id);
		if (cv != null) {
			cv.setValue(newValue);
			cv.setUnit(newUnit);
		}
		
		return cv;
	}

	public CharacteristicValue find(long id) {
		return em.find(CharacteristicValue.class, id);
	}

	public List<CharacteristicValue> find(Modification modification) {
		return em
				.createQuery("SELECT cv FROM CharacteristicValue cv "
						+ " WHERE c.modification = :mod")
						.setParameter("mod", modification)
						.setMaxResults(CHARACTER_VALUE_IN_RESULT)
						.getResultList();
	}

	public List<CharacteristicValue> find(Characteristic characteristic) {
		return em
				.createQuery("SELECT cv FROM CharacteristicValue cv "
						+ " WHERE c.characteristic = :ch")
						.setParameter("ch", characteristic)
						.setMaxResults(CHARACTER_VALUE_IN_RESULT)
						.getResultList();
	}

	public void remove(long id) {
		CharacteristicValue cv = em.find(CharacteristicValue.class, id);
		if (cv != null) {
			em.remove(cv);
		}
	}

}
