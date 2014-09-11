package characteristic.repository;

import java.util.List;

import javax.persistence.EntityManager;

import characteristic.dao.Characteristic;

public class CharacteristicRepositoryImpl implements CharacteristicRepository {

	private static final int CHARACTERISTIC_IN_RESULT = 100;
	
	private EntityManager em;
	
	public CharacteristicRepositoryImpl(EntityManager em){
		this.em = em;
	}
	
	public Characteristic find(int id) {
		return em.find(Characteristic.class,id);
	}

	public Characteristic create(String name, Characteristic parent) {
		Characteristic ch = new Characteristic(name,parent);
		em.persist(ch);
		
		return ch;
	}

	public void remove(int id) {
		Characteristic ch = em.find(Characteristic.class, id);
		
		if (ch != null) {
			em.remove(ch);
		}

	}

	public Characteristic update(int id, String newName) {
		Characteristic ch = em.find(Characteristic.class, id);
		if (ch != null) {
			ch.setName(newName);
		}
		
		return ch;
	}

	public Characteristic update(int id, Characteristic newParent) {
		Characteristic ch = em.find(Characteristic.class, id);
		if (ch != null) {
			ch.setParentCharacteristic(newParent);
		}
		
		return ch;
	}

	public List<Characteristic> find(String name) {
		return em
				.createQuery("SELECT c FROM Characteristic c WHERE c.name LIKE :name")
				.setParameter("name", name)
				.setMaxResults(CHARACTERISTIC_IN_RESULT)
				.getResultList();
	}

	public List<Characteristic> find(Characteristic parent) {
		return em
				.createQuery("SELECT c FROM Characteristic c, IN(c.parentCharacteristic) AS pc "
						+ " WHERE pc=:parent")
				.setParameter("parent", parent)
				.setMaxResults(CHARACTERISTIC_IN_RESULT)
				.getResultList();
	}

}
