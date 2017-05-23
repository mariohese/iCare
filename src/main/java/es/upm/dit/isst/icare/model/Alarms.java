package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


//Clase que podrá ser manejada por un gestor de persistencia
@Entity
public class Alarms implements Serializable {
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Index
	private String nombrepaciente;
	@Index
	private String operador;
	@Index
	private int nivel;
	@Index
	private String estado;
	@Index
	private String descripcion;
	@Index
	private String decision;
	@Index
	private Date fecha;
	@Index
	private Pacientes paciente;
	@Index
	private Long idPaciente;
	@Index
	private String localizacion;
	@Index
	private double latitud;
	@Index
	private double longitud;
	
	
	

	public Alarms (){
		
	}
	
	public Alarms(Pacientes paciente, String descripcion, String estado, String usuario, int nivel, String decision, Date fecha, String localizacion, double latitud, double longitud){
		String nombre = paciente.getPaciente();
		this.paciente = paciente;
		this.nombrepaciente = nombre;
		this.operador = usuario;
		this.nivel = nivel;
		this.decision = decision;
		this.fecha = fecha;
		this.idPaciente = paciente.getId();
		this.descripcion = descripcion;
		this.estado = estado;
		this.localizacion = localizacion;
		this.longitud=longitud;
		this.latitud=latitud;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
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


	public String getNombrepaciente() {
		return nombrepaciente;
	}


	public void setNombrepaciente(String nombrepaciente) {
		this.nombrepaciente = nombrepaciente;
	}


	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public String getDecision() {
		return decision;
	}


	public void setDecision(String decision) {
		this.decision = decision;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

}