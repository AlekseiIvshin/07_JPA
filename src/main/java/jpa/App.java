package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import marks.service.MarkService;
import marks.service.MarkServiceImpl;

/** 
 * Main. 
 * @author AlekseiIvshin
 *
 */
public class App {

	static final Logger LOG = LoggerFactory.getLogger(App.class);
	/**
	 * Main.
	 * @param args in arguments
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("07_JPA");
		EntityManager em = emf.createEntityManager();
		MarkService markService = new MarkServiceImpl(em);
		LOG.info(markService.findMark(1).toString());
		
	}

}
