package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import daos.EstudianteDao;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EstudianteDao e = new EstudianteDao(emf);
		//e.AddEstudiante(1, "Juan", "Scabuzzo", 25, "Masculino", 38925738, "Azul", 2321);
		e.getEstudiante(1);
		emf.close();
	}

}
