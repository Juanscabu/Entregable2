package repositories;

import entities.Carrera;
import entities.Estudiante;

public interface RegistroRepository {

	public boolean matricularEstudiante(Estudiante e,Carrera c, int a);
}
