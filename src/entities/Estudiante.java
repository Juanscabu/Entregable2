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
	
	@OneToMany(mappedBy="estudiante")
	private List<Registro> carreras;
	
	public Estudiante() {
		super();		
	}
	
	public Estudiante(String nombre, String apellido, int edad, String genero, int documento, String ciudad,
			int libreta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.documento = documento;
		this.ciudad = ciudad;
		this.libreta = libreta;
		this.carreras = new ArrayList<Registro>();
		
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

	public List<Registro> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Registro> carreras) {
		this.carreras = carreras;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero="
				+ genero + ", documento=" + documento + ", ciudad=" + ciudad + ", libreta=" + libreta + ", carreras="
				+ carreras + "]";
	}
	
	 
}
