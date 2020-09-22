package repositoriesImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import entities.Carrera;
import entities.Estudiante;
import repositories.EstudianteRepository;

public class EstudianteRepositoryImpl implements EstudianteRepository {
	private EntityManager em;

	public EstudianteRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	public EstudianteRepositoryImpl() {
		super();
	}

	public Estudiante addEstudiante (Estudiante e) {
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE libreta = ?1", Estudiante.class);
		query.setParameter(1,e.getLibreta());
		List<Estudiante> resultados = query.getResultList();
		@SuppressWarnings("unused")
		Estudiante existeEstudiante = null;
		if (!resultados.isEmpty()) {
			return existeEstudiante = (Estudiante) resultados.get(0);
		}
		em.persist(e);
		return e;		
	}

	public Estudiante getEstudiante (int libreta) {
		Estudiante e = em.find(Estudiante.class,libreta);
		return e;
	}

	public List<Estudiante> getEstudiantes() {	
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e ORDER BY apellido ASC", Estudiante.class);
		List<Estudiante> estudiantes = query.getResultList();
		estudiantes.forEach(p -> System.out.println(p));
		return estudiantes;
	}


	public List<Estudiante> getEstudiantesGenero(String genero) {
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE genero = ?1", Estudiante.class);
		query.setParameter(1, genero);
		List<Estudiante> estudiantes = query.getResultList();
		estudiantes.forEach(p -> System.out.println(p));
		return estudiantes;
	}

	public List<Estudiante> getEstudiantesCarrera(Carrera c, String ciudad) {
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e JOIN Registro r on (e.libreta = r.estudiante) WHERE e.ciudad = ?1 AND r.carrera = ?2", Estudiante.class);
		query.setParameter(1,ciudad);
		query.setParameter(2,c);
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}
}
