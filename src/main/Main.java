package main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Carrera;
import entities.Estudiante;
import repositoriesImpl.CarreraRepositoryImpl;
import repositoriesImpl.EstudianteRepositoryImpl;
import repositoriesImpl.RegistroRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager emE = emf.createEntityManager();
		EntityManager emC = emf.createEntityManager();
		EntityManager emR = emf.createEntityManager();
		EstudianteRepositoryImpl e = new EstudianteRepositoryImpl(emE);
		CarreraRepositoryImpl c = new CarreraRepositoryImpl(emC);
		RegistroRepositoryImpl r = new RegistroRepositoryImpl(emR);
		
		
		Estudiante e1 = new Estudiante("Juan", "Scabuzzo", 25, "Masculino", 38925738, "Azul",1387);		
		e.addEstudiante(e1);
		Estudiante e2 = new Estudiante("Mati", "Villegas", 25, "Masculino", 3892212, "Tandil", 1372);
		e.addEstudiante(e2);
		//Getters 
		//e.getEstudiantesGenero();
		
		//e.getEstudiantes();
		//System.out.println(e.getEstudiante(1387));
		//Carrera TUDAI = new Carrera("TUDAI");
		//Carrera ingenieria = c.getCarrera(1);
		//c.AddCarrera(TUDAI);
		//Carrera c1 = c.getCarrera(1);
		//c.AddCarrera(c1);
		//Carrera TUDAI = c.getCarrera(2);
		//r.matricularEstudiante(e.getEstudiante(1387),ingenieria, 2019);
		//r.matricularEstudiante(e.getEstudiante(1372),TUDAI,2018);
		//List<Carrera> carreras = c.getCarrerasCantInscriptos();
		//List<Estudiante> estudiantes = e.getEstudiantesCarrera(c1,"Azul");
		List<Carrera> carreras = c.getReporteCarreras();
		carreras.forEach(p -> System.out.println(p));
		//estudiantes.forEach(p -> System.out.println(p));
		emE.close();
		emC.close();
		emR.close();
		emf.close();
	}
  
}
