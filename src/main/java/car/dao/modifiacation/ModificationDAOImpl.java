package car.dao.modifiacation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import car.dao.mark.Mark;
import car.dao.mark.MarkDAO;
import car.dao.mark.MarkDAOImpl;
import car.dao.model.Model;
import car.dao.model.ModelDAO;
import car.dao.model.ModelDAOImpl;
import common.dao.GenericDAOImpl;

public class ModificationDAOImpl 
		extends GenericDAOImpl<Modification, Long>
		implements ModificationDAO{

	static final Logger LOG = LoggerFactory.getLogger(ModificationDAOImpl.class);

	public ModificationDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	public Modification addNewCar(String markName, String modelName, String modificationName) {
		MarkDAO markDAO = new MarkDAOImpl(entityManager);
		Mark mark = markDAO.findOne(markName);
		if(mark == null){
			mark = new Mark();
			mark.setName(markName);
			mark = markDAO.create(mark);
		}
		ModelDAO modelDAO = new ModelDAOImpl(entityManager);
		Model model = modelDAO.findOne(mark, modelName);
		if(model == null){
			model = new Model();
			model.setName(modelName);
			model.setMark(mark);
			model = modelDAO.create(model);
		}
		Modification modif = new Modification();
		modif.setModel(model);
		modif.setName(modificationName);
		return this.create(modif);
		
	}

	public List<Modification> findAny(Model model, String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Modification> query = builder.createQuery(Modification.class);
		Root<Modification> root = query.from(Modification.class);
		query
			.where(
				builder.like(
						root.get(Modification_.name), 
						name))
			.where(
					builder.equal(
							root.get(Modification_.model), 
							model))
			.select(root);
		TypedQuery<Modification>ctq = entityManager.createQuery(query);
		return ctq.getResultList();
	}

	public Modification findOne(Model model, String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Modification> query = builder.createQuery(Modification.class);
		Root<Modification> root = query.from(Modification.class);
		query
			.where(
				builder.equal(
						root.get(Modification_.name), 
						name))
			.where(
					builder.equal(
							root.get(Modification_.model), 
							model))
			.select(root);
		TypedQuery<Modification>ctq = entityManager.createQuery(query);
		try{
			return ctq.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}

}
