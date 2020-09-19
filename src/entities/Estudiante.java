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


@Entity
public class Estudiante {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	

	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	@Column
	private int documento;
	@Column
	private String ciudad;
	@Column
	private int libreta;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Carrera> carreras;
	
	
	
	public Estudiante(String nombre, String apellido, int edad, String genero, int documento, String ciudad,
			int libreta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.documento = documento;
		this.ciudad = ciudad;
		this.libreta = libreta;
		this.carreras = new ArrayList<Carrera>();
		
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getLibreta() {
		return libreta;
	}

	public void setLibreta(int libreta) {
		this.libreta = libreta;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	
	//Graduo o no
	// antiguedad en carreras
}
