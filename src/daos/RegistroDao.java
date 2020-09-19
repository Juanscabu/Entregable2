package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Carrera;
import entities.Estudiante;
import entities.Registro;

public class RegistroDao {

private EntityManagerFactory emf;
	
	public RegistroDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void matricular(Estudiante e, Carrera c, int a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		 	//c = em.find(Carrera.class,1);
			Registro r = new Registro (e,c,a);
		    em.persist(r);
		    em.getTransaction().commit();
		    em.close();
	}
}
