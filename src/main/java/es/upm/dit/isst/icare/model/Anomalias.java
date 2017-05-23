package es.upm.dit.isst.icare.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Anomalias implements Serializable{
	private static final long serialVersionUID = 01L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Index
	private String nombrepaciente;
	@Index
	private Pacientes paciente;
	@Index
	private Long idPaciente;
	@Index
	private String descripcion;
	@Index
	private Date fecha;
	
	
	public Anomalias(){
		
	}
	
	public Anomalias (Pacientes paciente, String tipoanomalia, Date fecha){
		String nombre = paciente.getPaciente();
		this.paciente = paciente;
		this.nombrepaciente= nombre;
		this.descripcion=tipoanomalia;
		this.fecha=fecha;
		this.idPaciente = paciente.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrepaciente() {
		return nombrepaciente;
	}

	public void setNombrepaciente(String nombrepaciente) {
		this.nombrepaciente = nombrepaciente;
	}

	public Pacientes getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



}