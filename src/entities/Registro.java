package entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
@Entity
public class Registro implements Serializable{
	private static final long serialVersionUID = -7881603150879655580L;
	@Id
	@MapsId
	@ManyToOne
	private Estudiante estudiante;
	@Id
	@MapsId
	@ManyToOne
	private Carrera carrera;
	@Column
	private boolean termino;
	@Column
	private int inscripcion;
	@Column
	private int graduacion;

	public Registro() {
		super();
	}

	public Registro(Estudiante estudiante, Carrera carrera, int inscripcion) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.termino = false;
		this.inscripcion = inscripcion;
		this.graduacion = 0;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public boolean isTermino() {
		return termino;
	}

	public void setTermino(boolean termino) {
		this.termino = termino;
	}

	public int getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(int inscripcion) {
		this.inscripcion = inscripcion;
	}

	public int getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(int graduacion) {
		this.graduacion = graduacion;
	}

	@Override
	public String toString() {
		return "estudiante=" + estudiante + ", carrera=" + carrera + ", termino=" + termino
				+ ", inscripcion=" + inscripcion + ", graduacion=" + graduacion;
	}



}
