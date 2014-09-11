package modification.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mark.dao.Mark;
import model.dao.Model;

public class ModificationDAOImpl implements ModificationDAO {

	private static final int MODIFICATION_IN_RESULT = 10;
	
	private EntityManager em;
	
	public ModificationDAOImpl(EntityManager em){
		this.em = em;
	}
	
	public Modification create(Model model, String name) {
		Modification m = new Modification();
		m.setName(name);
		m.setModel(model);
		em.persist(m);
		return m;
	}

	public Modification update(int id, String newName) {
		Modification m = em.find(Modification.class, id);
		if (em != null) {
			m.setName(newName);
		}
		
		return m;
	}

	public Modification update(int id, Model newModel) {
		Modification m = em.find(Modification.class, id);
		if (em != null) {
			m.setModel(newModel);
		}
		
		return m;
	}

	public Modification find(int id) {
		return em.find(Modification.class, id);
	}

	public List<Modification> find(String markName, String modelName,
			String name) {
		return em
				.createQuery("SELECT m FROM Modification m "
						+ "WHERE m.model.mark LIKE :markName "
						+ "AND m.model.name LIKE :modelName "
						+ "AND m.name LIKE :modifName")
				.setParameter("markName", markName)
				.setParameter("modelName", modelName)
				.setParameter("modifName", name)
				.setMaxResults(MODIFICATION_IN_RESULT)
				.getResultList();
	}

	public void remove(int id) {
		Modification m = em.find(Modification.class, id);
		if (em != null) {
			em.remove(m);
		}
	}

}
