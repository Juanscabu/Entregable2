package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrera {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private int cantInscriptos;
	
	@OneToMany(mappedBy="carrera",fetch=FetchType.EAGER)
	private List<Registro> estudiantes;

	public Carrera(String nombre) {
		this.nombre = nombre;
		this.cantInscriptos = 0;
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

	public int getCantInscriptos() {
		return cantInscriptos;
	}

	public void setCantInscriptos(int cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nombre=" + nombre + ", cantInscriptos=" + cantInscriptos;
	}
	
	
	
}
