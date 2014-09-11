package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mark.dao.Mark;
import mark.repository.MarkRepository;
import mark.repository.MarkRepositoryImpl;
import model.dao.Model;
import model.repository.ModelRepository;
import model.repository.ModelRepositoryImpl;

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
		MarkRepository markService = new MarkRepositoryImpl(em);
		List<Mark> marks = markService.find("M%");
		for(Mark m: marks){
			LOG.info(m.toString());
		}
		
	}

}
