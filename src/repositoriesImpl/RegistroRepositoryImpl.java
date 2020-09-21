package repositoriesImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Carrera;
import entities.Estudiante;
import entities.Registro;
import repositories.RegistroRepository;

public class RegistroRepositoryImpl implements RegistroRepository {

private EntityManager em;
	
	public RegistroRepositoryImpl(EntityManager em) {
		this.em = em;
		this.em.getTransaction().begin();
	}
	
	public boolean matricularEstudiante(Estudiante e, Carrera c, int a) {
		 	Carrera c1 = em.find(Carrera.class,c.getId());
		 	Estudiante e1 = em.find(Estudiante.class,e.getLibreta());
		 	Registro r1 = new Registro(e,c,a);
		 	r1 = em.find(Registro.class,r1);
		 	if (c1 != null && e1 != null && r1 == null) {
		 	Query query = em.createQuery("UPDATE Carrera c SET c.cantInscriptos = c.cantInscriptos+1 WHERE id=?1");
		 	query.setParameter(1,c.getId());
		 	query.executeUpdate();
			Registro r = new Registro (e,c,a);
		    em.persist(r);
		    return true;
		 	}
		 return false;
	}
}
