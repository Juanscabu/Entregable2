package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Carrera {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy="carrera")
	private List<Registro> estudiantes;

	public Carrera(String nombre) {
		this.nombre = nombre;
		this.estudiantes = new ArrayList<Registro>();
	}
	
	public Carrera() {
		super();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId () {
		return this.id;
	}

	public List<Registro> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Registro> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	
}
