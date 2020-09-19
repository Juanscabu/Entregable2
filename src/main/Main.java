package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import daos.CarreraDao;
import daos.EstudianteDao;
import daos.RegistroDao;
import entities.Carrera;
import entities.Estudiante;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EstudianteDao e = new EstudianteDao(emf);
		CarreraDao c = new CarreraDao(emf);
		RegistroDao r = new RegistroDao(emf);
		//e.AddEstudiante(1, "Juan", "Scabuzzo", 25, "Masculino", 38925738, "Azul", 2321);
		//e.AddEstudiante(2, "Mati", "Villegas", 25, "Masculino", 3892212, "Tandil", 2372);
		
		Estudiante estudiante = e.getEstudiante(1);
		//System.out.println(estudiante);
		//e.getEstudiantesGenero();
		 
		Carrera c1 = c.getCarrera();
		//c.AddCarrera(c1);
		r.matricular(estudiante, c1, 2019);
		emf.close();
	}

}
