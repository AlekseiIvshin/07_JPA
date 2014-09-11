package mark.repository;

import java.util.List;

import javax.persistence.EntityManager;

import mark.dao.Mark;

public class MarkRepositoryImpl implements MarkRepository {

	private static final int MARK_COUNT_IN_RESULT = 10;
 	/**
	 * Entity manager.
	 */
	private EntityManager em;
	
	public MarkRepositoryImpl(EntityManager em){
		this.em = em;
	}
	
	public Mark create(String name){
		Mark mark = new Mark(name);
		em.persist(mark);
		
		return mark;
	}
	
	public void remove(int id){
		Mark mark = em.find(Mark.class, id);
		
		if (mark != null) {
			em.remove(mark);
		}
	}

	public Mark update(int id, Mark newMark) {
		Mark mark = em.find(Mark.class, id);
		
		if (mark != null) {
			mark.setName(newMark.getName());
		}
		
		return mark;
	}

	public Mark find(int id) {
		return em.find(Mark.class, id);
	}

	public List<Mark> find(String name) {
		return em
				.createQuery("SELECT m FROM Mark m WHERE m.name LIKE :markName")
				.setParameter("markName", name)
				.setMaxResults(MARK_COUNT_IN_RESULT)
				.getResultList();
	}
}
