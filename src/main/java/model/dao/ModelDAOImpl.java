package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mark.dao.Mark;

public class ModelDAOImpl implements ModelDAO{

	private static final int MODELS_IN_RESULT = 100;
	private EntityManager em;
	
	public ModelDAOImpl(EntityManager em){
		this.em = em;
	}
	
	public Model create(String name, Mark mark) {
		Model model = new Model(name,mark);
		em.persist(model);
		
		return model;
		
	}

	public void remove(int id) {
		Model model = em.find(Model.class, id);
		if (model != null) {
			em.remove(model);
		}
	}

	public Model update(int id, Model newModel) {
		Model model = em.find(Model.class, id);
		if (model != null) {
			model.setName(newModel.getName());
			model.setMark(newModel.getMark());
		}
		return model;
	}

	public Model find(int id) {
		return em.find(Model.class,id);
	}

	public List<Model> find(String modelName, String markName) {
		return em
				.createQuery("SELECT m FROM Model m, IN(m.mark) AS mark "
						+ "WHERE m.name LIKE :modelName "
						+ "and mark.name LIKE :markName")
				.setParameter("modelName", modelName)
				.setParameter("markName", markName)
				.setMaxResults(MODELS_IN_RESULT)
				.getResultList();
	}

}
