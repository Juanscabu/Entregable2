package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Estudiante;

public class CarreraDao {
	private EntityManagerFactory emf;
	
	public CarreraDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void AddEstudiante (int id,String nombre, String apellido, int edad, String genero, int documento, String ciudad,
			int libreta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		 Estudiante e = em.find(Estudiante.class,id);
			System.out.println(e);
		    e = new Estudiante(nombre,apellido,edad,genero,documento,ciudad,libreta);
		    em.persist(e);
		    em.getTransaction().commit(); // no se si se guarda
		    em.close();
		//
		
	}
	
}
