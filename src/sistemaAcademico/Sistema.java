package sistemaAcademico;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import entities.Carrera;
import entities.Estudiante;
import repositoriesImpl.CarreraRepositoryImpl;
import repositoriesImpl.EstudianteRepositoryImpl;
import repositoriesImpl.RegistroRepositoryImpl;

public class Sistema {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		EstudianteRepositoryImpl e = new EstudianteRepositoryImpl(em);
		CarreraRepositoryImpl c = new CarreraRepositoryImpl(em);
		RegistroRepositoryImpl r = new RegistroRepositoryImpl(em);
		
		CSVParser estudiantes = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./csv/estudiantes.csv"));
		CSVParser carreras = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./csv/carreras.csv"));
		
		//2A)
		cargarEstudiantes(estudiantes,e,em);
		cargarCarreras(carreras,c,em);
		
		//2B
		r.matricularEstudiante(e.getEstudiante(1387),c.getCarrera(1), 2019);
		
		//2C 
		System.out.println("lista de estudiantes por nombre " + e.getEstudiantes());
		
		//2D
		System.out.println("estudiante por libreta " + e.getEstudiante(1387));
		
		//2E
		List<Estudiante> estudiantesPorGenero = e.getEstudiantesGenero("Masculino");
		estudiantesPorGenero.forEach(p -> System.out.println(p));
		
		//2F
		List<Carrera> carrerasCantInscriptos = c.getCarrerasCantInscriptos();
		carrerasCantInscriptos.forEach(p -> System.out.println(p));
		
		//2G
		List<Estudiante> estudiantesCarrera = e.getEstudiantesCarrera(c.getCarrera(1),"Azul");
		estudiantesCarrera.forEach(p -> System.out.println("estudiante en el id carrera " + p));
		
		//3
		List<Carrera> listarCarreras = c.getReporteCarreras();
		listarCarreras.forEach(p -> System.out.println(p));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	private static void cargarCarreras(CSVParser carreras, CarreraRepositoryImpl c,EntityManager emC) {
		for(CSVRecord row: carreras) {
			String nombre = row.get("nombre");
			Carrera carrera = new Carrera(nombre);
			c.addCarrera(carrera);
			}
	}

	private static void cargarEstudiantes(CSVParser estudiantes, EstudianteRepositoryImpl e,EntityManager emE) {
		for(CSVRecord row: estudiantes) {
			String nombre = row.get("nombre");
			String apellido = row.get("apellido");
			int edad =  Integer.parseInt(row.get("edad"));
			String genero = row.get("genero");
			int documento = Integer.parseInt(row.get("documento"));
			String ciudad = row.get("ciudad");
			int libreta = Integer.parseInt( row.get("libreta"));
			Estudiante estudiante = new Estudiante(nombre,apellido,edad,genero,documento,ciudad,libreta);
			e.addEstudiante(estudiante);
			}
	}
  
}
