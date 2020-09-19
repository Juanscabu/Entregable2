package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Estudiante;

public class EstudianteDao {
	private EntityManagerFactory emf;
	
	public EstudianteDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EstudianteDao() {
		super();
	}
	
	public Estudiante AddEstudiante (int id,String nombre, String apellido, int edad, String genero, int documento, String ciudad,
			int libreta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		 Estudiante e = em.find(Estudiante.class,id);
		    if(e!=null)
		    {
		        return e;
		    }
		    e = new Estudiante(nombre,apellido,edad,genero,documento,ciudad,libreta);
		    em.persist(e);
		    em.getTransaction().commit(); // no se si se guarda
		    em.close();
		    return e;
		//
		
	}
	
	public Estudiante getEstudiante (int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Estudiante e = em.find(Estudiante.class,id);
		//System.out.println(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}
	
	public List<Estudiante> getEstudiantes() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings({"unchecked" })
		List<Estudiante> estudiantes = em.createQuery("SELECT * FROM Estudiante").getResultList();
		estudiantes.forEach(p -> System.out.println(p));
		em.getTransaction().commit();
		em.close();
		return estudiantes;
	}
	
	


	
	public List<Estudiante> getEstudiantesGenero() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings({"unchecked" })
		List<Estudiante> estudiantes = em.createQuery("SELECT * FROM Estudiante ORDER BY genero DESC").getResultList();
		estudiantes.forEach(p -> System.out.println(p));
		em.getTransaction().commit();
		em.close();
		return estudiantes;
	}
	
	
}
