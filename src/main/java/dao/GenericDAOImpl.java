package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAOImpl<Model, IdType>  implements GenericDAO<Model, IdType> {

	protected EntityManager entityManager;
	protected Class<Model> entityType;
	
	public GenericDAOImpl(EntityManager entityManager){
		this.entityType = (Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.entityManager = entityManager;
	}
	
	public Model create(Model entity) {
		entityManager.persist(entity);
		return entity;
	}

	public Model update(Model entity) {
		return entityManager.merge(entity);
	}

	public Model find(IdType id) {
		return entityManager.find(entityType, id);
	}

	public List<Model> findAll() {
		return entityManager
				.createQuery("SELECT entity FROM "+entityType.getName()+" entity")
				.getResultList();
	}

	public void delete(IdType id) {
		Model m = find(id);
		entityManager.remove(m);
	}

}
