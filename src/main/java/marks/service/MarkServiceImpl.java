package marks.service;

import javax.persistence.EntityManager;

import marks.domain.Mark;

public class MarkServiceImpl implements MarkService {

	/**
	 * Entity manager.
	 */
	private EntityManager em;
	
	public MarkServiceImpl(EntityManager em){
		this.em = em;
	}
	
	public Mark createMark(String name){
		Mark mark = new Mark(name);
		em.persist(mark);
		
		return mark;
	}
	
	public void removeMark(int id){
		Mark mark = em.find(Mark.class, id);
		
		if(mark != null){
			em.remove(mark);
		}
	}

	public Mark updateMark(int id, Mark newMark) {
		Mark mark = em.find(Mark.class, id);
		
		if (mark != null) {
			mark.setName(newMark.getName());
		}
		
		return mark;
	}

	public Mark findMark(int id) {
		return em.find(Mark.class, id);
	}
}
