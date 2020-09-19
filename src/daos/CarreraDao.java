package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Carrera;
import entities.Estudiante;

public class CarreraDao {
	private EntityManagerFactory emf;
	
	public CarreraDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void AddCarrera (Carrera c) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		 	//c = em.find(Carrera.class,1);
		    em.persist(c);
		    em.getTransaction().commit();
		    em.close();
		//
		
	}
	
	public Carrera getCarrera () {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Carrera e = em.find(Carrera.class,3);
		System.out.println(e);
		em.getTransaction().commit();
		em.close();
		return e;
		
	}
	
}
